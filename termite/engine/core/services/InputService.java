package engine.core.services;

import java.util.Scanner;

/**
 * This is the input service. This class is used when the player need to enter
 * something in the terminal.
 * <p>
 *     The developer doesn't need to use this class because the engine handle
 *     the input on his own.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.36
 */
public class InputService {

    private final Scanner in;

    public InputService() {

        this.in = new Scanner(System.in);
    }

    public String read() {

        return this.in.next();
    }
}
