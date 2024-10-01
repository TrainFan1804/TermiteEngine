package de.o.le.termiteengine.engine.util;

import java.io.InputStream;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.5
 */
public final class ResourceLoader {

	public static InputStream loadRes(Class<?> classPath, String fileName) {

		return classPath.getResourceAsStream(fileName);
	}

	private ResourceLoader() { }
}
