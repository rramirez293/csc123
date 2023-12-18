
public class Transactions {
	
	private String type;
	private double amount;
	
	public Transactions(double amount) {
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public String getDescription() {
		return null;
	}

}
