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
<form name="frm" method="post" action="modify.do?seq=${boardInfo.seq }">
	<table border="1">
		<tbody>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title }"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${boardInfo.writer }</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><fmt:formatDate value="${boardInfo.regDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" value="${boardInfo.content }"/></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" id="btnSave" value="저장"/>
	<button type="button" id="btnList">목록</button>
</form>