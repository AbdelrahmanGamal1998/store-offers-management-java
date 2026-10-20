package store;

import java.io.IOException;
import java.util.Scanner;

public class CollaboratorMain {

	public void CollaboratorMain() throws IOException {
		Collaborator collaborator = new Collaborator();
		System.out.println("Please Enter Username : ");
		Scanner Uname = Input.scanner();
		String username = Uname.next();
		System.out.println("Please Enter Store Name : ");
		Scanner Sname = Input.scanner();
		String store_Name = Sname.next();
		collaborator.Collabrorator_login(username, store_Name);
		int loop = 1;
		while (loop == 1) {
			System.out.println(
					"Want to Add Products? Press 0 / Want to View Statistics? Press 1? /Want to Delete Product ? Press 2? /Want to Edit Product? Press 3?");
			Scanner UserChoice = Input.scanner();
			int Choice = UserChoice.nextInt();
			if (Choice == 0) {
				System.out.println("Enter product Name");
				Scanner input_name = Input.scanner();
				String name = input_name.next();
				System.out.println("Enter product Price");
				Scanner input_price = Input.scanner();
				String price = input_price.next();
				System.out.println("Enter product Brand");
				Scanner input_brand = Input.scanner();
				String brand = input_brand.next();
				System.out.println("Enter product Category");
				Scanner input_category = Input.scanner();
				String category = input_category.next();
				collaborator.addProduct_bycollaborator(name, price, brand, category);
			} else if (Choice == 1) {
				collaborator.run();
			} else if (Choice == 2) {
				collaborator.Deleteproduct_by_collaborator();
			} else if (Choice == 3) {
				collaborator.Updateproduct_by_collaborator();
			} else
				System.out.println("Maho Mafesh 7aga tanya :D");

			System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
			Scanner End_op = Input.scanner();
			loop = End_op.nextInt();
		}
		System.out.println("Thanks For Using Our Website!!");
	}
}
