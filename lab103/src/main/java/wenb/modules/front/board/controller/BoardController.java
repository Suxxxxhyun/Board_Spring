package wenb.modules.front.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wenb.core.mvc.controller.BaseController;
import wenb.modules.admin.user.vo.commentListVO;
import wenb.modules.front.board.service.BoardService;
import wenb.modules.front.board1.vo.Board1VO;
import wenb.modules.front.board1.vo.ReplyVO;
import wenb.modules.front.user.vo.UserVO;

@Controller
//spring에서 @controller를 'boardcontroller'라는 이름으로 읽어들임
//@Controller("aaaa")라고 한다면, 스프링에서 @controller를 aaaa라는 이름으로 읽어들임
@RequestMapping(value ="/front/board") //titles-define.xml -> 14라인에 의해 /front/user작성한것임
public class BoardController extends BaseController {

	//@Autowired //자동주입으로 선언된 레퍼런스 변수이름인 boardService (이름 못바꿈!)
	//BoardService boardService; //자동주입 
	
	//@Autowired
	//BoardService boardService2;
	
	@Resource(name="boardService")
	BoardService boardService; //자동주입으로, 선언된 변수이름인 boardService를 Resource를 통해 이름 바꿀 수 있음
	
	//Autowired는 선언할때 이미 impl에서 등록된 이름으로 선언되어야하고
	//Resource는 괄호안의 name은 이미 imple에서 등록된 이름을 작성해야하며
	//선언할때는 이름을 바꾸어줄수가 있음.
	//그래서 boardService2로 등록된 것을 boardService로 바꾸어준것을 확인할 수 있음
	
	
	
	/*public String getList() {
		
		//BoardServceImpl boardService = new BoardServceImpl(); 
		List<?> retList = boardService.getList(); //레퍼런스 변수를 boardService라고 했지? 위에서 선언해서 스프링에서 알아서 18라인 객체 만들어주고, 내가 선언한
												 //레퍼런스변수이름가지고 메서드 호출을 함. (레퍼런스 변수를 선언한 것을 -> 자동주입이라고함)
	}*/
	
	@RequestMapping("/getInfo.do")
	public String getInfo(Model model, Board1VO vo, HttpServletRequest request) throws Exception {
		UserVO user = super.getUser();
		
		if (user == null) {
			return "redirect:/front/user/login.do";
		} else {
			Board1VO boardVO = boardService.getInfo(vo);
			model.addAttribute("userVO",user);
			model.addAttribute("boardVO", boardVO);
			System.out.println("boardVO : " + boardVO );
			return super.getViewName(request);
		}
	}
	
	//commentList.jsp가 없으니까 ajax로 함. (애초에 requestMapping에서 commentList.jsp로 바인딩되잖아? 근데 난 상세정보 페이지에서
	//댓글을 보여주려고하는건데 commentList.jsp로 갈필요없지? 그래서 그냥 리스트를 반환해주고있는것임. url이 아니라.
	//또, ResponseBody는 ajax를 위한 코드임.
	//ajax를 사용하면 jsp에 모델(ReplyVO)을 던져주지 않음. 즉. model.attribute를 하지않음.
	//걍 list를 반환
	@ResponseBody
	@RequestMapping("/commentList.do")
	public List<ReplyVO> getCommentList(Model model, ReplyVO vo, HttpServletRequest request) throws Exception {
		UserVO user = super.getUser();
		if (user == null) {
			return null;
		} else {
			List<ReplyVO> list = boardService.getCommentList(vo);
			return list;
		}
	}
	
	@RequestMapping(value ="/createComment.do")
	@ResponseBody
	public Map<String, Object> createComment(ReplyVO vo) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		boardService.createComment(vo);
		result.put("ret", true);
		return result;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model, Board1VO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			List<Board1VO> list = boardService.getBoard1List(vo);
			model.addAttribute("list", list);
			return super.getViewName(request);
		}
	}
	
	
	@RequestMapping("/edit.do")
	public String edit(Model model, Board1VO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			Board1VO boardInfo = boardService.getInfo(vo);
			model.addAttribute("boardInfo", boardInfo);
			return super.getViewName(request);
		}
	}
	
	@RequestMapping("/modify.do")
	public String modify(Model model, Board1VO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			boardService.modifyBoard(vo);
			return "redirect:getInfo.do?seq="+vo.getSeq();
		}
	}
}
