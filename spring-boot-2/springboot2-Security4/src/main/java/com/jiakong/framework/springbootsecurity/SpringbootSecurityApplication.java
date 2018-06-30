package com.jiakong.framework.springbootsecurity;

import com.jiakong.framework.springbootsecurity.config.Appctx;
import com.jiakong.framework.springbootsecurity.user.entity.SysUser;
import com.jiakong.framework.springbootsecurity.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

/**
 * 安全系统启动类
 *
 * @author yangpeng
 */
@SpringBootApplication
public class SpringbootSecurityApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringbootSecurityApplication.class);

    @PostConstruct
    public void initApplication() {
        logger.info("Running with Spring profile(s) : {}");
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootSecurityApplication.class);
        Appctx.ctx = application.run(args);
    }

    /**
     * 该方法竟在第一次启动本项目时使用
     * 后续请注释此方法调用
     * 初始化管理员密码
     * username 数据库的name
     * TEST/000000   user/123456
     */
    public void initialUser() {
        UserService suserService = (UserService) Appctx.ctx.getBean("userService");
        String username = "TEST";
        SysUser su = suserService.findByName(username);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
        su.setPassword(bc.encode(su.getPassword()));
        logger.info("密码" + su.getPassword());
        suserService.update(su);
    }


}
