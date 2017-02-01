package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.ui.Formatter;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

/**
 * Text UI of the application.
 */
public class TextUi {

    private static final String DIVIDER = "===================================================";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final PrintStream out;

    private Formatter _formattor;

    public TextUi() {
        this(System.out);
        _formattor = new Formatter();
    }

    public TextUi(PrintStream out) {
        this.out = out;
        _formattor = new Formatter();
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
    	String fullInputLine = _formattor.getUserCommand();
        showToUser(_formattor.getCommandPrompt(fullInputLine));
        return fullInputLine;
    }


    public void showWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = _formattor.getStorageFileInfo(storageFilePath);
        showToUser(_formattor.getWelcomeMessage(version, storageFileInfo));
    }

    public void showGoodbyeMessage() {
        showToUser(_formattor.getGoodbyeMessage());
    }


    public void showInitFailedMessage() {
        showToUser(_formattor.getInitFailedMessage());
    }

    /** Shows message(s) to the user */
    public void showToUser(String... message) {
        for (String m : message) {
        	out.println(_formattor.formatShowToUser(m));
        }
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        if (resultPersons.isPresent()) {
            showPersonListView(resultPersons.get());
        }
        showToUser(result.feedbackToUser, DIVIDER);
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private void showPersonListView(List<? extends ReadOnlyPerson> persons) {
        showToUserAsIndexedList(_formattor.getFormattedPersons(persons));
    }

    /** Shows a list of strings to the user, formatted as an indexed list. */
    private void showToUserAsIndexedList(List<String> list) {
        showToUser(_formattor.getIndexedListForViewing(list));
    }


}
