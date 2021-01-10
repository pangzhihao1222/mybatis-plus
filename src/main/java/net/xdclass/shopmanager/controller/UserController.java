package net.xdclass.shopmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import net.xdclass.shopmanager.model.User;
import net.xdclass.shopmanager.request.SaveUserRequest;
import net.xdclass.shopmanager.util.JsonData;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "用户模块", value = "用户controller")
@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @ApiOperation("用户列表")
    @GetMapping("list")
    public JsonData list() {
        User user1 = User.builder().phone("1231231231").id(1).email("sadfsdf@124.com").build();
        User user2 = User.builder().phone("1231231231").id(1).email("sadfsdf@124.com").build();
        User user3 = User.builder().phone("1231231231").id(1).email("sadfsdf@124.com").build();
        List list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return JsonData.buildSuccess(list);
    }

    @ApiOperation("查看用户详情")
    @GetMapping("detail")
    public JsonData query(@ApiParam(name = "id", value = "用户id", example = "1")
                          @RequestParam("id") int id) {
        return JsonData.buildSuccess();
    }

    @ApiOperation("用户登录")
    @PostMapping("login")
    @ApiResponses({
            @ApiResponse(responseCode = "302",description = "重定向，跳转登录"),
            @ApiResponse(responseCode = "403",description = "没权限"),
    })
    public JsonData login(@ApiParam(name = "phone", value = "手机号", example = "12222222222")
                          @RequestParam("phone") String phone,
                          @ApiParam(name = "pwd", value = "密码", example = "123456")
                          @RequestParam("pwd") String pwd) {
        return JsonData.buildSuccess();
    }

    @ApiIgnore //忽略此接口文档
    @ApiOperation("根据id删除用户")
    @DeleteMapping("/delete/{id}")
    public JsonData delById(@ApiParam(name = "id", value = "用户id", example = "1")
                            @PathVariable("id") int id) {
        return JsonData.buildSuccess();
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
//    public JsonData save(@NonNull SaveUserRequest saveUserRequest){
    public JsonData save(@RequestBody@NonNull SaveUserRequest saveUserRequest){
        return JsonData.buildSuccess();
    }
}
