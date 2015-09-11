package creditlimitcalculator;
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
+charges -credits), display the new balance and determine whether the new balance exceeds sthe customer's
credit limit. For those customers whose credit limit is exceeded, the program should display the message 
"Credit limit exceeded".*/

public class Customer {
	
	private String storeName;
	private int accountNumber, beginningBalance, credits, charges;
	private static int accountNumberPlacer = 0;//records the last numerical account number statically this way 
									//any new customers that are added will have the next number in line assigned
	Customer()
	{
		beginningBalance = 0;
		credits = 0;
		charges= 0;
		assignAccountNumber();
	}
	Customer(String storeName, int beginningBalance)
	{
		this.storeName = storeName;
		this.beginningBalance = beginningBalance;
		credits = 0;
		charges = 0;
		assignAccountNumber();
	}
	
	//method that will assign the account number for the customer
	void assignAccountNumber()
	{
		accountNumberPlacer++;
		this.accountNumber = Integer.valueOf(accountNumberPlacer);//use valueOf so that accountNumber will not be pointing to the static variable
	}
	
	
	//setter methods
	void setName(String storeName)
	{
		this.storeName = storeName;
	}
	void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	
	
	//adds new credits to the current credit
	void addCredit(int credit)
	{
		this.credits +=credit;
	}

	void addCharge(int charges)//adds new charges to the account, but makes sure that there is enough credit to subtract
	{
		if(getAccountBalance()-charges >= 0)//if the current account balance is greater than 0, then there is more credit available
			this.charges +=charges;
		else//if the charges goes below the account balance, then there is no more credit left.
			System.out.println("Credit Limit Exceeded");
	}
	
	//getter methods
	String getStoreName()
	{
		return storeName;
	}
	int getAccountBalance()//returns the current balance of account
	{
		return beginningBalance + credits- charges;
	}
	int getTotalCredits()
	{
		return credits;
	}
	int getTotalCharges()
	{
		return charges;
	}
	int getAccountNumber()
	{
		return accountNumber;
	}
	int getBeginningBalance()
	{
		return beginningBalance;
	}
	
	void newMonth()//sets the beginning balance of the new month to the last months ending balance
	{
		beginningBalance = getAccountBalance();
	}

}//end of Customer class
