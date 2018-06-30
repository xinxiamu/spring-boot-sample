package org.chiwooplatform.oxm.support;

import org.chiwooplatform.oxm.config.AppConfig;
import org.chiwooplatform.simple.model.HUser;
import org.chiwooplatform.simple.model.WechatMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootConfiguration
@Import({ AppConfig.class })
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JaxbProcessorTest.class)
public class JaxbProcessorTest {

	@Autowired
	private JaxbProcessor processor;

	@Test
	public void toXmlTest() throws Exception {
		System.out.println("processor: " + processor);
		WechatMessage msg = new WechatMessage();
		msg.setToUserName("ToUserName");
		msg.setContent("aaa");
//		List list = new ArrayList();
//		list.add(msg);
//		list.add(msg);
		String xmlStr = processor.toXml(msg);
		System.out.println(xmlStr);
	}



	@Test
	public void toBeanTest() throws Exception {
		String xml = "<xml><aaa>sdfsdfsd</aaa><ToUserName><![CDATA[mutou]]></ToUserName><FromUserName><![CDATA[yingying]]></FromUserName>"
				+ "<CreateTime>1498547497</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[加油]]></Content><MsgId>6436212491545076337</MsgId></xml>";
		WechatMessage message = processor.toBean(xml, WechatMessage.class);
		System.out.println("message: " + message);
	}

	@Test
	public void test1() throws Exception {
		HUser user = new HUser();
		user.setEMPLOYEE_NAME("liyan 00250836");
		user.setEMPLOYEE_NUM("00250836");
		user.setREGION_NAME("Headquarter");
		user.setREGION_CODE("0001");
		String xmlStr = processor.toXml(user);
		System.out.println(xmlStr);
	}

	@Test
	public void test2() throws Exception {
		String xml = "<dbr:PO_GET_REGION_USERS_ITEM><dbr:EMPLOYEE_NUM>00250836</dbr:EMPLOYEE_NUM><dbr:EMPLOYEE_NAME>liyan 00250836</dbr:EMPLOYEE_NAME><dbr:REGION_NAME>Headquarter</dbr:REGION_NAME><dbr:REGION_CODE>0001</dbr:REGION_CODE><dbr:ATTRIBUTE1>SCS</dbr:ATTRIBUTE1><dbr:ATTRIBUTE2/><dbr:ATTRIBUTE3/><dbr:ATTRIBUTE4/><dbr:ATTRIBUTE5/></dbr:PO_GET_REGION_USERS_ITEM>";
		HUser user = processor.toBean(xml, HUser.class);
		System.out.println(user.toString());
	}
}
