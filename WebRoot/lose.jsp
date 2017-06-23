<%@page import="dao.UserDao"%>
<%@page import="domain.losefindinfo"%>
<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>找到了 | 寻物</title>
		<!-- 导入 css-->
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<!--导入jquery.js-->
		<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
			
		<!--导入bootstrap.js-->
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	</head>
	<body>
		<!-- header-->
		<div class="container">
			<!--logo
				
				小屏幕 2个一行 
				超小屏幕一个一行
			-->
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12" >
					<img src="img/find.png" />
				</div>
				
				<c:if test="${not empty user}">		
					<div class="col-md-5 col-sm-6 col-xs-12 pull-right" >
						<ul class="list-inline" >
							<li style="padding-top: 25px;p">${user.user } 欢迎你！ </li>
								<%-- <img class="img-responsive" src=<%=logo %> alt="Responsive image" class="img-circle"> --%>
							<li><a href="Persenal?method=login">个人主页</a></li>
							<li><a href="login?method=exit">退出</a></li>
						</ul>
					</div>
				</c:if>
			</div>
			
			<!--导航条-->
			<div class="row">
				<nav class="navbar navbar-default">
				  <div class="container-fluid">
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand">找到了</a>
				    </div>
				
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				        <li><a href="main.jsp">首页</a></li>
				        <li class="active"><a href="#">寻物<span class="sr-only">(current)</span></a></li>
				        <li><a href="select?method=find&status=2">认领</a></li>
				        <li><a href="#">通过类型查询</a></li>
				      </ul>
				      <form class="navbar-form navbar-left pull-right" role="search">
				        <div class="form-group">
				          <input type="text" class="form-control" placeholder="Search">
				        </div>
				       <a type="submit" class="btn btn-default" href="#">Submit</a>
				      </form>
				     
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
			</div>
			<!--
            	搜索栏的制作
            -->
            <form>
            	
            </form>
            <!--
            	主要内容的制作。
            -->
            <c:forEach items="${list}" var="item" varStatus="status">
			<div class="panel panel-danger">
				  <div class="panel-heading ">
				    <h2 class="panel-title"><a href="">标题：${item.getShorttitle() }</a></h2>
				  </div>
				  <div class="panel-body">
				  	<font size="4">发起人：${item.getUser() }</font>
				  	<h4><small>发起时间：${item.getReleasetime() }</small></h4>
				    <div class="row">
					  <div class="col-md-3">
									<c:if test="${item.getCategory().equals('U盘类')}">
										<img src="img/U.jpg" width="200px" alt=""></img>
									</c:if>
									<c:if test="${item.getCategory().equals('书籍材料类')}">
										<img src="img/book.jpg" width="200px" alt=""></img>
									</c:if>
									<c:if test="${item.getCategory().equals('钥匙类')}">
										<img src="img/key.jpg" width="200px" alt=""></img>
									</c:if>
									<c:if test="${item.getCategory().equals('其他类')}">
										<img src="img/other.png" width="200px" alt=""></img>
									</c:if>
								</div>
					   <div class="col-md-9">
					   	<p>类别：${item.getCategory() }</p>
					   	<p>丢失时间：${item.getDatetime() }</p>
					   	<p>丢失地点：${item.getPlace() }</p>
					   	<p>详细信息：${item.getInformation() }</p>
					   	<p>手机:${item.getPhone() }</p>
					   	<p>邮箱：${item.getAddress() }</p>
					   </div>
					</div>
				  </div>
				  <!--  
				  <div class="panel-footer" align="right"><a href="select?method=show&id=${item.getNumber() }&type=1">了解更多 >>></a></div>
				  -->
			</div>
			</c:forEach>
			
			
			
			
            <!--
            	分页描述：分页器
            -->
          <!--   <div align="center">
	            <nav aria-label="Page navigation" >
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div> -->
			<!--
            	页脚内容
            -->
			<hr></hr>
			<div class="page-header" align="right">
  			<h5>@联系我们:2756299678@qq.com</small></h5>
			</div>
		
		</div>
	</body>
</html>
