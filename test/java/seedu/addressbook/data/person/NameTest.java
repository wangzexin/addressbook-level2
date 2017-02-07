package seedu.addressbook.data.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import seedu.addressbook.data.person.Name;

public class NameTest {
	/**
	 * Test for the method isSimilar in Name class
	 */
	
	@Test
	public void testIsSimilar(){
		Name name1 = new Name("");
		Name name2 = new Name("");
		assertEqual(name1.isSimilar(name2));
	}
}