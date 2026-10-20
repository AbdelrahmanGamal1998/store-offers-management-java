package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Offer {
	private String OfferName;
	private String Offerprice;

	Database_write_infile write = new Database_write_infile();
	Delete_view offer = new Delete_view();
	StoreOwner_Edit offer_Price = new StoreOwner_Edit();
	Edit_offer_view Edit_offer_view = new Edit_offer_view();

	public String getOfferName() {
		return OfferName;
	}

	public void setOfferName(String offerName) {
		OfferName = offerName;
	}

	public String getOfferprice() {
		return Offerprice;
	}

	public void setOfferprice(String offerprice) {
		Offerprice = offerprice;
	}

	public void add_Offers(String name, String price) throws IOException {
		File file = new File("Offers.txt");
		String arr[] = { name, price };
		write.Write(file, arr);
	}

	public void deleteOffer() throws IOException {
		File inputFile = new File("Offers.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = offer.Delete();
		String s0;
		String s1;

		while ((s0 = reader.readLine()) != null & (s1 = reader.readLine()) != null) {
			// trim newline when comparing with lineToRemove
			String trimmedLine0 = s0.trim();
			String trimmedLine1 = s1.trim();

			if (trimmedLine0.equals(lineToRemove))
				continue;
			String arr[] = { s0, s1 };
			write.Write(tempFile, arr);

		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		System.out.println("Offer Is deleted  Successfuly");
	}

	public void UpdatedOfferPrice() throws IOException {
		ArrayList<Offer> A = new ArrayList<Offer>();
		File f = new File("Offers.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1, s2 = null;
		ArrayList<String> to_BeEdited = new ArrayList<String>();
		to_BeEdited = Edit_offer_view.Edit_offer_Price();
		String a = to_BeEdited.get(0);
		String b = to_BeEdited.get(1);

		while (read.hasNext()) {
			s1 = read.nextLine();
			s2 = read.nextLine();

			Offer x = new Offer(s1, s2);
			A.add(x);
			PrintWriter writer = new PrintWriter("Offers.txt");
			writer.print("");
			writer.close();
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).getOfferName().equals(a)) {
				A.get(i).setOfferprice(b);
			}
		}
		File file1 = new File("Offers.txt");
		FileWriter h1 = new FileWriter(file1, true);
		for (int j = 0; j < A.size(); j++) {
			s1 = A.get(j).getOfferName();
			s2 = A.get(j).getOfferprice();
			String x[] = { s1, s2 };
			write.Write(file1, x);
		}
		System.out.println("The Price Of this Offer Is Updated Successfuly");

	}

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(String offerName, String offerprice) {
		super();
		OfferName = offerName;
		Offerprice = offerprice;
	}
		
	public void offer_File(String line0, String line1, String line2, String line3, String product) throws IOException {
		File file5 = new File("Offers.txt");
		FileReader freader = new FileReader(file5);
		Scanner read5 = new Scanner(file5);
		System.out.println("This Product After offer");
		while (read5.hasNext()) {
			line0 = read5.nextLine();
			line1 = read5.nextLine();
			if (line0.equalsIgnoreCase(product)) {
				System.out.println("the product price is :");
				System.out.println(line1 + " L.E");

				break;
			}
		}
	}


}
