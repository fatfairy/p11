<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<%
	String bashPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<base href="<%=bashPath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台 订单列表</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function sendOrder(id,m){
		location.href = "sendOrder?oid="+id+"&m="+m;
	}
	$(function(){
		$("#search").click(function(){
			var username = $("input[name='username']").val();
			var status = $("select[name='orderStatus'] option:selected").val();
			location.href="searchOrder?username="+username+"&status="+status;
		})
	})
</script>
</head>
<body>
<div class="row" style="width:98%;margin-left: 1%;margin-top: 5px;">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				订单列表
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group form-inline">
							<span>用户姓名</span>
							<input type="text" name="username" class="form-control">
						</div>
					</div>
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group form-inline">
							<span>订单状态</span>
							<select name="orderStatus" class="form-control">
								<option value=" ">----------</option>
								<option value="1">未支付</option>
								<option value="2">已支付,待发货</option>
								<option value="3">已发货,待收货</option>
								<option value="4">完成订单</option>
							</select>
						</div>
					</div>
					<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
						<button type="button" class="btn btn-primary" id="search"><span class="glyphicon glyphicon-search"></span></button>
					</div>
				</div>
				
				<table id="tb_list" class="table table-striped table-hover table-bordered table-condensed">
					<tr>
						<td>序号</td>
						<td>订单编号</td>
						<td>总金额</td>
						<td>订单状态</td>
						<td>订单时间</td>
						<td>用户姓名</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${orderList}" var="order" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${order.oId}</td>
						<td>${order.oCount}</td>
						<td>
							<c:if test="${order.oState eq 1}">
								未支付
							</c:if>
							<c:if test="${order.oState eq 2}">
								已支付,待发货
							</c:if>
							<c:if test="${order.oState eq 3}">
								已发货,待收货
							</c:if>
							<c:if test="${order.oState eq 4}">
								订单完成
							</c:if>
						</td>
						<td>${order.oTime}</td>
						<td>${order.userName}</td>
						<td>
							<c:if test="${order.oState eq 2}">
								<button type="button" class="btn btn-danger btn-sm" onclick="sendOrder('${order.oId}','send')">发货</button>
							</c:if>

							<c:if test="${order.oState eq 3}">
								<button type="button" class="btn btn-primary btn-sm" onclick="sendOrder('${order.oId}','refund')">退款</button>
							</c:if>
						</td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>