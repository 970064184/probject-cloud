package com.zhangbin.cloud.brand.service.impl;

import com.zhangbin.cloud.brand.entity.TbBrand;
import com.zhangbin.cloud.brand.mapper.TbBrandMapper;
import com.zhangbin.cloud.brand.service.ITbBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;


/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author zb
 * @since 2019-09-13
 */
@Service
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements ITbBrandService {

     @Autowired
     private TbBrandMapper mapper;


}
