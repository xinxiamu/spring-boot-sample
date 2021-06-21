package com.example.demokafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.io.IOException;

@SpringBootTest
//@EmbeddedKafka(count = 4,ports = {9092,9093,9094,9095}) // 启动测试验证kafka运行环境。4个节点
@EmbeddedKafka(count = 1,ports = {9092}) // 启动测试验证kafka运行环境。4个节点
class DemoKafkaApplicationTests {

	@Test
	void contextLoads() throws IOException {
		System.in.read();
	}

}
