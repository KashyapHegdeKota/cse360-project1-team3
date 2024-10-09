package edu.asu.DatabasePart1;
import java.util.*;

public class Admin{
	private static String username;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter username: ");
		username = scan.nextLine();
		System.out.println("-----------------------------------------");
		System.out.printf("Welcome %s to the Admin Page\n", username);
		System.out.println("-----------------------------------------");
		
		String cont="y";
		while (cont.toLowerCase()=="y"){
			int choice;
			System.out.println("What action would you like to perform?\n"+
								"1. Invite an individual to join the application.\n"+
								"2. Reset a user account.\n"+
								"3. Delete a user account.\n"+
								"4. List the user accounts.\n"+
								"5. Add or remove a role from a user.\n"+
								"6. Log out.\n");
			System.out.print("Enter your choice (1-6): ");
			choice = scan.nextInt();
			if (choice==1){
				invite();
			}
			else if (choice==2){
				reset();
			}
			else if (choice==3){
				static String username_del;
				System.out.println("Enter the username you want to delete: ");
				username_del = scan.nextLine();
				System.out.println("Are you sure?(yes if you want to continue): ");
				String ans= scan.nextLine();
				if (ans.toLowerCase()=="yes") {
					DatabaseHelper.deleteUserByEmail(username_del);
					System.out.println("Successfully deleted the user.");
				}
				else {
					System.out.println("Admin changed their mind.")
				}
				
			}
			else if (choice==4){
				DatabaseHelper.displayUsersByAdmin();
			}
			else if (choice==5){
				
			}
			else if (choice==6){
				System.out.println("Logging Out");
				break;
			}
			else {
				System.out.println("Invalid Choice.");
			}
	
			System.out.println("Do you want to continue?(y/Y for yes): ");
			cont = scan.nextLine();
		}
				
	}
	
	static char[] generateOTP() {
		char[] otp = new char[5]; // Array to hold the characters
        int index = 0;
        
       for(int i=0;i<5;i++) {
    	   Random r = new Random();
    	   char c = (char)(r.nextInt(9)+'0');
    	   otp[i] = c;
       }
       
        return otp;
	}
	
	static void register() {
		
	}
	
	static void reset(String username) {
		char[] otp = generateOTP();
		int cond = 0;
		String otp_gen = "";
		for(int i = 0; i < 5; i++) {
			otp_gen = otp_gen + Character.toString(otp[i]);
			}
		System.out.println("Enter OTP: ");
		String otp_user = scan.nextLine();
		
		if(otp_user.equals(otp_gen)) {
			System.out.println("Enter the new password: ");
			String new_pass = scan.nextLine();
			
//			while(cond == 0) {
//				if(PasswordEvaluator.evaluatePassword(new_pass) == "Success") {
//					//Database change the password of that username
//					cond = 1;
//				}
//				else {
//					cond = 0;
//				}
//			}
		
		
		}
		
		
		
	}