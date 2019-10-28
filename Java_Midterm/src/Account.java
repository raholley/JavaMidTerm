//Account class implements the Interfaces
public class Account implements Balancable, Withdrawalable, Depositable{
	//Instance Variable
	private double balance = 0;

	   @Override
	   public void deposit(double amount) {
	      	       balance += amount;
	   }

	   @Override
	   public void withdraw(double amount) {
	            balance -= amount;
	   }

	   @Override
	   public double getBalance() {
	            return balance;
	   }

	   @Override
	   public void setBalance(double amount) {
	           balance = amount;
	   }
}