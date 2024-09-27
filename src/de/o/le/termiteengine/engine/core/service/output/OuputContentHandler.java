package de.o.le.termiteengine.engine.core.service.output;

import java.util.Map;

/**
 * @author o.le
 * @version 1.0
 * @since 1.1.0
 */
public class OuputContentHandler {

	public static void init(String path) {
		
		MessageContentReader reader = new MessageContentReader();
		MessageContentConverter converter = new MessageContentConverter();
		Map<MessageType, Message> content = converter.convert(reader.read(path));

		MessageContainer.DISK.setMessages(content);
	}

	private OuputContentHandler() { }
}
