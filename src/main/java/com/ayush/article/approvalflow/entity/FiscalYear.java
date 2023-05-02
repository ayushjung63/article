package com.ayush.article.approvalflow.entity;

import com.ayush.article.approvalflow.enums.ApprovalStatus;
import com.ayush.article.approvalflow.state.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fiscal_year")
public class FiscalYear {
    @Id
    @SequenceGenerator(name = "fiscal_year_seq",sequenceName = "fiscal_year_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fiscal_year_seq")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;
}
