package benyandadamson.interbank.data.models;

import java.util.List;

public class User {
    private Long userId;
    private String username;
    private String hashedPassword;
    private String phoneNumber;
    private String email;
    private UserType userType;
    private List<Account> accounts;
}
