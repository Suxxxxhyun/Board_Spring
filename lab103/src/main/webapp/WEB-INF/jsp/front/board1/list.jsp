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
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${list eq null}">
			<tr>
			<td colspan="7">조회된 게시판이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${list ne null}">
			<c:forEach var="list" items="${list }">
				<tr>
					<td>
						<a href="getBoard.do?seq=${list.seq }">
						${list.seq }
						</a>
					</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td>
						<fmt:formatDate value="${list.regDate }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<button type="button" id="btnWrite">등록</button>