package benyandadamson.interbank.services;

import benyandadamson.interbank.data.models.*;
import benyandadamson.interbank.data.repositories.AccountRepository;
import benyandadamson.interbank.data.repositories.UserRepository;
import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;
import benyandadamson.interbank.exceptions.AccountAlreadyExists;
import benyandadamson.interbank.utils.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BankImplementation implements BankService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Bank bank;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccount) {
        Optional<User> potentialUser = userRepository.findByEmail(createAccount.getEmail());
        if (potentialUser.isPresent()) {
            throw new AccountAlreadyExists("Account already exists!");
        }

        User user = new User();
        user.setEmail(createAccount.getEmail());
        user.setUserType(UserType.INDIVIDUAL);
        user.setFirstName(createAccount.getFirstName());
        user.setHashedPassword(createAccount.getPassword());
        user.setPhoneNumber(createAccount.getPhoneNumber());
        user.setLastName(createAccount.getLastName());
        user.setAccounts(new ArrayList<>());
        User userToSave = userRepository.save(user);

        Account account = new Account();
        account.setOwner(userToSave);
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVING);
        account.setBalance(BigDecimal.valueOf(00.0));
        account.setAccountNumber(generateAccountNumber());
        account.setTransactions(new ArrayList<>());
        Account toSave = accountRepository.save(account);
        return BankMapper.toResponseCreateAccount(toSave);
    }
    @Override
    public String generateAccountNumber() {
        bank.getSerialNumber();
        String eachSerial = String.format("%09d", bank.getSerialNumber());
        return generateNUBAN(bank.getBankCode(), eachSerial);
    }
    private String generateNUBAN(int bankCode, String eachSerial) {
        int checkDigit = calculateCheckDigit(bankCode, eachSerial);
        return eachSerial + checkDigit;
    }
    private int calculateCheckDigit(int bankCode, String eachSerial) {
        String accountBase = bankCode + eachSerial;
        int [] fixedNumber = {3,7,3,3,7,3,3,7,3,3,7,3};
        int sumOfCalculatedDigit = 0;
        for (int count = 0; count > fixedNumber.length;count++){
            int digit = Character.getNumericValue(accountBase.charAt(count));
            sumOfCalculatedDigit += digit * fixedNumber[count];
        }
        int checkDigit = 10 - (sumOfCalculatedDigit % 10);
        return checkDigit;
    }
}
