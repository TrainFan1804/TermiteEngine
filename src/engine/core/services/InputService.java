package engine.core.services;

import engine.core.EngineResources;
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
 * @version                             1.2
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

		return this.readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * This will read a integer from the terminal with checking of the entered
	 * integer is between {@code lowBound} and {@code upBound}. Only when the
	 * integer are between both arguments the input will be returned!
	 * 
	 * @param lowBound 	The lower bound that is valid (Not included).
	 * 			E.g. lowBound = 5 and input = 5 will <b>not</b>
	 * 			returned!
	 * @param upBound	The upper bound of a valid input. See {@code lowBound}.
	 */
	public int readInt(int lowBound, int upBound) {

		int input = 0;
		boolean isValid = false;

		do {

			try {

				String str = this.read();
				input = Integer.parseInt(str);

				if (input <= lowBound
					|| input > upBound)
						throw new InputMismatchException();

				isValid = true;
			} catch(NumberFormatException | InputMismatchException ex) {

				EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_WRONG_INPUT);
			}
		} while(!isValid);

		return input;
	}
}
