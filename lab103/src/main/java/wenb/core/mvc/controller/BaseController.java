package wenb.core.mvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.MessageSourceAccessor;

import wenb.core.utils.SessionUtil;
import wenb.modules.front.user.vo.UserVO;

public class BaseController {
	protected final Log LOGGER = LogFactory.getLog(this.getClass());

	@Resource(name="messageSourceAccessor")
	//messageSourceAccessor - context-common.xml파일의 11라인에 정의되어있음
	protected MessageSourceAccessor messageSourceAccessor;

	/**
	 * 로그인 객체 반환
	 * <pre>
	 * </pre>
	 * @method getUser
	 * @return UserVO
	 * @date 2022. 11. 2.
	 * @author swchoi
	 * @return
	 * @throws Exception
	 */
	protected UserVO getUser() throws Exception {
		return (UserVO) SessionUtil.getAttribute("user");
	}
	
	/**
	 * 로그인 여부
	 * <pre>
	 * </pre>
	 * @method isLogin
	 * @return boolean
	 * @date 2022. 11. 2.
	 * @author swchoi
	 * @return
	 * @throws Exception
	 */
	protected boolean isLogin() throws Exception {
		return (SessionUtil.isEmpty("user") ? false : true);
	}
	
	protected String getViewName(HttpServletRequest request) throws Exception {
		String uri = request.getRequestURI(); /*"/admin/user/list.do"*/
		String url = request.getRequestURL().toString(); /*http://localhost:8070/admin/user/list.do*/
		String a = request.getQueryString(); /* ?a=d&b=c*/
		
		uri = uri.substring(0, uri.lastIndexOf("."));
		String[] uris = uri.split("/");
		return uris[1] + "/" + uris[2] + "/" + uris[3];
	}
}
