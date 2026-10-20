package store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit_offer_view {

	
	public  ArrayList<String> Edit_offer_Price() throws IOException {
		ArrayList<String> edit = new ArrayList<String>();
		System.out.println("Please enter the offerd product name you want to Edit");
		Scanner x1 = Input.scanner();
		String edited = x1.next();
		System.out.println("Please enter the new offerd product price ");
		Scanner x2 = Input.scanner();
		String edited2 = x2.next();
		edit.add(0, edited);
		edit.add(1,edited2);
		return edit;
	}
	
}
