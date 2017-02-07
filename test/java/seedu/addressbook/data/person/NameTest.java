package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
	/**
	 * Test for the method isSimilar in Name class
	 * @throws IllegalValueException 
	 */
	
	@Test
	public void testIsSimilar() throws IllegalValueException{
		Name name1 = new Name("Jane Eyre");
		Name name2 = new Name("Jay Chou");
		
		assertFalse(name1.isSimilar(name2));
		assertTrue(name1.isSimilar(name1));
	}
}