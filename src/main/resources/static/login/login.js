var login = {};
$(function(){
})
/**
* 表单提交
*/
$('#loginSubmit').on("click", function(){
     //获取表单对象，并进行表单校验
	http.ajax({
		before:true,
		id:".login-form",
		url:"http://localhost:8030/login",
		success:function(data){
			if(data.code == "S200"){
				window.location.href="/index?token="+data.data; 
			}else{
				alert(data.msg);
			}
		}
	})
});

