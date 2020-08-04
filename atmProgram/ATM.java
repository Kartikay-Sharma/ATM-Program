package atmProgram;

import java.util.Scanner;
import java.util.HashMap;

public class ATM {

	// To keep record of Account Number and Password
	static HashMap<Integer, String> accPass = new HashMap<Integer, String>(2);
	// To keep record Account Number and Objects (to make each account unique)
	static HashMap<Integer, Account> accObj = new HashMap<Integer, Account>(2);
	
	public static void main(String[] args) {
		
		//Default Account Numbers and Passwords
		Account obj1 = new Account();
		Account obj2 = new Account();
		accPass.put(1234, "1234");
		accPass.put(9876, "abcd");
		accObj.put(1234, obj1);
		accObj.put(9876, obj2);
		
		int accNo, x;
		String pass;
		boolean i = true;
		Scanner sc = new Scanner(System.in);
		
		while(i == true) {
			
			System.out.println("Welcome to ATM");
			System.out.println("1 - Log In");
			System.out.println("2 - Stop");
			System.out.print("Choice: ");
			//Exception handling is done to prevent getting input other than numbers
			try {
				x = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Enter a valid option.");
				x = sc.nextInt();
			}
			
			switch(x) {
			
			case 1:
				System.out.print("Account Number: ");
				accNo = sc.nextInt();
				System.out.print("Password: ");
				pass = sc.next();
				authenticate(accNo, pass);
				break;
			case 2:
				System.out.println("ATM turned off.");
				i = false;
				break;
			default:
				System.out.println("Enter a valid option.");
				break;
			
			}
			
		}
		
		sc.close();

	}
	
	//Authenticate Account Number and Password
	static void authenticate(int accNo, String pass) {
		
		if(accPass.containsKey(accNo) && pass.equals(accPass.get(accNo))) {
			
			//when successful now user can access account options
			Account o = accObj.get(accNo);
			o.optionMenu();
			
		}
		else {
			
			System.out.println("Wrong Account Number or Password");
			
		}
		
	}

}


abstract class AccFunctions {

	//Functions the user can perform while accessing their account
	int balance;
	
	AccFunctions(){
		balance = 0;
	}
	
	int getBalance() {
		return balance;
	}
	
	int deposit(int x) {
		balance += x;
		return balance;
	}
	
	int withdraw(int x) {
		balance -= x;
		return balance;
	}

}