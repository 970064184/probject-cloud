var login = {};
$(function(){
})
/**
* 表单提交
*/
$('#loginSubmit').on("click", function(){
     //获取表单对象，并进行表单校验
	http.ajax({
		id:$(".login-form"),
		url:"http://localhost:7800/login",
		success:function(data){
			if(data.code == "S200"){
				window.location.href="http://localhost:8088/index?token="+data.data; 
			}else{
				alert(data.msg);
			}
		}
	})
});

