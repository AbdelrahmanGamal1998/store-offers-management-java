package store;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Collaborator_controller {

	public static void verify_Collaborator(String name, String storename) throws IOException {
		
		Collaborator_verification Collaborator_verification = new Collaborator_verification();
		File file = new File("Collaborator.txt");
		String arr[] = { name, storename };
		int value = Collaborator_verification.check_collaborator_database(file, arr);

		if (value == 1) {
			System.out.println("Access Granted! Welcome in :" + arr[1]);
		}
		else if (value == 2) {
			System.out.println("Invalid Collaborator name !");
			System.exit(0);
		}
		else if (value == 0) {
			System.out.println("Invalid Store name!");
			System.exit(0);
		}
		else {
			System.out.println("Invalid name & Store name ");
			System.exit(0);
		}

	}
}