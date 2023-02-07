<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<script>	
	$(document).ready(function(){
		$("#btnEdit").click(function(){
			location.replace("edit.do?seq=${boardInfo.seq}");
		});
		$("#btnList").click(function(){
			location.replace("list.do");
		});
	});
	
	function insertReply(){
		$.ajax({
			type:"POST"
			,url:"insertReply.do"
			,data : (
				comment : $("#contents").val();
				,userId : ${user.userId}
				,boardId : ${boardInfo.seq}
			), success:function(data){
				var msg;
				
				switch(data){
				case 1 : 
					msg = "댓글 등록 성공";
					break;
				case 0 :
					msg = "댓글 등록 실패";
					break;
				}
				
				alert(msg);
			}, error:function(XMLHttpRequest, textStatus, errorThrown){
				alert(textStatus);
			}
		})
	}
</script>
<table border="1">
	<tbody>
		<tr>
			<th>제목</th>
			<td>${boardInfo.title }</td>
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
			<td>${boardInfo.content }</td>
		</tr>
	</tbody>
</table>
<button type="button" id="btnEdit">수정</button>
<button type="button" id="btnList">목록</button>
<br>
<textarea rows="5" cols="30" name="contents" id="contents">
</textarea><br>
<button type="button" id="btnSave" onclick="insertReply()">댓글작성</button>
<table border="1">
	<thead>
		<tr>
			<th>작성자명</th>
			<th>작성일자</th>
			<th>댓글내용</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${replyList eq null}">
			<tr>
			<td colspan="7">조회된 게시판이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${replyList ne null}">
			<c:forEach var="replyList" items="${replyList }">
				<tr>
					<td>
						${replyList.userId }
					</td>
					<td>
						<fmt:formatDate value="${replyList.regDate }" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						${replyList.comment }
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>