package wenb.core.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * RequestContextHolder를 이용한 Request 없이 Session 사용
 * <pre>
 * </pre>
 * @package wenb.core.utils
 * @class SessionUtil.java
 * @author swchoi
 * @since 2022. 11. 2.
 * @version 1.0
 * @company wenbiz
 */
public class SessionUtil {
	public static void setAttribute(String key, Object value) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(true);
		session.setAttribute(key, value);
	}
	
	public static Object getAttribute(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getSession().getAttribute(key);
	}
	
	public static boolean isEmpty(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return (request.getSession().getAttribute(key) == null ? true : false);
	}
}
