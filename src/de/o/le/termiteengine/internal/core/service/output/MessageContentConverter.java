package de.o.le.termiteengine.internal.core.service.output;

import java.util.HashMap;
import java.util.Map;

/**
 * Because {@link MessageContentReader.read(String)} return a Map were {@code key}
 * and {@code value} are strings the map must be converted into something that
 * can be used by the engine.
 * 
 * @author o.le
 * @version 1.2
 * @since 1.1.0
 */
class MessageContentConverter {

	Map<MessageType, Message> convert(Map<String, String> map) {

		Map<MessageType, Message> formatMap = new HashMap<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			
			MessageType key = MessageType.valueOf(entry.getKey());
			Message value = new Message(entry.getValue());
			formatMap.put(key, value);
		}

		return formatMap;
	}
}
