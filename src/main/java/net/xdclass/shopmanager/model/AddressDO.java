package net.xdclass.shopmanager.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 鐢靛晢-鍏?徃鏀跺彂璐у湴鍧?〃
 * </p>
 *
 * @author pangzhihao
 * @since 2021-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("address")
public class AddressDO implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 鐢ㄦ埛id
     */
    private Long userId;

    /**
     * 鏄?惁榛樿?鏀惰揣鍦板潃锛?->鍚︼紱1->鏄
     */
    private Integer defaultStatus;

    /**
     * 鏀跺彂璐т汉濮撳悕
     */
    private String receiveName;

    /**
     * 鏀惰揣浜虹數璇
     */
    private String phone;

    /**
     * 鐪?鐩磋緰甯
     */
    private String province;

    /**
     * 甯
     */
    private String city;

    /**
     * 鍖
     */
    private String region;

    /**
     * 璇︾粏鍦板潃
     */
    private String detailAddress;

    private Date createTime;


}
