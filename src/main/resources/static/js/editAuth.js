layui.use(['layer','form'],function(){
	var form = layui.form,
	layer = layui.layer;
	
	/**
	 * 监听编辑用户
	 * @param data
	 * @returns
	 */
	form.on('submit(editAuth)',function(data){
		console.log(data.field);
		layer.alert(JSON.stringify(data.field),{
			title:'最终的提交信息'
		})
		http.ajax({
			url:http.remoteUrl+"/microservice-provider-user/auth/editAuth",
			data:data.field,
			beforeSend:function(xhr){
				var authorication = localStorage.getItem("Authorication");
				xhr.setRequestHeader("Authorication",authorication);
			},
			success:function(data){
				if(data.code == "S200"){
					//当你在iframe页面关闭自身时
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭
				}else{
					layer.msg(data.msg);
				}
			}
		});
		return false;//不跳转
	});
	
	
})