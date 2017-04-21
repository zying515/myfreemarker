<@override name="titile">
<title>后台管理-任务列表</title>
<meta name="keywords" content="后台管理-任务列表">
<meta name="description" content="后台管理-任务列表">
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
                <strong>任务列表</strong>
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
                    <h5>任务列表</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="table_data_tables.html#">选项1</a>
                            </li>
                            <li><a href="table_data_tables.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="">
                        <a  href="${baseUrl}task/home" class="btn btn-primary ">新建任务</a>
                    </div>
                    <div id="editable_wrapper" class="dataTables_wrapper form-inline" role="grid">
                        <div class="row"><div class="col-sm-6">
                            <div class="dataTables_length" id="editable_length">
                                <label>每页
                                    <select name="editable_length" aria-controls="editable" class="form-control input-sm">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select> 条记录
                                </label>
                            </div>
                        </div>
                            <div class="col-sm-6">
                                <div id="editable_filter" class="dataTables_filter">
                                    <label>查找：
                                        <input type="search" class="form-control input-sm" aria-controls="editable"></label>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-bordered table-hover  dataTable" id="editable" aria-describedby="editable_info">
                        <thead>
                        <tr role="row">
                            <th class="sorting" tabindex="0" aria-controls="editable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="渲染引擎：激活排序列升序" style="width: 169px;">任务名称</th>
                            <th class="sorting" tabindex="0" aria-controls="editable" rowspan="1" colspan="1" aria-label="浏览器：激活排序列升序" style="width: 290px;">开始时间</th>
                            <th class="sorting" tabindex="0" aria-controls="editable" rowspan="1" colspan="1" aria-label="平台：激活排序列升序" style="width: 264px;">结束时间</th>
                            <th class="sorting" tabindex="0" aria-controls="editable" rowspan="1" colspan="1" aria-label="引擎版本：激活排序列升序" style="width: 115px;">执行人</th>
                            <th class="sorting" tabindex="0" aria-controls="editable" rowspan="1" colspan="1" aria-label="CSS等级：激活排序列升序" style="width: 110px;">备注</th>
                            <th class="sorting" tabindex="0" aria-controls="editable" rowspan="1" colspan="1" aria-label="CSS等级：激活排序列升序" style="width: 110px;">完成状态</th>

                        </tr>
                        </thead>
                        <tbody>
                      <#list itaskList as task>
                         <#if task_index%2==0>
                            <tr class="gradeA odd">
                          <#else>
                                <tr class="gradeA even">
                        </#if>

                          <td class="sorting_1">${task.name}</td>
                          <td class=" ">${task.begindate}</td>
                          <td class=" ">${task.enddate}</td>
                          <td class="center ">${task.author}</td>
                          <td class="center ">${task.remark}</td>
                          <td class="center ">${task.isfinish}</td>
                      </tr>


                            </#list>












                        </tbody>
                        <!--<tfoot>
                        <tr><th rowspan="1" colspan="1">渲染引擎</th><th rowspan="1" colspan="1">浏览器</th><th rowspan="1" colspan="1">平台</th><th rowspan="1" colspan="1">引擎版本</th><th rowspan="1" colspan="1">CSS等级</th></tr>
                        </tfoot>-->
                    </table>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="dataTables_info" id="editable_info" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 ${pagesize} 项，共 ${totalPages} 页</div>
                            </div>
                            <div class="col-sm-6">
                                <div class="dataTables_paginate paging_simple_numbers" id="editable_paginate">
                                    <ul class="pagination">
                                          <#if page==1>
                                              <li class="paginate_button previous " aria-controls="editable" tabindex="0" id="editable_previous"><a href="${baseUrl}/task/newpage?page=1">上一页</a></li>
                                            <#else>
                                                <li class="paginate_button previous " aria-controls="editable" tabindex="0" id="editable_previous"><a href="${baseUrl}/task/newpage?page=${page-1?number}">上一页</a></li>
                                          </#if>
                                        <#list 1..totalPages as index>
                                            <#if index==page>
                                                <li class="paginate_button active" aria-controls="editable" tabindex="0">
                                                    <a href="${baseUrl}task/newpage?page=${index}">${index}</a>
                                                </li>
                                            <#else>
                                                <li class="paginate_button" aria-controls="editable" tabindex="0">
                                                    <a href="${baseUrl}task/newpage?page=${index}">${index}</a>
                                                </li>
                                            </#if>
                                        </#list>
                                        <#if page==totalPages>
                                            <li class="paginate_button next " aria-controls="editable" tabindex="0" id="editable_next">
                                                <a href="${baseUrl}task/newpage?page=${totalPages}">下一页</a>
                                            </li>
                                        <#else>
                                            <li class="paginate_button next " aria-controls="editable" tabindex="0" id="editable_next">
                                                <a href="${baseUrl}task/newpage?page=${page+1?number}">下一页</a>
                                            </li>
                                        </#if>
                                    </ul>
                                </div>
                            </div>
                        </div>
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
