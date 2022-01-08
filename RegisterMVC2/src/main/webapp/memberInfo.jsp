<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<link rel="stylesheet" href="css/list.css">
<body>
<table>
		<caption>회원 정보 보기</caption>
			<tr>
				<td>아이디</td>
				<td>${mbean.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${mbean.pw}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${mbean.email}</td>
			</tr>
			<tr>
				<td>전화</td>
				<td>${mbean.tel}</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>${mbean.hobby}</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>${mbean.job}</td>
			</tr>	
			<tr>
				<td>정보</td>
				<td>${mbean.info}</td>
			</tr>	
		</table>
		<div class="btn">
			<div>
				<button type="button" onclick="location.href='MemberUpdateCon.do?id=${mbean.id}'">회원수정</button>
				<button type="button" onclick="location.href='memberDeleteForm.jsp?id=${mbean.id}'">회원삭제</button>
				<!-- <button type="button" onclick="location.href='MemberListCon.do'">목록보기</button>
				<button type="button" onclick="location.href='memberJoin.jsp'">회원가입</button> -->
			</div>
		</div>
</body>
</html>