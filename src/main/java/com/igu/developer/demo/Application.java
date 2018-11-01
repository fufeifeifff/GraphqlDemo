package com.igu.developer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackageClasses = {Application.class})
public class Application {
	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		builder.sources(Application.class);
//		return builder;
//	}

//	@Bean
//	ApplicationRunner init(CarService carService) {
//		return args -> {
////			carService.getCars().forEach(System.out::println);
////			userService.getUser().forEach(System.out::println);
//		};
//	}
}


