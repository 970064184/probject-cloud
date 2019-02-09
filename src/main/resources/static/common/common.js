/**
 * ajax 相关封装
 */
var http = {};
http.ajax = function(params){
	var flag=true;
	if(params.id){
		if(params.before){
			$(params.id).bootstrapValidator('validate');
			flag = $(params.id).data("bootstrapValidator").isValid();
		}
		params.data =$(params.id).serializeObject();
	}
	if(flag){
		if(!params.type){//默认为post请求
			params.type = "POST";
		}
		if(!params.contentType){
			params.contentType = "application/json;charset=UTF-8";
			params.dataType ="json";
			params.data = JSON.stringify(params.data);
		}
		if(!params.async){
			params.async = true;//默认为异步
		}
		$.ajax({
			type:params.type,
			url:params.url,
			data:params.data,
			async:params.async,
			cache:false,
			contentType:params.contentType,
			dataType:params.dataType,
			error:function(data){
				alert("系统异常");
			},
			success:function(data){
				params.success(data);
			}
		});
	}
}
/**
 * 序列化表单数据
 */
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
