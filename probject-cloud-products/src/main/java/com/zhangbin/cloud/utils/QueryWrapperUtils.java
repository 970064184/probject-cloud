package com.zhangbin.cloud.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;

import java.util.Map;

public class QueryWrapperUtils {

    /**
     * 根据前端传过来的参数组装分页条件
     * @param map 条件查询
     * @return 分页条件
     */
    public static QueryWrapper getQueryWrapper(Map<SqlKeyword, Map<String, Object>> map) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        map.forEach((sqlKeyword, o) -> {
            if (SqlKeyword.AND.equals(sqlKeyword)) {
                o.forEach((e, obj) -> {
                    queryWrapper.eq(e, obj);
                });
            }else if (SqlKeyword.LIKE.equals(sqlKeyword)) {
                o.forEach((e, obj) -> {
                    queryWrapper.like(e, obj);
                });
            }
        });
        return queryWrapper;
    }
}
