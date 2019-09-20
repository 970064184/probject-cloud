package com.zhangbin.cloud.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName(value = "tb_brand")
public class Brand implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long brandId;

    private String brandChName;

    private String brandEnName;

    private String brandLogo;

    private Integer isOnline;

    private Integer brandSort;

    private Date createdTime;

    private Date updatedTime;

    private String brandPlace;

    private String brandRemarks;
}
