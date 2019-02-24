/**
 * ajax 相关封装
 */
var http = {};
http.ajax = function(params) {
	if (!params.type) {// 默认为post请求
		params.type = "POST";
	}
	if (!params.contentType) {// 默认为json请求
		params.contentType = "application/json;charset=UTF-8";
		params.dataType = "json";
		if(params.data)
			params.data = JSON.stringify(params.data.field);
	}
	if (!params.async) {
		params.async = true;// 默认为异步
	}
	$.ajax({
		type : params.type,
		url : params.url,
		data : params.data,
		async : params.async,
		cache : false,
		contentType : params.contentType,
		dataType : params.dataType,
		beforeSend:params.beforeSend,
		error : function(data) {
			alert("系统异常");
		},
		success : function(data) {
			params.success(data);
		}
	});
}