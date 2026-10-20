package store;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class CustomerMain {

public void CustomerMain() throws IOException {
		Buy_Offer New_offer = new Buy_Offer();
		New_offer.setUser_type("User");
		User customer = new Customer();
		User curruse=new User();
		curruse=customer.login();
		int loop=1;
		while(loop==1) {
			System.out.println("Want to Buy Product? Press 1");
			Scanner Bproduct = Input.scanner();
			  int choice = Bproduct.nextInt();
			if(choice==1) {
				New_offer.BuyProduct(curruse);
			}
			else 
				System.out.println("A3melak eh delwa2ty :D");
			
			 System.out.println("Do you Wish to Perform Another Operation? Press 1 / Exit? Press 2");
			  Scanner AnotherOperation = Input.scanner();
					 loop = AnotherOperation.nextInt();
		}
		System.out.println("Thanks For Using Our Website!!");
	 }
}

