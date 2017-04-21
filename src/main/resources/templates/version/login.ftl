<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
    <title>后台管理-登录</title>
    <meta name="keywords" content="后台管理-登录">
    <meta name="description" content="后台管理-登录">
    <base id="base" href="${baseUrl}">
    <link href="${baseUrl}v2.0/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${baseUrl}v2.0/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="${baseUrl}v2.0/css/animate.css" rel="stylesheet">
    <link href="${baseUrl}v2.0/css/style.css?v=2.2.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name"></h1>
            </div>
            <h3>管理后台</h3>
            <form action="${baseUrl}user/login/select" method="post">
                <div class="form-group">
                    <input type="text"  name="username" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
                <!--<p class="text-muted text-center"> <a href="login.ftl#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>-->
                </p>
            </form>
        </div>
    </div>
    <!-- Mainly scripts -->
    <script src="${baseUrl}v2.0/js/jquery-2.1.1.min.js"></script>
    <script src="${baseUrl}v2.0/js/bootstrap.min.js?v=3.4.0"></script>
</body>
</html>
