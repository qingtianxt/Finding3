<%@page import="dao.UserDao"%>
<%@page import="domain.*"%>
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
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>

<!--导入bootstrap.js-->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<!-- header-->
	<div class="container">
		<!--logo
				
				小屏幕 2个一行 
				超小屏幕一个一行
			-->
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<img src="img/find.png" />
			</div>

			
		</div>


		<!--导航条-->
		<div class="row">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">找到了</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="main.jsp">首页</a></li>
							<li><a href="select?method=lose&status=1">寻物</a></li>
							<li><a href="select?method=find&status=2">认领</a></li>
							<li class="active"><a href="#">通过类型查询<span class="sr-only">(current)</span></a></li>
						</ul>
						<form class="navbar-form navbar-left pull-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="button" class="btn btn-default" href="#">Submit</button>
						</form>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
		<!--
            	搜索框的制作
            -->
		<c:if test="${param.status.equals('1')}">
			<div class="page-header">
				<h1>
					寻物消息 <small>find</small>
				</h1>
				<h4>
					<small>在这里，你可能会找到自己丢失的物品的信息。</small>
				</h4>

			</div>
		</c:if>
		<c:if test="${param.status.equals('2')}">
			<div class="page-header">
				<h1>
					认领消息 <small>find</small>
				</h1>
				<h4>
					<small>在这里，你可能会找到自己捡到的物品的信息。</small>
				</h4>
			</div>
		</c:if>
		<c:forEach items="${list}" var="item" varStatus="status">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="panel panel-success">
					<div class="panel-heading ">
						<h2 class="panel-title">
						<c:if test="${param.status.equals('1')}">寻物消息</c:if>
							<c:if test="${param.status.equals('2')}">认领消息</c:if>
						${item.getShorttitle() }
						</h2>
					</div>
					<div class="panel-body">
						<h4>
							<small>发起时间：${item.getReleasetime() }</small>
						</h4>
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
								<c:if test="${param.status.equals('1')}">
								<p>丢失时间：${item.getDatetime() }</p>
								<p>丢失地点：${item.getPlace() }</p>
								<p>详细信息：${item.getInformation() }</p>
									<p>手机:${item.getPhone() }</p>
									<p>邮箱：${item.getAddress() }</p>
								</c:if>
								<c:if test="${param.status.equals('2')}">
								<p>捡到时间：${item.getDatetime() }</p>
								<p>捡到地点：${item.getPlace() }</p>
								<p>详细信息：${item.getInformation() }</p>
									<p>手机:${item.getPhone() }</p>
									<p>邮箱：${item.getAddress() }</p>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach> 

		<!--
            	页脚内容
            -->
		<hr></hr>
		<div class="page-header" align="right">
			<h5>
				@联系我们:2756299678@qq.com</small>
			</h5>
		</div>

	</div>
</body>
</html>
