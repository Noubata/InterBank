package benyandadamson.interbank.utils;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.User;
import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;
import benyandadamson.interbank.dtos.responses.DepositResponse;
import benyandadamson.interbank.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class BankMapper {
    @Autowired
    static BankService bankService ;

    public static CreateAccountResponse toResponseCreateAccount(User user) {
        String account = bankService.generateAccountNumber();
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setAccountName(user.getUsername());
        createAccountResponse.setAccountType(AccountType.SAVING);
        createAccountResponse.setAccountStatus(AccountStatus.ACTIVE);
        createAccountResponse.setAccountNumber(account);
        return createAccountResponse;
    }
}