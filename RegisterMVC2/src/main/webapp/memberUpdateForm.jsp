<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<link rel="stylesheet" href="css/update-delete.css">
<body>
	<form action="MemberUpdateProcCon.do" method="post">
		<div class="container">
			<h2>회원 정보 수정</h2>
			<div class="item">
				<label>아이디</label>
				<label>${mbean.id}</label>
			</div>
			<div class="item">
				<label>이메일</label>
				<input type="email" name="email" value="${mbean.email}">
			</div>
			<div class="item">
				<label>전화</label>
				<input type="tel" name="tel" value="${mbean.tel}">
			</div>
			<div class="item">
				<label>비밀번호</label>
				<input type="password" name="pw" value="${mbean.pw}">
			</div>
		</div>
		<div class="btn-update">
			<input type="hidden" name="id" value="${mbean.id}">
		<%-- 	<input type="hidden" name="pw" value="${mbean.pw}"> --%>
			<input type="submit" class="up-btn" value="회원 수정 완료">&nbsp;
			<button type="button" class="up-btn" onclick="location.href='MemberListCon.do'">전체 회원 보기</button>
		</div>
	</form>
</body>
</html>