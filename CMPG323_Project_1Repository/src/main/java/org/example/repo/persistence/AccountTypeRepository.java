package org.example.repo.persistence;

//import oracle.security.crypto.util.VectorOverArrayList;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistance.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//The long refers to the datatype of our primary key
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

//        @Query(value = "SELECT new org.example.domain.dto.AccountTypeDto(" +
//                "           at.mnemonic," +
//                "           at.accountTypeName," +
//                "           at.CreationDate)" +
//                "    FROM" +
//                "           AccountType at" +
//                "           WHERE at.mnemonic = :mnemonic" )
//        AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


        @Query(value = "SELECT" +
                " at" +
                " FROM" +
                " AccountType at " +
                " WHERE at.mnemonic = :mnemonic ")
        AccountType getAccountTypeByMnemonic(String mnemonic);
}