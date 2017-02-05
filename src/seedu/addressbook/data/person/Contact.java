package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact information in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Contact{

	public static final String EXAMPLE = "dummy";
    public static final String MESSAGE_CONTACT_CONSTRAINTS = "dummy";
    public static final String CONTACT_VALIDATION_REGEX = "dummy";

	public final String value;
    private boolean isPrivate;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Checks if a given string is a valid person phone number.
     */
    public static boolean isValidContact(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instance of handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}