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
@TableName("product_order")
public class ProductOrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 璁㈠崟鍞?竴鏍囪瘑
     */
    private String outTradeNo;

    /**
     * NEW 鏈?敮浠樿?鍗?PAY宸茬粡鏀?粯璁㈠崟,CANCEL瓒呮椂鍙栨秷璁㈠崟
     */
    private String state;

    /**
     * 璁㈠崟鐢熸垚鏃堕棿
     */
    private Date createTime;

    /**
     * 璁㈠崟鎬婚噾棰
     */
    private BigDecimal totalFee;

    /**
     * 璁㈠崟瀹為檯鏀?粯浠锋牸
     */
    private BigDecimal payFee;

    /**
     * 鏀?粯绫诲瀷锛屽井淇?閾惰?-鏀?粯瀹
     */
    private String payType;

    /**
     * 鏄电О
     */
    private String nickname;

    /**
     * 澶村儚
     */
    private String headImg;

    /**
     * 鐢ㄦ埛id
     */
    private Integer userId;

    /**
     * 0琛ㄧず鏈?垹闄わ紝1琛ㄧず宸茬粡鍒犻櫎
     */
    private Integer del;

    /**
     * 鏇存柊鏃堕棿
     */
    private Date updateTime;

    /**
     * 璁㈠崟绫诲瀷 DAILY鏅??鍗曪紝PROMOTION淇冮攢璁㈠崟
     */
    private String orderType;

    /**
     * 鏀惰揣鍦板潃 json瀛樺偍
     */
    private String receiverAddress;


}
