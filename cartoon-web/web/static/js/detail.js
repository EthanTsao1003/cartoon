
var cid;
var strat;
var end;


$(function () {
     detailLoad();
     cid  = getQueryVariable("cartoon");
     relevantLoad();
     infoLoad();
     serializeLoad();
     collectOrNot();
     recordRead();
});

function detailLoad() {
    $('.pop2').hide();
}

function infoLoad() {

    $.ajax({
        url : '../cartoon',
        type : 'get',
        data : {cartoonId : cid},
        success : function (result) {
            if (result.code == 500){
                alert("加载失败");
            }
            $('#detail_img').css('content','url(img/cartoon/'+result.data.cartoonCover+')');
            $('.detail_h1').text(result.data.cartoonTitle);
            $('.detail_h2').text(result.data.cartoonAuthor);
            $('#category').text(result.data.cartoonCategory);
            $('#serialize').text(result.data.cartoonSerialize);
            $('#state').text(result.data.cartoonState);
            $('.text_span').text(result.data.cartoonIntro);
        }
    });
}


function serializeLoad() {

    $.ajax({
        url : '../serialize',
        type : 'get',
        data : {cartoonId : cid},
        success : function (result) {
            if (result.code == 500){
                alert("加载失败");
            }
           $.each(result.data, function (index, obj) {
               if(index == 0 ){
                   strat = index + 1;
                   $('#start_btn').attr('name', obj);
               }
               if(index < 50){
                   if (index == result.data.length -1){
                       end = index + 1;
                       $('.header').append('<div class="detail_button" id="button_start">' + strat + ' - ' + end + '');
                       strat = index + 1;
                   }
               }else{
                   if (index+1 % 50 == 1){
                       $('.header').append('<div class="detail_button">' + strat + ' - ' + end + '');
                   }
               }

               $('.data').append('<div class="data_button" id="serialize' + index + '">' + '<div class="short_title">' +obj+
                   '</div>' +
                   '</div>');
           });
        }
    });
}


function getQueryVariable(variable){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}



function relevantLoad() {
    $.ajax({
        url: '../cartoons',
        type: 'get',
        data: {pageNum: 2, pageSize: 6},
        success: function (result) {
            if (result.code == 500) {
                alert("加载失败");
            }
            $.each(result.data, function (index, obj) {
                var divClass = "detail_recommend2";
                var serialize = obj.cartoonSerialize;
                var imgId = "cover" + obj.cartoonId;
                if (obj.cartoonState != "完结") {
                    serialize = "更新至" + serialize;
                }
                if (index == 0) {
                    divClass = "detail_recommend";
                }

                $('.recommend_div').append('<div class="' + divClass + '" id="' + obj.cartoonId + '">' + '<div class="recommend_cartoon_title_div">' +
                    '<img class="recommed_img" id="' + imgId + '" /><div class="detail_title_serial">' + serialize + '</div>' +
                    '</div>' +
                    '<span class="recommed_title_span">' + obj.cartoonTitle + '</span>' +
                    '<span class="recommed_author_span">' + obj.cartoonAuthor + '</span>' +
                    '</div>');

                $('#' + imgId).css('content', 'url(img/cartoon/' + obj.cartoonCover + ')');
            });
        }
    });
}

// 追漫or取消
$(document).on('click', '#collect_btn', function () {
    if ( $('#collect_text').text() == "已追漫"){
        $.ajax({
            url: '../deselectCollect',
            type: 'post',
            data : {cartoonId : cid},
            success: function (result) {
                if (result.code == 500){
                    pop2(result.message);
                }else{
                    if (result.message != null){
                        pop2(result.message);
                        $('#collect_text').text("追漫");
                        $('#label_img4').css("content","url(img/icon/追漫.svg)");
                    }else{
                        pop2("请登录0v0");
                    }

                }
            }
        });
     }else{
        $.ajax({
            url: '../collect',
            type: 'post',
            data : {cartoonId : cid},
            success: function (result) {
                if (result.code == 500){
                    pop2(result.message);
                }else{
                    if (result.message != null){
                        pop2(result.message);
                        $('#collect_text').text("已追漫");
                        $('#label_img4').css("content","url(img/icon/已追.svg)");
                    }else{
                        pop2("请登录0v0");
                    }
                }

            }
        });
    }
});

// 追未追漫
function collectOrNot() {
    $.ajax({
        url : '../collectOrNot',
        type : 'get',
        data : {cartoonId : cid},
        success : function (result) {
            if (result.code == 200){
                $('#label_img4').css("content","url(img/icon/已追.svg)");
                $('#collect_text').text("已追漫");
            }
        }
    });
}

//续看
function recordRead() {

    $.ajax({
        url : '../recordRead',
        type : 'get',
        data : {cartoonId : cid},
        success : function (result) {
            if (result.code == 200){
                $('#start_btn').text("续看 " + result.data.onRecord);
                $('#start_btn').attr('name',  result.data.onRecord);
            }
        }
    });
}

//弹窗
function pop2(text) {
    $('.pop2').text(text);
    $('.pop2').fadeIn();
    setTimeout(function () {
        $('.pop2').fadeOut();
    },1000);
}

$(document).on("click", ".data_button", function() {
    window.open('read.html?cartoon=' + cid + '&serialize='+$(this).text()+'');
});

$(document).on("click", "#start_btn", function() {
    window.open('read.html?cartoon=' + cid + '&serialize='+$(this).attr('name')+'');
});

