package wenb.modules.front.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wenb.core.mvc.controller.BaseController;
import wenb.modules.front.user.service.UserService;
import wenb.modules.front.user.vo.UserVO;

/**
 * 사용자 관련 컨트롤러
 * <pre>
 * </pre>
 * @package wenb.modules.front.user.controller
 * @class UserController.java
 * @author swchoi
 * @since 2022. 10. 26.
 * @version 1.0
 * @company wenbiz
 */
@Controller
@RequestMapping(value="/front/user")
public class UserController extends BaseController {
	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 로그인 화면
	 * <pre>
	 * </pre>
	 * @method login
	 * @return void
	 * @date 2022. 11. 2.
	 * @author swchoi
	 * @throws Exception
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public void login() throws Exception {
		
	}
	
	/*public ModelAndView login() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login"); //ModelAndView로 반환하게되면, url을 정확하게 명시해줘야함.
		
		return mv;
	}* -> 옛날방식임/
	
	/*public String login() throws Exception {
		return "user/login";
	}*/ //String이면 위와 같음.
	
	/**
	 * 로그인 처리
	 * <pre>
	 * </pre>
	 * @method login
	 * @return void
	 * @date 2022. 11. 2.
	 * @author swchoi
	 * @param model
	 * @param vo
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value="/loginProcess.do", method=RequestMethod.POST)
	public String login(Model model, UserVO vo, HttpServletRequest request) throws Exception {
		UserVO user = userService.getUser(vo);
		System.out.println("USER : " + user);
		String view = "front/user/login";
		
		//messageSourceAccessor - context-common.xml파일의 11라인에 정의되어있음
		if (user == null) {
			model.addAttribute("loginFail", messageSourceAccessor.getMessage("user.login.failed"));
			//return "redirect:login.do"; //상대경로, 내가 처음 위치한 곳이 RequestMapping한 /front/user였지? 그 상태에서 리다이렉트로 login.do로 오게했지? -> 상대경로는, login.do앞의 경로가 /front/user와 같게본다는 의미임
			//78라인에 있는 것을 model에 담아 75라인인 view에 보여주는 과정임. 
		} else {
			request.getSession().setAttribute("user", user);
			if(user.getRoleCd().equals("001")) {
				view = "redirect:/admin/user/list.do";
			} else {
				view = "redirect:/front/board/list.do";
			}
			//return "redirect:/front/board/list.do"; //절대경로 : localhost:8070 + /front/board/list.do
		} //내가 로그인하고 나서 다른 페이지로 이동해야된다면, 반환값을 void로 줄 수 가없음!, 다른 페이지로 가야하는 리턴값이 필요할테니까!
		//redirect는 무조건 get방식으로 처리됨
		return view;
	}
}
