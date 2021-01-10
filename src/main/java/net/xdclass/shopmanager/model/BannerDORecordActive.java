package net.xdclass.shopmanager.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@TableName("banner")
public class BannerDORecordActive extends Model<BannerDORecordActive> {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String img;

    private String url;

    @TableField("weight")
    private Integer weight;

    @TableField(exist = false)
    private Date createTime;



}
