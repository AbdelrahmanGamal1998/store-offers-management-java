package store;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class StoreOwnerMain {

	public void StoreOwnerMain() throws IOException {
		Buy_Offer offer = new Buy_Offer();
		StoreOwner_Edit storeowner_Edit=new StoreOwner_Edit();
		offer.setUser_type("StoreOwner");
		User user = new User();
		User curruse = new User();
		curruse = user.login();
		StoreOwner storeowner = new StoreOwner();
		RemoteControlForCommandPattern remotecontrol;
		int loop = 1;
		while (loop == 1) {
			System.out.println(
					"Want to Add Products? Press 0 / Want to Add Store? Press 1 / Want to show views? Press 2 / Want to Buy Product? Press 3 / Want to Delete Product? Press 4 / Want to Edit Product's Price? Press 5 /Want to add Collaborator press 6? /Want to view press 7"
					+ "/ Want Undo Add ? Press 8 / Want Undo Delete ? Press 9 / Want Undo Edit ? Press 10");
			Scanner StoreOwnerChoice = Input.scanner();
			int choice = StoreOwnerChoice.nextInt();
			if (choice == 0) {
				System.out.println("Enter product name");
				Scanner input_name = Input.scanner();
				String name = input_name.next();
				System.out.println("Enter product price");
				Scanner input_price = Input.scanner();
				String price = input_price.next();
				System.out.println("Enter product Brand");
				Scanner input_brand = Input.scanner();
				String brand = input_brand.next();
				System.out.println("Enter  product category");
				Scanner input_category = Input.scanner();
				String category = input_category.next();
				storeowner.StoreOwner_addProduct(name, price, brand, category);
			} else if (choice == 1) {
				storeowner.addStore();
			} else if (choice == 2) {
				Timer timer = new Timer();
				timer.schedule(new StoreOwner_Statistics(), 0, 600000);
			} else if (choice == 3) {
				offer.BuyProduct(curruse);
			} else if (choice == 4) {
				storeowner.StoreOwner_Deleteproduct();
			} else if (choice == 5) {
				storeowner.StoreOwner_Updateproduct();
			}
			 else if (choice == 6) {
				System.out.println("Please Enter Collaborator name");
				Scanner Collaboratorname = Input.scanner();
				String Collaborator_name = Collaboratorname.next();
				System.out.println("Please Enter the Collaborator Store Name ");
				Scanner CollaboratorSname = Input.scanner();
				String Store_Name = CollaboratorSname.next();
				storeowner.add_Collaborator(Collaborator_name, Store_Name);
			}
			else if (choice == 7) {
				storeowner.View_History();

			}
			else if(choice == 8) {
				remotecontrol=new RemoteControlForCommandPattern(new UndoAddedProductCommand(storeowner));
				remotecontrol.ButtonPressed();
			}
            else if(choice == 9) {
            	remotecontrol=new RemoteControlForCommandPattern(new UndoDeletedProduct(storeowner));
				remotecontrol.ButtonPressed();
			}
            else if(choice == 10) {
            	remotecontrol=new RemoteControlForCommandPattern(new UndoEditedProductPrice(storeowner_Edit));
				remotecontrol.ButtonPressed();
			}


			else
				System.out.println("Ma saba7 el fool ba2a :D");
			System.out.println("Do you Wish to Perform Another Operation? Press 1 / Exit? Press 2");
			Scanner enter_loop = Input.scanner();
			loop = enter_loop.nextInt();
		}
		System.out.println("Thanks For Using Our Website!!");
	}

}