import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
	
	private List<Transactions> transactions;
	protected boolean isOpen;
	private AccountHolder accountHolder;
	private String accountType;
	private double balance;
	private int accountNumber;
	private static int accountNumberAdd = 1000;
	
	public Account(String accountType, AccountHolder accountHolder) {
		this.transactions = new ArrayList<>();
		this.isOpen = true;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.balance = 0;
		this.accountNumber = accountNumberAdd++;
		
		
	}

	public boolean withdraw(double amount) {
		
		if (isOpen && balance >= amount) {
			balance -= amount;
	        transactions.add(new Transactions(-amount));
	        System.out.println("Withdrawn $" + amount + " from " + accountType + " account.");
	        return true;
	        } 
		else {
	        System.out.println("Insufficient funds in " + accountType + " account.");
	        return false;
	        }
	}
	
	public void deposit(double amount) {
        if (isOpen) {
		balance += amount;
        transactions.add(new Transactions(amount));
        System.out.println("Deposited $" + amount + " into " + accountType + " account.");
        }
        else {
        	
        }
    }
	
	public double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	public void close() {
		isOpen = false;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public List<Transactions> getAccountStatement(){
		return transactions;
	}
	
	public int hashCode() {
        return Objects.hash(accountNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account otherAccount = (Account) obj;
        return accountNumber == otherAccount.accountNumber;
    }
    
     public String getName() {
        return accountHolder.getName();
    }

    public String getSsn() {
        return accountHolder.getSsn();
    }
    public int getAgeInYears() {
    	return accountHolder.getAgeInYears();
    }
	

}
