package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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