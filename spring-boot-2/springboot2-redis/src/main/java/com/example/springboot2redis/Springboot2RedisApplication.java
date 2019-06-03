package com.example.springboot2redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Springboot2RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2RedisApplication.class, args);
    }

    @RestController
    @RequestMapping("index")
    public class IndexCOntroller {

        @Autowired
        private RedisTemplate<String, Object> redisTemplate;

        @Autowired
        @Qualifier("stringRedisTemplate")
        private StringRedisTemplate stringRedisTemplate;

        @GetMapping
        public String index() {
            RedisSerializer a = redisTemplate.opsForValue().getOperations().getValueSerializer();
            System.out.println(">>a:" + a);

            redisTemplate.opsForValue().set("name", "木头人");
            stringRedisTemplate.opsForValue().set("user", "小草公司");

            Map map = new HashMap();
            map.put(1,"ab");
            map.put("a",3);
            redisTemplate.opsForValue().set("a", map);
            List<Map> list = new ArrayList<>();
            list.add(map);
            list.add(map);
            redisTemplate.opsForValue().set("b",list);

            return "hello welcome";
        }

        @GetMapping("/list")
        public Object getList() {
            return redisTemplate.opsForValue().get("b");
        }

        @GetMapping("/map")
        public Object getMap() {
            return redisTemplate.opsForValue().get("a");
        }

        @GetMapping("name")
        public Object getName() {
            System.out.println(">>user:" + stringRedisTemplate.opsForValue().get("user"));
            return redisTemplate.opsForValue().get("name");
        }
    }
}
