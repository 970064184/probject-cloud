layui.use(['layer','table'],function(){
	var table = layui.table,
	layer = layui.layer;
	var data =[{ "userName": "10001" ,"userPhone": "杜甫" ,"status": "xianxin@layui.com"},
		{"userName": "10002" ,"userPhone": "李白","status": "xianxin@layui.com"
    }];
	table.render({
		elem:'#authId',
		page:true,
		data:data,
//		url:"/getUser",
		cols:[[
			{
				field:'userName',
				title:'用户名'
			},{
				field:'userPhone',
				title:'用户手机号码'
			},{
				field:'status',
				title:'用户状态'
			}
		]]
	});
	
	/**
	 * 添加用户按钮点击事件
	 */
	$("#addAuthId").click(function(){
		layer.open({
			type:2,
			title:$(this).text(),
			area:['500px','520px'],
			content:'addAuth.html',
			end:function(){
				location.reload();
			}
		});
	});
	
	/**
	 * 编辑用户按钮点击事件
	 */
	$("#editAuthId").click(function(){
		layer.open({
			type:2,
			title:$(this).text(),
			area:['500px','520px'],
			content:'addAuth.html',
			end:function(){
				location.reload();
			}
		});
	});
});