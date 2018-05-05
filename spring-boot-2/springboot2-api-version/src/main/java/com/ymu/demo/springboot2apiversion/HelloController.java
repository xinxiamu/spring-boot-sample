package com.ymu.demo.springboot2apiversion;

import com.ymu.demo.springboot2apiversion.version.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class HelloController {

    //---------------- api版本管理 demo start ------------------//

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello0(HttpServletRequest request) {
        print(request);
        return "hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiVersion(1)
    public String hello1(HttpServletRequest request) {
        print(request);
        return "hello:v1";
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiVersion(5)
    public String hello5(HttpServletRequest request) {
        print(request);
        return "hello:v5";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiVersion(2)
    public String hello2(HttpServletRequest request) {
        print(request);
        return "hello:v2";
    }

    private void print(HttpServletRequest request) {
        System.out.println("version:" + request.getHeader("Content-Version"));
    }

}