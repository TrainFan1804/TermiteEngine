package de.o.le.termite.engine.filesystem;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Will load engine resources that are in the resource folder.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.4.5
 */
public final class ResourceLoader {

	/**
	 * Load a file from the resources.
	 * 
	 * @param classPath The class that want access his resources.
	 * @param fileName The name of the file the class want to load.
	 * @return The file that is loading.
	 */
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

	/**
	 * Private constructor.
	 */
	private ResourceLoader() { }
}
