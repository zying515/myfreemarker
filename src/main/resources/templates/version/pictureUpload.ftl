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
                    <h5>文件上传</h5>
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
                    <form id="my-awesome-dropzone" class="dropzone dz-clickable" action="form_file_upload.html#">
                        <div class="dropzone-previews"></div>
                        <button type="submit" class="btn btn-primary pull-right">提交</button>
                        <div class="dz-default dz-message"><span>图片上传</span></div></form>
                    <div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>



























<link href="${baseUrl}v2.0/css/plugins/dropzone/basic.css" rel="stylesheet"></link>
<link href="${baseUrl}v2.0/css/plugins/dropzone/dropzone.css" rel="stylesheet"></link>
<script src="${baseUrl}v2.0/js/jquery-2.1.1.min.js"></script>
<script src="${baseUrl}v2.0/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${baseUrl}v2.0/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseUrl}v2.0/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${baseUrl}v2.0/js/plugins/pace/pace.min.js"></script>
<script src="${baseUrl}v2.0/js/hplus.js?v=2.2.0"></script>
<script src="${baseUrl}v2.0/js/plugins/dropzone/dropzone.js"></script>

<script>
    $(document).ready(function () {

        Dropzone.options.myAwesomeDropzone = {

            autoProcessQueue: false,
            uploadMultiple: true,
            parallelUploads: 100,
            maxFiles: 100,

            // Dropzone settings
            init: function () {
                var myDropzone = this;

                this.element.querySelector("button[type=submit]").addEventListener("click", function (e) {
                    e.preventDefault();
                    e.stopPropagation();
                    myDropzone.processQueue();
                });
                this.on("sendingmultiple", function () {});
                this.on("successmultiple", function (files, response) {});
                this.on("errormultiple", function (files, response) {});
            }

        }

    });
</script>
<input type="file" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">
</@override>

<@extends name="index.ftl"/>
