package de.o.le.termite.engine.instance.exception;

/**
 * When you want to add a instance with the same id this exception will be thrown.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.2.5
 */
public class DuplicateInstanceIdException extends RuntimeException {

	/**
	 * Throw a new exception.
	 * 
	 * @param id The id that you want to add a second time.
	 */
	public DuplicateInstanceIdException(int id) {

		super("The id " + id + " is already present. Can't have duplicated id's!");
	}
}
