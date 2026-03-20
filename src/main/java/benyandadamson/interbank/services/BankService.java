package benyandadamson.interbank.services;

import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;
import benyandadamson.interbank.dtos.responses.DepositResponse;

public interface BankService {
    DepositResponse deposit(DepositRequest depositRequest);

    CreateAccountResponse createAccount(CreateAccountRequest createAccount);
}
