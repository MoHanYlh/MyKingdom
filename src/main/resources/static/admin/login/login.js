var code;
var show = 0;
// 去掉 O o 0 i I l L 难以区分的字母
var codeArray = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e',
		'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
		'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
/**
 * 生成验证码
 */
function createCode() {
	code = "";
	var codeLength = 6;
	for (var i = 0; i < codeLength; i++) {
		var charNum = Math.floor(Math.random() * codeArray.length);
		code += codeArray[charNum];
	}
	$("#checkCode").html(code);
}
/**
 * 显示验证码输入框
 */
function showValidate(){
	$('#pwdDiv').addClass('line');
	$('#codeDiv').css('display', '');
	$('#code').attr('required', '');
	show = 1;
	createCode();
}
/**
 * 检查是否需要输入验证码
 */
function loginCheck() {
	if(show == 0){
		$.ajax({
			type : "POST",
			url : "/admin/loginCheck",
			data : JSON.stringify({
				'username' : $('#username').val()
			}),
			success : function(rs) {
				if(rs && rs.status == 200){
					login();
				}else{
					alert(rs.message);
					showValidate();
				}
			},
			error : function() {
				alert("网络错误");
			},
			dataType : "json",
			contentType : "application/json"
		});
	}else{
		var validateCode = code.toUpperCase();
		var inputCode = $('#code').val().toUpperCase();
		if (validateCode == inputCode) {
			login();
		} else {
			alert("验证码错误");
			createCode();
		}
	}
}
/**
 * 登录
 */
function login() {
	$.ajax({
		type : "POST",
		url : "/admin/login",
		data : JSON.stringify({
			'username' : $('#username').val(),
			'password' : $('#password').val()
		}),
		success : function(rs) {
			if (rs && rs.status == 200) {
				alert("登录成功");
				show = 0;
				var data = rs.data;
				localStorage.setItem("rspm.local", JSON.stringify(data));
			} else {
				alert(rs.message);
			}
		},
		error : function() {
			alert("网络错误");
		},
		dataType : "json",
		contentType : "application/json"
	});
}