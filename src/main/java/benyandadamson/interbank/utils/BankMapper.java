package benyandadamson.interbank.utils;

import benyandadamson.interbank.data.models.AccountStatus;
import benyandadamson.interbank.data.models.AccountType;
import benyandadamson.interbank.data.models.User;
import benyandadamson.interbank.dtos.requests.CreateAccountRequest;
import benyandadamson.interbank.dtos.responses.CreateAccountResponse;

import java.util.UUID;

public class BankMapper {
    public static CreateAccountResponse toResponseCreateAccount(CreateAccountRequest request) {
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setAccountName(request.getLastName());
        createAccountResponse.setAccountType(AccountType.SAVING);
        createAccountResponse.setAccountStatus(AccountStatus.ACTIVE);
        createAccountResponse.setAccountNumber();

    }
    public String generateAccountNumber() {
        serialNumber++;
        String eachSerial = String.format("%09d", serialNumber);
        return generateNUBAN(bankCode, eachSerial);
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
