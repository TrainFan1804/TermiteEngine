package engine.core.services.output;

/**
 * This is the output service. This class is used when something is printed to
 * the terminal.
 * <p>
 *     Right now just the {@link Application} use this and the developer need
 *     to implement the wanted output on his own with {@code System.out.print()}
 *     but later the developer shouldn't even need to do this and just let the
 *     engine cook.
 * </p>
 *
 * @author                              o.le
 * @version                             1.1
 1 @since                               0.36
 */
public class OutputService {

    	private final String FORMAT;

	/*
		TODO need to find a way to let the output be start with the format
		that was defined by the developer
	*/
    	public OutputService() { 

		this.FORMAT = ""; 
	} 

    	public OutputService(String format) {

       		this.FORMAT = format.strip() + " ";
    	}

	/**
	 * Will just print a new line.
	 */
	public void printNewLine() {

		System.out.println();
	}

    	/**
	 * Use this when you want to print a normal string with you defined format.
	 * 
	 * @param str The printed string.
	 */
	public void printString(String str) {

		this.printWithFormat(str);
	}

	/**
	 * Use this when you want to print the stored content of a {@link Message}
	 * directly.
	 * 
	 * @param msg The printed message.
	 */
    	public void printMessage(Message msg) {

        	this.printWithFormat(msg.toString());
    	}

    	/**
	 * This method is used to print out {@link MessageType}. You don't need
	 * to use this method because this is use internaly only.
	 * 
	 * @param type The printed MessageType.
	 */
	public void printMessage(MessageType type) {

		this.printMessage(MessageContainer.DISK.getMessage(type));
	}

	/**
	 * Use this method to print exception message with you defined format.
	 * 
	 * @param e The thrown exception.
	 */
    	public void printError(Exception e) {

        	this.printWithFormat(e.getLocalizedMessage());
    	}

    	/**
     	* Print the string with the defined format.
     	*/
    	private void printWithFormat(String msg) {

        	System.out.println(this.FORMAT + msg);
    	}
}
