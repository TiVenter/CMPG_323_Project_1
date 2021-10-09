package org.example.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.Service.GeneralResponse;
import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.logic.flow.CreateAccountTransactionFlow;
import org.example.logic.flow.FetchAccountTransactionFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//The webconfig will pickup this controller
@RequestMapping("account-transaction")

public class AccountTransactionController {
    // we tell it to refer to the interface and not the implementation class
    //Pull fetchAccountTypeFlow into our Controller
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    // wE WILL BE INJECTING private final FetchAccountTypeFlow fetchAccountTypeFlow;(springbean) into AccountTypeController(spring-bean)
    //that is what aoutwire is for

    @Autowired//This is also for dependacy injections
    public AccountTransactionController(FetchAccountTransactionFlow fetchAccountTransactionFlow, CreateAccountTransactionFlow createAccountTransactionFlow){
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.createAccountTransactionFlow = createAccountTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account transactions.", notes = "Returns a list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transactions returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> accountTransaction = fetchAccountTransactionFlow.getAllAccountTransactions();
        // We pull our FetchAccountTypeFlowImpl into our controller
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>( true,  accountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("Create new transactions")
    // we have no path but when we post we will give it its account type
    @ApiOperation(value = "Creates a new AccountTransaction", notes = "Creates a new AccountType in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create new AccountType.",required = true)
            @RequestBody AccountTransactionDto accountTransaction){
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true,accountTransactionResponse );
        return new ResponseEntity(response, HttpStatus.CREATED);

    }
    @GetMapping("{memberId}")
    // we have no path but when we post we will give it its account type
    @ApiOperation(value = "Fetches the specified accountTransaction", notes = "Fetches the accountTransaction corresponding to the given memberId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found"),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAllAccountTransactions(
            @ApiParam(value = "The memberId that uniquely identifies the AccountTransaction.",
                    example = "1",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId){
        AccountTransactionDto accountTransaction = fetchAccountTransactionFlow.getAccountTransactionByMemberId(memberId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse(true,accountTransaction );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
