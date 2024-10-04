package de.o.le.termiteengine.engine.core.service.output;

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

	/**
	 * Will map the returned map from {@link MessageContentReader#read(java.io.File) } to a new
	 * map that map the given map correctly for easy use.
	 * <p>
	 * I could merge the two methods but I don't know yet.
	 * 
	 * @param map The mapped values from the loaded output file.
	 * @return A map with better type convention.
	 */
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
