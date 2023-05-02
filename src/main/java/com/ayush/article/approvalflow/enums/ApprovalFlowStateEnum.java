package com.ayush.article.approvalflow.enums;

public enum ApprovalFlowStateEnum {
    NEW(0,"NewState");
    private int key;
    private String value;
    ApprovalFlowStateEnum(int key, String value){
        this.key=key;
        this.value=value;
    }
}
