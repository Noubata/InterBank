package benyandadamson.interbank.services;

import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;
import benyandadamson.interbank.dtos.responses.DepositResponse;

public interface BankService {
    CreateAccountResponse createAccount(CreateAccountRequest createAccount);
    String generateAccountNumber();

}
