package com.ayush.article.reverse;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "fiscal_year", schema = "public", catalog = "test_db")
public class FiscalYear {
    private long id;
    private String name;
    private String status;
    private Collection<FiscalYearApprovalDetail> fiscalYearApprovalDetailsById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiscalYear that = (FiscalYear) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }

    @OneToMany(mappedBy = "fiscalYearByFiscalYearId")
    public Collection<FiscalYearApprovalDetail> getFiscalYearApprovalDetailsById() {
        return fiscalYearApprovalDetailsById;
    }

    public void setFiscalYearApprovalDetailsById(Collection<FiscalYearApprovalDetail> fiscalYearApprovalDetailsById) {
        this.fiscalYearApprovalDetailsById = fiscalYearApprovalDetailsById;
    }
}
