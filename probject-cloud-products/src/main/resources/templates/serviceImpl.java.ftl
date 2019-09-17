package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
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
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} mapper;

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    */
    @Override
    public IPage<${entity}> page(PageEntity pageBean){
        IPage<${entity}> page = new Page<>(pageBean.getPage(),pageBean.getLimit());
        Map<${"SqlKeyword,Map\lString, Object\g"}> map =pageBean.getMap();
        QueryWrapper<${entity}> queryWrapper = QueryWrapperUtils.getQueryWrapper(map);
        return mapper.selectPage(page, queryWrapper);
    }

}
</#if>
