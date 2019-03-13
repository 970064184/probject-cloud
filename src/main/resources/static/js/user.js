layui.use(['layer','table','upload'],function(){
	var table = layui.table,
	upload = layui.upload,
	layer = layui.layer;
	var data =[{ "userName": "10001" ,"userPhone": "杜甫" ,"status": "xianxin@layui.com"},
		{"userName": "10002" ,"userPhone": "李白","status": "xianxin@layui.com"
    }];
	table.render({
		elem:'#userId',
		page:true,
//		data:data,
		url:http.remoteUrl+"/microservice-provider-user/user/findAllUserByPage",
		headers:{
			Authorication:localStorage.getItem("Authorication")
		},
		where:{
			search:{
				userName:'r',
				userAge:'1'
			}
		},
		contentType: 'application/json',
		method:'post',
		toolbar:'#leftToolBar',
//		toolbar:'default',
//		toolbar:'<div class="layui-table-tool-temp"><div class="layui-inline" title="导入" lay-event="LAYTABLE_INPORT"><i class="layui-icon layui-icon-upload-circle"></i></div></div>',//开启工具栏"#barDemo","default",true
		totalRow:true,//开启合计行
		defaultToolbar: ['filter', 'exports'],
		cols:[[{
				type:'checkbox',
				fixed:'left'
			},
			{
				field:'userName',
				title:'用户名'
			},{
				field:'userPhone',
				title:'用户手机号码'
			},{
				field:'created',
				title:'用户注册时间'
			},{
				fixed:'right',
				title:'操作',
				toolbar:'#barDemo',
				
			}
		]],response:{
			statusName:'code',
			statusCode:'200',
			msgName:'msg',
		},parseData:function(res){
			return{
				"code":res.code,
				"msg":res.msg,
				"count":res.data.count,
				"data":res.data.data
			};
		}
	});
	/**
	 * 监听头工具栏事件
	 */
	table.on('toolbar(user)',function(obj){
		var layEvent = obj.event;//获得lay-event对应的值
		 if(layEvent ==='addUserId'){//添加用户
			layer.open({
				type:2,
				title:$(this).text(),
				area:['500px','520px'],
				content:'addUser.html'
			});
		}
	})
	/**
	 * 导入用户
	 */
	upload.render({
	    elem: '#importUserId',
	    url:http.remoteUrl+'/microservice-provider-user/user/importUser',
	    accept: 'file' ,//普通文件
    	headers:{
			Authorication:localStorage.getItem("Authorication")
		},
	    done: function(res){
	    	if(res.code == "200"){
				layer.msg("成功导入");
				location.reload();
			}else{
				return layer.msg(res.msg);
			}	
	    }
	  });

	/**
	 * 监听行工具事件
	 */
	
	table.on('tool(user)',function(obj){
		var data = obj.data,//获得当前行数据
		layEvent = obj.event;//获得lay-event对应的值
		 if(layEvent === 'detail'){
			 	layer.alert('当前行详细信息：<br>'+ JSON.stringify(data))
		    } else if(layEvent === 'del'){
		      layer.confirm('真的删除行么', function(index){
		        obj.del(); //删除对应行（tr）的DOM结构
		        layer.close(index);
		        //向服务端发送删除指令
		        http.ajax({
		        	url:http.remoteUrl+'/microservice-provider-user/user/delUser/'+data.userId,
		        	type:"GET",
		    		beforeSend:function(xhr){
		    			var authorication = localStorage.getItem("Authorication");
		    			xhr.setRequestHeader("Authorication",authorication);
		    		},
					success:function(data){
						if(data.code == "S200"){
							layer.msg(data.msg);
						}else{
							layer.msg(data.msg);
						}
					}
				});
		      });
		    } else if(layEvent === 'edit'){
		    	layer.open({
					type:2,
					title:$(this).text(),
					area:['500px','520px'],
					content:'editUser.html',
					success:function(index,layero){
						var pIframe = $('iframe')[0].contentWindow.document;//找到上一级父页面
						var subForm = $(pIframe).find('#formId');//在父页面里找到editForm表格，这个Id为所编辑form的ID值
						$.each(data,function(i,item){
							subForm.find("[name="+i+"]").val(item);
						})
						subForm.find("#userPwdDiv").hide();
					}
				});
		    }
	})
	
});