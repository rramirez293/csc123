import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AccountHolder {
	private String name;
	private String ssn;
	private LocalDate dob;
	private String address;
	
	public AccountHolder(String name, String ssn, String dob, String address) {
		this.name = name;
		this.ssn = ssn;
		this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDOB() {
		return dob;
	}
	
	public void setDOB() {
		this.dob = dob;
	}

	public int getAgeInYears() {
		LocalDate currentAge = LocalDate.now();
		Period period = Period.between(dob, currentAge);
		return period.getYears();
	}
	
	public String getSsn() {
			return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
