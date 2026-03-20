package benyandadamson.interbank.services;

import benyandadamson.interbank.data.models.User;
import benyandadamson.interbank.data.repositories.UserRepository;
import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.requests.DepositRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;
import benyandadamson.interbank.dtos.responses.DepositResponse;
import benyandadamson.interbank.exceptions.AccountAlreadyExists;
import benyandadamson.interbank.utils.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankImplementation implements BankService {
    @Autowired
    UserRepository userRepository;
    public DepositResponse deposit(DepositRequest depositRequest) {

    }

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccount) {
        Optional<User> potentialUser = userRepository.findByEmail(createAccount.getEmail());
        if (potentialUser.isPresent()) {
            throw new AccountAlreadyExists("Account already exists!");
        }
        User user = new User();
        user.setEmail(createAccount.getEmail());
        user.setUserType(createAccount.getUserType());
        user.setPhoneNumber(createAccount.getPhoneNumber());
        user.setUsername(createAccount.getFirstName() + " " + createAccount.getLastName());
        user.setHashedPassword(createAccount.getPassword());
        User toSave = userRepository.save(user);
        return BankMapper.toResponseCreateAccount(toSave);
    }
}
