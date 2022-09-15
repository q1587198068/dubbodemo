package com.athy;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableDubbo//开启基于注解的dubbo功能
public class DubboProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProvideApplication.class, args);

		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/*.xml"});
	//context.start();
	/*		try {
			System.out.println("DubboProvideApplication await");
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

}
