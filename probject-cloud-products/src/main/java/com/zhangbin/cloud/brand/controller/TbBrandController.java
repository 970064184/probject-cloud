package com.zhangbin.cloud.brand.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangbin.cloud.brand.entity.TbBrand;
import com.zhangbin.cloud.brand.service.ITbBrandService;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.utils.PageEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;



/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
 @Api(tags="品牌表相关接口")
@RestController
@RequestMapping("/brand")
public class TbBrandController {

     @Autowired
     private ITbBrandService service;

     @ApiOperation(value = "根据 ID 查询", notes = "根据 主键ID 查询")
     @PostMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<TbBrand> getById(@RequestParam("id")Serializable id) {
        TbBrand respData = service.getById(id);
        return DtoUtils.returnSuccess(respData);
     }

    @ApiOperation(value = "新增记录", notes = "插入一条记录")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Dto<Boolean> save(@RequestBody TbBrand entity) {
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
     public  Dto<Boolean> updateById(@RequestBody TbBrand entity) {
        boolean respData = service.updateById(entity);
        return DtoUtils.returnSuccess(respData);
     }

    @ApiOperation(value = "分页查询", notes = "根据 entity 条件，查询全部记录（并翻页）")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Dto<IPage<TbBrand>> page(@RequestBody(required = false) PageEntity pageBean) {
        IPage<TbBrand> respData = service.page(pageBean);
        return DtoUtils.returnSuccess(respData);
    }

 }
