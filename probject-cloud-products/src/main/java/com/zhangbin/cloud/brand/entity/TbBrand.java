package com.zhangbin.cloud.brand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author zb
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbBrand对象", description="品牌表")
public class TbBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "brand_id")
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Long brandId;

    @ApiModelProperty(value = "品牌中文名称")
    private String brandChName;

    @ApiModelProperty(value = "品牌英文名称")
    private String brandEnName;

    @ApiModelProperty(value = "品牌logo")
    private String brandLogo;

    @ApiModelProperty(value = "是否上线.0=是1=否")
    private Integer isOnline;

    @ApiModelProperty(value = "排序")
    private Integer brandSort;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(value = "产地")
    private String brandPlace;

    @ApiModelProperty(value = "备注")
    private String brandRemarks;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;


}
