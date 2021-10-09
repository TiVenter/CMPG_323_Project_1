package org.example.logic.flow.impl;

import org.example.domain.dto.AccountTransactionDto;
import org.example.logic.flow.CreateAccountTransactionFlow;
import org.example.translator.AccountTransactionTranslator;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component

// We can inject this component via its name ("createAccountTypeFlowName") this will then be used by our
//createAccountTypeFlow.java file and inject it with the name
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public CreateAccountTransactionFlowImpl (AccountTransactionTranslator accountTransactionTranslator)
    {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        if (null == accountTransactionDto.getTransactionDate()){
            accountTransactionDto.setTransactionDate(LocalDate.now());
        }
        return accountTransactionTranslator.create(accountTransactionDto);
    }
}


