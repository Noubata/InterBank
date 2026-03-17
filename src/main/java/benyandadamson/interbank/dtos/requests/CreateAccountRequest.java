package benyandadamson.interbank.dtos.requests;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.UserType;

public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private String city;
    private String state;
    private String nextOfKinName;
    private String nextOfKinNumber;
    private AccountType accountType;
    private UserType userType;
    private AccountStatus accountStatus;
    private String address3;

}
