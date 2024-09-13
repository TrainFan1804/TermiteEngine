package engine.core.services.output;

import java.util.Map;

/**
 * @author o.le
 * @version 1.0
 * @since 1.1.0
 */
class MessageContainer {
	
	static final MessageContainer DISK = new MessageContainer();

	private Map<MessageType, Message> content;

	private MessageContainer() { }

	
	public void setMessages(Map<MessageType, Message> content) {

		this.content = content;
	}

	public Message getMessage(MessageType type) {

		return this.content.get(type);
	}
}
