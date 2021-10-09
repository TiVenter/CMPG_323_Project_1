package org.example.logic.flow.impl;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistance.AccountType;
import org.example.logic.flow.FetchAccountTypeFlow;
import org.example.translator.AccountTypeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

// the main purpose of this class is to manage all the account types in one class
// we will then pull this into controller to do the job
@Transactional
@Component
// this will go to all clases looking for components like in our LogigConfig file
//We know that this claas is now inside our spring context

    public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

// Here we will pull in our translator {AccountTypeTranslator}
     private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    // Next we will autowire our translator
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    // the nwe go and create return accountTypeTranslator.getAllAccountTypes();
    public List<AccountTypeDto> getAllAccountTypes(){
        return accountTypeTranslator.getAllAccountTypes();
    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        //fetches our query from accountrepository.java there are 3 different types
        //return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
        return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }

    public boolean methodToTest(){
        return true;
    }

}
