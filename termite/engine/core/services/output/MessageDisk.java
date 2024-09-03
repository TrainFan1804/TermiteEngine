package engine.core.services.output;

import engine.instance.Message;
import java.util.HashMap;
import java.util.Map;

/**
 * @author o.le
 * @version 1.0
 * @since 2.0.0
 */
public class MessageDisk {
	
	private static final MessageDisk DISK = new MessageDisk();

	public static MessageDisk getMessageDisk() { return DISK; }

	private Map<MessageType, Message> content = new HashMap<>();

	private MessageDisk() { }

	public void addMessage(MessageType type, String msg) {

		this.content.put(type, new Message(msg));
	}
	
	public Message getMessage(MessageType type) {

		return this.content.get(type);
	}
}
