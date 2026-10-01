package labcodeinspection;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Email {

	private static final Logger LOGGER = Logger.getLogger(Email.class.getName());

	private String firstName;
	private String lastName;
	private String password = null;
	private String department;
	private int defaultLen = 8;
	private String emailAddress;

	public Email(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void showInfo() {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("\nFIRST NAME= " + firstName + "\nLAST NAME= " + lastName);
			LOGGER.info("DEPARTMENT= " + department + "\nEMAIL= " + emailAddress + "\nPASSWORD= " + password);
		}
	}

	public void setDeparment(final int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			this.department = "unknown";
			break;
		}
	}

	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		final char[] password = new char[length];

		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}

		return new String(password);
	}

	public void generateEmail() {
		this.password = this.randomPassword(this.defaultLen);
		this.emailAddress = this.firstName.toLowerCase(Locale.ROOT)
				+ this.lastName.toLowerCase(Locale.ROOT)
				+ "@"
				+ this.department
				+ ".espol.edu.ec";
	}
}