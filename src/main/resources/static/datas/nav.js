navs = [ {
	"title" : "主页",
	"href" : "cop.html",
	"children" : null,
	"icon":"&#xe66c",
}, {
	"title" : "系统设置",
	"href" : "www.sys.com",
	"icon":"&#xe66c",
	"spread":true,
	"children" : [ {
		"title" : "权限模块",
		"href" : "www.sys.com",
		"icon":"&#xe66c",
		"children" : null
	} ]
}, {
	"title" : "业务系统",
	"href" : "www.manager.com",
	"icon":"&#xe66c",
	"spread":true,
	"children" : [ {
		"title" : "销售系统",
		"href" : "www.child01.com",
		"icon":"&#xe66c",
		"spread":false,
		"children" : [ {
			"title" : "订单系统",
			"href" : "www.order.com",
			"icon":"&#xe653",
			"children" : [ {
				"title" : "未完成订单",
				"href" : "www.undo.com",
				"icon":"&#xe653",
				"children" : [ {
					"title" : "服装部订单",
					"href" : "www.clothes.com",
					"icon":"&#xe653",
					"children" : [ {
						"title" : "成人部分",
						"href" : "www.clothes.com",
						"icon":"&#xe653",
						"children" : null
					}, {
						"title" : "儿童部分",
						"href" : "www.clothes.com",
						"icon":"&#xe653",
						"children" : null
					} ]
				}, {
					"title" : "玩具部订单",
					"href" : "www.clothes.com",
					"icon":"&#xe653",
					"children" : [ {
						"title" : "成人部分",
						"href" : "www.clothes.com",
						"icon":"&#xe653",
						"children" : null
					}, {
						"title" : "儿童部分",
						"href" : "www.clothes.com",
						"icon":"&#xe653",
						"children" : null
					} ]
				} ]
			} ]
		}, {
			"title" : "结算系统",
			"href" : "www.order.com",
			"icon":"&#xe653",
			"children" : null
		} ]
	}, {
		"title" : "公关系统",
		"href" : "www.child02.com",
		"icon":"&#xe653",
		"children" : null,
		"spread":false
	} ]
} ];