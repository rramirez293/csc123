
public class SavingAccount extends Account {
	
	public SavingAccount(AccountHolder accountHolder) {
		super("Savings", accountHolder);
	}
	
	public boolean withdraw(double amount) {
		if(getBalance() >= amount) {
			return super.withdraw(amount);
		}
		else {
			System.out.println("Insufficent funds for transaction");
			return false;
		}
	}

}
