package com.zhangbin.cloud.brand.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangbin.cloud.brand.entity.TbBrand;
import com.zhangbin.cloud.utils.PageEntity;


/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
public interface ITbBrandService extends IService<TbBrand> {

   /**
   * 根据 entity 条件，查询全部记录（并翻页）
   */
   IPage<TbBrand> page(PageEntity pageBean);

}
