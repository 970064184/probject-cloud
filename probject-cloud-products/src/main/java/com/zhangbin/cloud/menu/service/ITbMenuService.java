package com.zhangbin.cloud.menu.service;

import com.zhangbin.cloud.menu.entity.TbMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangbin.cloud.utils.PageEntity;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
public interface ITbMenuService extends IService<TbMenu> {

   /**
   * 根据 entity 条件，查询全部记录（并翻页）
   */
   IPage<TbMenu> page(PageEntity pageBean);

}
