package com.ayush.article.approvalflow.state;

import com.ayush.article.approvalflow.entity.FiscalYear;
import com.ayush.article.approvalflow.enums.ApprovalStatus;
import org.springframework.stereotype.Component;

@Component
public class SubmitState implements ApprovalFlowState{
    @Override
    public void next(FiscalYear fiscalYear) {
        fiscalYear.setStatus(ApprovalStatus.APPROVE);
//        fiscalYear.setState(new ApproveState());
    }

    @Override
    public void prev(FiscalYear fiscalYear) {
        fiscalYear.setStatus(ApprovalStatus.NEW);
//     fiscalYear.setState(new NewState());
    }
}
