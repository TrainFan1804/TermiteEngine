package de.o.le.termiteengine.engine.core.service.output;

import java.util.Map;

/**
 * Because the file with the output content is only loaded once during runtime
 * the data must be saved in a way to access those values easily.
 * <p>
 * Because the file is loaded before the game start the game could load a bit
 * longer. Especially in a future version where more customizable options are
 * available.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.1.0
 */
class MessageContainer {
	
	/**
	 * Because this is only used in {@link OutputService} this is totally
	 * fine that the field is package default.
	 */
	static final MessageContainer DISK = new MessageContainer();

	private Map<MessageType, Message> content;

	/**
	 * Private constructor. Use the DISK field for access.
	 */
	private MessageContainer() { }

	/**
	 * Set the custom content.
	 * 
	 * @param content The custom content.
	 */
	void setMessages(Map<MessageType, Message> content) {

		this.content = content;
	}

	/**
	 * Get the message that is mapped to the given type.
	 * 
	 * @param type The type of the message that should be printed.
	 * @return The message that belong to the given type.
	 */
	Message getMessage(MessageType type) { return this.content.get(type); }
}
