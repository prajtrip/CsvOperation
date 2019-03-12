package com.csv;

public class Account {
private String accountNumber;
private Double transactionValue;
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public Double getTransactionValue() {
	return transactionValue;
}
public void setTransactionValue(Double transactionValue) {
	this.transactionValue = transactionValue;
}
@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", transactionValue=" + transactionValue + "]";
}

}
