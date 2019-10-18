package edu.mum.cs.cs425.midten.midwestten.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "account_type")
public class AccountType {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountTypeId;

    @Column(name = "account_type_name")
    @NotBlank(message = "Account name should be entered")
    private String accountTypeName;


    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}
