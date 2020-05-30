package com.didispace.service.dy;

import com.didispace.service.SendMessage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SendMessageFactory implements ApplicationContextAware {

    private static Map<SendMessageType, A> a;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, A> beans = applicationContext.getBeansOfType(A.class);
        a = new HashMap<>();
        beans.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            a.put(value.getType(), value);
        });
    }
}
