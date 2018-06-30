package com.jiakong.framework.springbootsecurity.config;

import org.springframework.context.ApplicationContext;

/**
 * Appctx
 *
 * @author yangpeng
 * @date 2018-05-22-17
 */
public class Appctx {
    public static ApplicationContext ctx = null;

    public static Object getObject(String string) {
        return ctx.getBean(string);
    }
}
