package de.o.le.termite.engine.core.service.output;

import java.io.File;
import java.util.Map;

/**
 * This class will handle the loading process when you want to add your own custom
 * output messages.
 * <p>
 * You can <b>only</b> customize outputs for the game while it's running!
 * <p>
 * You don't need to use any of this class because this will do by the engine
 * anyway.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.1.0
 */
public class OuputContentHandler {

	/**
	 * This method will start the initialization of the loading of the custom
	 * engine output.
	 * 
	 * @param contentFile The file of the loaded content.
	 */
	public static void init(File contentFile) {
		
		MessageContentReader reader = new MessageContentReader();
		MessageContentConverter converter = new MessageContentConverter();
		Map<MessageType, Message> content = converter.convert(reader.read(contentFile));

		MessageContainer.DISK.setMessages(content);
	}

	/**
	 * Private constructor.
	 */
	private OuputContentHandler() { }
}
