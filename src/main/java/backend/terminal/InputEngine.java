package backend.terminal;

// java import
import java.util.Scanner;

import backend.actions.CommandType;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.2
 */
class InputEngine {

    private Scanner input;

    InputEngine() {

        this.input = new Scanner(System.in);
    }

    /**
     * Listen to the terminal to read the next command the user is enter.
     *  
     * @return                          The keyword the user entered.
     */
    CommandType commandInput() {

        String inString;
        CommandType inKeyword;
        do {

            inString = this.input.next();
            try {

                inKeyword = CommandType.valueOf(inString.toUpperCase());
            } catch (IllegalArgumentException e) {

                System.out.println("Invalid input");
                inKeyword = null;   // TODO I don't like this line
            }

        } while(inKeyword == null);

        return inKeyword;
    }
}
