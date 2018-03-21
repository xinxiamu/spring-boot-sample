package com.example.springboot2ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-21 下午5:56
 * @updateTime
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private GoodsTypeDaoImpl goodsTypeDao;

    @GetMapping
    public String testSave(String value) {
        return goodsTypeDao.save(value);
    }

    @GetMapping("/update")
    public String testUpdate(String value) {
        return goodsTypeDao.update(value);
    }

    @GetMapping("/delete")
    public String testDelete(String value) {
        return goodsTypeDao.delete(value);
    }

    @GetMapping("/selecte")
    public String testSelect(String value) {
        return goodsTypeDao.select(value);
    }
}
