package creditlimitcalculator;

import java.util.ArrayList;
import java.util.Scanner;

/*
4.18 Credit Limit Calculator

Develop a Java application that determins whether 
any of several department-store customers has exceeded the credit limit on charge account.
For each customer, the following facts are available:
a) account number
b)balance at the beginning of the month
c)total of all items charged by the customer this month
d)total of all credits applied to the customer's account this month
e)allowed credit limits
The program should input all these facts as integers, calculate the new balance (= beginning balance
+charges -credits), display the new balance and determine whether the new balance exceeds the customer's
credit limit. For those customers whose credit limit is exceeded, the program should display the message 
"Credit limit exceeded".*/


public class CreditLimitCalculator {

	static Scanner input;
	static ArrayList<Customer> departmentStores;
	
	public static void main(String[] args) {
	
		input = new Scanner(System.in);	
		departmentStores = new ArrayList<Customer>();//list of department Stores
		
		String userInput;
		
			assignNewCustomer();
			
			do{
				System.out.print("What would you like to do(add, Credit, Charge, Print, End)? ");
				userInput = input.next();
				
				if(userInput.equalsIgnoreCase("Add"))
					assignNewCustomer();
				else if(userInput.equalsIgnoreCase("Credit"))
					addNewCredit();
				else if(userInput.equalsIgnoreCase("Charge"))
					addNewCharges();
				else if(userInput.equalsIgnoreCase("print"))
					printCustomers();
			}while(!userInput.equalsIgnoreCase("end"));
				
		
	}
	
	//method that will ask user for information to add a new Customer to the list of department stores
	static void assignNewCustomer()//takes user input to add new customers
	{
	
	
			System.out.print("Input name of new department store: ");
			String storeName = input.next();
			System.out.print("Input customer's account balance: ");
			int balance = input.nextInt();
			departmentStores.add(new Customer(storeName, balance));
	}
	
	static void addNewCharges()
	{
		Customer customerToCharge = findCustomer();
		System.out.print("Input charge amount: ");
		int charge = input.nextInt();
		customerToCharge.addCharge(charge);
	}
	static void addNewCredit()
	{
		Customer customerToCredit = findCustomer();
		System.out.print("Input credit amount: ");
		int credit = input.nextInt();
		customerToCredit.addCredit(credit);
	}
	
	 //method that finds the customer the user wants to look at
	static Customer findCustomer()
	{
		System.out.print("Input customer's name to edit: ");
		String checkName = input.next();
		for(int x =0; x <departmentStores.size(); x++)//searches through the list to find the name of the store to get
		{
			if(departmentStores.get(x).getStoreName().equalsIgnoreCase(checkName))
			{
				return departmentStores.get(x);
			}
		}
		return null;//if no store is found return nothing
	}

	
	//prints out the customers and the information in regards to their accounts
	static void printCustomers()
	{
		Customer tempStorage;//temporarly stores customer from array. 
		for(int x=0; x < departmentStores.size();x++)
		{
			tempStorage = departmentStores.get(x);
			System.out.printf("%s account number is %d: %n"
					+ "Total monthly charges are %d, Total monthly credits are %d%n"
					+ "The beginning balance is %d, the credits allowed is %d%n%n", 
					tempStorage.getStoreName(), tempStorage.getAccountNumber(), 
					tempStorage.getTotalCharges(), tempStorage.getTotalCredits(),
					tempStorage.getBeginningBalance(), tempStorage.getAccountBalance());
		}
	}

}
