package com.jaya.moneyapi.repository;

import com.jaya.moneyapi.model.ExchangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRecordRepository extends JpaRepository<ExchangeRecord, Long> {

    List<ExchangeRecord> findByUserdID(Long userID);
}
