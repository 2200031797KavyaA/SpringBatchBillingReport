package com.example.SpringBatchBillingReport.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.SpringBatchBillingReport.model.BillingRecord;

@Component
public class BillingRecordReader extends FlatFileItemReader<BillingRecord> {

    public BillingRecordReader() {
        setResource(new ClassPathResource("billing_data.csv"));
        setLinesToSkip(1); // Skip header row

        setLineMapper(new DefaultLineMapper<BillingRecord>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("customerName", "phoneNumber", "amount", "billingDate");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(BillingRecord.class);
            }});
        }});
    }
}