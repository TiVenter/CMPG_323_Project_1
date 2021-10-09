package org.example.translator.impl;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistance.AccountType;
import org.example.repo.persistence.AccountTypeRepository;
import org.example.translator.AccountTypeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }
    //THrow exceptions according to what went wrong
    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for (AccountType accountType : accountTypeRepository.findAll()) {
            accountTypeDtos.add(new AccountTypeDto(accountType));
            }
            } catch (Exception e) {
            //logg our exceptions to check out and investigate
        throw new RuntimeException("Unable to read from DB", e);
        }
        return accountTypeDtos;
        }

    @Override
    public  AccountTypeDto create(AccountTypeDto accountTypeDto){
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch ( Exception e){
            throw new RuntimeException("Uanble to save to the DB", e);
        }
    }

    @Override
    public  AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch ( Exception e){
            throw new RuntimeException("Uanble to save to the DB", e);
        }
    }

    @Override
    public  AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic){
        try {
            //return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
            return null;
        }catch ( Exception e){
            throw new RuntimeException("Uanble to save to the DB", e);
        }
    }

}
