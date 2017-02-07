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

		testSameFullName();
		
		testSupersetSubsetNames();
		
		testDifferentCasingNames();
		
		testDifferentCasingAndSupersetSubsetNames();
		
		testNullName();
	}

	private void testNullName() throws IllegalValueException {
		Name normalName = new Name("Super Man");
		Name nullName = null;
		assertFalse(normalName.isSimilar(nullName));
	}

	private void testDifferentCasingAndSupersetSubsetNames() throws IllegalValueException {
		Name differentCaseSupersetName = new Name("Jay CHOU Zhou");
		Name differentCaseSubsetName1 = new Name("jAY cHOU");
		Name differentCaseSubsetName2 = new Name("Jay Chou");
		
		assertTrue(differentCaseSubsetName1.isSimilar(differentCaseSupersetName));
		assertTrue(differentCaseSupersetName.isSimilar(differentCaseSubsetName1));
		assertTrue(differentCaseSubsetName2.isSimilar(differentCaseSupersetName));
		assertTrue(differentCaseSupersetName.isSimilar(differentCaseSubsetName2));
	}

	private void testDifferentCasingNames() throws IllegalValueException {
		Name differentCaseName1 = new Name("jAY cHOU");
		Name differentCaseName2 = new Name("Jay Chou");

		assertTrue(differentCaseName1.isSimilar(differentCaseName2));
		assertTrue(differentCaseName2.isSimilar(differentCaseName1));
	}

	private void testSupersetSubsetNames() throws IllegalValueException {
		Name supersetName = new Name("Jay Chou Zhou");
		Name subsetName = new Name("Jay Chou");
		
		assertTrue(subsetName.isSimilar(supersetName));
		assertTrue(supersetName.isSimilar(subsetName));
	}

	private void testSameFullName() throws IllegalValueException {
		Name name1 = new Name("Jane Eyre");
		Name name2 = new Name("Jay Chou");
		Name name3 = new Name("Jay Chou");
		
		assertFalse(name1.isSimilar(name2));
		assertTrue(name1.isSimilar(name1));

		assertTrue(name2.isSimilar(name3));
	}
}