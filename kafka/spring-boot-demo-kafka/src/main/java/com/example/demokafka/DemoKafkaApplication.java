package com.example.demokafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoKafkaApplication.class, args);
	}

	@RestController
	@RequestMapping("/kafka")
	class KafkaProducerController {
		private Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		private KafkaTemplate kafkaTemplate;

		@GetMapping("/send")
		public String send(@RequestParam String msg){
			logger.info("生产者生产的消息："+msg);
			kafkaTemplate.send("test_topic", msg); // 没有主题会自动创建
			return "success";
		}
	}

	/**
	 * 消费者
	 */
	@Component
	class TestConsumer {

		@KafkaListener(topics = "test_topic")
		public void listen (ConsumerRecord<?, ?> record) throws Exception {
			System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
		}
	}

}
