package org.example.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

// WE WILL BE CONFIGURING OUR DATABASE
@Entity // tag as entity so java can know it is database table
//DEMO_ACCOUNT_TYPE is the actual name of your database

@Table(name = "ACCOUNT_TYPE", schema = "HR")
public class AccountType implements Serializable {

    @Id // tells it that this a primary key
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "HR.ACCOUNT_TYPE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")

    private Long accountTypeId; // Doesnt have to be name of colums just something to represent it by
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;



    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountType() {
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }


    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {return accountTypeId;}
    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MNEMONIC") // actual names of my columns
    public String getMnemonic() { return mnemonic;}
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name ="ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }
    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;}

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType",orphanRemoval = true,cascade = CascadeType.PERSIST)
    private Set<AccountTransaction> accountTransactions;
    //public Set<AccountTransaction> getAccountTransactions(){
        //return accountTransactions;
    //}



    //public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
    //    this.accountTransactions = accountTransactions;
    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
