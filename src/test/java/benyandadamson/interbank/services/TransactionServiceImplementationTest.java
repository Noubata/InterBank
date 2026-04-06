package benyandadamson.interbank.services;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.UserType;
import benyandadamson.interbank.data.repositories.AccountRepository;
import benyandadamson.interbank.data.repositories.TransactionRepository;
import benyandadamson.interbank.data.repositories.UserRepository;
import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplementationTest {
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private BankImplementation bankService;

    @InjectMocks
    private TransactionServiceImplementation transactionService;

    @BeforeEach
    void setUp(){
        CreateAccountRequest newAccountCreation1 = new CreateAccountRequest();
        newAccountCreation1.setEmail("samuel@gmail.com");
        newAccountCreation1.setAccountType(AccountType.SAVING);
        newAccountCreation1.setAccountStatus(AccountStatus.ACTIVE);
        newAccountCreation1.setCity("City");
        newAccountCreation1.setAddress("address one");
        newAccountCreation1.setFirstName("Samuel");
        newAccountCreation1.setLastName("Samuel");
        newAccountCreation1.setPassword("password123");
        newAccountCreation1.setPhoneNumber("08011223344");
        newAccountCreation1.setNextOfKinName("NextOFKinOne");
        newAccountCreation1.setNextOfKinNumber("09011223344");
        newAccountCreation1.setState("state");
        newAccountCreation1.setUserType(UserType.INDIVIDUAL);

        bankService.createAccount(newAccountCreation1);
    }

    @Test
    void createAccountRequestTest(){
        assertNotNull(accountRepository);
    }

}