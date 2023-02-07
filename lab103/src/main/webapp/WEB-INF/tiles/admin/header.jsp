<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
	    $(document).ready(function(){
			$("#logoutBtn").click(function(){
				location.replace("/admin/user/logout.do"); //로그아웃에 대한 버튼이벤트 -> AdminUserController에 logout.do추가함
			});
		});
    </script>
	<div class="header">
		<div class="headerText">
		Admin Header Area
		</div>
		<div class="loginArea">
			${sessionScope.user.userId }(${user.userNm})님 환영합니다 <%--UserController 82라인, user라는 이름으로 user정보를 던져줌 --%>
			<button type="button" id="logoutBtn">로그아웃</button>
		</div>
	</div>