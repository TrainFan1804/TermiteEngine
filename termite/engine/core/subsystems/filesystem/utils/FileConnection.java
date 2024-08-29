package engine.core.subsystems.filesystem.utils;

import java.io.File;

/**
 * @author 								o.le
 * @version 							1.0
 * @since								0.40
 */
public class FileConnection {
	
	private static final String EXTENSION = ".json";

	private File file; 

	public FileConnection(String path) {

		
		this.file = new File(path + EXTENSION);
	}

	public File getConnection() { return this.file; }
}
