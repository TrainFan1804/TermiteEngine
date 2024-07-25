package backend.terminal;

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
public enum Command {

    SAVE, LOAD, EXIT,

    INV, MAP, HELP,
    
    TALK, SEARCH, USE, GO, LEAVE;


    static List<Command> getKeywordList() {

        Command[] keywords = Command.values();
        return Arrays.asList(keywords);
    }
}
