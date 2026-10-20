package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Buy_Offer {
	private String User_type;
	Database_write_infile write = new Database_write_infile();
	Offer offer_file = new Offer();

	public String getUser_type() {
		return User_type;
	}

	public void setUser_type(String user_type) {
		this.User_type = user_type;
	}

	public void BuyProduct(User user) throws IOException {
		ArrayList<String> to_beWritten = new ArrayList<String>();
		int result = 0;
		String line0 = null;
		String line1 = null;
		String line2 = null;
		String line3 = null;
		view_Products(line0, line1, line2, line3);
		System.out.println("PLEASE Choose a SPECIFIC Product ");
		Scanner choicee = Input.scanner();
		String product = choicee.next();
		System.out.println("This Products Details is   ");
		if (product != null) {
			offer_file.offer_File(line0, line1, line2, line3, product);
		}
		to_beWritten = StoreProducts_file(line0, line1, line2, line3, product);
		result = Integer.parseInt(to_beWritten.get(0));
		System.out.println("Please Enter The Amount You Want  ");
		Scanner amountt = Input.scanner();
		int amount = amountt.nextInt();
		int Discount = Calculate_offer(result, amount);
		String Dis = String.valueOf(Discount);
		System.out.println("Congratulation you got an offer : " + Dis + " L.E");
		System.out.println("To Buy The Product?Press 1 ");
		Scanner choiice = Input.scanner();
		int choice = choiice.nextInt();
		if (choice == 1) {
			File file2 = new File("SoldProducts.txt");
			System.out.println("Please Enter The Shipping address ?  ");
			Scanner Addr = Input.scanner();
			String Shipping_Address = Addr.next();
			System.out.println("-------------------");
			System.out.println("If You Agree To Our Product Agreement?Press 1 ");
			Scanner Agreement = Input.scanner();
			int agree = Agreement.nextInt();
			if (agree == 1) {
				System.out.println("we will send you a confirmation mail ");
				System.out.println("the product will be shipping 2 Working days Thanks for Using Our Website  ");
				String arr[] = { user.getName(), product, Dis, to_beWritten.get(1), to_beWritten.get(2) };
				write.Write(file2, arr);
				System.out.println("The Product On The Cart ");
			} else
				System.out.println("The product is discareded ,THANKS FOR USING OUR WEBSITE");
		} else
			System.out.println("THANKS FOR USING OUR WEBSITE");
	}

	public void view_Products(String line0, String line1, String line2, String line3) throws IOException {
		System.out.println("Our Products are   ........ ");
		File file = new File("StoreProducts.txt");
		BufferedReader breader = new BufferedReader(new FileReader(file));
		while ((line0 = breader.readLine()) != null & (line1 = breader.readLine()) != null
				& (line2 = breader.readLine()) != null & (line3 = breader.readLine()) != null) {
			System.out.println(line0);
		}
	}

	public ArrayList<String> StoreProducts_file(String line0, String line1, String line2, String line3, String product)
			throws IOException {
		ArrayList<String> info = new ArrayList<String>();
		File fille = new File("StoreProducts.txt");
		FileReader Freader = new FileReader(fille);
		Scanner read = new Scanner(fille);
		System.out.println("------------------------");
		System.out.println("This Product Before offer");
		while (read.hasNext()) {
			line0 = read.nextLine();
			line1 = read.nextLine();
			line2 = read.nextLine();
			line3 = read.nextLine();
			if (line0.equalsIgnoreCase(product)) {
				System.out.println("the product price is :");
				info.add(0, line1);
				System.out.println(line1 + "L.E");
				System.out.println("the product brand is :");
				info.add(1, line2);
				System.out.println(line2);
				System.out.println("the product category is :");
				info.add(2, line3);
				System.out.println(line3);
				System.out.println("------------------------");
				return info;
			}
		}
		return null;
	}

	public int Calculate_offer(int result, int amount) {
		if ("User".equals(getUser_type())) {
			if (amount == 1) {
				return (int) (result - (result * 0.05));
			} else
				return (int) (result - (result * 0.1));
		} else if ("StoreOwner".equals(getUser_type())) {
			if (amount == 1) {
				return (int) (result - (result * 0.15));
			} else
				return (int) (result - (result * 0.3));
		}
		return 0;
	}
	
}