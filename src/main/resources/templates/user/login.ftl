<!DOCTYPE html>
<html class="bg-black">
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Log in</title>
    <base id="base" href="${baseUrl}">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="${baseUrl}css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="${baseUrl}css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Theme style -->
    <link href="${baseUrl}css/AdminLTE.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bg-black">

<div class="form-box" id="login-box">
    <div class="header">Sign In</div>
    <form action="${baseUrl}user/login/select" method="post">
        <div class="body bg-gray">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="请输入用户名"/>
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="请输入密码"/>
            </div>
            <div class="form-group">
                <span>验证码： <input type="text" name="yzmCode"   class="yzmInput" style="width:40%" placeholder="请输入验证码"/></span>
                <span> <img src="${baseUrl}css/images/v1.0/yzm.gif" alt="点击刷新"  id="loginyz_img" class="code-img"></span>
                <span><a href="javascript:void 0;" onclick="XG_YZM.showImage()">换一张</a></span>
            </div>
            <div class="form-group">
                <input type="checkbox" name="remember_me"/> Remember me
            </div>
        </div>
        <div class="footer">
            <button type="submit" class="btn bg-olive btn-block">Sign me in</button>

            <p><a href="#">I forgot my password</a></p>

            <a href="register.html" class="text-center">Register a new membership</a>
        </div>
    </form>

    <div class="margin text-center">
        <span>Sign in using social networks</span>
        <br/>
        <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
        <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
        <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

    </div>
</div>


<!-- jQuery 2.0.2 -->
<script src="${baseUrl}js/jquery-1.11.3.js"></script>

<script src="${baseUrl}js/v1.0/xg.yzm.js"></script>

<!-- Bootstrap -->
<script src="${baseUrl}js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>