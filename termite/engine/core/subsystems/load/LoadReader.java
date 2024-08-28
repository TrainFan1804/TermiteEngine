package engine.core.subsystems.load;

import engine.core.subsystems.utils.FileConnection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 								o.le
 * @version 							1.0
 * @since								0.41
 */
class LoadReader implements AutoCloseable {
	
	private FileReader reader;

	LoadReader(FileConnection connection) throws FileNotFoundException {

		this.reader = new FileReader(connection.getConnection());
	}

	int readFromFile() throws IOException { return this.reader.read(); }

	@Override
	public void close() throws IOException { this.reader.close(); }
}
