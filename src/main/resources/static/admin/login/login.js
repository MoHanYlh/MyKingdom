$(function() {
	createCode();
})
/**
 * alert()可用toastr替换。
 */
var code;
// 去掉 O o 0 i I l L 难以区分的字母
var codeArray = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e',
		'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
		'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
function createCode() {
	code = "";
	var codeLength = 6;
	for (var i = 0; i < codeLength; i++) {
		var charNum = Math.floor(Math.random() * codeArray.length);
		code += codeArray[charNum];
	}
	$("#checkCode").html(code);
}

function loginCheck() {
	var validateCode = code.toUpperCase();
	var inputCode = $('#code').val().toUpperCase();
	console.log(validateCode);
	console.log(inputCode)
	if (validateCode == inputCode) {
		login();
	} else {
		alert("验证码错误");
		createCode();
	}
}
function login() {
	$.ajax({
		type : "POST",
		url : "/admin/login",
		data : JSON.stringify({
			'username' : $('#username').val(),
			'password' : $('#password').val()
		}),
		success : function(rs) {
			createCode();
			// if (rs && rs.status == 200) {
			// var data = rs.data;
			// localStorage.setItem("rspm.local", JSON.stringify(data));
			// $('#loginModal').modal("hide");
			// toastr.success($.i18n.prop('i18n_web_loginSuccess'))
			// setUser();
			// } else {
			// toastr.info($.i18n.prop('i18n_web_loginError'));
			// }
		},
		error : function() {
			// toastr.error("network error, please check it");
		},
		dataType : "json",
		contentType : "application/json"
	});
}