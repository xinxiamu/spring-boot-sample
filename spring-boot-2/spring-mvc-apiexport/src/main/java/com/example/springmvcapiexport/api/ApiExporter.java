package com.example.springmvcapiexport.api;

import com.alibaba.fastjson.JSON;
import com.example.springmvcapiexport.JsonHandlerExceptionResolver;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * API暴露器，监测项目中所有的Controller的RequestMapping方法
 *
 * @author lujijiang
 */
public class ApiExporter implements ApplicationListener<ContextRefreshedEvent>, HttpRequestHandler, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(ApiExporter.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //防止二次调用
        if (event.getApplicationContext().getParent() != null) {
            return;
        }

        if (this.applicationContext == null && event.getApplicationContext() instanceof WebApplicationContext) {
            this.applicationContext = event.getApplicationContext();
            this.initializeAPI();
            //开发环境自动监听
            /*if (isDev(this.applicationContext.getEnvironment().getActiveProfiles())) {
                new Thread(() -> {
                    while (true) {
                        try {
                            initializeAPI();
                            TimeUnit.SECONDS.sleep(10);
                        } catch (Exception e) {
                            logger.error("The loop scan API has an exception", e);
                        }
                    }
                }).start();
            }*/
        }
    }

    private boolean isDev(String[] activeProfiles) {

        if (activeProfiles != null) {
            for (String activeProfile : activeProfiles) {
                if (activeProfile.contains("dev")) {
                    return true;
                }
            }
        }
        return false;
    }


    class ApiMeta {
        String name;
        Object bean;
        Method method;

        @Override
        public String toString() {
            return "ApiMeta{" +
                    "name='" + name + '\'' +
                    ", bean=" + bean +
                    ", method=" + method +
                    '}';
        }
    }

    private ApplicationContext applicationContext;

    private Map<String, ApiMeta> apiMetaMap = new ConcurrentHashMap<>();

    private String encoding = "UTF-8";

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/javascript;charset=utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        String method = request.getMethod();
        if (method != null && "POST".equalsIgnoreCase(method)) {
            try (InputStream is = request.getInputStream(); PrintWriter out = response.getWriter()) {
                handlePost(IOUtils.toString(is, encoding), out);
            }
        } else {// GET、PUT、DELETE
            handlePostExcept(request,response);
        }

    }

    private void  handlePostExcept(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        ApiMeta apiMeta = apiMetaMap.get(action);
        try {
            if (apiMeta == null) {
                throw new ApiException(-1, String.format("Can not find a API named %s", action), null);
            }

            Object[] argsValue = null;
            List<String> argNames = new ArrayList<>();

            Enumeration<String> pNames = request.getParameterNames();
            while (pNames.hasMoreElements()) {
                String pName = pNames.nextElement();
                if (!"action".equalsIgnoreCase(pName)) {
                    argNames.add(pName);
                }
            }
            Class<?>[] parameterTypes = apiMeta.method.getParameterTypes();
            if (parameterTypes.length != argNames.size()) {
                throw new ApiException(-1, String.format("Need %d parameters,but got %d", parameterTypes.length,
                        argNames.size()), null);
            }
            if (!argNames.isEmpty()) {
                argsValue = new Object[argNames.size()];
                for (int i = 0; i < argNames.size(); i++) {
                    String value = request.getParameter(argNames.get(i));
                    Object newValue = null;
                    Class<?> parameterType = parameterTypes[i];
                    if (parameterType == String.class) {
                        newValue = value;
                    } else if (parameterType == int.class) {
                        newValue = Integer.valueOf(value).intValue();
                    } else if (parameterType == Integer.class) {
                        newValue = Integer.valueOf(value);
                    } else if (parameterType == Boolean.class) {
                        newValue = Boolean.valueOf(value);
                    } else if (parameterType == boolean.class) {
                        newValue = Boolean.valueOf(value).booleanValue();
                    } else if (parameterType == long.class) {
                        newValue = Long.valueOf(value).longValue();
                    } else if (parameterType == Long.class) {
                        newValue = Long.valueOf(value);
                    } else if (parameterType == float.class) {
                        newValue = Float.valueOf(value).floatValue();
                    } else if (parameterType == Float.class) {
                        newValue = Float.valueOf(value);
                    } else if (parameterType == double.class) {
                        newValue = Double.valueOf(value).doubleValue();
                    } else if (parameterType == Double.class) {
                        newValue = Double.valueOf(value);
                    } else if (parameterType == BigDecimal.class) {
                        newValue = new BigDecimal(value);
                    }

                    argsValue[i] = newValue;
                }
            }

            Object result ;
            if (argsValue != null) {
                result = apiMeta.method.invoke(apiMeta.bean, argsValue);
            } else {
                result = apiMeta.method.invoke(apiMeta.bean);
            }
            response.getWriter().write(JSON.toJSONString(result));
        } catch (Exception e) {
            JsonHandlerExceptionResolver.handleExceptionJsonMessage(response.getWriter(), e, null);
            return;
        }
    }


    private void handlePost(String json, PrintWriter out) throws IOException {
        ApiRequest apiRequest = JSON.parseObject(json, ApiRequest.class);
        ApiResponse apiResponse = new ApiResponse(); //api输出对象
        apiResponse.setId(apiRequest.getId());
        String action = apiRequest.getAction();
        ApiMeta apiMeta = apiMetaMap.get(action);

        try {
            if (apiMeta == null) {
                throw new ApiException(-1, String.format("Can not find a API named %s", action), null);
            }
//            Assert.notNull(apiMeta, String.format("Can not find a API named %s", action));
            Class<?>[] parameterTypes = apiMeta.method.getParameterTypes();
            if (parameterTypes.length != apiRequest.getArgs().length) {
                throw new ApiException(-1, String.format("Need %d parameters,but got %d", parameterTypes.length,
                        apiRequest.getArgs().length), null);
            }
            for (int i = 0; i < apiRequest.getArgs().length; i++) {
                Object arg = apiRequest.getArgs()[i];
                String argJson = String.valueOf(arg);
                if (CharSequence.class.isAssignableFrom(parameterTypes[i])) {
                    argJson = "\"".concat(argJson.replace("\"", "\\\"")).concat("\"");
                }
                apiRequest.getArgs()[i] = JSON.parseObject(argJson, parameterTypes[i]);
            }
            Object result = apiMeta.method.invoke(apiMeta.bean, apiRequest.getArgs());
            apiResponse.setResult(result);
        } catch (Exception e) {
            JsonHandlerExceptionResolver.handleExceptionJsonMessage(out, e, null);
            return;
        }
        String responseJSON = JSON.toJSONString(apiResponse);
        out.print(responseJSON);
        logger.debug("API({}):\r\nrequest:{}\r\nresponse:{}", apiMeta, json, responseJSON);
    }


    /**
     * 初始化动作，找到所有的API并进行注册
     */
    private void initializeAPI() {
        Map<String, ApiMeta> apiMetaMap = new ConcurrentHashMap<>();
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(beanName);
            Class<?> beanClass = applicationContext.getType(beanName);
            while (beanClass.getName().contains("$$")) {
                beanClass = beanClass.getSuperclass();
            }
            if (beanClass.getAnnotation(Controller.class) == null
                    && beanClass.getAnnotation(RestController.class) == null) {
                continue;
            }
            parseClassApi(apiMetaMap, beanName, bean, beanClass);
            Class[] interfaces = beanClass.getInterfaces();
            for (Class interface_ : interfaces) {
                parseClassApi(apiMetaMap, beanName, bean, interface_);
            }
        }
        if (logger.isInfoEnabled()) {
            for (String name : this.apiMetaMap.keySet()) {
                if (!apiMetaMap.containsKey(name)) {
                    logger.info("API service({}) has been deleted.", this.apiMetaMap.get(name));
                }
            }
        }
        this.apiMetaMap = apiMetaMap;
    }

    private void parseClassApi(Map<String, ApiMeta> apiMetaMap, String beanName, Object bean, Class<?> beanClass) {
        Method[] methods = beanClass.getMethods();
        parseApi(apiMetaMap, beanName, bean, methods);
        Class superClass = beanClass.getSuperclass();
        if (superClass != null) {
            parseClassApi(apiMetaMap, beanName, bean, superClass);
            Class[] interfaces = superClass.getInterfaces();
            for (Class interface_ : interfaces) {
                methods = interface_.getMethods();
                parseClassApi(apiMetaMap, beanName, bean, interface_);
            }
        }
    }

    private void parseApi(Map<String, ApiMeta> apiMetaMap, String beanName, Object bean, Method[] methods) {
        for (Method method : methods) {
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            PostMapping postMapping = method.getAnnotation(PostMapping.class);
            GetMapping getMapping = method.getAnnotation(GetMapping.class);
            PutMapping putMapping = method.getAnnotation(PutMapping.class);
            DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
            if (requestMapping != null || postMapping != null || getMapping != null
                    || putMapping != null || deleteMapping != null) {
                String name = beanName.concat(".").concat(method.getName());
                ApiMeta apiMeta = new ApiMeta();
                apiMeta.method = method;
                apiMeta.bean = bean;
                apiMeta.name = name;
                ApiMeta existAPIMeta = apiMetaMap.get(name);
                if (existAPIMeta != null) {
                    if (!Arrays.equals(existAPIMeta.method.getParameterTypes(), method.getParameterTypes())) {
                        throw new IllegalStateException(
                                String.format("Duplicate API name %s with %s and %s", name, existAPIMeta, apiMeta));
                    }
                    continue;
                }
                apiMetaMap.put(name, apiMeta);
                if (logger.isInfoEnabled()) {
                    if (!this.apiMetaMap.containsKey(name)) {
                        logger.info("API service({}) has been registered.", apiMeta);
                    }
                }
            }
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug(">>>>>>>>>>>>>afterPropertiesSet:" + this.getClass().getSimpleName());
    }
}
