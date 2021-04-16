<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Portal</title>
<link rel="stylesheet" href="<c:url value="/assets/css/user.css" />" />
<!-- jQuery -->
<script src="<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<!-- 스크립트 삽입 -->
<script src="<c:url value="/assets/javascript/members.js"/>"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
					<form id="login-form" name="loginform" method="POST" action="<c:url value="/members/login"/>">

						<label class="block-label" for="email">이메일</label> <input
							id="email" name="email" type="text" value=""> <label
							class="block-label">패스워드</label> <input name="password"
							type="password" value=""> <input type="submit"
							value="로그인">
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>