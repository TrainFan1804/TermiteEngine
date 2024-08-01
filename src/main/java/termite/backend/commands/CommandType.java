package termite.backend.commands;

// java import
import java.util.Arrays;
import java.util.List;

/**
 * These are the keyword that are available for the user to communicate with
 * the game through the front end.
 * 
 * @author                              o.le
 * @version                             1.6
 * @since                               0.13
 */
public enum CommandType {
    
    SAVE,
    LOAD,
    EXIT,
    HELP,

    INV,
    MAP,

    TALK,
    SEARCH, 
    USE,
    GO,
    LEAVE;

    /**
     * Get all keywords in a list.
     * 
     * @return                          The list with the keywords.
     */
    public static List<CommandType> getKeywordList() {

        CommandType[] keywords = CommandType.values();
        return Arrays.asList(keywords);
    }
}
