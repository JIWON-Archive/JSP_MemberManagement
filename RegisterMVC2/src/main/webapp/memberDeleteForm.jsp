<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
<link rel="stylesheet" href="css/update-delete.css">	
</head>
<body>
	<div class="wrapper">
		<form action="MemberDeleteProcCon.do" method="post">
			<div class="container">
				<h2>회원 삭제</h2>
				<div class="item">
					<label>아이디</label>
					<input type="text" name="id" value="${param.id}">
					<%-- <label><%= request.getParameter("id") %></label> --%>
				</div>
				<div class="item">
				<label>비밀번호</label> 
				<input type="password" name="pw">
				</div>
				<div class="message">
					<p>회원 삭제 완료 버튼을 누르면 탈퇴되며 계정을 복구할 수 없습니다.</p>
				</div>
			</div>
			<div class="btn-delete">
				<input type="hidden" name="id" value="${param.id}"> 
				<input type="submit" value="회원 삭제 완료" class="del-btn">
			</div>
		</form>
		<div class="btn-all">
			<button class="del-btn" onclick="location.href='MemberListCon.do'">회원 삭제 취소</button>
		</div>
	</div>
</body>
</html>