
public class Checking extends Account {
	
	//Create Instance Variables for Checking
	private double monthlyBankFee;
	
	//Checking constructor
	public Checking(double fee) {
		monthlyBankFee =fee;
	}

	 public double getMonthlyBankFee() {
	       return monthlyBankFee;
	 }
	 
	 public void subtractMonthlyBankFee () {
	     setBalance(getBalance() - monthlyBankFee);
 }
}