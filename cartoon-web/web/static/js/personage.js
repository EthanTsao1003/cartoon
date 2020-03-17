
var sexs;
var inboxContent = {};

$(function(){

	cssLoad();
	personageLoad();
	inbox();
	outbox();
	collectLoad();
	recordLoad();
}); 


function cssLoad(){
	$('.inbox_content').hide();
	$('.pop2').hide();
	$('.menu1_content').show();
	$('#option2').hide();
	$('#option3').hide();
	content();
	$('#menu1_content').show();
}

//菜单
$('.menu').click(function(){
		resetColors();
		content();
		child();
		
		
		$('#child1').css('color','#32aaff');
		$('#child4').css('color','#32aaff');
		$('#child7').css('color','#32aaff');
		if('menu1' == $(this).attr('id'))
		{
			$('#menu1').css({"color":"#32aaff"});
			$('#menu1').css({"background":"#FFFFFF"});
			$('.pp1').css("content","url(img/icon/用户信息2.svg)");
			$('#menu1_content').show();
			 $('#option1').show();
		}
		if('menu2' == $(this).attr('id'))
		{
			$('#menu2').css({"color":"#32aaff"});
			$('#menu2').css({"background":"#FFFFFF"});
			$('.pp2').css("content","url(img/icon/已购漫画2.svg)");
			$('#menu2_content').show();
		}
		if('menu3' == $(this).attr('id'))
		{
			
			$('#menu3').css({"color":"#32aaff"});
			$('#menu3').css({"background":"#FFFFFF"});
			$('.pp3').css("content","url(img/icon/我的追漫2.svg)");
			$('#menu3_content').show();
			
		}
		if('menu4' == $(this).attr('id'))
		{
			$('#menu4').css({"color":"#32aaff"});
			$('#menu4').css({"background":"#FFFFFF"});
			$('.pp4').css("content","url(img/icon/历史记录2.svg)");
			$('#menu4_content').show();
		}
		if('menu5' == $(this).attr('id'))
		{
			$('#menu5').css({"color":"#32aaff"});
			$('#menu5').css({"background":"#FFFFFF"});
			$('.pp5').css("content","url(img/icon/个人消息2.svg)");
			$('#menu5_content').show();
			 $('#option7').show();
			
		}
		if('menu6' == $(this).attr('id'))
		{
			$('#menu6').css({"color":"#32aaff"});
			$('#menu6').css({"background":"#FFFFFF"});
			$('.pp6').css("content","url(img/icon/意见反馈2.svg)");
			$('#menu6_content').show();
		}
});



// 选项卡
 $('.child_option').click(function() {
		child();
		
        $(this).css('color','#32aaff');
		if('child1' == $(this).attr('id')){
			$('#option1').show();
		}
		if('child2' == $(this).attr('id')){
			$('#option2').show();
		}
		if('child3' == $(this).attr('id')){
			$('#option3').show();
		}
		if('child4' == $(this).attr('id')){
			// $('#option1').show();
		}
		if('child5' == $(this).attr('id')){
			// $('#option2').show();
		}
		if('child6' == $(this).attr('id')){
			// $('#option3').show();
		}
		if('child7' == $(this).attr('id')){
			$('#option7').show();
		}
		if('child8' == $(this).attr('id')){
			$('#option8').show();
		}
		if('child9' == $(this).attr('id')){
			$('#option9').show();
		}
		if('child10' == $(this).attr('id')){
			$('#option10').show();
		}
		
 });


//性别
$('.sex_span').click(function(){

	if('check_all' == $(this).attr('id')){
		$('.letter_checkbox').prop('checked',true);
	}
	else if('check_all2' == $(this).attr('id')){
		$('.letter_checkbox2').prop('checked',true);
	}
	else if('delete' == $(this).attr('id')){
		// $('#option8').show();
	}
	else if('delete2' == $(this).attr('id')){
		// $('#option8').show();
	}
	else if('deselect_all' == $(this).attr('id')){
		$('.letter_checkbox').prop('checked',false);
	}
	else if('deselect_all2' == $(this).attr('id')){
		$('.letter_checkbox2').prop('checked',false);
	}
	else{
		sex(this);
	}
});

function sex(sex){
	$('.sex_span').css({'background':'#f4f4f4', 'color': '#717171'});
	$('.message_btn').css({'background':'#fff', 'color': '#686869'});
	$(sex).css({'background':'#22a1d6', 'color': '#fff'});
	sexs = $(sex).text();
}


//收件箱全选
$('.message_btn').click(function(){
	
	// if('#check_all' == $(this).attr('id')){
	// 	// $('#option8').show();
	// }
	// else if('delete' == $(this).attr('id')){
	// 	// $('#option8').show();
	// }
	// else{
	// 	$('.sex_span').css({'background':'#f4f4f4', 'color': '#717171'});
	// 	$('.message_btn').css({'background':'#fff', 'color': '#686869'});
	// 	$(this).css({'background':'#22a1d6', 'color': '#fff'})
	// }
});


// 菜单初始化
function resetColors(){
	$('.pp1').css("content","url(img/icon/用户信息.svg)");
	$('.pp2').css("content","url(img/icon/已购漫画.svg)");
	$('.pp3').css("content","url(img/icon/我的追漫.svg)");
	$('.pp4').css("content","url(img/icon/历史记录.svg)");
	$('.pp5').css("content","url(img/icon/个人消息.svg)");
	$('.pp6').css("content","url(img/icon/意见反馈.svg)");
	$('.menu').css({"background":"#ECEDF0"});
	$('.menu').css("color","#686869");
};

// 选项卡初始化
function child(){
	$('.child_option').css('color','#686869');
	// $('#option1').hide();
	// $('#option2').hide();
	// $('#option3').hide();
	$('.option_centent').hide();
};

//内容隐藏
function content(){
	$('.content_div').hide();
}

function personageLoad() {
	$.ajax({
		url: '../get_user',
		type: 'get',
		success: function (result) {

			if (result.code == 500) {
				alert(result.message);
			}
			if (result.data.userTel != null) {
				$('#tel').text(result.data.userTel);
				$('#tel_bound').text("已绑定");
			}
			if (result.data.userEmail != null) {
				$('#email').text(result.data.userEmail);
				$('#email_bound').text("已绑定");
			}
			if (result.data.userName != null) {
				$('#username').val(result.data.userName);
			}
			$('#uid').text(result.data.userId);
			if (result.data.personage.intro != null) {
				$('#intro').text(result.data.personage.intro);
			}

			if (result.data.personage.sex == "男") {
				sex("#man");
			}
			if (result.data.personage.sex == "女") {
				sex("#woman");
			}
		}
	});
}

//修改用户个人信息
$(document).on('click', '#update', function () {
	$.ajax({
		url: '../update_personage',
		type: 'post',
		data : {userId: $('#uid').text(), userName : $('#username').val(), userTel:$('#tel').text(), userEmail:$('#email').text(), intro : $('#intro').val(), sex : sexs},
		success: function (result) {
			if (result.code == 500){
				console.log(result.message);
			}else{
				pop("提交成功！");
				personageLoad();
			}

		}
	});
});


//写短信
$(document).on('click', '#send_btn', function () {
	$.ajax({
		url: '../save_message',
		type: 'post',
		data : {receiver: $('#addresses').val(), exporter : $('#uid').text(), content: $('#send_content').val()},
		success: function (result) {
			if (result.code == 500){
				console.log(result.message);
			}else{
				pop(result.message);
				outbox();
			}

		}
	});
});

//收件箱
function inbox() {

	$.ajax({
		url: '../inbox',
		type: 'get',
		success: function (result) {
			$.each(result.data, function (index, obj) {
				inboxContent[obj.messageId] = obj.content;
				$('#inbox').append('<div class="option1_set letter_div" id = "' + obj.messageId + '">' +
					'<input class="letter_checkbox" id = "checkbox' + obj.messageId + '" type="checkbox" />' +
					'<span class="letter_span" id="letter_name">' + obj.userName + '</span>' +
					'<span class="letter_span" id="letter_time"> ' + obj.time + ' </span></div>');
			});
		}
	});
}

//发件箱
function outbox() {

	$.ajax({
		url: '../outbox',
		type: 'get',
		success: function (result) {
			$.each(result.data, function (index, obj) {
				inboxContent[obj.messageId] = obj.content;
				$('#outbox').append('<div class="option1_set letter_div" id = "' + obj.messageId + '">' +
					'<input class="letter_checkbox2" id = "checkbox' + obj.messageId + '" type="checkbox" />' +
					'<span class="letter_span" id="letter_name">' + obj.userName + '</span>' +
					'<span class="letter_span" id="letter_time"> ' + obj.time + ' </span></div>');
			});
		}
	});
}

//查看信件
$(document).on('click', '.letter_span', function () {
	console.log(inboxContent[$(this).parent().attr('id')]);
	$('.inbox_content').text(inboxContent[$(this).parent().attr('id')]);
	$('.inbox_content').show();
});

//关闭信件
$(document).on('click', '.inbox_content', function () {
	$('.inbox_content').hide();
});


//意见反馈
$(document).on('click', '#send_btn2', function () {


	console.log($('#qq').val());
	$.ajax({
		url: '../feedback',
		type: 'post',
		data : {type: $('.selectBox option:selected').val(), contact : $('#qq').val(), content: $('#feedback_content').val()},
		success: function (result) {
			if (result.code == 500){
				console.log(result.message);
			}else{
				pop(result.message);
			}

		}
	});
});

//追漫加载
function collectLoad() {

	$.ajax({
		url: '../listCollect',
		type: 'get',
		success: function (result) {
			$.each(result.data, function (index, obj) {
				var imgId = "collectPt" + obj.cartoonInfo.cartoonId;
				$('#collect1').append('<div class="cartoon_collect" id = "' + obj.cartoonInfo.cartoonId + '">' +
					'<div class="collect_title_div">' +
					'<img class="collect_pt cartoon_title_img" id="' + imgId + '"/>' +
					'</div>' +
					'<span class="collect_title_span"> ' + obj.cartoonInfo.cartoonTitle + ' </span>' +
					'<span class="collect_renewal_span"> ' + obj.cartoonInfo.cartoonState + ' </span>' +
					'</div>');
				$('#' + imgId + '').css("content","url(img/cartoon/" + obj.cartoonInfo.cartoonCover + "");

			});
		}
	});
}

//阅读记录加载
function recordLoad() {

	$.ajax({
		url: '../listRecord',
		type: 'get',
		success: function (result) {
			$.each(result.data, function (index, obj) {
				var imgId2 = "record" + obj.cartoonInfo.cartoonId;
				$('#history').append('<div class="cartoon_collect" id = "' + obj.cartoonInfo.cartoonId + '">' +
					'<div class="collect_title_div">' +
					'<img class="collect_pt cartoon_title_img" id="' + imgId2 + '"/>' +
					'</div>' +
					'<span class="collect_title_span"> ' + obj.cartoonInfo.cartoonTitle + ' </span>' +
					'<span class="collect_renewal_span">看到 ' + obj.onRecord + '</span>' +
					'<span class="collect_renewal_span"> ' + obj.time + ' </span>' +
					'</div>');
				$('#' + imgId2 + '').css("content","url(img/cartoon/" + obj.cartoonInfo.cartoonCover + "");

			});
		}
	});
}

// $(function() {
// 	$("#pic").click(function() {
// 		$("#upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
// 		$("#upload").on("change", function() {
// 			var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
// 			if (objUrl) {
// 				$("#pic").attr("src", objUrl); //将图片路径存入src中，显示出图片
// 				upimg();
// 			}
// 		});
// 	});
// });
//
// //建立一?可存取到?file的url
// function getObjectURL(file) {
// 	var url = null;
// 	if (window.createObjectURL != undefined) { // basic
// 		url = window.createObjectURL(file);
// 	} else if (window.URL != undefined) { // mozilla(firefox)
// 		url = window.URL.createObjectURL(file);
// 	} else if (window.webkitURL != undefined) { // webkit or chrome
// 		url = window.webkitURL.createObjectURL(file);
// 	}
// 	return url;
// }
//上传头像到服务器
// function upimg() {
// 	var pic = $('#upload')[0].files[0];
// 	var file = new FormData();
// 	file.append('image', pic);
// 	console.log(pic);
// 	$.ajax({
// 		url: "../uploadImg",
// 		type: "post",
// 		data: file,
// 		dataType: "json",
// 		cache: false,
// 		contentType: false,
// 		processData: false,
// 		success: function (data) {
// 			console.log(data);
// 			var res = data;
// 			console.log(res);
// 			$("#resimg").append("<img src='/" + res + "'>")
// 		}
// 	});
// }


//追漫列表or阅读列表跳转
$(document).on("click", ".cartoon_collect", function() {
	window.open("detail.html?cartoon=" + $(this).attr('id') + "");
});


//弹窗
function pop(text) {
	$('.pop2').text(text);
	$('.pop2').fadeIn();
	setTimeout(function () {
		$('.pop2').fadeOut();
	},1000);
}