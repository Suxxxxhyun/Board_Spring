package wenb.core.advice;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * <pre>
 * Log Util
 * </pre>
 * @package egovframework.com.utl
 * @class Log4jAdvice.java
 * @author swchoi
 * @since 2021. 3. 13.
 * @version 1.0
 * @company wenbiz
 */
public class Log4jAdvice {
	private SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * <pre>
	 * 사전 로그 처리
	 * </pre>
	 * @method beforeLog
	 * @return void
	 * @date 2021. 3. 13.
	 * @author swchoi
	 * @param jp
	 */
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String message = "[사전 처리] " + method + "() 메소드 ARGS 정보 : arguments";
		if (args != null) {
			if (args.length > 0) {
				message = message.replaceAll("arguments", args[0].toString());
			} else {
				message = message.replaceAll("arguments", "None");
			}
		} else {
			message = message.replaceAll("arguments", "None");
		}
		
		Date date = new Date();
		System.out.println("#############################################################################");
		System.out.println("Start Date : " + formatter.format(date));
		System.out.println(message);
	}

	/**
	 * <pre>
	 * 메소드 수행시간 측정
	 * </pre>
	 * @method aroundLog
	 * @return Object
	 * @date 2021. 3. 13.
	 * @author swchoi
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + NumberFormat.getInstance().format(stopWatch.getTotalTimeMillis()) + "(ms)초");
		return returnObj;
	}
	
	/**
	 * 에러발생시 수행
	 * <pre>
	 * </pre>
	 * @method exceptionLog
	 * @return void
	 * @date 2021. 5. 23
	 * @author swchoi
	 * @param jp
	 * @param exceptionObj
	 */
	public void afterThrowingLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외처리] " + method + "() 메소드 수행 중 발생된 예외메시지 : " + exceptionObj.getMessage());
		exceptionObj.printStackTrace();
	}
	
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후처리)] " + method + "() 메소드 리턴값 : " + (returnObj == null ? "void" : returnObj.toString()));
		System.out.println("#############################################################################\n");
	}



}
