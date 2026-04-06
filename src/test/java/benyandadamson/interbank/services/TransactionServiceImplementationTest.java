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

        CreateAccountRequest newAccountCreation2 = new CreateAccountRequest();
        newAccountCreation2.setEmail("paul@gmail.com");
        newAccountCreation2.setAccountType(AccountType.SAVING);
        newAccountCreation2.setAccountStatus(AccountStatus.ACTIVE);
        newAccountCreation2.setCity("City");
        newAccountCreation2.setAddress("address two");
        newAccountCreation2.setFirstName("paul");
        newAccountCreation2.setLastName("paul");
        newAccountCreation2.setPassword("password123");
        newAccountCreation2.setPhoneNumber("08044332211");
        newAccountCreation2.setNextOfKinName("NextOFKinOne");
        newAccountCreation2.setNextOfKinNumber("09044332211");
        newAccountCreation2.setState("state");
        newAccountCreation2.setUserType(UserType.INDIVIDUAL);

        bankService.createAccount(newAccountCreation2);
    }

    @Test
    void createAccountRequestTest(){
        assertNotNull(accountRepository);
        System.out.println(accountRepository.findAll());
    }

}