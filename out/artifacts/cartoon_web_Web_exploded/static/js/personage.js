$(function(){


	cssLoad();
	personageLoad();
}); 


function cssLoad(){
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
		$('.sex_span').css({'background':'#f4f4f4', 'color': '#717171'});
		$('.message_btn').css({'background':'#fff', 'color': '#686869'});
		$(this).css({'background':'#22a1d6', 'color': '#fff'})
	}
});

$('#a_page').click(function(){
	
});


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
		url : '../get_user',
		type : 'get',
		success : function (result) {

			console.log(result.data);

			console.log(result.data.personage.birthday);
			// $('#username').text(result.data.personage);
			// $('')
		}
	});
}
