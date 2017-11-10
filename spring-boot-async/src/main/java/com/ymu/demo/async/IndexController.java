package com.ymu.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    Task task;

    @GetMapping("/index")
    public String index() throws Exception {
        task.webTest();
        return "index";
    }
}
