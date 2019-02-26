layui.config({
	base: '../layui/extra/'
}).use(['layer','element','navbar','tab'],function(){
	var element = layui.element,
	$ = layui.$;
	layer = layui.layer,
	navbar = layui.navbar(),
	tab = layui.tab({
        elem: '.admin-nav-card' //设置选项卡容器
    });
	
	http.ajax({
		url:"http://localhost:8030/microservice-provider-web/getAllMenu",
		type:"GET",
		beforeSend:function(xhr){
			var authorication = localStorage.getItem("Authorication");
			xhr.setRequestHeader("Authorication",authorication);
		},
		success:function(data){
			if(data.code == "200"){
				var menu = navbarData(data.data);
				//设置navbar
				navbar.set({
					spreadOne: true,
					elem: '#admin-navbar-side',
					cached: true,
					data: menu//navs
				});
				//渲染navbar
				navbar.render();
				//监听点击事件
				navbar.on('click(side)', function (data) {
					console.log(data);
					tab.tabAdd(data.field);
				});
			}else if(data.code == "401"){
				window.location.href="login.html"; 
			}else{
				layer.msg(data.msg);
			}
		}
	});
});
/**
 * 自定义节点字段名称
 * @param data
 * @returns
 */
function navbarData(data){
	var val = new Array();
	for ( var key in data) {
		var dataObj = {};
		dataObj.title = data[key].authName;
		dataObj.icon = data[key].authLogo;
		dataObj.href = data[key].authUrl;
		if(data[key].children && data[key].children.length>0){
			var children = navbarData(data[key].children);
			dataObj.children = children;
		}
		val[key]=dataObj;
	}
	return val;
}