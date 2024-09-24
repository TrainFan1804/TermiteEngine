package engine.core.services;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import java.util.InputMismatchException;
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
 * @version                             1.1
 * @since                               0.36
 */
public class InputService {

    	private final Scanner IN;

    	public InputService() {

        	this.IN = new Scanner(System.in);
    	}

	/**
	 * This method is used to read from the terminal.
	 * 
	 * @return 							When the user press {@code ENTER} this
	 * 									method will return an empty string.
	 */
    	public String read() {

        	return this.IN.nextLine();
    	}

	/**
	 * This method is used to read a integer from the terminal.
	 * 
	 * @return 			Will listen to the terminal as long as
	 * 				the user has not entered a valid type.
	 */
	public int readInt() {

		int input = 0;
		boolean isValid = false;

		do {

			try {

				input = this.IN.nextInt();
				isValid = true;
			} catch(InputMismatchException ex) {

				ApplicationResources.OUT.printMessage(MessageType.MSG_WRONG_INPUT);
				this.IN.next();	// clear invalid input from stream
						// or user can't enter anything
						// in the terminal anymore
			}
		} while(!isValid);

		System.out.println("\n\n" + input);
		return input;
	}
}
