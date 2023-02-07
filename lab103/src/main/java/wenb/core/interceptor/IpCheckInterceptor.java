package wenb.core.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import wenb.core.mvc.vo.RestfulStatusVO;

@Controller("ipcheckInterceptor")
public class IpCheckInterceptor extends HandlerInterceptorAdapter {
	@Resource(name="messageSourceAccessor")
	protected MessageSourceAccessor messageSourceAccessor;
	private final Logger LOGGER = LoggerFactory.getLogger(IpCheckInterceptor.class.getName());

	/** API접속 체크 IP 목록패턴배열 */
	private String[] apiIPs;

	public void setApiIPs(String[] apiIPs) {
		this.apiIPs = apiIPs;
	}

	/** API 접속 포트 */
	private String[] apiPorts;

	public void setApiPorts(String[] apiPorts) {
		this.apiPorts = apiPorts;
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		RestfulStatusVO status = request.getSession().getAttribute("sessionAuth") == null ? new RestfulStatusVO() : (RestfulStatusVO) request.getSession().getAttribute("sessionAuth");
		System.out.println("requestURI=" + request.getRequestURI());
		if (this.apiIPs != null && this.apiIPs.length > 0) {
			if (!PatternMatchUtils.simpleMatch(apiIPs, request.getRemoteAddr())) {
				LOGGER.debug("## 허용된 관리자 접근 IP 이외의 접근. remoteAddr : " + request.getRemoteAddr());
				LOGGER.debug("## AdminIPs : " + apiIPs.toString());
				LOGGER.debug("## Access Port : " + String.valueOf(request.getServerPort()));
				
				status.setCode(HttpStatus.FORBIDDEN.value());
				status.setName(HttpStatus.FORBIDDEN);
				status.setMessage(this.messageSourceAccessor.getMessage("msg.not.allowed.ip"));
			} else {
				status.setCode(HttpStatus.ACCEPTED.value());
				status.setName(HttpStatus.ACCEPTED);
				status.setMessage(this.messageSourceAccessor.getMessage("msg.allowed.ip"));
			}
		} else {
			return false;
		}
		request.getSession().setAttribute("sessionAuth", status);
		return true;
	}
}
