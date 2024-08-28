package engine.core.subsystems.save;

import java.io.File;

/**
 * @author 								o.le
 * @version 							1.0
 * @since								0.40
 */
class FileConnection {
	
	private File file; 

	FileConnection(String path) {

		this.file = new File(path);
	}

	File getConnection() { return this.file; }
}
