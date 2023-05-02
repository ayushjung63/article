package com.ayush.article.approvalflow.service.impl;

import com.ayush.article.approvalflow.entity.FiscalYear;
import com.ayush.article.approvalflow.enums.ApprovalStatus;
import com.ayush.article.approvalflow.repo.FiscalYearRepo;
import com.ayush.article.approvalflow.service.FiscalYearService;
import com.ayush.article.approvalflow.state.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FiscalYearServiceImpl implements FiscalYearService {
    private final FiscalYearRepo fiscalYearRepo;

//    private ApprovalFlowState state=new SubmitState();

    @Override
    public Long create(FiscalYear fiscalYear) {
        fiscalYear.setStatus(ApprovalStatus.NEW);
        FiscalYear data = fiscalYearRepo.save(fiscalYear);
        return data.getId();
    }

    @Override
    public void forward(Long fiscalYearId) {
        FiscalYear fiscalYear = fiscalYearRepo.findById(fiscalYearId).orElseThrow(
                () -> new RuntimeException("Fiscal Year does not exists.")
        );
       nextState(fiscalYear);
        fiscalYearRepo.save(fiscalYear);
    }

    @Override
    public void reject(Long fiscalYearId) {
        FiscalYear fiscalYear = fiscalYearRepo.findById(fiscalYearId).orElseThrow(
                () -> new RuntimeException("Fiscal Year does not exists.")
        );
        previousState(fiscalYear);
        fiscalYearRepo.save(fiscalYear);
    }

    public void previousState(FiscalYear fiscalYear) {
        ApprovalFlowState state = this.getCurrentState(fiscalYear);
        state.prev(fiscalYear);
    }

    public void nextState(FiscalYear fiscalYear) {
        ApprovalFlowState state = this.getCurrentState(fiscalYear);
        state.next(fiscalYear);
    }


    private ApprovalFlowState getCurrentState(FiscalYear fiscalYear) {
        ApprovalStatus status = fiscalYear.getStatus();
        if (status!=null) {
            switch (status) {
                case NEW:
                    return new NewState();
                case SUBMIT:
                    return new SubmitState();
                case VERIFY:
                    return new VerifyState();
                case APPROVE:
                    return new ApproveState();
                default:
                    throw new RuntimeException("Invalid Status");
            }
        }
        return new NewState();
    }
}
