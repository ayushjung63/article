package com.ayush.article.approvalflow.state;

import com.ayush.article.approvalflow.entity.FiscalYear;
import com.ayush.article.approvalflow.enums.ApprovalStatus;

public class ApproveState implements ApprovalFlowState{
    @Override
    public void next(FiscalYear fiscalYear) {
        throw new RuntimeException("Fiscal Year already approved");
    }

    @Override
    public void prev(FiscalYear fiscalYear) {
        fiscalYear.setStatus(ApprovalStatus.SUBMIT);
//        fiscalYear.setState(new SubmitState());
    }
}
