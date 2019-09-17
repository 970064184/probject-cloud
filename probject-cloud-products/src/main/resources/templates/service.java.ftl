package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import java.io.Serializable;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangbin.cloud.utils.PageEntity;


/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

   /**
   * 根据 entity 条件，查询全部记录（并翻页）
   */
   IPage<${entity}> page(PageEntity pageBean);

}
</#if>
