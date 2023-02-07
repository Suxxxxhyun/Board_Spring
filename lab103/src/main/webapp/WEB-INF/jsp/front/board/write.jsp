<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(document).ready(function(){
		$("#btnList").click(function(){
			location.replace("list.do");
		});
	}
</script>
<form name="frm" method="post" action="create.do"> 
	<table border="1">
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title"/>
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${user.userNm }"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" id="content"/></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" id="btnSave" value="저장"/>
	<button type="button" id="btnList">목록</button>
</form>