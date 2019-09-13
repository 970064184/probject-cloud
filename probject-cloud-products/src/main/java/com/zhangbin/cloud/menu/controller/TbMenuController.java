package com.zhangbin.cloud.menu.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import org.springframework.http.MediaType;
import java.io.Serializable;
import com.zhangbin.cloud.menu.entity.TbMenu;
import com.zhangbin.cloud.menu.service.ITbMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zb
 * @since 2019-09-13
 */
 @Api(tags="相关接口")
@RestController
@RequestMapping("/menu")
public class TbMenuController {

     @Autowired
     private ITbMenuService service;

     @ApiOperation(value = "根据 ID 查询", notes = "根据 主键ID 查询")
     @PostMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<TbMenu> getById(@RequestParam("id")Serializable id) {
        TbMenu respData = service.getById(id);
        return DtoUtils.returnSuccess(respData);
     }

    @ApiOperation(value = "新增记录", notes = "插入一条记录")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Dto<Boolean> save(@RequestBody TbMenu entity) {
        boolean respData = service.save(entity);
        return DtoUtils.returnSuccess(respData);
    }

     @ApiOperation(value = "根据 ID 删除", notes = "根据 ID 删除")
     @PostMapping(value = "/removeById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<Boolean> removeById(@RequestParam("id")Serializable id) {
        boolean respData = service.removeById(id);
        return DtoUtils.returnSuccess(respData);
     }

     @ApiOperation(value = "根据 ID 选择修改", notes = "根据 ID 选择修改")
     @PostMapping(value = "/updateById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<Boolean> updateById(@RequestBody TbMenu entity) {
        boolean respData = service.updateById(entity);
        return DtoUtils.returnSuccess(respData);
     }

 }
