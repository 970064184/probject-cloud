package com.zhangbin.cloud.menu.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>
 * 
 * </p>
 *
 * @author zb
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbMenu对象", description="")
public class TbMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单图标")
    private String logo;

    @ApiModelProperty(value = "跳转url")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否隐藏")
    private Integer isHide;

    @ApiModelProperty(value = "父id")
    private Long pId;

    @ApiModelProperty(value = "创建时间")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date updated;


}
