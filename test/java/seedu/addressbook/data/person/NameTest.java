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
		Name name3 = new Name("Jay Chou");
		Name supersetName = new Name("Jay Chou Zhou");
		Name differentCaseName = new Name("jAY cHOU");
		Name nullName = null;
		
		assertFalse(name1.isSimilar(name2));
		assertTrue(name1.isSimilar(name1));

		assertTrue(name2.isSimilar(name3));
		
		assertTrue(name2.isSimilar(supersetName));
		assertTrue(supersetName.isSimilar(name3));
		
		assertTrue(differentCaseName.isSimilar(name2));
		assertTrue(name2.isSimilar(differentCaseName));
		
		assertTrue(differentCaseName.isSimilar(supersetName));
		assertTrue(supersetName.isSimilar(differentCaseName));
		
		assertFalse(name1.isSimilar(nullName));
	}
}