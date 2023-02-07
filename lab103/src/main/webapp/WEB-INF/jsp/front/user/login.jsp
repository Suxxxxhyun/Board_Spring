<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="loginProcess.do" method="post">
	<!-- input type의 serId, password가  UserVO의 get,set떼고 소문자로 시작하는 메서드명과 같아서 바인딩되서 들어감-->
	<input type="text" name="userId" /><br />
	<input type="password" name="password" /><br />
	<input type="submit" value="로그인" />
	<div>
		<c:if test="${loginFail ne null }">
			${loginFile}
			aaaa
		</c:if>
		<c:if test="${loginFail eq null }">
			bbbb
		</c:if>
		
	</div>
</form>