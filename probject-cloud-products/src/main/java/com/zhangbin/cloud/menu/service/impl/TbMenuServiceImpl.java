package com.zhangbin.cloud.menu.service.impl;

import com.zhangbin.cloud.menu.entity.TbMenu;
import com.zhangbin.cloud.menu.mapper.TbMenuMapper;
import com.zhangbin.cloud.menu.service.ITbMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zb
 * @since 2019-09-13
 */
@Service
public class TbMenuServiceImpl extends ServiceImpl<TbMenuMapper, TbMenu> implements ITbMenuService {

     @Autowired
     private TbMenuMapper mapper;


}
