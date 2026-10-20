package store;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class AdminMain {

	public void AdminMain() throws IOException {
		Admin Admin = new Admin();
		Admin.Admin_login();
		int loop = 1;
		while (loop == 1) {
			System.out.println(
					"Want to Add Products? Press 0 / Want to Add Brands? Press 1 / View Statistics? Press 2  / Want to Add Offer? Press 3 / Want to Delete Offer? Press 4 / Want to Edit Offer? Press 5");
			Scanner button = Input.scanner();
			int button1 = button.nextInt();
			if (button1 == 0) {
				System.out.println("Enter product name");
				Scanner input_name = Input.scanner();
				String name = input_name.next();
				System.out.println("Enter product price");
				Scanner input_price = Input.scanner();
				String price = input_price.next();
				System.out.println("Enter product Brand");
				Scanner input_brand = Input.scanner();
				String brand = input_brand.next();
				System.out.println("Enter product category");
				Scanner input_category = Input.scanner();
				String category = input_category.next();
				Admin.Admin_addProduct(name, price, brand, category);
			} else if (button1 == 1) {
				System.out.println("Enter product Brand name");
				Scanner brand_Name = Input.scanner();
				System.out.println("Enter Brand category");
				Scanner brand_Category = Input.scanner();
				Admin.Admin_brands(brand_Name, brand_Category);
			} else if (button1 == 2) {
				System.out.println("Sum Users: ");
				Admin.Sum_User__product_statistics();
				System.out.println("Average Users : ");
				Admin.Average_User_product_Statistics();
				Admin.Maxiumum_User_statistics();
				Admin.Min_User_statistics();
				System.out.println("Sum products: ");
				Admin.Sum_User__product_statistics();
				System.out.println("Average Products : ");
				Admin.Average_User_product_Statistics();
				Admin.max_Products_statistics();
				Admin.min_Products_statistics();

			} else if (button1 == 3) {
				System.out.println("Enter name");
				Scanner inputname = Input.scanner();
				String name = inputname.next();
				System.out.println("Enter Offerd price");
				Scanner input_offer_price = Input.scanner();
				String price = input_offer_price.next();
				Admin.Add_offer(name, price);

			} else if (button1 == 4) {
				Admin.Delete_offer();
			} else if (button1 == 5) {
				Admin.Update_offer();
			} else
				System.out.println("Fawa2 ya3am el hag 2olna Press 0 aw 1");

			System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
			Scanner button2 = Input.scanner();
			loop = button2.nextInt();

		}
		System.out.println("Thanks For Using Our Website!!");
	}
}