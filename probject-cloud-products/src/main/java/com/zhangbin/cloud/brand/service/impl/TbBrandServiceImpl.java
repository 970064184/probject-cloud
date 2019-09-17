package com.zhangbin.cloud.brand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbin.cloud.brand.entity.TbBrand;
import com.zhangbin.cloud.brand.mapper.TbBrandMapper;
import com.zhangbin.cloud.brand.service.ITbBrandService;
import com.zhangbin.cloud.utils.PageEntity;
import com.zhangbin.cloud.utils.QueryWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
@Service
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements ITbBrandService {

    @Autowired
    private TbBrandMapper mapper;

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    */
    @Override
    public IPage<TbBrand> page(PageEntity pageBean){
        IPage<TbBrand> page = new Page<>(pageBean.getPage(),pageBean.getLimit());
        Map<SqlKeyword,Map<String, Object>> map =pageBean.getMap();
        QueryWrapper<TbBrand> queryWrapper = QueryWrapperUtils.getQueryWrapper(map);
        return mapper.selectPage(page, queryWrapper);
    }

}
