<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<script>	
	$(document).ready(function(){
		$(".idDesc").css("display","none");
		$("#btnList").click(function(){
			location.replace("list.do");
		});
		$("#btnDup").click(function(){
			var params = {
				userId : $("#userId").val()
				//이때 키의 userId : 부분은 UserVO의 get,set떼고의 메소드명과 같아아함(물론 첫문자는 소문자로)
				, password : $("#password").val()
			}
			
			$.ajax({
				type:"POST"
				, url:"dupCheck.do"
				, data : params
				, success:function(data){
					$(".idDesc").css("display","block");
					if(data.ret == true){
						$(".idDesc").text("사용가능한 아이디입니다.");
					} else {
						$(".idDesc").text("기존에 사용중인 아이디입니다.");
					}
					//console.log(data.ret);
				} 
				, error:function(XMLHttpRequest, textStatus, errorThrown){
					alert(textStatus);
				}
				//17~19라인이 성공을 했으면 (잘 보내졌으면, 아이디 중복이든 중복이 아니든 success로 보내짐) respons의 res
				//url부분은 write.do가 어차피 /admin/user/write.do이기때문에 /admin/user/일치해서 이 부분은 위에 작성하지 않아도됨.
			})
		});
	});
	
	function dupCheck(frm){
		if($(".idDesc").text().length == ""){
			alert("중복 확인을 해야합니다.");
			return false;
		}
		return true;
	}
</script>
<form name="frm" method="post" action="create.do"> 
	<table border="1">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="userId" name="userId"/>
					<button type="button" id="btnDup">중복확인</button>
					<p class="idDesc"></p>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userNm"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<select name="roleCd">
					<c:forEach items="${roleList }" var="roleList" varStatus="index">
						<option value="${roleList.roleCd }">${roleList.roleNm }</option>
						<!--  <option value="001">관리자</option>
						<option value="002">사용자</option>-->
					</c:forEach>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<input type="submit" id="btnSave" value="저장" onclick="return dupCheck()"/>
	<button type="button" id="btnList">목록</button>
</form>
