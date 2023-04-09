package com.ag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MiniProjectInsuranceReportGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectInsuranceReportGenerationApplication.class, args);
	}

}
