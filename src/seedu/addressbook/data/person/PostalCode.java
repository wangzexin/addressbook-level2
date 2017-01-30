package seedu.addressbook.data.person;

public class PostalCode{
	private String _value;
	
	public PostalCode(String value){
		_value = value;
	}
	
	public String getPostalCode(){
		return _value;
	}
}