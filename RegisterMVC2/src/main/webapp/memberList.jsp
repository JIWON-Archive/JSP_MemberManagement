<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 관리자 페이지 -->
<title>모든 회원 보기</title>
</head>
<link rel="stylesheet" href="css/list.css">
<body>
	<table>
		<caption>모든 회원 보기</caption>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
		<!-- ArrayList list에서 꺼내서 가져오고 bean 키워드로 담아준다. -->
			<c:forEach var="bean" items="${list}">
				<tr>
					<td><a href="MemberInfoCon.do?id=${bean.id}">${bean.id}</a></td>
					<td>${bean.email}</td>
					<td>${bean.tel}</td>
					<td>${bean.hobby}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</body>
</html>