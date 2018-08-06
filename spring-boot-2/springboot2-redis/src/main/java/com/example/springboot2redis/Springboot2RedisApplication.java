package com.example.springboot2redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Springboot2RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2RedisApplication.class, args);
    }

    @RestController
    @RequestMapping("index")
    public class IndexCOntroller {

        @Autowired
        private RedisTemplate redisTemplate;

        @Autowired
        @Qualifier("stringRedisTemplate")
        private RedisTemplate stringRedisTemplate;

        @GetMapping
        public String index() {
            RedisSerializer a = redisTemplate.opsForValue().getOperations().getValueSerializer();
            System.out.println(">>a:" + a);

            redisTemplate.opsForValue().set("name", "木头人");
            stringRedisTemplate.opsForValue().set("user", "小草公司");
            return "hello welcome";
        }

        @GetMapping("name")
        public Object getName() {
            System.out.println(">>user:" + stringRedisTemplate.opsForValue().get("user"));
            return redisTemplate.opsForValue().get("name");
        }
    }
}
