package bank;

import java.io.Serializable;

public class BankAccounts implements Serializable {
	public static final long serialVersionUID = 7654321L;
	
	Double balance;
	int accountNumber;
	int PIN;
	String Accessor;
	
	public BankAccounts(Double balance, int accountNumber, int PIN, 
			String Accessor) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.PIN = PIN;
		this.Accessor = Accessor;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	public String getAccessor() {
		return Accessor;
	}

	public void setAccessor(String accessor) {
		Accessor = accessor;
	}

}
