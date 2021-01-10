package net.xdclass.shopmanager.model;

import lombok.*;

import java.util.Date;
import java.util.Objects;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/
//@Setter
//@Getter
////@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@ToString
//
//@EqualsAndHashCode(of = {"id","name"})
//@EqualsAndHashCode(exclude = {"id","name"})
@Data
@Builder
public class User {

    private int id;

    private String email;

    private String phone;

    private  String name;


//    private static  final String pwd = "123456";
//
//    private static Date createTime = new Date();
//
//
//
//    public void login( String pwd){
//            //TODO
//            System.out.println(pwd);
//    }


}
