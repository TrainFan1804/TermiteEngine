package termite.backend.commands;

// java import
import java.util.Arrays;
import java.util.List;

/**
 * These are the keyword that are available for the user to communicate with
 * the game through the front end.
 * 
 * @author                              o.le
 * @version                             1.5
 * @since                               0.13
 */
public enum CommandType {
    
    SAVE(true),
    LOAD(true),
    EXIT(true),
    HELP(true),

    INV(false),
    MAP(false),

    TALK(false),
    SEARCH(false), 
    USE(false),
    GO(false),
    LEAVE(false);

    public final boolean isEngineCommand;

    CommandType(boolean isEngineCommand) {

        this.isEngineCommand = isEngineCommand;
    }

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
