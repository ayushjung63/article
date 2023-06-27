package com.ayush.article.reverse;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fiscal_year_approval_detail", schema = "public", catalog = "test_db")
public class FiscalYearApprovalDetail {
    private long id;
    private Integer state;
    private Long fiscalYearId;
    private FiscalYear fiscalYearByFiscalYearId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "fiscal_year_id")
    public Long getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(Long fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiscalYearApprovalDetail that = (FiscalYearApprovalDetail) o;
        return id == that.id &&
                Objects.equals(state, that.state) &&
                Objects.equals(fiscalYearId, that.fiscalYearId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, fiscalYearId);
    }

    @ManyToOne
    @JoinColumn(name = "fiscal_year_id", referencedColumnName = "id")
    public FiscalYear getFiscalYearByFiscalYearId() {
        return fiscalYearByFiscalYearId;
    }

    public void setFiscalYearByFiscalYearId(FiscalYear fiscalYearByFiscalYearId) {
        this.fiscalYearByFiscalYearId = fiscalYearByFiscalYearId;
    }
}
