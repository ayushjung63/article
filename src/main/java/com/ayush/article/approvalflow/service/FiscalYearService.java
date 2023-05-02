package com.ayush.article.approvalflow.service;

import com.ayush.article.approvalflow.entity.FiscalYear;

public interface FiscalYearService {
    Long create(FiscalYear fiscalYear);
    void forward(Long fiscalYearId);
    void reject(Long fiscalYearId);
}
