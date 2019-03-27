layui.use(['atree','layer','form'],function(){
	var tree = layui.atree,
	$ = layui.$,
	form = layui.form,
	layer = layui.layer;
	
	http.ajax({
		url:"http://localhost:8030/microservice-provider-user/system/getAllMenu",
		type:"GET",
		beforeSend:function(xhr){
			var authorication = localStorage.getItem("Authorication");
			xhr.setRequestHeader("Authorication",authorication);
		},
		success:function(data){
			if(data.code == "200"){
				var data = navbarData(data.data);
				
				 layui.atree({
				    	elem:"#configAuthId",//传入元素选择器
				        check: 'checkbox', //勾选风格 
				        skin: 'as', //设定皮肤
				            //,target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
//				      drag: true,
				        spreadAll:true,
				        props:{//设置key属性别名
				    		  addBtnLabel:'新增',
				    		  deleteBtnLabel:'删除',
				    		  name: 'name',
				              id: 'authId',
				              children:'children',
				              checkbox:'checkbox',
				              spread:'spread'
				        },
				        change:function(val){//选中回调函数
				        	 console.group('change event')
				          console.log('Array')
				          console.log(val);
				          console.groupEnd()
				        },
				        click: function(item) { //点击节点回调
				          console.group('click event')
				          console.log('Object')
				          console.log(item);
				          console.groupEnd()
				        },
				        addClick:function(item,elem,add){//新增回调函数
				        	  console.group('append event')
				          console.log('Object')
				          console.log(item);
				          console.log('dom')
				          console.log(elem);
				          console.log('dom add event')
				          var item ={
				             name: '测试节点'+new Date().getTime(),
				             id:-1
				         }
				          add(item)
				          console.groupEnd()
				        },
				        deleteClick:function(item,elem,done){//删除回调函数
				        	 console.group('delete event')
				          console.log('Object')
				          console.log(item);
				          console.log('dom')
				          console.log(elem);
				          console.log('dom delete event')
				          done();
				          console.groupEnd()
				        },
				        nodes: data
				    });
			}else{
				layer.msg(data.msg);
			}
		}
	});
	/**
	 * 监听添加用户
	 * @param data
	 * @returns
	 */
	form.on('submit(configAuth)',function(data){
		layer.alert(JSON.stringify(data.field),{
			title:'最终的提交信息'
		})
		http.ajax({
			url:http.remoteUrl+"/microservice-provider-user/auth/addAuth",
			data:data.field,
			beforeSend:function(xhr){
				var authorication = localStorage.getItem("Authorication");
				xhr.setRequestHeader("Authorication",authorication);
			},
			success:function(data){
				if(data.code == "200"){
					//当你在iframe页面关闭自身时
					close();
				}else{
//					close();
					layer.msg(data.msg);
				}
			}
		});
		return false;//不跳转
	});
	
	$("#closeId").click(function(){
		close();
	})
})


function close(){
	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index); //再执行关闭
}


/**
 * 自定义节点字段名称
 * @param data
 * @returns
 */
function navbarData(data){
	var val = new Array();
	for ( var key in data) {
		var dataObj = {};
		dataObj.name = data[key].authName;
		dataObj.spread = true;
		if(data[key].children && data[key].children.length>0){
			var children = navbarData(data[key].children);
			dataObj.children = children;
		}
		val[key]=dataObj;
	}
	return val;
}


/*layui.config({
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

	var renderTable = function(){
		treetable.render({
			treeColIndex:2,
			treeSpid:-1,
			treeIdName:'authId',
			treePidName:'pId',
			elem:'#configAuthId',
			check:'checkbox',
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
				}
			]],
			done:function(){
				layer.closeAll('loading');
			}
		})
	};
	renderTable();
})*/