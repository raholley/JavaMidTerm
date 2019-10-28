
public class Savings extends Account {
	
	//Create Instance Variables for Savings
	 double interestRate;
	 double interestEarned;
	
	// Create constructor for Savings 
	public Savings(double intrate) {
		 interestRate=intrate;
	}
	
	//Gets and sets
	public double getInterestRate()
	{
	return interestRate;
	}
	
	//Calculate the monthly interest amount earned
	public void setInterestEarned(double balance, double intrate)
	{
	interestEarned =balance * intrate;
	}
	public double getInterestEarned()
	{
	return interestEarned;
	}
	
	//Method to add the interest earned to the customer's balance/account
	 public void addInterestToBalance() {
	       setBalance(getBalance() + getInterestEarned());	   
		
	}

}
