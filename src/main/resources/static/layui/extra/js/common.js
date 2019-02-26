/**
 * 公共异常信息
 * @param exports
 * @returns
 */
layui.define(['layer'], function(exports) {
	"use strict";

	var $ = layui.jquery,
		layer = layui.layer;

	var common = {
		/**
		 * 抛出一个异常错误信息
		 * @param {String} msg
		 */
		throwError: function(msg) {
			throw new Error(msg);
			return;
		},
		/**
		 * 弹出一个错误提示
		 * @param {String} msg
		 */
		msgError: function(msg) {
			layer.msg(msg, {
				icon: 5
			});
			return;
		}
	};

	exports('common', common);
});

$('.admin-side-toggle').on('click', function () {
    var sideWidth = $('#admin-side').width();
    if (sideWidth === 200) {
        $('#admin-body').animate({
            left: '0'
        }); //admin-footer
        $('#admin-footer').animate({
            left: '0'
        });
        $('#admin-side').animate({
            width: '0'
        });
    } else {
        $('#admin-body').animate({
            left: '200px'
        });
        $('#admin-footer').animate({
            left: '200px'
        });
        $('#admin-side').animate({
            width: '200px'
        });
    }
});