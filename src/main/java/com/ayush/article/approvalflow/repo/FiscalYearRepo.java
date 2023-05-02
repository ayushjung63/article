package com.ayush.article.approvalflow.repo;

import com.ayush.article.approvalflow.entity.FiscalYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiscalYearRepo  extends JpaRepository<FiscalYear,Long> {
}
