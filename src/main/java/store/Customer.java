package store;

import java.io.IOException;

public class Customer extends User {

	User customer = new User();
	Buy_Offer buy = new Buy_Offer();

	public void Customer_Login() throws IOException {
		customer.login();
	}

	public void Buy_Product(User u) throws IOException {
		buy.BuyProduct(u);
	}

}