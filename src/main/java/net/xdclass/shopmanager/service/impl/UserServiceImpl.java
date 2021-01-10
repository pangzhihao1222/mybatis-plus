package net.xdclass.shopmanager.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.shopmanager.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public void login(String pwd, String phone) {

        log.info("用户登录：{}",phone);

    }

}
