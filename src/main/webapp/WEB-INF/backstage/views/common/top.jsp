<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar cm-navbar">
	<img class="logo" alt="Brand" src="${pageContext.request.contextPath}/backstage/images/logo.png">
	<span class="pageTitle">&nbsp;</span>
	<ul class="nav navbar-nav navbar-right cm-navbar-nav">
		<li>
			<c:choose>
				<c:when test="${empty sessionScope.username }">
					<a href="${pageContext.request.contextPath}/backstage/login.html">登录</a>
				</c:when>
				<c:otherwise>
					<p class="navbar-text text-info">${sessionScope.username}</p>
				</c:otherwise>
			</c:choose>
			
		</li>
		<li><a href="">安全退出</a></li>
		<li><a href="">个人设置</a></li>
	</ul>
</div>