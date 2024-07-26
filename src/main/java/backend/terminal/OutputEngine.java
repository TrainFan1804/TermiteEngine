package backend.terminal;

/**
 * This is a class that provide different static method to print something to 
 * the terminal. The output will be automaticly formated.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.4
 */
public final class OutputEngine {

    private OutputEngine() {}

    /**
     * Print a normal message to the screen.
     * 
     * @param msg                       The printed message.
     */
    public static void printMessasgeToTerminal(String msg) {

        System.out.println(msg);
    }

    /**
     * Print a error message to the screen.
     * 
     * @param msg                       The printed message.
     */
    public static void printErrorToTerminal(String msg) {

        System.err.println(msg);
    }
}
