package net.xdclass.shopmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.xdclass.shopmanager.model.BannerDO;
import net.xdclass.shopmanager.service.BannerService;
import net.xdclass.shopmanager.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/
@Api(tags = "轮播图管理模块",value = "轮播图Controller")
@RestController
@RequestMapping("api/v1/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation("轮播图列表")
    @GetMapping("list")
    public JsonData list(){

        List<BannerDO> list = bannerService.list();

        return JsonData.buildSuccess(list);
    }

}
