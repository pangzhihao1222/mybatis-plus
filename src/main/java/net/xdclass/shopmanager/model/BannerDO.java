package net.xdclass.shopmanager.model;

import com.baomidou.mybatisplus.annotation.*;
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
//public class BannerDO extends Model<BannerDO>
public class BannerDO {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String img;

    private String url;

    @TableField("weight")
    private Integer weight;

    @TableField(exist = false) //数据库不存在的字段
    private Date createTime;

    /**
     * 乐观锁版本号
     */
    @Version
    private Integer version;  //实现乐观锁，但是表中需要添加一个版本字段

    /**
     * 逻辑删除标识位
     */
    @TableLogic            //也可以加在配置文件中：实现假删除功能
    private Integer deleted;



}
