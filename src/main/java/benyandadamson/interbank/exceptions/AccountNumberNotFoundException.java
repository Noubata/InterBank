package benyandadamson.interbank.exceptions;

public class AccountNumberNotFoundException extends RuntimeException {
    public AccountNumberNotFoundException(String message) {
        super(message);
    }
}
