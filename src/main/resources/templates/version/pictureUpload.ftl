<@override name="titile">
<title>后台管理-图片上传</title>
<meta name="keywords" content="后台管理-图片上传">
<meta name="description" content="后台管理-图片上传">
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
                <strong>上传图片</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">

    </div>
</div>
<div class="wrapper wrapper-content animated fadeIn">

    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>图片上传</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_file_upload.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_file_upload.html#">选项1</a>
                            </li>
                            <li><a href="form_file_upload.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="page-container">
                        <div id="uploader" class="wu-example">
                            <div class="queueList">
                                <div id="dndArea" class="placeholder">
                                    <div id="filePicker" class="webuploader-container"><div class="webuploader-pick">点击选择图片</div><div id="rt_rt_1be9d1hipdp650j16tf4t1pmf1" style="position: absolute; top: 0px; left: 412.5px; width: 168px; height: 44px; overflow: hidden; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div></div>
                                    <p>或将照片拖到这里，单次最多可选300张</p>
                                </div>
                                <ul class="filelist"></ul></div>
                            <div class="statusBar" style="display:none;">
                                <div class="progress" style="display: none;">
                                    <span class="text">0%</span>
                                    <span class="percentage" style="width: 0%;"></span>
                                </div>
                                <div class="info">共0张（0B），已上传0张</div>
                                <div class="btns">
                                    <div id="filePicker2" class="webuploader-container"><div class="webuploader-pick">继续添加</div><div id="rt_rt_1be9d1hit118b49a1ou24jfca16" style="position: absolute; top: 0px; left: 0px; width: 1px; height: 1px; overflow: hidden;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div></div>
                                    <div class="uploadBtn state-pedding">开始上传</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>



<script type="text/javascript">
    // 添加全局站点信息
    var BASE_URL = '${baseUrl}v2.0/js/plugins/webuploader';
    var HttpBaseUrl='${baseUrl}';
</script>




















<link rel="stylesheet" type="text/css" href="${baseUrl}v2.0/css/plugins/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css" href="${baseUrl}v2.0/css/demo/webuploader-demo.css">
<script src="${baseUrl}v2.0/js/jquery-2.1.1.min.js"></script>
<script src="${baseUrl}v2.0/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${baseUrl}v2.0/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseUrl}v2.0/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${baseUrl}v2.0/js/plugins/pace/pace.min.js"></script>
<script src="${baseUrl}v2.0/js/hplus.js?v=2.2.0"></script>
<script src="${baseUrl}v2.0/js/plugins/dropzone/dropzone.js"></script>
<script src="${baseUrl}v2.0/js/demo/webuploader-demo.js"></script>
<script src="${baseUrl}v2.0/js/plugins/webuploader/webuploader.min.js"></script>
</@override>

<@extends name="index.ftl"/>
