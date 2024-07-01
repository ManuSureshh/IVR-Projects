package com.vis.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@ComponentScan(basePackages = {"dump.me.in.db", "dump.me.in.db.scheduler"})
@SpringBootApplication
@EnableScheduling
public class PnbMetlifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PnbMetlifeApplication.class, args);
	}

}
