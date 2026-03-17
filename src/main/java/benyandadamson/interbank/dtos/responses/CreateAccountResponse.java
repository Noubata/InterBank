package benyandadamson.interbank.dtos.responses;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.UserType;


public class CreateAccountResponse {
    private AccountType accountType;
    private String AccountNumber;
    private String AccountName;
    private AccountStatus accountStatus;

}
