package termite.terminal;

/**
 * This is a class that provide different method to print something to 
 * the terminal. The output will be automaticly formated.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.13
 */
final class OutputEngine {

    private static final OutputEngine engine = new OutputEngine();

    public static OutputEngine getEngine() {

        return engine;
    }

    private OutputEngine() {}

    /**
     * Print a normal message to the screen.
     * 
     * @param msg                       The printed message.
     */
    public void printMessasge(String msg) {

        System.out.println(">>" + msg);
    }

    /**
     * Print a error message to the screen.
     * 
     * @param msg                       The printed message.
     */
    public void printErrorMessage(String msg) {

        System.err.println("[Error] " + msg);
    }
}
