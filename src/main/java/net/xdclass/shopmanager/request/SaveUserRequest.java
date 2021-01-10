package net.xdclass.shopmanager.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "新增用户请求模型")
public class SaveUserRequest {

    @ApiModelProperty(value = "主键")
    private int id;
    @ApiModelProperty(value = "邮箱",required = true,example = "xxx@qq.com")
    private String email;
    @ApiModelProperty(value = "手机号",required = false)
    private String phone;
    @ApiModelProperty(value = "用户姓名",required = true)
    private  String name;
}
