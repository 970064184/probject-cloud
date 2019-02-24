//config的设置是全局的
layui.config({
    base: '../common/'
}).use(['layer','element','navbar'],function(){
	var element = layui.element,
	layer = layui.layer,
	navbar = layui.navbar(),
	$ = layui.$;
	
	 //设置navbar
    navbar.set({
        spreadOne: true,
        elem: '#admin-navbar-side',
        cached: true,
        data: navs
		/*cached:true,
		url: 'datas/nav.json'*/
    });
    //渲染navbar
    navbar.render();
	
	http.ajax({
		url:"http://localhost:8030/microservice-provider-web/getAllMenu",
		type:"GET",
		beforeSend:function(xhr){
			var authorication = localStorage.getItem("Authorication");
			xhr.setRequestHeader("Authorication",authorication);
		},
		success:function(data){
			if(data.code == "200"){
			}else if(data.code == "401"){
				window.location.href="login.html"; 
			}else{
				layer.msg(data.msg);
			}
		}
	});
	
	
});