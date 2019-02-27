layui.use(['layer','form'],function(){
	var layer = layui.layer,
	form = layui.form
	$ = layui.$;
	
//	监听提交
	form.on('submit(login)',function(data){
		http.ajax({
			url:"http://localhost:8030/login",
			data:data,
			success:function(data){
				if(data.code == "S200"){
					localStorage.setItem("Authorication", data.data.auth);
					localStorage.setItem("user",JSON.stringify(data.data.user));
					window.location.href="index.html"; 
				}else{
					layer.msg(data.msg);
				}
			}
		});
		return false;//不跳转的意思
	});
	
//	表单初始赋值
	form.val('loginForm',{
		"username":"test",
		"password":"123"
	});
	
})