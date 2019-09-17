package com.zhangbin.cloud.menu.service.impl;

import com.zhangbin.cloud.menu.entity.TbMenu;
import com.zhangbin.cloud.menu.mapper.TbMenuMapper;
import com.zhangbin.cloud.menu.service.ITbMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.zhangbin.cloud.utils.QueryWrapperUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangbin.cloud.utils.PageEntity;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
@Service
public class TbMenuServiceImpl extends ServiceImpl<TbMenuMapper, TbMenu> implements ITbMenuService {

    @Autowired
    private TbMenuMapper mapper;

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    */
    @Override
    public IPage<TbMenu> page(PageEntity pageBean){
        IPage<TbMenu> page = new Page<>(pageBean.getPage(),pageBean.getLimit());
        Map<SqlKeyword,Map<String, Object>> map =pageBean.getMap();
        QueryWrapper<TbMenu> queryWrapper = QueryWrapperUtils.getQueryWrapper(map);
        return mapper.selectPage(page, queryWrapper);
    }

}
