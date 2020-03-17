$(function () {
	$('.pop').css('display', 'none');
	judge();
});


//打开登录框
$('#login_shade').click(function () {
		$('#loging_shade').show();
		$('.login').css("border-bottom",function(){return "5px solid #00a1d6";});
		$('.register').css("border-bottom",function(){return "5px solid #eee";}); 
		$('.login_frm').show();
		$('.register_frm').hide();
		$('.user_message').val("");
		$('.password_message').val("");
	   
    });

//打开注册框
$('#register_shade').click(function () {
		$('.loging_shade').show();
		$('.login').css("border-bottom",function(){return "5px solid #eee";});
		$('.register').css("border-bottom",function(){return "5px solid #00a1d6";}); 
		$('.login_frm').hide();
		$('.register_frm').show();
		$('.user_message').val("");
		$('.password_message').val("");
    });	

//切换登录框
$('.login').click(function () {
	  
		$('.login_frm').show();
		$('.register_frm').hide();
		$('.login').css("border-bottom",function(){return "5px solid #00a1d6";});
		$('.register').css("border-bottom",function(){return "5px solid #eee";});
    });	

//切换注册框
$('.register').click(function () {
	  
	   $('.login_frm').hide();
	   $('.register_frm').show();
	   $('.login').css("border-bottom",function(){return "5px solid #eee";}); 
	   $('.register').css("border-bottom",function(){return "5px solid #00a1d6";}); 
    });		

//关闭登录框
$('.btn_close').click(function () {
       $('.loging_shade').hide();
    });

//切换账号
$('#switchover').click(function(){
	// $('#page_head_div').hide();
	// $('#page_loging_div').show();
	$('.login').css("border-bottom",function(){return "5px solid #00a1d6";});
	$('.register').css("border-bottom",function(){return "5px solid #eee";}); 
	$('.login_frm').show();
	$('.loging_shade').show();
	$('.register_frm').hide();
});










$('.page_top_a').click(function(){
	window.location.replace("index.html");
});

$('.page_mark_img').click(function(){
	window.location.replace("index.html");
});



$('.boutique_put_div').click(function(){
	window.location.replace("detail.html");
});

$('.rank_tabs_li').click(function(){
	window.location.replace("detail.html");
});

//用户登录
$('.btn_login').click(function(){
	//调用登录方法
	login($('#login_user').val(), $('#login_password').val());
});
//用户登录
function login(user, password){
	$.ajax({
		url: '../login',
		type: 'get',
		data: {userNumber : user, userPassword : password},
		success: function (result) {


			if(result.code == 500){
				$('#password_error').text(result.message);
				$('#login_password').css({'border-color': '#f25d8e','color': 'rgb(0, 0, 0)'});
			}
			else{
				$('.pop').css('color', '#5ebf70');
				pop("登录成功");
				setTimeout(function () {
					$('.pop').css('color', '#f25d8e');
					$('.loging_shade').hide();
					$('#page_head_div').show();
					$('#page_loging_div').hide();
				}, 2000);

			}

		}
	});
}


$('#login_password').bind('input propertychange', function() {
	if($('#password_error').text()=='用户名或密码错误'){
		$('#login_password').css({'color': 'rgb(0, 0, 0)'});
		$('#password_error').text(' ');
	}
});

$('.password_message').focus(function () {
	$(this).css({'border-color': '#00a1d6'});
});
$('.password_message').blur(function () {
	$(this).css({'border-color': '#c6d8f2'});
});


//注销
$('#logout').click(function(){
	$.ajax({
		url : '../logout',
		type: 'get',
		success : function (result) {
			if (result.code == 200){
				console.log(result.message);
				$('#page_head_div').hide();
				$('#page_loging_div').show();
			}
		}
	});
});

//个人中心
$('#personage').click(function(){
	$.ajax({
		url: '../judge',
		type: 'get',
		success: function (result) {
			if (result.code == 500) {
				console.log(result.message);
			}
			else{
				window.location.replace("personage.html");
			}
		}
	});
});



//加载用户栏
function judge(){
	$.ajax({
		url:'../judge',
		type : 'get',
		success : function (result) {
			if (result.code == 200){
				$('#page_head_div').show();
				$('#page_loging_div').hide();
			}
		}
	});
}


//回车绑定登录 注册
$('#login_user').keydown(function (event) {
	if (event.keyCode == 13) {
		$(".btn_login").trigger("click");
	}
});

$('#login_password').keydown(function (event) {
	if (event.keyCode == 13) {
		$(".btn_login").trigger("click");
	}
});

$('#register_user').keydown(function (event) {
	if (event.keyCode == 13) {
		$(".btn_register").trigger("click");
	}
});

$('#register_password').keydown(function (event) {
	if (event.keyCode == 13) {
		$(".btn_register").trigger("click");
	}
});

$('#register_password2').keydown(function (event) {
	if (event.keyCode == 13) {
		$(".btn_register").trigger("click");
	}
});


//注册
$(document).on('click', '.btn_register', function () {
	if ($('#register_password').val() == $('#register_password2').val() & $('#register_password').val() != "") {
		$.ajax({
			url:'../save',
			type : 'post',
			data : { userNumber : $('#register_user').val(), userPassword :  $('#register_password').val()},
			success : function (result) {
				console.log(result.code);
				if (result.code == 200){
					pop(result.message);
					setTimeout(function () {
						login($('#register_user').val(), $('#register_password').val());
					},2000);

				}
				else if(result.code == 500	){
					pop(result.message);
				}
			}
		});
	}else{
		if ($('#register_password').val() == "" || $('#register_user').val() == ""){
			pop("账号密码不能为空");
		}
		else{
			pop("密码不一致");
		}
	}

});



//弹窗
function pop(text) {
	$('.pop').text(text);
	$('.pop').fadeIn();
	setTimeout(function () {
		$('.pop').fadeOut();
	},1000);
}