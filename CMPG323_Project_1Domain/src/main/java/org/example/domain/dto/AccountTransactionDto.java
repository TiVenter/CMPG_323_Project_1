package org.example.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.domain.persistance.AccountTransaction;
import org.example.domain.persistance.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "AccountTransaction",
        description = "A DTO that represents the AccountTransaction"
)
public class AccountTransactionDto implements Serializable {

    private AccountType accountType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;


    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long memberId, Long amount, LocalDate transactionDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setMemberId(accountTransaction.getMemberId());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
    }

//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }

    @ApiModelProperty(position = 1, // give a position so this will show up first in my model
            value = "Account Traction MemberId",
            name = "memberId",
            notes = "Uniquely identifies the member id",
            dataType = "java.lang.String",
            example = "6", // default value
            required = true)

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 2,
            value = "Account Transaction Amount",
            name = "Amount",
            notes = "The Amount",
            dataType = "java.lang.String",
            example = "100",
            required = true)

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the AccountTransaction took place",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, memberId, amount, transactionDate);
    }

    //This is for you Json objects(Models)
    //If we have a get in here that isnt part of the model we add it here
    //One of our current 3 fields

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getMemberId(),getAmount(),getTransactionDate());
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountType=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
