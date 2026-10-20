package store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Drives the real console menus with scripted keyboard input. The tests run in a copy of the seed data
 * (see pom.xml), so each test starts from the same files.
 */
class AppFlowsTest {

	private final InputStream originalIn = System.in;
	private final PrintStream originalOut = System.out;
	private ByteArrayOutputStream captured;

	@BeforeEach
	void captureOutput() {
		captured = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captured, true, StandardCharsets.UTF_8));
	}

	@AfterEach
	void restoreStreams() {
		System.setIn(originalIn);
		System.setOut(originalOut);
		Input.reset();
	}

	/** Runs the app with the given lines typed on the keyboard and returns everything it printed. */
	private String run(String... typedLines) throws IOException {
		String keyboard = String.join("\n", typedLines) + "\n";
		System.setIn(new ByteArrayInputStream(keyboard.getBytes(StandardCharsets.UTF_8)));
		Input.reset();
		Main.main(new String[0]);
		return captured.toString(StandardCharsets.UTF_8);
	}

	private static String read(String dataFile) throws IOException {
		return Files.readString(Path.of(dataFile));
	}

	@Test
	void unknownMainMenuChoiceIsRejected() throws IOException {
		String output = run("7");

		assertTrue(output.contains("New Account? Press 0 / Login? Press 1"));
		assertTrue(output.contains("Yagada3 2olna 0 aw 1"));
	}

	@Test
	void newAccountIsCreatedAndSaved() throws IOException {
		String output = run("0", "newuser", "Secret123", "customer", "new@example.com", "0100000000");

		assertTrue(output.contains("Account Created Successfuly"));
		assertTrue(read("Users.txt").contains("newuser"));
	}

	@Test
	void duplicateUsernameIsRejected() throws IOException {
		String output = run("0", "admin", "Secret123", "customer", "dup@example.com", "0100000000");

		assertTrue(output.contains("UserName Is Used"));
		assertTrue(output.contains("Account Can't Be Created"));
	}

	@Test
	void adminCanLogInAndAddAProduct() throws IOException {
		String output = run(
				"1", "0", // log in as Admin
				"admin", "admin123", "admin", // credentials
				"0", "TestProduct", "10", "BrandX", "Food", // add product
				"2"); // exit

		assertTrue(output.contains("Access Granted! Welcome!"));
		assertTrue(output.contains("Thanks For Using Our Website!!"));
		assertTrue(read("AdminProducts.txt").contains("TestProduct"));
	}
}
