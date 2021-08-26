package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages="com") base package를 변경하는 anotation
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // 데이터베이스 설정안함
//@MapperScan(basePackages = "com.example.*") // mapper scan 추가!!!
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}
}