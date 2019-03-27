layui.use(['layer','table','upload'],function(){
	var table = layui.table,
	upload = layui.upload,
	layer = layui.layer;
	table.render({
		elem:'#roleId',
		page:true,
		url:http.remoteUrl+"/microservice-provider-user/role/findAllRoleByPage",
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
		totalRow:true,//开启合计行
		defaultToolbar: ['filter', 'exports'],
		cols:[[{
				type:'checkbox',
				fixed:'left'
			},
			{
				field:'roleName',
				title:'角色名称'
			},{
				field:'roleCode',
				title:'角色编码'
			},{
				field:'roleDesc',
				title:'角色描述'
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
	table.on('toolbar(role)',function(obj){
		var layEvent = obj.event;//获得lay-event对应的值
		 if(layEvent ==='addRoleId'){//添加用户
			layer.open({
				type:2,
				title:$(this).text(),
				area:['400px','330px'],
				content:'addRole.html'
			});
		}
	})

	/**
	 * 监听行工具事件
	 */
	
	table.on('tool(role)',function(obj){
		var data = obj.data,//获得当前行数据
		layEvent = obj.event;//获得lay-event对应的值
		 if(layEvent === 'configAuth'){
			 	/*layer.alert('当前行详细信息：<br>'+ JSON.stringify(data))*/
			 layer.open({
					type:2,
					title:$(this).text(),
					area:['400px','380px'],//宽、高
					content:'configAuth.html'
				});
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