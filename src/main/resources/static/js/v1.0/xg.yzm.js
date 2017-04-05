/**
 * Created by Administrator on 2017/4/2.
 */
var XG_YZM= {
    id: "#loginyz_img",
    url:$("#base").attr("href"),
    init: function () {
        $(XG_YZM.id).click(function () {
            XG_YZM.showImage();
        })
    }, showImage: function () {
        var yzsrc=XG_YZM.url+"Random/kaptcha.jpg?flag=1&sid="+Math.random();
        $(XG_YZM.id).attr("src" ,yzsrc);
    }
}
$(document).ready(function() {
    XG_YZM.init();
});
