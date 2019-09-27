<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>蓝源Eloan-P2P平台</title>
		<%@ include file="common/links-tpl.jsp"  %>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/reception/css/account.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/reception/js/plugins/jquery.twbsPagination.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/reception/js/plugins-override.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/reception/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		 	$(function(){
		 		$("#beginDate").click(function(){
		 			WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M\'}'}); //只能选择今天之前的时间
		 		})
		 		$("#endDate").click(function(){
		 			WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'beginDate\')}',maxDate:'%y-%M-%d'}); //只能选择今天之前的时间
		 		})
		 		$("#query").click(function(){
		 			$("#currentPage").val(1); //重新查询的时候设置当前页为1
		 			$("#searchForm").submit() ;
		 		})
		 		//不是局部刷新数据
		 		//通过发送请求，让服务器重新为该jsp加载数据
		 		$("#pagination").twbsPagination({
		 			totalPages: 15, //${pageResult.totalPage}, //总页数,当没有数据时，使用默认的页数1		 			
	 	
		 			visiblePages:10,  //表示页面上面最多可以显示几页 	 			
		 			startPage: 1,//${pageResult.currentPage}, 起始页
		 			onPageClick:function(eventm,page){
		 				$("#currentPage").val(page); 
			 			$("#searchForm").submit(); 
		 			}
		 		})
		 	});
		
		</script>
	</head>
	<body>
	
		<!-- 网页顶部导航 -->
		<%@ include file="common/head-tpl.jsp" %>
		<!-- 网页导航 -->
		<c:set var="currentNav" value="personal"></c:set>
		<%@ include file="common/navbar-tpl.jsp" %>
		<div class="container">
			<div class="row">
				<!--导航菜单-->
				<div class="col-sm-3">
					<c:set var="currentMenu" value="ipLog"></c:set>
					<%@ include file="common/leftmenu-tpl.jsp" %>		
				</div>
				<!-- 功能页面 -->
				<div class="col-sm-9">
					<form action="${pageContext.request.contextPath }/reception/views/iplog_list/getdataOfPaging.do" name="searchForm" id="searchForm" class="form-inline" method="post">
						<input type="hidden" id="currentPage" name="currentPage" value="" />
						<div class="form-group">
							<label>时间范围</label>
							<input type="text" class="form-control beginDate" name="beginDate" id="beginDate" value='${qo.beginDate}'/>
						</div>
						<div class="form-group">
							<label></label>
							<input type="text" class="form-control endDate" name="endDate" id="endDate" value='${qo.endDate}'/>
						</div>
						<div class="form-group">
						    <label>状态</label>
						    <select class="form-control" name="state" id="state">
						    	<option value="-1">全部</option>
						    	<option value="0">登录失败</option>
						    	<option value="1">登录成功</option>
						    </select>
						    <script type="text/javascript">
						    	$("#state option[value=${qo.state}]").attr("selected" , true);
						    </script>
						</div>
						<div class="form-group">
							<button type="button" id="query" class="btn btn-success"><i class="icon-search"></i> 查询</button>
						</div>
					</form>
					
					<div class="panel panel-default" style="margin-top: 20px;">
						<div class="panel-heading">
							登录日志
						</div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>用户</th>
									<th>登录时间</th>
									<th>登录ip</th>
									<th>登录状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pageResult.listData }" var="item">
									<tr>
										<td>${item.userName}</td>
										<td>${item.loginTime}</td>
								        <td>${item.ip}</td>
								        <td>${item.stateDisplay}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table> 	
						<div style="text-align: center;">
							<ul id="pagination" class="pagination"></ul>
						</div>
					</div>
				</div>
			</div>
		</div>		
		<%@ include file="common/footer-tpl.jsp" %>		
	</body>
</html>