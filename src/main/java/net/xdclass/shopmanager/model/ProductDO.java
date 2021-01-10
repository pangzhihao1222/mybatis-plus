package net.xdclass.shopmanager.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author pangzhihao
 * @since 2021-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("product")
public class ProductDO implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 鏍囬?
     */
    private String title;

    /**
     * 灏侀潰鍥
     */
    private String coverImg;

    /**
     * 璇︽儏
     */
    private String detail;

    /**
     * 鑰佷环鏍
     */
    private BigDecimal oldPrice;

    /**
     * 鏂颁环鏍
     */
    private BigDecimal price;

    /**
     * 搴撳瓨
     */
    private Integer stock;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createTime;

    /**
     * 閿佸畾搴撳瓨
     */
    private Integer lockStock;


}
