package org.example.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.dto.AccountTypeDto;
//import org.example.domain.persistance.AccountTypeDto;
import org.example.logic.flow.CreateAccountTypeFlow;
import org.example.logic.flow.FetchAccountTypeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.domain.Service.GeneralResponse;
import java.util.List;


@RestController
//The webconfig will pickup this controller
@RequestMapping("account-type")
public class AccountTypeController {
// we tell it to refer to the interface and not the implementation class
//Pull fetchAccountTypeFlow into our Controller
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
// wE WILL BE INJECTING private final FetchAccountTypeFlow fetchAccountTypeFlow;(springbean) into AccountTypeController(spring-bean)
    //that is what aoutwire is for

   @Autowired//This is also for dependacy injections
   public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                @Qualifier("createAccountTypeFlowName")CreateAccountTypeFlow createAccountTypeFlow){
       this.fetchAccountTypeFlow = fetchAccountTypeFlow;
       this.createAccountTypeFlow = createAccountTypeFlow;
   }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the cofigured Account types.", notes = "Returns a list of account tpes")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
    @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
    @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        // We pull our FetchAccountTypeFlowImpl into our controller
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>( true,  accountTypes);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("Create new account")
    // we have no path but when we post we will give it its account type
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
        @ApiParam(value = "Request body to create new AccountType.",required = true)
                @RequestBody AccountTypeDto accountType){
       AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
       GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountTypeResponse );
       return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @GetMapping("{mnemonic}")
    // we have no path but when we post we will give it its account type
    @ApiOperation(value = "Fetches the specified accountType", notes = "Fetches the AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found"),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                      example = "MILES",
                      name = "mnemonic",
                      required = true)
            @PathVariable("mnemonic") final String mnemonic){
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
