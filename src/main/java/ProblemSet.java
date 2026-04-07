/**

        * File: Unit 3: Problem Set

        * Author: Weiya Liu

        * Date Created: March 27, 2026

        * Date Last Modified: April 7, 2026

        */

import java.util.Scanner;

public class ProblemSet {

public static void main(String args[]) {
	Scanner scanner = new Scanner (System.in);
	System.out.print("Input two emails: ");
	String input = scanner.nextLine();

	int comma = input.indexOf(',');

	if (comma == -1 ) {
		System.out.println("Invalid: Enter two emails separated by a space and a comma");
	} else {
		String firstEmail = input.substring (0, comma);
		firstEmail = firstEmail.trim();
		String secondEmail = input.substring (comma + 1);
		secondEmail = secondEmail.trim();
	
		process(firstEmail);
		process(secondEmail);
	}

	scanner.close();

	}

	// validate email (option 2 rules)
	public static String validEmail (String email) {
		
		// contains one @
		int firstAt = email.indexOf('@');
		int lastAt = email.lastIndexOf('@');

		if (firstAt == -1 ) {
			return "Invalid: Missing @";
		} 
		if (firstAt != lastAt) {
			return "Invalid: Multiple @";
		}

		// doesn't start or end with "."
		if (email.startsWith(".") || email.endsWith(".") ) {
			return "Invalid: Starts or ends with dot";
		}

		// must not contain spaces
		if (email.contains(" ")) {
			return "Invalid: Contains spaces";
		}

		// split domain and local
		String local = email.substring(0,firstAt);
		String domain = email.substring(firstAt + 1);

		// exception B: + and _ are only allowed in local
		if (domain.contains("+") || domain.contains("_")) {
			return "Invalid: + or _ not allowed in domain";
		}

		// local has to be between 1-64 characters
		if (local.length() < 1) {
			return "Invalid: Local part too short";
		}
		if (local.length() > 64) {
			return "Invalid: Local part too long";
		}

		// domain has to cotain a "."
		if (!domain.contains(".")) {
			return "Invalid: No dot in domain";
		}

		// domain extention must be 2-6 characters
		int lastDot = domain.lastIndexOf('.');
		String domainExtend = domain.substring(lastDot + 1);

		if (domainExtend.length() < 2 ) {
			return "Invalid: Domain extension too short";
		}
		
		if (domainExtend.length() > 6) {
			return "Invalid: Domain extension too long";
		}

		return "Valid";
	}

// extract local 
public static String getLocal (String email) {
	int atIndex = email.indexOf('@');
	String local = email.substring (0, atIndex);

// exception C: gmail normalization
String domain = email.substring(atIndex + 1);
	if (domain.equalsIgnoreCase("gmail.com")) {
			if (local.contains(".")) {
				local = local.replace(".", "");
		}
	} 
	return local;
}

//extract domain
public static String getDomain (String email) {
	int atIndex = email.indexOf('@');
	return email.substring(atIndex + 1);
}

// process email
public static void process (String email) {
	String result = validEmail(email);

	if (result.startsWith("Valid")) {
		String local = getLocal(email);
		String domain = getDomain(email);
		System.out.println(email + ": " + result + " | Local: " + local + " | Domain: " + domain );
	} else {
		System.out.println(email + ": " + result);
	}
	}
}