<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%
	String bashPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<base href="<%=bashPath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function pNum(pid,p,no){
		// var nums = $("#num_count"+no).val();
		var num = no+1;
		$.ajax({
			url:"updateCartNum?pid="+pid+"&num="+num+"&price="+p,
			method:"get",
			success:function(){
				location.href = "getCart";
			},
			error:function(){
				alert("服务器异常");
			}
		})
	}
	function mNum(pid,p,no){
		var num = no-1; //数量
		// var nums = $("#num_count"+no).val();
		if(Number(no)<=1){
			if(confirm("确认要删除吗?")){
				num = 0;
			}else{
				return;
			}
		}
		$.ajax({
			url:"updateCartNum?pid="+pid+"&num="+num+"&price="+p,
			method:"get",
			success:function(){
				location.href = "getCart";
			},
			error:function(){
				alert("服务器异常");
			}
		})
	}
	function clearCart(pid){
		if(confirm("确认要删除吗")){
			location.href="clearCart?pid="+pid;
		}
	}
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>我的购物车<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small></h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
 					<th>序号</th>
 					<th>商品名称</th>
 					<th>价格</th>
 					<th>数量</th>
 					<th>小计</th>
 					<th>操作</th>
 				</tr>
 				<c:set value="0" var="sum"></c:set>
 				<c:forEach items="${cart.products}" var="c" varStatus="i">
	 				<tr>
	 					<th>${i.count}</th>
	 					<th>${c.pName}</th>
	 					<th>${c.pPrice}</th>
	 					<th width="100px">
		 					<div class="input-group">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="mNum(${c.pId},${c.pPrice},${c.num})">-</button>
		 						</span>
		 						<input type="text" class="form-control" id="num_count${c.num}" value="${c.num}" readonly="readonly" style="width:40px">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="pNum(${c.pId},${c.pPrice},${c.num})">+</button>
		 						</span>
	 						</div>
	 					</th>
	 					<th>¥&nbsp;${c.num*c.pPrice}</th>
	 					<th>
	 						<button type="button" class="btn btn-default" onclick="clearCart(${c.pId})">删除</button>
	 					</th>
	 				</tr>
					<c:set var="sum" value="${c.num*c.pPrice}"></c:set>
<%--	 				<c:set var="sum" value="${sum+c.money}"></c:set>--%>
 				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="pull-right" style="margin-right: 40px;">
			
	            <div>
	            	<a id="removeAllProduct" href="javascript:clearCart(0)" class="btn btn-default btn-lg">清空购物车</a>
	            	&nbsp;&nbsp;
	            	<a href="getOrderView" class="btn  btn-danger btn-lg">订单预览</a>
	            	
	            </div>
	            <br><br>
	            <div style="margin-bottom: 20px;">        		  
	            	商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;${cart.cCount}</b></span>
	            </div>
		</div>
	</div>
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>