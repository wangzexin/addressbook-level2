package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.PostalCode;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be entered in the following format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";

    private Block _block;
    private Street _street;
    private Unit _unit;
    private PostalCode _postalCode;
    private boolean isPrivate;
    
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_CODE_INDEX = 3;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] primitiveComponents = trimmedAddress.split(", ");
        _block = new Block(primitiveComponents[BLOCK_INDEX]);
        _street = new Street(primitiveComponents[STREET_INDEX]);
        _unit = new Unit(primitiveComponents[UNIT_INDEX]);
        _postalCode = new PostalCode(primitiveComponents[POSTAL_CODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    public String getBlock() {
    	return _block.getBlock();
    }

    public String getStreet() {
    	return _street.getStreet();
    }

    public String getUnit() {
    	return _unit.getUnit();
    }

    public String getPostalCode() {
    	return _postalCode.getPostalCode();
    }

    @Override
    public String toString() {
        return this.getBlock() + ", " + this.getStreet() + ", " 
        		+ this.getUnit() + ", " + this.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getBlock().equals(((Address) other).getBlock())
                && this.getStreet().equals(((Address) other).getStreet())
                && this.getUnit().equals(((Address) other).getUnit())
                && this.getPostalCode().equals(((Address) other).getPostalCode())
                ); // state checks
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
