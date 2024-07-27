package backend.terminal;

// java import
import java.io.InputStream;
import java.util.Scanner;
import java.util.InputMismatchException;
// custom import
import backend.TermiteSettings;
import backend.actions.CommandType;

import static backend.terminal.OutputEngine.printErrorToTerminal;

/**
 * 
 * <p>
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             1.5
 * @since                               0.2
 */
class InputEngine {

    // changable input streams
    public static InputStream inputStream = TermiteSettings.DEFAULT_INPUT;
    private static InputEngine engine;

    private Scanner input;

    public static InputEngine getEngine() {

        if (engine == null) {

            engine = new InputEngine();
        }

        return engine;
    }

    private InputEngine() {

        this.input = new Scanner(inputStream);
    }

    /**
     * Listen to the terminal to read the next command the user is enter.
     *  
     * @return                          The keyword the user entered.
     */
    CommandType commandInput() {

        String inString;
        CommandType inKeyword = null;
        do {

            inString = this.input.next();
            try {

                inKeyword = CommandType.valueOf(inString.toUpperCase());
            } catch (IllegalArgumentException e) {

                System.out.println("Invalid input");
            }
        } while(inKeyword == null);

        return inKeyword;
    }

    public int intInput() {

        boolean isValid = false;
        int scan = 0;

        do {
            
            try {
    
                scan = this.input.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
    
                printErrorToTerminal("Wrong input! Please try again.");
            }
        } while(!isValid);

        return scan;
    }

    public String strInput() {

        return this.input.next();
    }
}
