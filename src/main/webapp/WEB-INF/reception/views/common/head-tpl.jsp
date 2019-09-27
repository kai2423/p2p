<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="el-header" >
    <div class="container" style="position: relative;">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/reception/views/main.do">首页</a></li>
                <c:choose>
                	<c:when test="${empty logininfo }">
                		<li><a href="${pageContext.request.contextPath }/reception/login.html">登录</a></li>
                		<li><a href="${pageContext.request.contextPath }/reception/register.html">快速注册</a></li>
               		</c:when>
               		<c:otherwise>
		                <li>
		                      <a class="el-current-user" href="personal.do">${logininfo.username}</a>
		                </li>
		                <li><a  href="#">账户充值  </a></li>
		                <li><a  href="${pageContext.request.contextPath}/reception/views/common/logout.do">注销 </a></li>
                    </c:otherwise>
                </c:choose>
            <li><a href="#">帮助</a></li>
        </ul>
    </div>
</div>