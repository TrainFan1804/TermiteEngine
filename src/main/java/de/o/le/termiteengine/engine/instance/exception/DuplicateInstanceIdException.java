package de.o.le.termiteengine.engine.instance.exception;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.5
 */
public class DuplicateInstanceIdException extends RuntimeException {

	public DuplicateInstanceIdException(int id) {

		super("The id " + id + " is already present. Can't have duplicated id's!");
	}
}
