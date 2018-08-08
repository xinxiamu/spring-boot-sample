package com.example.springboot2webservicecxf.webservice;

import javax.jws.WebService;

import com.example.springboot2webservicecxf.vo.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 接口实现
 * 
 * @author leftso
 *
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
		targetNamespace = "http://webservice.leftso.com/", // 与接口中的命名空间一致,一般是接口的包名倒
		endpointInterface = "com.example.springboot2webservicecxf.webservice.CommonService"// 接口地址
)
@Component
public class CommonServiceImp implements CommonService {

	@Override
	public String sayHello(String name) {

		return "Hello ," + name;
	}

	@Override
	public User getUser(String userId) {
		User user = new User();
		user.setUserId(userId + "-" +UUID.randomUUID().toString().replace("-", ""));
		user.setUserName("test1");
		user.setEmail("maplefix@163.xom");

		return user;
	}

	@Override
	public String getUserName(String userId) {
		return "test" + userId;
	}

}
