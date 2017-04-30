<@override name="titile">
<title>后台管理-图片列表</title>
<meta name="keywords" content="后台管理-图片列表">
<meta name="description" content="后台管理-图片列表">
</@override>
<@override name="navbar-header">
<div class="navbar-header">
    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="form_basic.html#"><i class="fa fa-bars"></i> </a>
    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
        <div class="form-group">
            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
        </div>
    </form>
</div>
</@override>

<@override name="wrapper wrapper-content">
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>图片管理</h2>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">主页</a>
            </li>
            <li>
                <a>图片管理</a>
            </li>
            <li>
                <strong>图片列表</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">

    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <#list pictureList as picture>
                        <a class="fancybox" href="${baseUrl}upload/${picture.picturename}${picture.picturefix}" title="图片1">
                            <img alt="image" src="${baseUrl}upload/${picture.picturename}${picture.picturefix}">
                        </a>
                    </#list>


                </div>
            </div>
        </div>

    </div>
</div>



<script type="text/javascript">
    // 添加全局站点信息
    var HttpBaseUrl='${baseUrl}';
</script>




















<link href="${baseUrl}v2.0/js/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
<style type="text/css">.fancybox-margin{margin-right:17px;}</style>
<script src="${baseUrl}v2.0/js/plugins/fancybox/jquery.fancybox.js"></script>
<script src="${baseUrl}v2.0/js/jquery-2.1.1.min.js"></script>
<script src="${baseUrl}v2.0/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${baseUrl}v2.0/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseUrl}v2.0/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${baseUrl}v2.0/js/plugins/pace/pace.min.js"></script>
<script src="${baseUrl}v2.0/js/hplus.js?v=2.2.0"></script>
<script src="${baseUrl}v2.0/js/plugins/dropzone/dropzone.js"></script>
</@override>

<@extends name="index.ftl"/>
