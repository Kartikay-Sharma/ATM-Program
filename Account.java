package atmProgram;

import java.util.Scanner;

public class Account extends AccFunctions{
	
	void optionMenu() {
		
		int x;
		boolean i = true;
		Scanner sc = new Scanner(System.in);
		
		while(i == true) {
			
			System.out.println("Select the option you want to access:");
			System.out.println("1 - Check Balance");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Log Out");
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
				System.out.println("Your balance is " + getBalance());
				break;
			case 2:
				System.out.print("Enter an amount: ");
				int y = sc.nextInt();
				if(y<0)
					System.out.println("Amount cannot be negative.");
				else
					System.out.println("Your balance is now " + deposit(y));
				break;
			case 3:
				System.out.print("Enter an amount: ");
				int z = sc.nextInt();
				if(z<0)
					System.out.println("Amount cannot be negative.");
				else if((balance - z)<0)
					System.out.println("Not enough balance.");
				else
					System.out.println("Your balance is now " + withdraw(z));
				break;
			case 4:
				System.out.println("Logged out successfully.");
				i = false;
				sc.nextLine();
				break;
			default:
				System.out.println("Enter a valid option.");
				break;
			
			}
			
		}
		
		//sc.close()		Do Not close sc here as Scanner is still needed when the user logs out
		
	}

}
