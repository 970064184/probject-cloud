package com.zhangbin.cloud.utils;

import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.zhangbin.cloud.common.PageBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@ApiModel("分页查询请求参数")
@Data
public class PageEntity extends PageBean {

    /**
     *mybatis-plus条件分页查询条件
     *     AND("AND"),
     *     OR("OR"),
     *     IN("IN"),
     *     NOT("NOT"),
     *     LIKE("LIKE"),
     *     EQ("="),
     *     NE("<>"),
     *     GT(">"),
     *     GE(">="),
     *     LT("<"),
     *     LE("<="),
     *     IS_NULL("IS NULL"),
     *     IS_NOT_NULL("IS NOT NULL"),
     *     GROUP_BY("GROUP BY"),
     *     HAVING("HAVING"),
     *     ORDER_BY("ORDER BY"),
     *     EXISTS("EXISTS"),
     *     BETWEEN("BETWEEN"),
     *     ASC("ASC"),
     *     DESC("DESC");
     *
     *     {
     * "map":{
     * "LIKE":{
     * "brand_ch_name":"t"
     * },
     * "AND":{
     * "brand_en_name":"test",
     * "brand_logo":"/"
     * }
     * }
     * }
     */
    @ApiModelProperty(value="复杂条件查询参数")
    Map<SqlKeyword, Map<String, Object>> map = new HashMap<>();
}
