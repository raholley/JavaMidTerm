import java.text.NumberFormat;
import java.util.Scanner;

public class RegionalBankApp {

    //main method stater for the program
	public static void main(String[] args) {
	
	//Pull in my classes and set constant values
	//Requirements state that Banking fee is $1/month and interest earned is 1%/month
		
		Checking c = new Checking(1.00);
        Savings s = new Savings(0.01);
    
    //Requirements state the starting deposits are $1000 for both the accounts for each run
        c.setBalance(1000.00);
        s.setBalance(1000.00);
         
    //display a welcome message
        System.out.println("Welcome to the Account Application");
        System.out.println();
        
        System.out.println("Starting Balances:");
        System.out.println();
        
        //call the method to print the starting balances to the console
        printBalances(c, s);
        
        
        System.out.println("Enter the transactions for the month");
        System.out.println();
        
        
        // create the Scanner object
        Scanner sc = new Scanner(System.in);
        
        // continue until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        
        // get input from user and Validate
        String actionType = Validator.getString(sc, "Withdrawal or deposit? (w/d):  ");
        System.out.println();
        String accountType = Validator.getString(sc, "Checking or savings? (c/s):   ");
        System.out.println();
        double amount = Validator.getDouble(sc,"Amount? ");
        System.out.println();
        
        //Perform the actions based on user inputs
        Account account = null;
        if (accountType.equalsIgnoreCase("c")) {
            account = c;
        } else {
            account = s;
        }
       //Amount entered can not exceed the total account balance
        if (actionType.equalsIgnoreCase("w")) {
            if (amount > account.getBalance()) {
            	System.out.println("The amount you entered exceeds your account balance."
            			+ "Please enter a valid amount.\n");
            } else {
                account.withdraw(amount);
            }
        } else {
            account.deposit(amount);
        }	
        	
       //Interest and Bank fees
        c.subtractMonthlyBankFee();
        s.setInterestEarned(s.getBalance(), s.getInterestRate());
        s.addInterestToBalance();


        System.out.println("Monthly Payments and Fees");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("Checking Fee:                " + currency.format(c.getMonthlyBankFee()));
        System.out.println("Savings Interest Payment:    " + currency.format(s.getInterestEarned()));
        System.out.println();
        System.out.println("Final Balances");
        printBalances(c, s);
        
        
        // see if the user wants to continue
        choice = Validator.getString(sc, "Continue? (y/n): ");
        System.out.println();	

    }	
        
	}
	
       //Create a method to print the starting balances to the console 	
        private static void printBalances(Checking c, Savings s)  
        {
        NumberFormat currency = NumberFormat.getCurrencyInstance();  
        System.out.println("Checking: " + currency.format(c.getBalance()));
        System.out.println("Savings: " + currency.format(s.getBalance()));
        System.out.println();
            }
        	
	}


