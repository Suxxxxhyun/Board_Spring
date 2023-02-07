package wenb.modules.admin.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wenb.core.mvc.controller.BaseController;
import wenb.modules.admin.user.service.AdminUserService;
import wenb.modules.admin.user.vo.RoleListVO;
import wenb.modules.admin.user.vo.UserListVO;
import wenb.modules.admin.user.vo.UserVO;
import wenb.modules.admin.user.vo.commentListVO;

/**
 * 자바 doc(자바 독), 관리자 사용자 컨트롤러
 * <pre>
 * </pre>
 * @package wenb.modules.admin.user.controller
 * @class AdminUserController.java
 * @author qkrtn
 * @since 2022. 11. 18.
 * @version 1.0
 * @company wenbiz
 */

@Controller
@RequestMapping("/admin/user") //공통으로 들어갈 url
public class AdminUserController extends BaseController{
	@Autowired
	AdminUserService adminUserService;
	
	/**
	 * 사용자 목록 조회
	 * <pre>
	 * </pre>
	 * @method list
	 * @return String
	 * @date 2022. 12. 2.
	 * @author qkrtn
	 * @param model
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	//public String list(Model model, UserListVO vo, HttpServletRequest request) throws Exception{ --> 메모장에 적음
	public String list(Model model, UserListVO vo, HttpServletRequest request) throws Exception{
		//UserVO user = (UserVO) request.getSession().getAttribute("user");
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			if(user.getRoleCd().equals("001")) {
				
				List<UserListVO> list = adminUserService.getList(vo);
				//getList(vo)에 담기는 것은 없음. 성명을 기반으로 목록을 조회할 수도있고.. 이런부분을 위한
				//파라미터이기에 지금은 형식상 적혀있는 부분이야.
				model.addAttribute("list", list);
				
			} else {
				return "";
			}
			//return "user/list";
			return super.getViewName(request);
		}
	}
	
	/**
	 * 사용자 상세정보 반환
	 * <pre>
	 * </pre>
	 * @method getInfo
	 * @return String
	 * @date 2022. 12. 2.
	 * @author qkrtn
	 * @param model
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInfo.do")
	public String getInfo(Model model, UserVO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			if(user.getRoleCd().equals("001")) {
				UserVO userVO = adminUserService.getInfo(vo);
				System.out.println("userVO : " + userVO);
				model.addAttribute("userInfo", userVO);
			} else {
				return "";
			}
			//return "user/list";
			return super.getViewName(request);
		}	

	}
	
	/**
	 * 사용자 수정 
	 * <pre>
	 * </pre>
	 * @method edit
	 * @return String
	 * @date 2022. 12. 8.
	 * @author qkrtn
	 * @param model
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit.do")
	public String edit(Model model, UserVO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			if(user.getRoleCd().equals("001")) {
				UserVO userVO = adminUserService.getInfo(vo);
				List<RoleListVO> roleList = adminUserService.getRoleList();
				model.addAttribute("userInfo", userVO);
				model.addAttribute("roleList",roleList);
			} else {
				return "";
			}
			//return "user/list";
			return super.getViewName(request);
		}	

	}
	/**
	 * 사용자 정보 수정한 내역 저장
	 * <pre>
	 * </pre>
	 * @method modify
	 * @return String
	 * @date 2022. 12. 8.
	 * @author qkrtn
	 * @param model
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	//modify메소드에 담기는 모델이 없긴하지만 컨트롤러에서 습관적으로 Model model이라고 써줌.
	@RequestMapping("/modify.do")
	public String modify(Model model, UserVO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			adminUserService.modifyUser(vo);
			System.out.println("수정 후 저장 : " + vo.getUserNm());
			return "redirect:getInfo.do?userId="+vo.getUserId();
		}
	}
	
	//로그아웃을 위한 컨트롤러
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) throws Exception{
		//세션정보를 날릴예정인데, 세션정보는 request를 통해서만 얻어올 수 있음.
		request.getSession().invalidate(); //현재 생성한 세션정보를 없앰.
		return "redirect:/front/user/login.do";
	}
	
	@RequestMapping("/write.do")
	public String write(Model model, UserVO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			model.addAttribute("roleList",adminUserService.getRoleList());
			return super.getViewName(request);
		}
	}
	
	
	//등록을 누르고 나서 정보를 저장하기위한 컨트롤러, create.do의 Model model은 관습적으로 그냥 작성한것임.
	@RequestMapping("/create.do")
	public String create(Model model, UserVO vo, HttpServletRequest request) throws Exception{
		wenb.modules.front.user.vo.UserVO user = super.getUser();
		if(user == null) {
			return "redirect:/front/user/login.do";
		} else {
			adminUserService.createUser(vo);
			return "redirect:list.do";
		}
	}
	
	@RequestMapping(value="/dupCheck.do", produces="application/json")
	@ResponseBody //ajax를 위한 어노테이션
	//ajax는 key,value형태이기 때문에 반환값이 Map일수 밖에 없음.
	public Map<String, Object> dupCheck(UserVO vo) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		UserVO user = adminUserService.getInfo(vo);
		if(user == null) {
			result.put("ret", true); 
			//내가 input에 입력한 아이디를 사용할 수 있다는 true임.
		} else {
			result.put("ret", false); 
		}
		return result;
	}
	
	
	//댓글 - 수업시간에 한부분
	@RequestMapping(value ="/getCommentList.do")
	@ResponseBody
	public List<commentListVO> getCommentList(UserVO vo) throws Exception{
		List<commentListVO> list = adminUserService.getCommentList(vo);
		return list;
	}
	
	@RequestMapping(value ="/createComment.do")
	@ResponseBody
	public Map<String, Object> createComment(commentListVO vo) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		adminUserService.createComment(vo);
		result.put("ret", true);
		return result;
	}
}


