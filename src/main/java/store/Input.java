package store;

import java.util.Scanner;

/**
 * One shared Scanner on System.in. Several Scanners on the same stream lose buffered input,
 * which breaks the app as soon as the input is piped or scripted.
 */
final class Input {

	private static Scanner scanner;

	private Input() {
	}

	static Scanner scanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}

	/** Forget the shared Scanner, for example after System.setIn(...) in a test. */
	static void reset() {
		scanner = null;
	}
}
