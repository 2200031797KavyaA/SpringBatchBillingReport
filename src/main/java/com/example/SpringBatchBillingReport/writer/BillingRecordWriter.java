package com.example.SpringBatchBillingReport.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SpringBatchBillingReport.model.BillingRecord;
import com.example.springbatch.repository.BillingRecordRepository;

@Component
public class BillingRecordWriter implements ItemWriter<BillingRecord> {

    @Autowired
    private BillingRecordRepository repository;

    @Override
    public void write(List<? extends BillingRecord> items) {
        repository.saveAll(items);
    }
}
