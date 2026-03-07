package benyandadamson.interbank.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private Long bankId;
    private String bankName;
    private String bankCode;
    private List<Account> accounts;
}
