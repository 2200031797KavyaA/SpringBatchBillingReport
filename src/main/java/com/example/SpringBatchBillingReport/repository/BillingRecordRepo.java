package com.example.SpringBatchBillingReport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBatchBillingReport.model.BillingRecord;

public interface BillingRecordRepo extends JpaRepository<BillingRecord, Long> {
}