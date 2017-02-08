package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

public class Tagging{
	// Types of Tagging
	public enum TaggingType {ADD, DELETE};
	
	private Person _person;
	private Tag _tag;
	private TaggingType _taggingType;
	
	public Tagging(Person person, Tag tag, TaggingType taggingType){
		_person = person;
		_tag = tag;
		_taggingType = taggingType;
	}
}