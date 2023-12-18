import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public  class Bank {
	
	private Map<Integer, Account> accounts;
	//private String currencies;
	//private boolean open = true;
	protected double balance;
	
	
	public Bank() {
		this.accounts = new HashMap<>();
		//this.balance = balance;
		//this.currencies = currencies;
		}
	
	public void deposit(double depAmount) {
		if (depAmount > 0) {
			balance += depAmount;
			System.out.println("Deposit Successful, new balance is: "+ balance);
		} 
		/*else if(account = closed) {
			System.out.println("Deposit Failed, the balance is: "+ balance);
		}*/
		else {
			System.out.println("Account not found");
		}
	}
	
	public void withdraw(double withAmount) {
		if(withAmount > 0 && withAmount <= balance) {
			balance -= withAmount;
			System.out.println("Withdraw Successful, new balance is: "+ balance);
			}
		else if(withAmount > balance) {
		  System.out.println("Withdraw Failed, balance is "+ balance);
		}
		else {
			System.out.println("Account not found.");
		}
	}
		
	public void listAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts found.");
	    } 
		else {
			System.out.println("List of all accounts:");
	        for (Account account : accounts.values()) {
	        System.out.println("Account Number: " + account.getAccountNumber() +
	        ", Account Type: " + account.getAccountType() +
	        ", Account Holder Name: " + account.getName() +
	        ", Social Security Number: " + account.getSsn() +
	        ", Balance: $" + account.getBalance() + 
	        ", Account Status: " + (account.isOpen() ? "Open" : "Closed"));
	            }
	        }
	}
	
	public void closeAccount(int accountNumber) {
		if (accounts.containsKey(accountNumber)) {
            Account closedAccount = accounts.remove(accountNumber);
            closedAccount.close();
            System.out.println("Account closed successfully. Account Number: " + closedAccount.getAccountNumber());
        } else {
            System.out.println("Account not found.");
        }
	}
	public void openAccount(Account account) {
		if (!accounts.containsKey(account.getAccountNumber())) {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Account opened successfully. Account Number: " + account.getAccountNumber());
            /*if(account.getAgeInYears() < 18 && account.getAccountType() == "Checking") {
            	System.out.println("Sorry too young");
            }
            else {
            	System.out.println("Account opened successfully. Account Number: " + account.getAccountNumber());
            }
            if(account.getAgeInYears() < 5 && account.getAccountType() == "Saving") {
            	System.out.println("Sorry you do not meet the age requirement for a savings account");
            }
            else {
            	System.out.println("Account opened successfully. Account Number: " + account.getAccountNumber());
            }*/
        } 
		else {
            System.out.println("Account with this number already exists. Please choose a different account number.");
        }
	}
	
	public Set<Integer> getAccountNumbers() {
        return accounts.keySet();
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
	
    
}
