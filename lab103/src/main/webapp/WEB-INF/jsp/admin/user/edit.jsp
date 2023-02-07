<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<script>	
	$(document).ready(function(){
		$("#btnList").click(function(){
			location.replace("list.do");
		});
	});
</script>
<form name="frm" method="post" action="modify.do"> 
	<table border="1">
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" value="${userInfo.userId }"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userNm" value="${userInfo.userNm }"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" value="${userInfo.password }"/></td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<select name="roleCd">
					<c:forEach items="${roleList }" var="roleList" varStatus="index">
						<c:set var="selected" value=""/>
						<c:if test="${roleList.roleCd eq userInfo.roleCd }">
							<c:set var="selected" value="selected"/>
						</c:if>
						<option value="${roleList.roleCd }" ${selected }>${roleList.roleNm }</option>
						<!--  <option value="001">관리자</option>
						<option value="002">사용자</option>-->
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><fmt:formatDate value="${userInfo.regDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" id="btnSave" value="저장"/>
	<button type="button" id="btnList">목록</button>
</form>
