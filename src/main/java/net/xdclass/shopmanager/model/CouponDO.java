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
@TableName("coupon")
public class CouponDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 浼樻儬鍗风被鍨媅NEW_USER娉ㄥ唽璧犲埜锛孴ASK浠诲姟鍗凤紝PROMOTION淇冮攢鍔礭
     */
    private String category;

    /**
     * 鍙戝竷鐘舵?, PUBLISH鍙戝竷锛孌RAFT鑽夌?锛孫FFLINE涓嬬嚎
     */
    private String publish;

    /**
     * 浼樻儬鍒稿浘鐗
     */
    private String couponImg;

    /**
     * 浼樻儬鍒告爣棰
     */
    private String couponTitle;

    /**
     * 鎶垫墸浠锋牸
     */
    private BigDecimal price;

    /**
     * 姣忎汉闄愬埗寮犳暟
     */
    private Integer userLimit;

    /**
     * 浼樻儬鍒稿紑濮嬫湁鏁堟椂闂
     */
    private Date startTime;

    /**
     * 浼樻儬鍒稿け鏁堟椂闂
     */
    private Date endTime;

    /**
     * 浼樻儬鍒告?閲
     */
    private Integer publishCount;

    /**
     * 搴撳瓨
     */
    private Integer stock;

    /**
     * 鏄?惁鍙犲姞0鏄?笉琛岋紝1鏄?彲浠
     */
    private Integer addOne;

    private Date createTime;

    /**
     * 婊″?灏戞墠鍙?互浣跨敤
     */
    private BigDecimal conditionPrice;


}
