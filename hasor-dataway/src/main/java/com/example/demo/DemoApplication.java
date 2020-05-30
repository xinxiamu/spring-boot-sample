package com.example.demo;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableHasor
@EnableHasorWeb
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Controller
    @ResponseBody
    @RequestMapping("/")
    public class HomeController {

        /**
         * 输入http://localhost:8080直接跳转到http://localhost:8080/interface-ui/
         * @param request
         * @param response
         * @throws IOException
         */
        @GetMapping
        public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
           response.sendRedirect("/interface-ui/");
        }
    }
}
