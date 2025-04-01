package com.example.SpringBatchBillingReport.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBatchBillingReport.model.BillingRecord;
import com.example.SpringBatchBillingReport.processor.BillingRecordProcessor;
import com.example.SpringBatchBillingReport.writer.BillingRecordWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Job billingJob(JobBuilderFactory jobBuilderFactory, Step step1) {
        return jobBuilderFactory.get("billingJob")
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory,
                      FlatFileItemReader<BillingRecord> reader,
                      BillingRecordProcessor processor,
                      BillingRecordWriter writer) {
        return stepBuilderFactory.get("step1")
                .<BillingRecord, BillingRecord>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
