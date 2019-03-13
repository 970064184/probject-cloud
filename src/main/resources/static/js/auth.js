layui.config({
    base: '../layui/lay/modules/'
}).extend({
    treetable: 'treetable-lay/treetable'
}).use(['table','form','element','treetable','layer'],function(){
	var $ = layui.$,
	table = layui.table,
	form = layui.form,
	element = layui.element,
	treetable = layui.treetable,
	layer = layui.layer;
	var data=[
	    {
	      "d_id": 1,
	      "name": "xx",
	      "sex": "male",
	      "d_pid": -1
	    }
	  ]

	var renderTable = function(){
		treetable.render({
			treeColIndex:2,
			treeSpid:-1,
			treeIdName:'authId',
			treePidName:'pId',
			elem:'#authId',
			toolbar:'#leftToolBar',
			defaultToolbar: ['filter', 'exports'],
			/*data:data,*/
			url:http.remoteUrl+"/microservice-provider-user/auth/findAllAuthByPage",
			method:'post',
			reqdata:{
				  "limit": 10,
				  "page": 1
				},
			page:false,
			cols:[[
				{
					type:'numbers'
				},
				{
					field:'authId',
					title:'权限id'
				},
				{
					field:'authName',
					title:'权限名称'
				},
				{
					field:'authType',
					title:'权限类型',
					templet:function(d){
						var value="";
						switch (d.authType) {
						case 1:value="导航";break;
						case 2:value="菜单";break;
						case 3:value="api";break;
						case 4:value="按钮";break;
						default: value="导航";break;
						}
						return value;
					}
				},
				{
					field:'authUrl',
					title:'跳转url'
				},
				{
					field:'pid',
					title:'父节点id'
				},
				{
					templet:'#barDemo',
					title:'操作'
				}
			]],
			done:function(){
				layer.closeAll('loading');
			}
		})
	};
	renderTable();
	/**
	 * 监听头工具栏事件
	 */
	table.on('toolbar(auth)',function(obj){
		var layEvent = obj.event;//获得lay-event对应的值
		 if(layEvent ==='addAuthId'){//添加用户
			layer.open({
				type:2,
				title:$(this).text(),
				area:['460px','480px'],//宽、高
				content:'addAuth.html'
			});
		}
	});
	
	table.on('tool(auth)',function(obj){
		var data = obj.data,//获得当前行数据
		layEvent = obj.event;//获得lay-event对应的值
		 if(layEvent === 'del'){
		      layer.confirm('真的删除行么', function(index){
		        obj.del(); //删除对应行（tr）的DOM结构
		        layer.close(index);
		        //向服务端发送删除指令
		        http.ajax({
		        	url:http.remoteUrl+'/microservice-provider-user/auth/delAuth/'+data.authId,
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
					area:['460px','480px'],//宽、高
					content:'editAuth.html',
					success:function(index,layero){
						var pIframe = $('iframe')[0].contentWindow.document;//找到上一级父页面
						var subForm = $(pIframe).find('#formId');//在父页面里找到editForm表格，这个Id为所编辑form的ID值
						$.each(data,function(i,item){
							subForm.find("[name="+i+"]").val(item);
						})
					}
				});
		    }
	})
})