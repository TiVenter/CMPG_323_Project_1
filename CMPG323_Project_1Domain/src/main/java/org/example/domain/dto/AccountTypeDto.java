package org.example.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.domain.persistance.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType",
                description = "A DTO that represents the AccountType"
)
public class AccountTypeDto implements Serializable {

    private String mnemonic;
    private String accountTypeName;// HIERSO
    private LocalDate creationDate;



    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName; //HIERSO
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType){
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
        this.setMnemonic(accountType.getMnemonic());
    }

    @ApiModelProperty(position = 1, // give a position so this will show up first in my model
    value = "AccountType Mnemonic",
    name = "Mnemonic",
    notes = "Uniquely identifies the account type",
    dataType = "java.lang.String",
    example = "MILES", // default value
    required = true)

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }




    @ApiModelProperty(position = 2,
            value = "AccountType NAME",
            name = "Name",
            notes = "The name of the AccountType",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }//hierso

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }//hierso

    @ApiModelProperty(position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the AccountType was created",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    //public LocalDate getCreationDate() {return creationDate;}

    //public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;                           //hierso
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate);
    }




    //This is for you Json objects(Models)
    //If we have a get in here that isnt part of the moddel we add it here
    //One of our current 3 fields

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(),getAccountTypeName(),getCreationDate());
    }

}
