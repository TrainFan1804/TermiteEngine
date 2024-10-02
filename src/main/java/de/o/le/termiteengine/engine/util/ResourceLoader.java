package de.o.le.termiteengine.engine.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author o.le
 * @version 1.1
 * @since 1.4.5
 */
public final class ResourceLoader {

	public static File loadRes(Class<?> classPath, String fileName) {

		URL url = classPath.getResource(fileName);
		File res = null;

		try {

			res = new File(url.toURI());
		} catch (URISyntaxException ex) {

			// this is bad
			throw new RuntimeException("This should never be thrown..");
		}

		return res;
	}

	private ResourceLoader() { }
}
