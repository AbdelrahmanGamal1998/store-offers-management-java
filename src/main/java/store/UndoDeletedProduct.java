package store;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UndoDeletedProduct implements Command{
	private StoreOwner StoreOwner;

	public UndoDeletedProduct(StoreOwner storeOwner) {
		super();
		StoreOwner = storeOwner;
	}

	@Override
	public void execute() throws IOException {
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
		StoreOwner.StoreOwner_addProduct(name, price, brand,category);
	
		
	}
}
