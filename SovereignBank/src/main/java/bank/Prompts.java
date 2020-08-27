package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Prompts {
	public static void initialPrompt() {
		System.out.println("Welcome to Sovereign Bank.\n"
				+ "If logging in, press 1. If registering a new account, "
				+ "press 2. To exit, press 3.");
		Scanner userReader = new Scanner(System.in);
		ArrayList<String> userLoginHolder = new ArrayList<String>(); //Holds First name, last name, Username, and password
		
		int errorCounter = 0;
		while (errorCounter == 0) {
			
		int numInput = userReader.nextInt();
		
			switch (numInput) {
			case 1: // Login Option
				BankLib.readCustomersFromFile();
				System.out.println("Please input your username:");
				userLoginHolder.add(userReader.next());
				System.out.println("Please input your password:");
				userLoginHolder.add(userReader.next());
				BankLib.login(userLoginHolder.get(0), userLoginHolder.get(1));
				
				errorCounter++;
				break;
			case 2: // Registration Option
				ArrayList<Customer> masterCustList = new ArrayList<Customer>();

				System.out.println("Please input your desired username:");
				String userName = userReader.next();
				userLoginHolder.add(userName);
				System.out.println("Please input your desired password:");
				String password = userReader.next();
				userLoginHolder.add(password);
				System.out.println("What is your first name?");
				String firstName = userReader.next();
				userLoginHolder.add(firstName);
				System.out.println("What is your last name?");
				String lastName = userReader.next();
				userLoginHolder.add(lastName);
				
				//This method ensures username is unique.
				BankLib.usernameUniqueCheck(userLoginHolder.get(0));
				
				//Creates the object of the Customer account, and adds it into an ArrayList<Customer>
				Customer customer = new Customer(firstName, lastName, userName, password);
				masterCustList.add(customer);
				
				BankLib.saveCustomerToFile(masterCustList);
				
				//Prints out a message in console so the customer can see.
				System.out.println("\nUsername: " + customer.getUserName() + 
						"\n" + "Password: " + customer.getPassword()); //Test output to console.
				accountMenuPrompt(customer);
				errorCounter++;
				break;
			case 3: //Admin Login
				//TODO: Admin login menu.
			case 4: //Exit
				System.out.println("Goodbye. Bank with us again soon.");
				System.exit(0);
			default: // Bad input catcher.
				System.out.println("Incorrect input. Please try again.");
				break;
			}
		}
	}
	
	
		/* Decide how to structure Bank Accounts as separate objects. Consider moving PIN to
		 *  the account, so PIN is generated on application acceptance.
		 *  Also consider AccountPrompt asking for an account number when transferring funds.
		 */
	
	public static void accountMenuPrompt(Customer customer) { 
		Scanner actionReader = new Scanner(System.in);
		BankAccounts currentAccount;
		currentAccount = BankLib.retrieveAccount(customer.getUserName());
		System.out.println("=========================================================");
		System.out.println("Thank you for banking with Sovereign Bank Services, " 
									+ customer.getFirstName() + " " + customer.getLastName());
		if (currentAccount == null) {
			System.out.println("You have no currently open accounts.");
		} else {
		System.out.println("Your current account PIN: " + currentAccount.getPIN());//pulls PIN of bank account
		}
		System.out.println("Would you like to apply for an account? (Y/N)");
		String newAccountChoice = actionReader.next();
		
		switch (newAccountChoice) {
		case "Y":
			BankLib.applyForNewAccount(customer);
			System.out.println("Not a problem! An application for a bank account has been submitted!");
			System.out.println("Have a nice day! Session closing.");
			break;
		case "N":
			System.out.println("Very well. Please provide your account PIN for direct access.");
			int accountPIN = actionReader.nextInt();
			accountActionPrompt(customer, accountPIN);
			}

		}
	
		
	public static void accountActionPrompt(Customer customer, int PIN) {
		Scanner actionReader = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println("What service would you like to perform today?");
		System.out.println("Press the corresponding number to perform your desired service:");
		System.out.println("1. Deposit         || 2. Withdraw");
		System.out.println("3. Balance         || 4. Apply for New Account");
		System.out.println("5. Exit            || ");
		System.out.println("=========================================================");
		
		BankAccounts currentAccount = BankLib.pinAllocation(PIN);
		if (currentAccount == null) {
			return;
		}

		int numInput = actionReader.nextInt();
		
		switch (numInput) {
			case 1:
				System.out.println("How much money would you like to deposit?");
				Double depositAmt = actionReader.nextDouble();
			  	currentAccount.setBalance(currentAccount.getBalance() + depositAmt);
			  	System.out.println("Your current balance is: $" + currentAccount.getBalance());
				break;
			case 2:
				System.out.println("How much money would you like to deposit?");
				Double withdrawAmt = actionReader.nextDouble();
			  	currentAccount.setBalance(currentAccount.getBalance() - withdrawAmt);
			  	System.out.println("Your current balance is: $" + currentAccount.getBalance());
			case 3:
				System.out.println("Your current balance is: $" + currentAccount.getBalance());
			case 4:
				BankLib.applyForNewAccount(customer);


				System.out.println("Your account PIN is: " + currentAccount.getPIN());
				accountActionPrompt(customer, PIN);
			case 5:
				System.exit(0);
			case 6:

		}
	}
	
	public static void AdminPrompt() {
		System.out.println("Welcome, admin.");
		System.out.println("Your available actions are as follows:");
		System.out.println("1. ")
		
	}
	
}