package net.xdclass.shopmanager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.shopmanager.mapper.BannerMapper;
import net.xdclass.shopmanager.model.BannerDO;
import net.xdclass.shopmanager.model.BannerDORecordActive;
import net.xdclass.shopmanager.service.BannerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest(classes = Application.class)
@Slf4j
class BannerTest {


    @Autowired
    private BannerService bannerService;


    @Autowired
    private BannerMapper bannerMapper;

    /**
     * *************************** 查询 ****************************
     */

    /**
     * id查找
     */
    @Test
    public void testSelectById(){

        BannerDO bannerDO = bannerMapper.selectById(1);
        log.info("bannerDO: {}",bannerDO);
    }


    /**
     * 批量查找
     */
    @Test
    public void testSelectBatchIds(){

        List<BannerDO> list = bannerMapper.selectBatchIds( Arrays.asList(1,2));
        log.info("bannerDO: {}",list);
    }


    /**
     * 选择1条
     */
    @Test
    public void testSelectOne(){

        BannerDO bannerDO = bannerMapper.selectOne(new QueryWrapper<BannerDO>().eq("id",1));
        log.info("bannerDO: {}",bannerDO);
    }


    /**
     * 统计行数
     */
    @Test
    public void testSelectCount(){

        int size = bannerMapper.selectCount(null);
        log.info("bannerDO: {}",size);
    }


    /***
     * 查找全部数据
     */
    @Test
    public void testBannerList(){

        List<BannerDO> list = bannerService.list();
        log.info("轮播图列表:{}",list);

    }

    /**
     * *************************** 新增 ****************************
     */

    /***
     * 新增
     */
    @Test
    public void testAdd(){


        //BannerDO bannerDO = new BannerDO();
//        bannerDO.setImg("xxxxx");
//        bannerDO.setUrl("xdcalss.net");
        BannerDO bannerDO = BannerDO.builder().img("xxxxx").url("xdcalss.net").build();

        bannerMapper.insert(bannerDO);

        log.info("轮播图:{}",bannerDO);

    }

    /**
     * *************************** 删除 ****************************
     */

    @Test
    public void testDeleteId(){


       int rows = bannerMapper.deleteById(4);
       log.info("rows:{}",rows);

    }


    @Test
    public void testDeleteByMap(){

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("weight",12);
        columnMap.put("url","bbb");

        int rows = bannerMapper.deleteByMap(columnMap);
        log.info("rows:{}",rows);

    }

    /**
     * *************************** 修改 ****************************
     */

    /**
     * 更新
     */
    @Test
    public void testUpdate(){

        BannerDO bannerDO = BannerDO.builder().url("xdcalss.net").build();
       bannerDO.setUrl("taobao.com");
       int rows = bannerMapper.update(bannerDO,new QueryWrapper<BannerDO>().eq("id",1));
        log.info("rows:{}",rows);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdateWrapper(){


        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("url","aaaa.com");
        updateWrapper.eq("id",1);
        int rows = bannerMapper.update(null,updateWrapper);
        log.info("rows:{}",rows);
    }

    /**
     * *************************** QueryWrapper ****************************
     */

    /**
     * * eq 等于
     * * ne 不等于
     * * gt 大于
     * * ge 大于等于
     * * lt 小于
     * * le 小于等于
     * * or 拼接or
     * * between 两个值中间
     * * notBetween 不在两个值中间
     */
    @Test
    public void testQueryWrapper1(){

    //SELECT id,img,url,weight AS weightAAA FROM banner WHERE (id = ? AND url <> ?)
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",1);
        queryWrapper.or();
        queryWrapper.ne("url","bbbc.com");

        bannerMapper.selectList(queryWrapper);
    }


    /**
     * * like 模糊匹配
     * * notLike 不像
     * * likeLeft 左匹配
     * * likeRight 右边匹配
     * * isNull 字段为空
     * * in  in查询
     * * groupBy 分组
     * * orderByAsc 升序
     * * orderByEdsc 降序
     * * having having查询
     */
    @Test
    public void testQueryWrapper2(){

        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like("url","bbb");
//        queryWrapper.notLike("img","cccc");
        //SELECT id,img,url,weight AS weightAAA FROM banner WHERE (url LIKE ? AND img NOT LIKE ?)

        //queryWrapper.likeLeft("url","bbb");
        //queryWrapper.likeRight("img","cccc");

        queryWrapper.isNull("img");
        queryWrapper.in("url",Arrays.asList("aaaa","bbbb"));
        queryWrapper.orderByDesc("id");

        //SELECT id,img,url,weight AS weightAAA FROM banner WHERE (img IS NULL AND url IN (?,?)) ORDER BY id DESC
        bannerMapper.selectList(queryWrapper);
    }


    /**
     * *************************** 分页条件查询 ****************************
     */

    /**
     * 测试分页功能，指定参数查询
     */
    @Test
    public void  testPage(){

        QueryWrapper<BannerDO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("weight",4);

        //第一页，每页3条, 如果是第一页则直接一个问号，获取条数
        Page<BannerDO> page  = new Page<>(2,2);

        IPage<BannerDO> iPage =  bannerMapper.selectPage(page,queryWrapper.select("id","url")); //只查询id 和 url

        log.info("总条数:{}",iPage.getTotal());

        log.info("总页数:{}",iPage.getPages());

        log.info("数据：{}",iPage.getRecords());
    }

    /**
     * *************************** ActiveRecord ****************************
     */

    /**
     * AR几乎不用,容易混乱
     */
    @Test
    public void testActiveRecord(){
//        BannerDORecordActive build = BannerDORecordActive.builder().build();
//        BannerDORecordActive bannerDORecordActive = build.selectById(1);
//        log.info("ar:{}",bannerDORecordActive);
    }

    /**
     * *************************** 乐观锁 ****************************
     */

    /**
     * mybatisPlus
     * 乐观锁测试
     * 使用场景：扣减库存，公共数据的处理
     *
     */
    @Test
    public void testOptimi(){
        //
        BannerDO bannerDO = BannerDO.builder().version(2).id(1).url("open1024.com").build();
        bannerMapper.updateById(bannerDO);
    }

    /**
     * *************************** 逻辑删除 ****************************
     */

    /**
     * mybatisPlus
     * 逻辑删除（假删）
     */
    @Test
    public void testTableLogic(){

        int rows = bannerMapper.deleteById(1);
        log.info("rows:{}",rows);

    }





}
