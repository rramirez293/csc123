
public class CheckingAccount extends Account{
	
	private double overDraft;
	
	public CheckingAccount(AccountHolder accountHolder, double overDraft) {
		super("Checking", accountHolder);
		this.overDraft = overDraft;
	}
	
	public boolean withdraw(double amount) {
		if(isOpen && getBalance() - amount >= overDraft) {
			return super.withdraw(amount);
		}
		else {
			System.out.println("Withdraw failed, exeeding overdraft limit.");
			return false;
		}
	}
}
