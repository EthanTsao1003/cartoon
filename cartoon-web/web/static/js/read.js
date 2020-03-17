
var cid;
var serializeId;
var list;
var index;
$(function () {
   cssLoad();
    cid = getQueryVariable('cartoon');
    serializeId = decodeURI(getQueryVariable('serialize'));
    readLoad(cid, serializeId);
    record();
});

//阅读记录
function record() {
    $.ajax({
        url: '../record',
        type: 'post',
        data: {cartoonId: cid, onRecord: serializeId},
        success: function (result) {
            if (result.code == 500) {
                pop2(result.message);
            }
        }
    });
}

function cssLoad() {
    $('.page').css({'height': $('body').height()});
    $('.pop').hide();
}

function readLoad(cid,serialize) {

    $.ajax({
        url : '../read',
        type : 'get',
        data : {cartoonId : cid, serialize : serialize},
        success : function (result) {
            if (result.code == 500){
                alert("加载失败");
            }
            else{
                console.log(result.data[0]);
                index = 0;
                $('.cartoon_img').css('content', 'url(img/cartoon/cartoon/'+result.data[0]+')');
                list = result.data;
                console.log(result.data);
            }
        }
    });
}


$(document).on("click", ".page", function() {
    var id = $(this).attr('id');
        paging(id);
    $('.cartoon_img').css('content', 'url(img/cartoon/cartoon/'+list[index]+')');
});


function paging(id) {
    if (id == "page_previous"){
        if(index > 0){
            index = index -1;
        }else{
            $('.pop').text("已经是第一页了");
            $('.pop').fadeIn(600);
            setTimeout(function () {
                $('.pop').fadeOut(600);
            },1000);
        }
    }
    else{
        if(index < list.length-1){
            index = index + 1;
        }else{
            $('.pop').text("已经是最后一页了");
            $('.pop').fadeIn(600);
            setTimeout(function () {
                $('.pop').fadeOut(600);
            },1000);
        }
    }

}



function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}




$('.cartoon_img').mouseover(function () {
    $('.page').fadeOut();
});

$('.cartoon_img').mouseout(function () {
    $('.page').fadeIn();
});

$(window).resize(function () {          //当浏览器大小变化时

    // alert($(window).height());          //浏览器时下窗口可视区域高度 $('.carousel_div').width(); //区块的本身宽度
    // alert($(document).height());        //浏览器时下窗口文档的高度
    // alert($(document.body).height());   //浏览器时下窗口文档body的高度
    // alert($(document.body).outerHeight(true)); //浏览器时下窗口文档body的总高度 包括border padding margin
});


