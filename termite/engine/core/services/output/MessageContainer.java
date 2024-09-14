package engine.core.services.output;

import java.util.Map;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.0
 */
class MessageContainer {
	
	static final MessageContainer DISK = new MessageContainer();

	private Map<MessageType, Message> content;

	private MessageContainer() { }

	
	void setMessages(Map<MessageType, Message> content) {

		this.content = content;
	}

	Message getMessage(MessageType type) { return this.content.get(type); }
}
