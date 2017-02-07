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
		
		assertFalse(name1.isSimilar(name2));
		assertTrue(name1.isSimilar(name1));

		assertTrue(name2.isSimilar(name3));
		
		Name supersetName = new Name("Jay Chou Zhou");
		Name subsetName = new Name("Jay Chou");
		
		assertTrue(subsetName.isSimilar(supersetName));
		assertTrue(supersetName.isSimilar(subsetName));
		
		Name differentCaseName1 = new Name("jAY cHOU");
		Name differentCaseName2 = new Name("Jay Chou");
		Name differentCaseSupersetName = new Name("Jay CHOU Zhou");
		Name nullName = null;

		assertTrue(differentCaseName1.isSimilar(differentCaseName2));
		assertTrue(differentCaseName2.isSimilar(differentCaseName1));
		
		assertTrue(differentCaseName1.isSimilar(differentCaseSupersetName));
		assertTrue(differentCaseSupersetName.isSimilar(differentCaseName1));
		assertTrue(differentCaseName2.isSimilar(differentCaseSupersetName));
		assertTrue(differentCaseSupersetName.isSimilar(differentCaseName2));
		
		assertFalse(differentCaseName1.isSimilar(nullName));
	}
}