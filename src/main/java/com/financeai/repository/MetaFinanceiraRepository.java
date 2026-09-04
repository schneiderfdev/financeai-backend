package com.financeai.repository;

import com.financeai.model.MetaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaFinanceiraRepository extends JpaRepository<MetaFinanceira, Long> {
}