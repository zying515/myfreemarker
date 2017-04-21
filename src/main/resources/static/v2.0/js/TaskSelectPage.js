$(document).ready(function(){
    Task_Select.init(1);
});
var Task_Select={
    init:function(page){
        var base=$("#base").attr("href");
        $.ajax({
            type: "GET",
            url: base+"params?page="+page+"&size=3",
            data: {},
            dataType: "json",
            success: function(data){
                console.log(data);
                Task_Select.resetTableHtml(data,page);
            }
        });
    },
    resetTableHtml:function(data,page) {
        $("#taskTable").html("");
        if (data != null) {
            var html = "";
            var content = data.content;
            var contentLen = content.length;
            if (contentLen > 0) {
                for (var i = 0; i < contentLen; i++) {
                    html += "<tr>";
                    html += "<td>" + (i + 1) + "</td>";
                    html += "<td>" + content[i].name + "</td>";
                    html += "<td>" + content[i].author + "</td>";
                    html += "<td>" + content[i].registerdate + "</td>";
                    html += "<td>" + content[i].begindate + "</td>";
                    html += "<td>" + content[i].enddate + "</td>";
                    html += "<td>" + Task_Select.isFinishName(content[i].isfinish)+ "</td>";
                    html += "<td>" + content[i].remark+"</td>";
                }
                $("#taskTable").html(html);
                var totalpage=data.totalPages;
                var totalnum=data.totalElements;
                var pagesize=3;

               // pageInfoHtml:function(curpage,totalpage,totalnum,pageSize);
                Task_Select.pageInfoHtml(page,totalpage,totalnum,pagesize);
             }

            } else {

            }
        },isFinishName:function(isfinish){
            var str="";
            if("0"==isfinish){
                str="未完成";
            }else if("1"==isfinish){
                str="已完成";
            }else if("2"==isfinish){
                str="进行中";
            }
            return str;
         },pageInfoHtml:function(curpage,totalpage,totalnum,pageSize){
        var htmlpaging="<tr>";
        $("#pageTable").html("");
        totalpage= parseInt(totalpage);
        curpage=parseInt(curpage);
        if(curpage!=1){
            htmlpaging+='<td><a href="javascript:Task_Select.init(\''+(curpage-1)+'\');"  title="上一页">上一页</a></td>';
        }else{
            htmlpaging+='<td><span class="disabled">上一页</span></td>';
        }
        if(totalpage==1){
            htmlpaging +='<td><span class="current">1</span></td>';
        }else if( totalpage<= 10){
            for ( var j = curpage; j > 1; j--) {
                htmlpaging += '<td><a href="javascript:Task_Select.init(\''+(curpage-(j-1))+'\');">' + (curpage-(j-1)) + '</a></td>';
            }
            htmlpaging += '<td><span class="current">'+curpage+'</span></td> ';
            var k = totalpage - curpage;
            for ( var j = 1; j <= k; j++) {
                htmlpaging += '<td><a href="javascript:Task_Select.init(\''+( curpage+ j)+'\');">'+ ( curpage+ j) + '</a></td>';
            }
        }else if(curpage <= 10 && totalpage > 10){
            for ( var j = curpage; j > 1; j--) {
                htmlpaging += '<td><a href="javascript:Task_Select.init(\''+(curpage-j+1)+'\');">' + (curpage-j+1) + '</a></td>';
            }
            htmlpaging += '<td><span class="current">'+curpage+'</span></td> ';
            var k = 10-curpage;
            for ( var j = 1; j <= k; j++) {
                htmlpaging += '<td><a href="javascript:Task_Select.init(\''+(curpage + j)+'\');">'+ (curpage + j) + '</a></td>';
            }
      }
        if(curpage==totalpage){
            htmlpaging+='<td><span class="disabled">下一页</span></td>';
        }else{
            var temp=curpage+1;
            htmlpaging +='<td><a href="javascript:Task_Select.init(\''+temp+'\');">下一页</a></td>';
        }

        htmlpaging+="</tr>"
        $("#pageTable").html(htmlpaging);
    }




}
