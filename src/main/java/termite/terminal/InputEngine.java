package termite.terminal;

// java import
import java.util.Scanner;

/**
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.13
 */
final class InputEngine {

    private static final InputEngine engine = new InputEngine();
    
    private Scanner scanner;

    static InputEngine getEngine() {

        return engine;
    }

    private InputEngine() {

        this.scanner = new Scanner(System.in);
    }

    public String strInput() {

        return this.scanner.next();
    }
}
