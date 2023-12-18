import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class UIManager {
	private static Scanner menuInput = new Scanner(System.in);
	private static final String menuOptions= "1. Open Checking Account\n2. Open Saving Account\n3. List Account\n4. Account Statement\n5. Deposit\n6. Withdraw\n7. Close Account\n8. Exit";
   
	//Map<String, Account> act = new HashMap<>();
	
	public static void showMenu() {
		System.out.println(menuOptions);
	}
	
	public static void readUserInput() {
	int userChoice;
	Bank bank = new Bank();
	
	
	do{
		showMenu();
		userChoice = menuInput.nextInt();
		
		switch(userChoice) {
		case 1:
			Scanner menuInput = new Scanner(System.in);
			System.out.println("Enter full name: ");
            String name = menuInput.nextLine();
            System.out.println("Enter Social Security Number: ");
            String ssn = menuInput.nextLine();
            System.out.println("Enter date of birth: ");
            String dob = menuInput.nextLine();
            System.out.println("Enter your address");
            String address = menuInput.nextLine();
            System.out.println("Enter overdraft limit: ");
            double overDraft = menuInput.nextDouble();
            AccountHolder accountHolder = new AccountHolder(name, ssn,dob,address);
            CheckingAccount chkAccount = new CheckingAccount(accountHolder, overDraft);
            bank.openAccount(chkAccount);
            break;

		case 2:
			Scanner menuInput1 = new Scanner(System.in);
			System.out.println("Enter full name: ");
            String name1 = menuInput1.nextLine();
            System.out.println("Enter Social Security Number: ");
            String ssn1 = menuInput1.nextLine();
            System.out.println("Enter date of birth: ");
            String dob1 = menuInput1.nextLine();
            System.out.println("Enter your address");
            String address1 = menuInput1.nextLine();
            AccountHolder accountHolder1 = new AccountHolder(name1,ssn1,dob1,address1);
            SavingAccount saveAccount = new SavingAccount(accountHolder1);
            bank.openAccount(saveAccount);
            break;
		
		case 3:
			bank.listAccounts();
			break;
		
		case 4:
			Scanner menuInput2 = new Scanner(System.in);
			
			System.out.println("Enter the account number to view the statement:");
	        int accountNumber = menuInput2.nextInt();

	        Account account = bank.getAccount(accountNumber);
	        if (account != null) {
	            List<Transactions> statement = account.getAccountStatement();
	            System.out.println("Account Statement for Account Number " + accountNumber + ":");
	            for (Transactions transaction : statement) {
	                System.out.println(transaction.getDescription() + ": $" + transaction.getAmount());
	            }
	        } 
	        else {
	            System.out.println("Account not found.");
	        }
			break;
			
		case 5:
			Scanner menuInput3 = new Scanner(System.in);
			System.out.println("Enter the account number to deposit into:");
	        int depositAccountNumber = menuInput3.nextInt();

	        Account depositAccount = bank.getAccount(depositAccountNumber);
	        if (depositAccount != null) {
	            System.out.println("Enter the deposit amount:");
	            double depositAmount = menuInput3.nextDouble();
	            depositAccount.deposit(depositAmount);
	        } 
	        else {
	            System.out.println("Account not found.");
	        }
			break;
			
		case 6:
			Scanner menuInput4 = new Scanner(System.in);
			System.out.println("Enter the account number to withdraw from:");
	        int withdrawAccountNumber = menuInput4.nextInt();

	        Account withdrawAccount = bank.getAccount(withdrawAccountNumber);
	        if (withdrawAccount != null) {
	            System.out.println("Enter the withdrawal amount:");
	            double withdrawAmount = menuInput4.nextDouble();
	            withdrawAccount.withdraw(withdrawAmount);
	        } 
	        else {
	            System.out.println("Account not found.");
	        }
			break;
			
		case 7:
			Scanner menuInput5 = new Scanner(System.in);
			System.out.println("Enter account number you wish to close: ");
			int cAccount = menuInput5.nextInt();
			bank.closeAccount(cAccount);
			break;
			
		case 8:
			System.out.println("Goodbye!");
			break;
			
		default:
			System.out.println("Invalid choice, try again.");
		}
	
	

	}while(userChoice != 8);
}
}


