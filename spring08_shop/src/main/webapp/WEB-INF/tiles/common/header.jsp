<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class = "navbar navbar-expand navbar-dark bg-dark">
	<div class = "container">
		<div class = "navbar-header">
			<a class = "navbar-brand" class = "nav-link" href = "${pageContext.request.contextPath}/home.do">My Market</a>
		</div>
	</div>
	
	<div>
		<ul class = "navbar-nav mr-auto">
			<c:choose>
				<c:when test="${sessionScope.authInfo == null}">
					<li class = "nav-item"><a class = "nav-link" href = "${pageContext.request.contextPath}/member/login.do">로그인</a></li>
					<li class = "nav-item"><a class = "nav-link" href = "${pageContext.request.contextPath}/member/signup.do">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li class = "nav-item"><a class = "nav-link" href = "${pageContext.request.contextPath}/member/logout.do">${sessionScope.authInfo.memberName}님 로그아웃</a></li>
					<li class = "nav-item"><a class = "nav-link" href = "${pageContext.request.contextPath}/member/changepass.do">비밀번호 변경</a></li>
					<li class = "nav-item"><a class = "nav-link" href = "${pageContext.request.contextPath}/member/editmember.do">회원정보 수정</a></li>
				</c:otherwise>
			</c:choose>
					<li class = "nav-item"><a class = "nav-link" href = "${pageContext.request.contextPath}/board/list.do?currentPage=1">게시판</a></li>
		</ul>
	</div>
	
</nav>

