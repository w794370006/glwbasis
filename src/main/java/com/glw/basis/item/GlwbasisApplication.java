package com.glw.basis.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.glw.basis.item.data.dao")
public class GlwbasisApplication {
	public static void main(String[] args) {
		SpringApplication.run(GlwbasisApplication.class, args);
	}

}
