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
 * @version                             1.0
 * @since                               0.36
 */
public class OutputService {

    private final String format;

    public OutputService() { 

		this.format = ""; 
	} 

    public OutputService(String format) {

        this.format = format.strip() + " ";
    }

	public void printString(String str) {

		this.printWithFormat(str);
	}

    public void printMessage(Message msg) {

        this.printWithFormat(msg.toString());
    }

	public void printMessage(MessageType type) {

		this.printMessage(MessageContainer.DISK.getMessage(type));
	}

    public void printError(Exception e) {

        this.printWithFormat(e.getLocalizedMessage());
    }

    private void printWithFormat(String msg) {

        System.out.println(this.format + msg);
    }
}
