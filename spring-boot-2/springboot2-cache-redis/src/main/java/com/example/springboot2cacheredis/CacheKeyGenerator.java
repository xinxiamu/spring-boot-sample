package com.example.springboot2cacheredis;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 缓存键生成器
 */
public class CacheKeyGenerator implements KeyGenerator {

    /*
     * 构造缓存的key
     * @see
     * org.springframework.cache.interceptor.KeyGenerator#generate(java.lang.
     * Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        Map<String, Object> keyMap = new LinkedHashMap<>();
        keyMap.put("@target", target);
        keyMap.put("@method", generateMethodMap(method));
        keyMap.put("@params", params);
        String keyStr = JSON.toJSONString(keyMap);
        return keyStr;
    }

    /**
     * 生成方法对应Map
     *
     * @param method
     * @return
     */
    private Map<String, Object> generateMethodMap(Method method) {
        Map<String, Object> methodMap = new LinkedHashMap<>();
        methodMap.put("methodName", method.getName());
        String[] parameterTypes = new String[method.getParameterTypes().length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = method.getParameterTypes()[i].getCanonicalName();
        }
        methodMap.put("parameterTypes", parameterTypes);
        return methodMap;
    }

}
