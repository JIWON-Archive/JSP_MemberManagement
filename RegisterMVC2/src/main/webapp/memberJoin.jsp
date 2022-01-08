<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="css/join.css">
</head>
<body>
	<div class="wrapper">
		<h2>회원가입</h2>
		<form action="MemberJoinProc.do" method="post">
			<div class="container">
				<div class="input-box">
					<label for="id" class="item">아이디 </label><input type="text" name="id" id="id">
				</div>
				<div class="input-box">
					<label for="pw" class="item">비밀번호 </label><input type="password" name="pw" id=pw>
				</div>
				<div class="input-box">
					<label for="pw-check" class="item">비밀번호 확인 </label><input type="password" name="pwCheck" id="pw-check">
				</div>
				<div class="input-box">
					<label for="email" class="item">이메일 </label><input type="email" name="email" id="email">
				</div>
				<div class="input-box">
					<label for="tel" class="item">전화번호 </label><input type="tel" name="tel" id="tel">
				</div>
			
				<div class="check-box">
					<label class="item">취미</label><br>
					<label for="camping">캠핑 </label><input type="checkbox" name="hobby" value="캠핑" id="camping">&nbsp;
					<label for="hiking">등산 </label><input type="checkbox" name="hobby" value="등산" id="hiking">&nbsp;
					<label for="reading">독서 </label><input type="checkbox" name="hobby" value="독서" id="reading">&nbsp;
					<label for="listening">음악감상 </label><input type="checkbox" name="hobby" value="음악감상" id="listening">&nbsp;
				</div>
				<div class="input-box">
					<label class="item">직업 </label>&nbsp;
					<select name="job" class="select">
						<option value="학생">학생</option>
						<option value="개발자" selected>개발자</option>
						<option value="기획자">기획자</option>
						<option value="디자이너">디자이너</option>
					</select>
				</div>
				<div class="input-box">
					<label class="item">자기소개 </label><br>
					<textarea rows="5" cols="40" name="info"></textarea>
				</div>
				<div class="button">
					<input type="submit" value="회원가입">
					<input type="reset" value="취소">
				</div>
			</div>
		</form>
	</div>
</body>
</html>