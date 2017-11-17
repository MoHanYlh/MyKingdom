$(function() {
	createCode();
})
/**
 * alert()可用toastr替换。
 */
var code;
function createCode() {
	code = "";
	var codeLength = 6;
	// 去掉 O o 0 i I l L 难以区分的字母
	var codeArray = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z');
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
	}else{
		alert("验证码错误")
	}
}
function login() {
	alert("ok")
}