package seedu.addressbook.data.person;

/**
 * A read-only immutable interface for printables in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface Printable {
	String toString();
	
	default String getPrintableString(){
		return this.toString();
	}
}