
$(function () {
    $.ajax({
        url : '../cartoons',
        type : 'get',
        data : {pageNum : 0, pageSize : 10},
        success : function (result) {
            if (result.code == 500){
                alert("加载失败");
            }
            $.each(result.data,function(index,obj){
                var serialize =  obj.cartoonSerialize;
                var imgId = "cover"+obj.cartoonId;
                if (obj.cartoonState != "完结"){
                    serialize = "更新至"+serialize;
                }
                $('#cartoon_recommend_div').append('<div class="cartoon_put_div" id="'+obj.cartoonId+'">'+'<div class="cartoon_title_div">'+
                    '<img class="cartoon_title_img" id="'+imgId+'" /><div class="cartoon_title_serial_div">'+serialize+'</div>' +
                    '</div>'+
                    '<span class="cartoon_title_span">'+obj.cartoonTitle+'</span>'+
                    '<span class="cartoon_author_span">'+obj.cartoonAuthor+'</span>'+
                    '</div>');

                $('#'+imgId).css('content','url(img/cartoon/'+obj.cartoonCover+')');
            });
        }
    });
});


$(document).on("click", ".cartoon_put_div", function() {
    window.open("detail.html?cartoon=" + $(this).attr('id') + "");
});
