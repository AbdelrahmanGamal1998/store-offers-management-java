package store;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class Main {

	public static void main(String[] args) throws IOException {

		User user = new User();
		System.out.println("Welcome to 5od Fekra w Eshtery Bokra!");
		System.out.println("New Account? Press 0 / Login? Press 1");
		Scanner CHoice = Input.scanner();
		int INput_choice = CHoice.nextInt();
		if (INput_choice == 0) {
			user.createaccount();
		} else if (INput_choice == 1) {
			System.out.println("Admin? Press 0 / Customer? Press 1 / StoreOwner? Press 2 / Collaborator? Press 3");
			Scanner Type = Input.scanner();
			int Input_Type = Type.nextInt();
			if (Input_Type == 0) {
				AdminMain adminMain = new AdminMain();
				adminMain.AdminMain();

			} else if (Input_Type == 1) {
				CustomerMain cust_Main = new CustomerMain();
				cust_Main.CustomerMain();

			} else if (Input_Type == 2) {
				StoreOwnerMain Store_Main = new StoreOwnerMain();
				Store_Main.StoreOwnerMain();

			} else if (Input_Type == 3) {
				CollaboratorMain Collaborator_main = new CollaboratorMain();
				Collaborator_main.CollaboratorMain();
			}

			else
				System.out.println("3ayez eh delwa2ty!!");
		}

		else
			System.out.println("Yagada3 2olna 0 aw 1 :D");

	}

}