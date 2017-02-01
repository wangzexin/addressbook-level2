package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;
import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {

	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_DECORATOR = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private final Scanner in;
    private final PrintStream out;

    public Formatter(){
        this(System.in, System.out);
    }
    
    public Formatter(InputStream in, PrintStream out){
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }
    
    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    public String addPrefix(String str){
    	return LINE_DECORATOR + str;
    }
    
    public String addPostfix(String str){
    	return str + LINE_DECORATOR;
    }

	public String formatShowToUser(String m) {
		return this.addPrefix(m.replace("\n", this.addPostfix(LS)));
	}

	public String getCommandMessage() {
		return "Enter command: ";
	}

	public String getUserCommand() {
		out.print(this.addPrefix(this.getCommandMessage()));
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        
        return fullInputLine;
	}

	public String getCommandPrompt(String fullInputLine) {
		return "[Command entered:" + fullInputLine + "]";
	}

	public String getStorageFileInfo(String storageFilePath) {
		return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
	}

	public String getWelcomeMessage(String version, String storageFileInfo) {
		return getMessagesInLines(DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
	}

	private String getMessagesInLines(String... messages) {
		if (messages.length == 0) {
			return null;
		}
		else if (messages.length == 1){
			return messages[0];
		}
		else {
			String totalMessage = "";
	        for (String message : messages) {
	        	if (totalMessage != "") {
	        		totalMessage = totalMessage + "\n";
	        	}
	        	totalMessage = totalMessage + this.formatShowToUser(message);
	        }
			return totalMessage;
		}
	}

	public List<String> getFormattedPersons(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
		return formattedPersons;
	}

    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

	public String getGoodbyeMessage() {
		return getMessagesInLines(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
	}
}