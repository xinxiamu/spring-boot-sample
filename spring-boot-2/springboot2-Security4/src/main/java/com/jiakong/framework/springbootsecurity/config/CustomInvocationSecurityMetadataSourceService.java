package com.jiakong.framework.springbootsecurity.config;

import com.jiakong.framework.springbootsecurity.user.entity.SysResource;
import com.jiakong.framework.springbootsecurity.user.entity.SysRole;
import com.jiakong.framework.springbootsecurity.user.repository.SysResourceRpository;
import com.jiakong.framework.springbootsecurity.user.repository.SysRoleRrpository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * CustomInvocationSecurityMetadataSourceService
 *
 * @author yangpeng
 * @date 2018-05-23-09
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    private static Logger logger = LoggerFactory.getLogger(CustomInvocationSecurityMetadataSourceService.class);

    @Autowired
    private SysResourceRpository resourceRpository;
    @Autowired
    private SysRoleRrpository roleRrpository;

    private static Map<String, Collection<ConfigAttribute>> resourMap = null;

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
     * 一定要加上@PostConstruct注解
     * 一定要加上@PostConstruct注解
     * 一定要加上@PostConstruct注解
     * resourMap 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
     * String url = s1 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
     */
    @PostConstruct
    private void loadResourceDefine() {
        List<SysRole> roleList = roleRrpository.findAll();
        List<String> query = new LinkedList<>();
        if (roleList != null && roleList.size() > 0) {
            roleList.forEach(sysRole -> {
                query.add(sysRole.getName());
            });
        }
        resourMap = new HashMap<String, Collection<ConfigAttribute>>();
        query.forEach(s -> {
            ConfigAttribute configAttribute = new SecurityConfig(s);
            List<String> query1 = new LinkedList<>();
            List<SysResource> list = resourceRpository.findByName(s);
            if (list != null && list.size() > 0) {
                list.forEach(sysResource -> {
                    query1.add(sysResource.getResourceString());
                });
            }
            query1.forEach(s1 -> {
                String url = s1;
                if (resourMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourMap.get(url);
                    value.add(configAttribute);
                    resourMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(configAttribute);
                    resourMap.put(url, atts);
                }
            });
        });
    }

    /**
     * Accesses the {@code ConfigAttribute}s that apply to a given secure object.
     *
     * @param object the object being secured
     * @return the attributes that apply to the passed in secured object. Should return an
     * empty collection if there are no applicable attributes.
     * @throws IllegalArgumentException if the passed object is not of a type supported by
     *                                  the <code>SecurityMetadataSource</code> implementation
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        if (resourMap == null) {
            loadResourceDefine();
        }
        Iterator<String> iterator = resourMap.keySet().iterator();
        while (iterator.hasNext()) {
            String resURL = iterator.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourMap.get(resURL);
            }
        }
        return null;
    }

    /**
     * If available, returns all of the {@code ConfigAttribute}s defined by the
     * implementing class.
     * <p>
     * This is used by the {@link } to perform startup time
     * validation of each {@code ConfigAttribute} configured against it.
     *
     * @return the {@code ConfigAttribute}s or {@code null} if unsupported
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * Indicates whether the {@code SecurityMetadataSource} implementation is able to
     * provide {@code ConfigAttribute}s for the indicated secure object type.
     *
     * @param clazz the class that is being queried
     * @return true if the implementation can process the indicated class
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
