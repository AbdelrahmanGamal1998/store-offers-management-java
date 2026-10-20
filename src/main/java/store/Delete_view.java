package store;

import java.util.Scanner;

public class Delete_view {
	
	public String Delete() {
		System.out.println("Please Enter The Product Name You Want to Delete ");
		Scanner Pname = Input.scanner();
		String deleted = Pname.next();
		return deleted;
	}
}
