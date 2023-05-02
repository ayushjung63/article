package com.ayush.article.approvalflow.state;

import com.ayush.article.approvalflow.entity.FiscalYear;

public interface ApprovalFlowState {
    void next(FiscalYear fiscalYear);
    void prev(FiscalYear fiscalYear);
}
