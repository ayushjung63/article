package com.ayush.article.approvalflow.state;

import com.ayush.article.approvalflow.entity.FiscalYear;
import com.ayush.article.approvalflow.enums.ApprovalStatus;
import org.springframework.stereotype.Component;

@Component
public class NewState implements ApprovalFlowState{
    @Override
    public void next(FiscalYear fiscalYear) {
        fiscalYear.setStatus(ApprovalStatus.SUBMIT);
//        fiscalYear.setState(new SubmitState());
    }

    @Override
    public void prev(FiscalYear fiscalYear) {
        throw new RuntimeException("Status is NEW");
    }
}
