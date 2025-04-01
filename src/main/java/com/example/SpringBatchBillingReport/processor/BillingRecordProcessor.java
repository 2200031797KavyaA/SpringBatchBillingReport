package com.example.SpringBatchBillingReport.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.SpringBatchBillingReport.model.BillingRecord;

@Component
public class BillingRecordProcessor implements ItemProcessor<BillingRecord, BillingRecord> {

    @Override
    public BillingRecord process(BillingRecord record) {
        // Example: Apply a discount of 10% for amounts above 1000
        if (record.getAmount() > 1000) {
            record.setAmount(record.getAmount() * 0.90);
        }
        return record;
    }
}
