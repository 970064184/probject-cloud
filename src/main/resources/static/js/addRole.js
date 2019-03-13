layui.use(['layer','form'],function(){
	var form = layui.form,
	layer = layui.layer;
	
	/**
	 * 监听添加用户
	 * @param data
	 * @returns
	 */
	form.on('submit(addRole)',function(data){
		layer.alert(JSON.stringify(data.field),{
			title:'最终的提交信息'
		})
		http.ajax({
			url:http.remoteUrl+"/microservice-provider-user/role/addRole",
			data:data.field,
			beforeSend:function(xhr){
				var authorication = localStorage.getItem("Authorication");
				xhr.setRequestHeader("Authorication",authorication);
			},
			success:function(data){
				if(data.code == "200"){
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