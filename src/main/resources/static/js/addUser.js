layui.use(['layer','form','laydate','upload'],function(){
	var form = layui.form,
	layer = layui.layer,
	upload = layui.upload,
	laydate = layui.laydate;
	
	//日期
	laydate.render({
		elem:'#birthdayId'
	})
	
	/**
	 * 头像图片上传
	 */
	
	var uploadInst = upload.render({
		elem:'#test1',
		url:'/upload',
		before:function(obj){
			//预读本地文件示例，不支持ie8
			obj.preview(function(index,file,result){
				$("#demo1").show().find('img').attr('src',result);//图片链接
			});
		},done:function(res){
			if(res.code !="200"){
				return layer.msg('上传失败');
			}
			//上传成功
		},error:function(){
			var demoText = $("#demoText");
			demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			demoText.find('.demo-reload').on('click',function(){
				uploadInst.upload();
			});
		}
	});
	
	/**
	 * 监听添加用户
	 * @param data
	 * @returns
	 */
	form.on('submit(addUser)',function(data){
		console.log(data.field);
		layer.alert(JSON.stringify(data.field),{
			title:'最终的提交信息'
		})
		http.ajax({
			url:"addUser",
			data:data,
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