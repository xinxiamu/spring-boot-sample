package com.example.springmvcapiexport.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-20 下午8:53
 * @updateTime
 * @since 1.0.0
 */
@RestController
@RequestMapping("testController")
public class TestController {

    @PostMapping("/testPost")
    public ParVO1 testPost(@RequestBody ParVO2 vo2, @RequestBody ParVO1 vo1) {
        System.out.println("POST-测试，参数必须是json字符串转vo");
        return vo1;
    }

    @GetMapping("/testGet1")
    public String testGet1(String name, int i, BigDecimal bd, float f, double d, boolean b) {
        System.out.println(">>>>" + name + "-" + i);
        System.out.println(">>>>" + bd.toPlainString());
        System.out.println(">>>>" + f + "-" + d + "-" + b);
        return "测试各种参数-GET";
    }

    @GetMapping("/testGet2")
    public String testGet2() {
        return "RequestMapping-GET NO Par";
    }

}
