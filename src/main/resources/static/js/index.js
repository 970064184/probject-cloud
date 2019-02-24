layui.config({
	base: '../layui/extra/'
}).use(['layer','element','navbar'],function(){
	var element = layui.element,
	layer = layui.layer,
	navbar = layui.navbar(),
	$ = layui.$;
	
	http.ajax({
		url:"http://localhost:8030/microservice-provider-web/getAllMenu",
		type:"GET",
		beforeSend:function(xhr){
			var authorication = localStorage.getItem("Authorication");
			xhr.setRequestHeader("Authorication",authorication);
		},
		success:function(data){
			if(data.code == "200"){
				console.log(data.data);
				var data = navbarData(data.data);
				console.log(data);
				 //设置navbar
			    navbar.set({
			        spreadOne: false,
			        elem: '#admin-navbar-side',
			        cached: false,
			        data: data
			    });
			    //渲染navbar
			    navbar.render();
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