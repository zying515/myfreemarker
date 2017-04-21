<@override name="titile">
<title>后台管理-新建任务</title>
<meta name="keywords" content="后台管理-新建任务">
<meta name="description" content="后台管理-新建任务">
<link href="${baseUrl}v2.0/js/plugins/layer/laydate/need/laydate.css" rel="stylesheet" type="text/css"></link>
<link href="${baseUrl}v2.0/js/plugins/layer/laydate/skins/default/laydate.css"  rel="stylesheet" type="text/css"></link>

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
        <h2>任务管理</h2>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">主页</a>
            </li>
            <li>
                <a>任务管理</a>
            </li>
            <li>
                <strong>新建任务</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">

    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">


    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>新建任务</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>

                    <div class="ibox-content">
                        <form class="form-horizontal m-t" ovalidate="novalidate" id="signupForm" action="${baseUrl}task/home/add" method="post">
                        <!--<form class="form-horizontal m-t" id="signupForm" novalidate="novalidate">-->
                            <div class="form-group">
                                <label class="col-sm-3 control-label">任务名称</label>
                                <div class="col-sm-8">
                                    <input id="name" name="name" class="form-control" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间</label>
                                <div class="col-sm-8">
                                    <input placeholder="开始日期" name="begindate" class="form-control layer-date" id="start">
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间</label>
                                <div class="col-sm-8">
                                    <input placeholder="结束日期" class="form-control layer-date" name="enddate" value="" id="end"></div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注</label>
                                <div class="col-sm-8">
                                    <textarea name="remark" id="remark" class="form-control" type="text" aria-required="true" aria-invalid="false" style="margin: 0px -3.34375px 0px 0px; width: 668px; max-height: 154px; height: 182px;"></textarea>
                                </div>
                            </div>






                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

<script src="${baseUrl}v2.0/js/jquery-2.1.1.min.js"></script>
<script src="${baseUrl}v2.0/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${baseUrl}v2.0/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseUrl}v2.0/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${baseUrl}v2.0/js/plugins/pace/pace.min.js"></script>
<script src="${baseUrl}v2.0/js/hplus.js?v=2.2.0"></script>
<script src="${baseUrl}v2.0/js/plugins/layer/laydate/laydate.js">
<script>
$(document).ready(function () {
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
});
//外部js调用
laydate({
    elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
});
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY/MM/DD hh:mm:ss',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function (datas) {
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY/MM/DD hh:mm:ss',
    min: laydate.now(),
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function (datas) {
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);
</script>
</@override>

<@extends name="index.ftl"/>
