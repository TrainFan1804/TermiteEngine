package backend.terminal;

/**
 * This is a class that provide different static method to print something to 
 * the terminal. The output will be automaticly formated.
 * 
 * @author                              o.le
 * @version                             1.3
 * @since                               0.4
 */
public final class OutputEngine {

    private OutputEngine() {}

    /**
     * Print a normal message to the screen.
     * 
     * @param msg                       The printed message.
     */
    public static void printMessasge(Message msg) {

        System.out.println(">>" + msg.toString());
    }

    /**
     * Print a error message to the screen.
     * 
     * @param msg                       The printed message.
     */
    public static void printErrorToTerminal(String msg) {

        System.err.println("[Error] " + msg);
    }
}
