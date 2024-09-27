package de.o.le.termiteengine.engine.core.subsystem.filesystem.util;

import java.io.File;

/**
 * @author 								o.le
 * @version 							1.1
 * @since								0.40
 */
@Deprecated(since = "1.1.0", forRemoval = false)
public class FileConnection {
	
	private static final String EXTENSION = ".json";

	private File file; 

	public FileConnection(String path) { 

		
		this.file = new File(path + EXTENSION);
	}

	public File getConnection() { return this.file; }

	public boolean fileExists() {

		return this.file.exists();
	}
}
