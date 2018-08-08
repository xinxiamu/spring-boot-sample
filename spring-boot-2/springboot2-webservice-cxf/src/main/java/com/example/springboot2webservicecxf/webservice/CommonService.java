package com.example.springboot2webservicecxf.webservice;

import com.example.springboot2webservicecxf.vo.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 接口
 * 
 * @author leftso
 *
 */
@WebService(name = "CommonService", // 暴露服务名称
		targetNamespace = "http://webservice.leftso.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {

	@WebMethod
	@WebResult(name = "String", targetNamespace = "")
	String sayHello(@WebParam(name = "userName") String name);

	@WebMethod //标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
	User getUser(@WebParam(name = "userId") String userId);

	@WebMethod//(exclude=true)该犯法不暴露，静态方法和final方法不暴露
	@WebResult(name="String",targetNamespace="")
	String getUserName(@WebParam(name = "userId") String userId);

}
