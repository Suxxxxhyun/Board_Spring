<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<script>
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			location.replace("write.do");
		});
	});
</script>
<div>
	<form action="list.do" method="get">
		<select name="searchCondition">
			<option value="">전체</option>
			<option value="id">아이디</option>
			<option value="nm">이름</option>
		</select>
		<input type="text" name="searchKeyword"/>
		<input type="submit" value="검색"/>
	</form>
</div>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th> <!-- th를 하게 되면 가운데 정렬 및 두꺼운 폰트로 진행할 수 있음 -->
			<th>이름</th>
			<th>권한</th>
			<th>등록일(D)</th>
			<th>가입시간</th>
			<th>등록일(S)</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${list eq null}">
			<tr>
			<td colspan="7">조회된 회원이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${list ne null}">
			<c:forEach var="list" items="${list}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>
						<a href="getInfo.do?userId=${list.userId }">
						<!-- 36라인에 적은 getInfo.do?userId의 userId가 UserVO의 get,set떼고 소문자로 시작하는 부분과 같으면 알아서 바인딩 됨. -->
						${list.userId}
						</a>
					</td>
					<td>${list.userNm}</td> <!-- aa.count -->
					<td>${list.roleNm}</td>
					<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${list.regDate}" pattern="HH:mm:ss"/></td>
					<td>
						<fmt:parseDate var="regDt" value="${list.regDt }" pattern="yyyy-MM-dd"/>
						<!-- parseDate는 문자형식을 날짜형식으로 바꾸어줌. -->
						<fmt:formatDate value="${regDt}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<button type="button" id="btnWrite">회원등록</button>


