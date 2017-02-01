package seedu.addressbook.ui;

public class Formatter {
	/** A decorative string added to the beginning or end of lines printed by AddressBook */
    private String _decorator;
    
    public Formatter(String decorator){
    	_decorator = decorator;
    }
    
    public String addPrefix(String str){
    	return _decorator + str;
    }
    
    public String addPostfix(String str){
    	return str + _decorator;
    }
}