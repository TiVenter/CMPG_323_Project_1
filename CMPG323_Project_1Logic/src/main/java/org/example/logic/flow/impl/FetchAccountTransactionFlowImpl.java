package org.example.logic.flow.impl;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.logic.flow.FetchAccountTransactionFlow;
import org.example.logic.flow.FetchAccountTypeFlow;
import org.example.translator.AccountTransactionTranslator;
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

public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    // Here we will pull in our translator {AccountTypeTranslator}
    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    // Next we will autowire our translator
    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator){
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    // the nwe go and create return accountTypeTranslator.getAllAccountTypes();
    public List<AccountTransactionDto> getAllAccountTransaction(){
        return accountTransactionTranslator.getAllAccountTransaction();
    }
    @Override
    public AccountTransactionDto getAccountTransactionByMemberId(Long memberId){
        //fetches our query from accountrepository.java there are 3 different types
        return accountTransactionTranslator.getAccountTransactionByMemberId(memberId);
    }

@Override
public List<AccountTransactionDto> getAllAccountTransactions() {
    return null;
}

public boolean methodToTest(){
        return true;
    }

}
