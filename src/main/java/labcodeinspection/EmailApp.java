package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Logger;

public class EmailApp {

	private static final Logger LOGGER = Logger.getLogger(EmailApp.class.getName());

	public static void main(final String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			LOGGER.info("Enter your first name: ");
			final String firstName = scanner.nextLine();

			LOGGER.info("Enter your last name: ");
			final String lastName = scanner.nextLine();

			LOGGER.info(
					"\nDEPARTMENT CODE\n"
					+ "1. for sales\n"
					+ "2. for Development\n"
					+ "3. for accounting\n"
					+ "Enter code: ");

			final int departmentChoice = scanner.nextInt();

			final Email email = new Email(firstName, lastName);
			email.setDeparment(departmentChoice);
			email.generateEmail();
			email.showInfo();
		}
	}
}