<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-default el-navbar">
	<div class="container">
		<div class="navbar-header">
			<a href="/">
				<img alt="Brand" src="${pageContext.request.contextPath}/reception/images/logo.png">
			</a>
		</div>
		<ul class="nav navbar-nav">
			<li id="index"><a href="${pageContext.request.contextPath}/reception/views/main.do">首页</a></li>
			<li id="invest"><a href="#">我要投资</a></li>
			<li id="borrow"><a href="#">我要借款</a></li>
			<li id="personal"><a href="${pageContext.request.contextPath}/reception/views/personal.do">个人中心</a></li>
			<li><a href="#">新手指引</a></li>
			<li><a href="#">关于我们</a></li>
		</ul>
	</div>
</div>

<c:if test="${currentNav}">
<script type="text/javascript">
	$("#${currentNav}").addClass("active");
</script>
</c:if>