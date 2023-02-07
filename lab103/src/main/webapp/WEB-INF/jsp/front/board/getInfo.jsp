<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<script>
	$(document).ready(function(){
		getCommentList("${boardVO.seq}");
		
		$("#btnSave").click(function(){
			var params = {
					userId : "${userVO.userId}" //"${user.userId}" 작성한 사람의 컬럼을 만들어주지않아서 그냥 userInfo.userId로 해주겠음
					, comment : $("#comments").val()
					, boardId : "${boardVO.seq}"
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
		
		$("#btnEdit").click(function(){
			location.replace("edit.do?seq=${boardVO.seq}");
		});
		$("#btnList").click(function(){
			location.replace("list.do");
		});
	});

	function getCommentList(strBoardId) {
		$.ajax({
			type:"POST"
			, url:"/front/board/commentList.do"
			, dataType:"json"
			, data:{
				boardId:strBoardId
			}
			, success:function(results) {
				console.log(results);
				var $tbl = $("#commentList");
				$tbl.html("");
				var str = "<tbody>"
				$(results).each(function() {
					str += "<tr><td>" + this.userId + "</td>"
					str += "<td>" + this.regDt + "</td></tr>"
					str += "<tr><td colspan='2'>" + this.comment + "</td></tr>";
				});
				str += "</tbody>";
				$tbl.html(str);
			}, error:function(XMLHttpRequest, textStatus, errorThrown) {
				console.log("XMLHttpRequest:" + XMLHttpRequest);
				console.log("textStatus:" + textStatus);
				console.log("errorThrown:" + errorThrown);
			}
		});
	}
</script>
<table border="1">
	<tbody>
		<tr>
			<th>번호</th>
			<td colspan="3">${boardVO.seq}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${boardVO.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardVO.writer}</td>
			<th>작성일자</th>
			<td>${boardVO.regDate}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${boardVO.content}</td>
		</tr>
	</tbody>
</table>
<table border="1" id="commentList">
</table>
<textarea rows="10" cols="100" id="comments"></textarea>
<br />
<button type="button" id="btnSave">댓글 등록</button>
<button type="button" id="btnEdit">수정</button>
<button type="button" id="btnList">목록</button>