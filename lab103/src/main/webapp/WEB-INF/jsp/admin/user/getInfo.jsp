<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<script>	
	$(document).ready(function(){
		$("#btnEdit").click(function(){
			location.replace("edit.do?userId=${userInfo.userId}");
		});
		$("#btnList").click(function(){
			location.replace("list.do");
		});
		
		$("#btnComment").click(function(){
			var params = {
					userId : "${userInfo.userId}" //"${user.userId}" 작성한 사람의 컬럼을 만들어주지않아서 그냥 userInfo.userId로 해주겠음
					, comment : $("#txtComment").val()
			}
			$.ajax({
				type : "POST"
				, url : "createComment.do"
				, data : params
				, success : function(data){
					getCommentList();
				}
				, error:function(XMLHttpRequest, textStatus, errorThrown){
					console.log(XMLHttpRequest);
					console.log(textStatus);
					console.log(errorThrown);
				} 
			});
		});
		
		getCommentList();
	});
	
	function getCommentList() {
		var params = {
				userId : "${userInfo.userId }"
		}
		$.ajax({
			type : "POST"
			, url : "getCommentList.do"
			, data : params
			, success : function(data){
				var $tbl = $("#tblCommentList");
				$tbl.html("");
				var str = "<tbody>";
				$(data).each(function(){
					str += "<tr><td>" + this.userId + "</td><td>" + this.regDate + "</td></tr>";
					str += "<tr><td colspan='2'>" + this.comment + "</td></tr>";
					console.log(this.commentID + "," + this.userId + "," + this.comment);
				});
				str += "</tbody>";
				$tbl.html(str);
			}
			, error:function(XMLHttpRequest, textStatus, errorThrown){
				console.log(XMLHttpRequest);
				console.log(textStatus);
				console.log(errorThrown);
			}
		});
	}
</script>

<table border="1">
	<tbody>
		<tr>
			<th>아이디</th>
			<td>${userInfo.userId }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${userInfo.userNm }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${userInfo.password }</td>
		</tr>
		<tr>
			<th>권한</th>
			<td>${userInfo.roleNm }</td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><fmt:formatDate value="${userInfo.regDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
	</tbody>
</table>
<button type="button" id="btnEdit">수정</button>
<button type="button" id="btnList">목록</button>
<table id="tblCommentList" border="1">
</table>
<textarea id="txtComment" rows="6" cols="40"></textarea>
<button type="button" id="btnComment">댓글등록</button>