package com.zhangbin.cloud.menu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.menu.entity.TbMenu;
import com.zhangbin.cloud.menu.service.ITbMenuService;
import com.zhangbin.cloud.utils.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
@RestController
@RequestMapping("/menu")
public class TbMenuController {

     @Autowired
     private ITbMenuService service;

      /**
      * 根据 ID 查询
      */
     @PostMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<TbMenu> getById(@RequestParam("id")Serializable id) {
        TbMenu respData = service.getById(id);
        return DtoUtils.returnSuccess(respData);
     }

    /**
    * 插入一条记录（选择字段，策略插入）
    */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Dto<Boolean> save(@RequestBody TbMenu entity) {
        boolean respData = service.save(entity);
        return DtoUtils.returnSuccess(respData);
    }

      /**
      * 根据 ID 删除
      */
     @PostMapping(value = "/removeById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<Boolean> removeById(@RequestParam("id")Serializable id) {
        boolean respData = service.removeById(id);
        return DtoUtils.returnSuccess(respData);
     }

      /**
      * 根据 ID 选择修改
      */
     @PostMapping(value = "/updateById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public  Dto<Boolean> updateById(@RequestBody TbMenu entity) {
        boolean respData = service.updateById(entity);
        return DtoUtils.returnSuccess(respData);
     }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    */
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Dto<IPage<TbMenu>> page(@RequestBody(required = false) PageEntity pageBean) {
        IPage<TbMenu> respData = service.page(pageBean);
        return DtoUtils.returnSuccess(respData);
    }

 }
