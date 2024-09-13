package engine.core.subsystems.filesystem.utils;

import java.io.File;

/**
 * @deprecated will be removed in a further version
 * 
 * @author 								o.le
 * @version 							1.0
 * @since								0.40
 */
@Deprecated(since = "1.1.0")
public class FileConnection {
	
	private static final String EXTENSION = ".json";

	private File file; 

	public FileConnection(String path) { 

		
		this.file = new File(path + EXTENSION);
	}

	public File getConnection() { return this.file; }
}
