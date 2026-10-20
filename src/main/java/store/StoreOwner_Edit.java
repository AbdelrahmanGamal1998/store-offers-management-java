package store;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreOwner_Edit {

	static ArrayList<Products> products = new ArrayList<Products>();
	Database_write_infile Filewrite = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	History edit_History = new History();
	Edit_view Edit_view = new Edit_view();

	public void UpdatedProductPrice() throws IOException {
		File fiLe = new File("StoreProducts.txt");
		FileReader FrEader = new FileReader(fiLe);
		Scanner read = new Scanner(fiLe);
		String Name_line, Category_line = null;
		String Price_line, Brand_line = null;
		ArrayList<String> to_BeEdited = new ArrayList<String>();
		to_BeEdited = Edit_view.EditPrice();

		String NameOfProduct = to_BeEdited.get(0);
		String Newname = to_BeEdited.get(1);
		String NewPrice = to_BeEdited.get(2);
		String Newbrand = to_BeEdited.get(3);
		String Newcategory = to_BeEdited.get(4);
		while (read.hasNext()) {
			Name_line = read.nextLine();
			Price_line = read.nextLine();
			Brand_line = read.nextLine();
			Category_line = read.nextLine();
			Products x = new Products(Name_line, Price_line, Brand_line, Category_line);
			products.add(x);

			PrintWriter writer = new PrintWriter("StoreProducts.txt");
			writer.print("");
			writer.close();
		}

		File filex = new File("Before Edit.txt");
		for (int j = 0; j < products.size(); j++) {
			Name_line = products.get(j).getName();
			Price_line = products.get(j).getPrice();
			Brand_line = products.get(j).getBrand();
			Category_line = products.get(j).getCategory();
			String str[] = { Name_line, Price_line, Brand_line, Category_line };
			Filewrite.Write(filex, str);
		}

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(NameOfProduct)) {

				products.get(i).setName(Newname);
				products.get(i).setPrice(NewPrice);
				products.get(i).setBrand(Newbrand);
				products.get(i).setCategory(Newcategory);

			}
		}
		File file1 = new File("StoreProducts.txt");
		for (int j = 0; j < products.size(); j++) {
			Name_line = products.get(j).getName();
			Price_line = products.get(j).getPrice();
			Brand_line = products.get(j).getBrand();
			Category_line = products.get(j).getCategory();
			String str[] = { Name_line, Price_line, Brand_line, Category_line };
			Filewrite.Write(file1, str);
			edit_History.Edited_Prtoduct_History(NameOfProduct);

		}
		System.out.println("The Price Of This Product Is Updated Successfuly");

	}

	public void undoEdit() throws IOException {
		PrintWriter writer = new PrintWriter("StoreProducts.txt");
		writer.print("");
		writer.close();
		FileReader fr = new FileReader("Before Edit.txt");
		FileWriter fw = new FileWriter("StoreProducts.txt");
		int choice = fr.read();
		while (choice != -1) {
			fw.write(choice);
			choice = fr.read();
		}
		fr.close();
		fw.close();
	}
	
	/*public void undoEdit(Products product) throws IOException
    {
            File file = new File("Before Edit.txt");
            FileReader FREADER = new FileReader(file);
	Scanner read = new Scanner(file);
	String Name_line = null, Category_line = null;
	String Price_line = null, Brand_line = null;
            while (read.hasNext()) {
		Name_line = read.nextLine();
		Price_line = read.nextLine();
		Brand_line = read.nextLine();
		Category_line = read.nextLine();
            
             if (product.getName().contentEquals(Name_line))
                {   product.setName(Name_line);
                    product.setPrice(Price_line);
                    product.setBrand(Brand_line);
                    product.setCategory(Category_line);
                    System.out.println(product.getName());
                    System.out.println(product.getPrice());
                    System.out.println(product.getBrand());
                    System.out.println(product.getCategory());
                    break;
                }
                    
                }
           for (int i=0;i<products.size();i++)
            {
            if (product.getName().contentEquals(products.get(i).getName()))
            {
            products.get(i).setName(product.getName());
            products.get(i).setPrice(product.getPrice());
            products.get(i).setBrand(product.getBrand());
            products.get(i).setCategory(product.getCategory());
            //System.out.println(products.get(i).getName());
            //System.out.println(products.get(i).getPrice());
            
            }
              
 			PrintWriter writer = new PrintWriter("StoreProducts.txt");
 			writer.print("");
 			writer.close();
             
 			File file1 = new File("StoreProducts.txt");

    
 			
 			for (int j = 0; j < products.size(); j++) {
		   Name_line= products.get(j).getName();
	        Price_line=products.get(j).getPrice();
	        Brand_line=products.get(j).getBrand();
		    Category_line=products.get(j).getCategory();
		 /* System.out.println(products.get(j).getName());
          System.out.println(products.get(j).getPrice());*/
			/*	String str[] = { Name_line, Price_line, Brand_line, Category_line };
      	    Filewrite.Write(file1, str);
            }
          
            }*/

}