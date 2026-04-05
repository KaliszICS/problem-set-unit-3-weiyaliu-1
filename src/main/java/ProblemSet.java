import java.util.Scanner;

public class ProblemSet {

public static boolean validEmail (String email) {
		// contains one @
		int firstAt = email.indexOf('@');
		int lastAt = email.lastIndexOf('@');

		if (firstAt == -1 || firstAt != lastAt) {
			return false;
		} 

		// doesn't start or end with "."
		if (email.startsWith(".") || email.endsWith(".") ) {
			return false;
		}

		// must not contain spaces

		if (email.contains(" ")) {
			return false;
		}

		// split domain and local
		String local = email.substring(0,firstAt);
		String domain = email.substring(firstAt + 1);

		// local has to be between 1-64 characters
		if (local.length() < 1 || local.length() > 64) {
			return false;
		}

		// domain has to cotain a "."
		if (!domain.contains(".")) {
			return false;
		}

		// domain extention must be 2-6 characters
		int lastDot = domain.lastIndexOf('.');
		String domainExtend = domain.substring(lastDot + 1);

		if (domainExtend.length() < 2 || domainExtend.length() > 6) {
			return false;
		}

		return true;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		System.out.print("Input an Email: ");
		String email = scanner.nextLine();

		if (validEmail(email)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
		scanner.close();

	}
}