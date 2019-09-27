<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝源Eloan-P2P平台</title>
<%@ include file="common/links-tpl.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/reception/js/plugins/jquery.form.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/reception/css/account.css" />

<script type="text/javascript">
	$(function() {

	});
</script>
</head>
<body>
	<!-- 网页顶部导航 -->
	<%@ include file="common/head-tpl.jsp"%>
	<!-- 网页导航 -->
	<!-- 在当前的freemarker的上下文中,添加一个变量,变量的名字叫currentNav,变量的值叫personal -->
	<c:set var="currentNav" value="personal"></c:set>
	<%@ include file="common/navbar-tpl.jsp"%>

	<div class="container">
		<div class="row">
			<!--导航菜单-->
			<div class="col-sm-3">
				<c:set var="currentMenu" value="personal"></c:set>
				<%@ include file="common/leftmenu-tpl.jsp"%>
			</div>
			<!-- 功能页面 -->
			<div class="col-sm-9">
				<div class="panel panel-default">
					<div class="panel-body el-account">
						<div class="el-account-info">
							<div class="pull-left el-head-img">
								<img class="icon"
									src="${pageContext.request.contextPath}/reception/images/ms.png" />
							</div>
							<div class="pull-left el-head">
								<p>用户名:${logininfo.username}</p>
								<p>
									最后登录时间：<% out.print(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())); %>
								</p>
							</div>
							<div class="pull-left"
								style="text-align: center; width: 400px; margin: 30px auto 0px auto;">
								<a class="btn btn-primary btn-lg" href="/recharge.do">账户充值</a> <a
									class="btn btn-danger btn-lg" href="/moneyWithdraw.do">账户提现</a>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="row h4 account-info">
							<div class="col-sm-4">
								账户总额：<span class="text-primary">${totalAmount}元</span>
							</div>
							<div class="col-sm-4">
								可用金额：<span class="text-primary">${account.usableAmount}元</span>
							</div>
							<div class="col-sm-4">
								冻结金额：<span class="text-primary">${account.freezedAmount}元</span>
							</div>
						</div>

						<div class="row h4 account-info">
							<div class="col-sm-4">
								待收利息：<span class="text-primary">${account.unReceiveInterest}元</span>
							</div>
							<div class="col-sm-4">
								待收本金：<span class="text-primary">${account.unReceivePrincipal}元</span>
							</div>
							<div class="col-sm-4">
								待还本息：<span class="text-primary">${account.unReturnAmount}元</span>
							</div>
						</div>

						<div class="el-account-info top-margin">
							<div class="row">
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img
												src="${pageContext.request.contextPath}/reception/images/shiming.png" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>实名认证</h5>

											<p>
												已认证 <a href="#">查看</a>
											</p>

											<p>
												未认证 <a href="#">马上认证 </a>
											</p>

										</div>
										<div class="clearfix"></div>
										<p class="info">实名认证之后才能在平台投资</p>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img
												src="${pageContext.request.contextPath}/reception/images/shouji.jpg" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>手机认证</h5>

											<p>
												已认证 <a href="#">查看</a>
											</p>

											<p>
												未认证 <a href="javascript:;" id="showBindPhoneModal">马上绑定</a>
											</p>

										</div>
										<div class="clearfix"></div>
										<p class="info">可以收到系统操作信息,并增加使用安全性</p>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img
												src="${pageContext.request.contextPath}/reception/images/youxiang.jpg" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>邮箱认证</h5>

											<p>
												已绑定 <a href="#">修改</a>
											</p>

											<p>
												未绑定 <a href="javascript:;" id="showBindEmailModal">马上绑定</a>
											</p>


										</div>
										<div class="clearfix"></div>
										<p class="info">您可以设置邮箱来接收重要信息</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img
												src="${pageContext.request.contextPath}/reception/images/baozhan.jpg" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>VIP会员</h5>
											<p>
												普通用户 <a href="#">查看</a>
											</p>
										</div>
										<div class="clearfix"></div>
										<p class="info">VIP会员，让你更快捷的投资</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="bindPhoneModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">绑定手机</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="bindPhoneForm" method="post"
						action="/bindPhone.do">
						<div class="form-group">
							<label for="phoneNumber" class="col-sm-2 control-label">手机号:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="phoneNumber"
									name="phoneNumber" />
								<button id="sendVerifyCode" class="btn btn-primary"
									type="button" autocomplate="off">发送验证码</button>
							</div>
						</div>
						<div class="form-group">
							<label for="verifyCode" class="col-sm-2 control-label">验证码:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="verifyCode"
									name="verifyCode" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="bindPhone">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="bindEmailModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">绑定邮箱</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="bindEmailForm" method="post"
						action="/sendEmail.do">
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="email" name="email" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="bindEmail">保存</button>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="common/footer-tpl.jsp"%>
</body>
</html>