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
<title>商品列表页</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	
   
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;商品列表</h3>
	</div>
	<div class="panel-body">
	   	   <!--列表开始-->
	    <div class="row" style="margin: 0 auto;">
	    	<c:forEach items="${glist.list}" var="g" varStatus="i">
		    	<div class="col-sm-3">
				    <div class="thumbnail">
				      <img src="${g.pImage}" width="180" height="180"  alt="小米6" />
				      <div class="caption">
				        <h4>商品名称<a href="getGoodsById?id=${g.pId}">${g.pName}</a></h4>
				        <p>热销指数
				        	<c:forEach begin="1" end="${g.pState}">
				        		<img src="image/star_red.gif" alt="star"/>
				        	</c:forEach>
				        </p>
				         <p>上架日期:${g.pTime}</p>
			             <p style="color:orange">价格:${g.pPrice}</p>
				      </div>
				    </div>
				  </div>
	    	</c:forEach>

			<center>
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-end">

					<c:choose>
						<c:when test="${glist.isFirstPage}">
							<li class="page-item disabled">
								<a class="page-link">Previous</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="getGoodsListByTypeId?pageNo=${glist.prePage}&typeid=${glist.list.get(0).tId}">Previous</a>
							</li>
						</c:otherwise>
					</c:choose>


					<c:forEach begin="1" end="${glist.pages}" step="1" var="i">
						
						<c:if test="${i==glist.pageNum}">
							<li class="page-item active">
						</c:if>

						<c:if test="${i!=glist.pageNum}">
							<li class="page-item">
						</c:if>

							<a class="page-link" href="getGoodsListByTypeId?pageNo=${i}&typeid=${glist.list.get(0).tId}">${i}</a>
						</li>
					</c:forEach>

					<c:choose>
						<c:when test="${glist.isLastPage}">
							<li class="page-item disabled">
								<a class="page-link" href="#">Next</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="getGoodsListByTypeId?pageNo=${glist.nextPage}&typeid=${glist.list.get(0).tId}">Next</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			</center>
		</div>
   	</div>
</div>
      <!-- 底部 -->
   <%@ include file="footer.jsp"%>
</body>
</html>