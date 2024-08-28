package engine.core.subsystems.utils;

import java.io.File;

/**
 * @author 								o.le
 * @version 							1.0
 * @since								0.40
 */
public class FileConnection {
	
	private File file; 

	public FileConnection(String path) {

		this.file = new File(path);
	}

	public File getConnection() { return this.file; }
}
