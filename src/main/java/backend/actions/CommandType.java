package backend.actions;

// java import
import java.util.Arrays;
import java.util.List;

/**
 * These are the keyword that are available for the user to communicate with
 * the game through the terminal.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.2
 */
public enum CommandType {

    SAVE, LOAD, EXIT,

    INV, MAP, HELP,
    
    TALK, SEARCH, USE, GO, LEAVE;

    /**
     * Get all keywords in a list.
     * 
     * @return                          The list with the keywords.
     */
    static List<CommandType> getKeywordList() {

        CommandType[] keywords = CommandType.values();
        return Arrays.asList(keywords);
    }
}
