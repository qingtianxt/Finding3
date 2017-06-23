<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>找到了 | 主页</title>
<!-- 导入 css-->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!--导入jquery.js-->
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>

<!--导入bootstrap.js-->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- 导入validate  -->
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>

<script>
	$(function() {
		$("#checkForm2").validate({
			errorElement : 'span',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				user : {
					required : true,
				},

				password : {
					required : true,
				},
				password2 : {
					required : true,
					equalTo : "#password"
				},
				email : {
					required : true,
				},
				phone : {
					required : true,
				}
			},
			messages : {
				user : {
					required : "用户名为空",
				},

				password : {
					required : "密码为空",
				},
				password2 : {
					required : "密码为空",
					equalTo : "两次输入密码不一致"
				},
				email : {
					required : "邮箱为空",
				},
				phone : {
					required : "电话号码为空",
				}
			},
			highlight : function(element) {
				$(element).closest('.form-group').addClass('has-error');
			},
			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},
			errorPlacement : function(error, element) {
				element.parent('div').append(error);
			}
		});
	});
</script>
<script>
	$(function() {
		$('.carousel').carousel({
			interval : 3000
		})
	})
</script>
<style type="text/css">
.code {
	background-image: url(code.jpg);
	font-family: Arial;
	font-style: italic;
	color: Red;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}

.unchanged {
	border: 0;
}
</style>
<script>
	$(function() {
		$("#checkForm").validate({
			errorElement : 'span',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				user : {
					required : true,
				},
				codeCheck : {
					required : true,
					equalTo : "#checkCode"
				},
				password : {
					required : true,
				}
			},
			messages : {
				user : {
					required : "用户名为空",
				},
				codeCheck : {
					required : "验证码为空",
					equalTo : "验证码输入错误"
				},
				password : {
					required : "密码为空",
				}
			},
			highlight : function(element) {
				$(element).closest('.form-group').addClass('has-error');
			},
			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},
			errorPlacement : function(error, element) {
				element.parent('div').append(error);
			}
		});
	});
</script>
<style type="text/css">
.code {
	background-image: url(code.jpg);
	font-family: Arial;
	font-style: italic;
	color: Red;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}

.unchanged {
	border: 0;
}
</style>
<script type="text/javascript">
	var code; //在全局 定义验证码   
	function createCode() {
		code = "";
		var codeLength = 4; //验证码的长度   
		var checkCode = document.getElementById("checkCode");
		var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'); //所有候选组成验证码的字符，当然也可以用中文的   

		for (var i = 0; i < codeLength; i++) {

			var charIndex = Math.floor(Math.random() * 36);
			code += selectChar[charIndex];

		}
		//  alert(code);   
		if (checkCode) {
			checkCode.className = "code";
			checkCode.value = code;
		}

	}
</script>
</head>
<body onload="createCode()">
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
			<c:if test="${user.user.equals('')}">
				<div class="col-md-5 col-sm-6 col-xs-12 pull-right">
					<ul class="list-inline">
						<li style="padding-top: 25px;p">${user.user }欢迎你！</li>
						<%-- <img class="img-responsive" src=<%=logo %> alt="Responsive image" class="img-circle"> --%>
						<li><a href="Persenal?method=login">个人主页</a></li>
						<li><a href="login?method=exit">退出</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${!user.user.equals('')}">

				<div class="pull-right">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal" data-whatever="@mdo">登录</button>
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal1" data-whatever="@fat">注册</button>

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">登录</h4>
								</div>
								<div class="modal-body">
									<form action="login?method=login" method="post" id="checkForm">
										<div class="form-group">
											<label for="exampleInputPassword1">昵称</label> <input
												type="text" class="form-control" id="exampleInputPassword1"
												name="user" placeholder="username">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">密码</label> <input
												type="password" class="form-control"
												id="exampleInputPassword1" name="password"
												placeholder="password">
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="checkCode">验证码</label>
											<div class="col-md-4">
												<input type="text" name="codeCheck" class="form-control"
													id="codeCheck" placeholder="Code">
											</div>
											<div class="col-md-4">
												<input type="text" onclick="createCode()" readOnly="true"
													id="checkCode" class="unchanged" style="width: 80px" />
											</div>
											<div class="col-md-1"></div>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="submit" class="btn btn-primary">登录</button>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>

					<!-- Modal -->
					<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">注册页面</h4>
								</div>
								<div class="modal-body">
									<form action="login?method=register" method="post"
										id="checkForm2">
										<div class="form-group">
											<label for="exampleInputPassword1">昵称</label> <input
												type="text" class="form-control" id="exampleInputPassword1"
												name="user" placeholder="username">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">密码</label> <input
												type="password" class="form-control" id="password"
												name="password" placeholder="password">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">再次输入密码</label> <input
												type="password" class="form-control"
												id="exampleInputPassword2" name="password2"
												placeholder="repassword">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">邮箱</label> <input
												type="email" class="form-control" id="exampleInputEmail1"
												name="email" placeholder="email">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">手机号</label> <input
												type="text" class="form-control" id="exampleInputEmail1"
												name="phone" placeholder="phone">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="submit" class="btn btn-primary">提交</button>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>

		<c:if test="${param.status.equals('1')}">
			<div class="alert alert-success" role="alert">注册成功</div>
		</c:if>
		<c:if test="${param.status.equals('2')}">
			<div class="alert alert-success" role="alert">注册失败</div>
		</c:if>
		<c:if test="${param.status.equals('3')}">
			<div class="alert alert-success" role="alert">登录失败 ，用户名或密码错误</div>
		</c:if>
		<c:if test="${param.status.equals('4')}">
			<div class="alert alert-success" role="alert">你还没有登录，请登录</div>
		</c:if>
		<c:if test="${param.status.equals('5')}">
			<div class="alert alert-success" role="alert">退出成功</div>
		</c:if>
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
						<a class="navbar-brand">找到了</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">首页<span class="sr-only">(current)</span></a></li>
							<li><a href="select?method=lose&status=1">寻物</a></li>
							<li><a href="select?method=find&status=2">认领</a></li>
							<li><a href="#">通过类型查询</a></li>
						</ul>
						<form class="navbar-form navbar-left pull-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
		<!--
        	轮播图
        -->
		<div class="row">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<!--需要几张图片 就得添加几个 li 还需要在下面的div提供几个 class=item的div-->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- 显示的图片 -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/1.jpg" alt="">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="img/2.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="img/3.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!--
        	寻物消息内容
        -->
		<div class="page-header">
			<h1>
				寻物消息 <small>find</small>
			</h1>
			<h4>
				<small>在这里，你可能会找到自己丢失的物品的信息。</small>
			</h4>
		</div>
		<div class="row">
			<form action="select?method=lose&status=3" method="post">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/book.jpg" alt="">
						<div class="caption">
							<h3>书籍</h3>
							<p>进步的阶梯，成果的积累，书中自有颜如玉，书中自有黄金屋。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="书籍材料类">书籍材料类</button>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/key.jpg" alt="">
						<div class="caption">
							<h3>钥匙</h3>
							<p>房间的钥匙，自行车的车锁，钥匙在生活中扮演者重要的角色。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="钥匙类">钥匙类</button>
						</div>
					</div>
				</div>


				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/U.jpg" alt="">
						<div class="caption">
							<h3>U盘</h3>
							<p>记忆的枷锁，胜利的果实，重要的回忆，信息的载体。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="U盘类">U盘类</button>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/other.png" alt="">
						<div class="caption">
							<h3>其他</h3>
							<p>钱包，手机，校园卡，身份证，重要的东西，捡到的一定要记得归还。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="其他类">其他类</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!--
        	寻主消息内容
        -->
		<div class="page-header">
			<h1>
				认领消息 <small>find</small>
			</h1>
			<h4>
				<small>在这里，你可能会找到自己捡到的物品的信息。</small>
			</h4>
		</div>
		<div class="row">
			<form action="select?method=find&status=4" method="post">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/book.jpg" alt="">
						<div class="caption">
							<h3>书籍</h3>
							<p>进步的阶梯，成果的积累，书中自有颜如玉，书中自有黄金屋。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="书籍材料类">书籍材料类</button>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/key.jpg" alt="">
						<div class="caption">
							<h3>钥匙</h3>
							<p>房间的钥匙，自行车的车锁，钥匙在生活中扮演者重要的角色。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="钥匙类">钥匙类</button>
						</div>
					</div>
				</div>


				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/U.jpg" alt="">
						<div class="caption">
							<h3>U盘</h3>
							<p>记忆的枷锁，胜利的果实，重要的回忆，信息的载体。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="U盘类">U盘类</button>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="thumbnail">
						<img src="img/other.png" alt="">
						<div class="caption">
							<h3>其他</h3>
							<p>钱包，手机，校园卡，身份证，重要的东西，捡到的一定要记得归还。</p>
							<button type="submit" class="btn btn-danger btn-lg btn-block"
								name="type" value="其他类">其他类</button>
						</div>
					</div>
				</div>
			</form>
		</div>

		<hr></hr>
		<div class="page-header" align="right">
			<h5>
				@联系我们:2756299678@qq.com</small>
			</h5>
		</div>

	</div>
</body>
</html>
