package com.example.SpringBatchBillingReport;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchBillingReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchBillingReportApplication.class, args);
	}

}
