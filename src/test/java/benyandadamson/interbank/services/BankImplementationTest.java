package benyandadamson.interbank.services;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.UserType;
import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BankImplementationTest {
    @Autowired
    BankImplementation bankImplementation;

    @Test
    void testCreateAccount(){
        CreateAccountRequest createAccount = new CreateAccountRequest();
        createAccount.setFirstName("John");
        createAccount.setLastName("Doe");
        createAccount.setAccountStatus(AccountStatus.ACTIVE);
        createAccount.setAccountType(AccountType.SAVING);
        createAccount.setCity("Lagos");
        createAccount.setEmail("john@gmail.com");
        createAccount.setAddress("yaba");
        createAccount.setPhoneNumber("1234567890");
        createAccount.setPassword("123456");
        createAccount.setNextOfKinName("beny");
        createAccount.setNextOfKinNumber("1234567899");
        createAccount.setState("Lagos");
        createAccount.setUserType(UserType.INDIVIDUAL);

        CreateAccountResponse account = bankImplementation.createAccount(createAccount);
    }

}