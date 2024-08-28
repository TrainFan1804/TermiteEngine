package engine.core.subsystems.save;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 								o.le
 * @version 							1.0
 * @since								0.40
 */
class SaveWriter implements AutoCloseable {
	
	private FileWriter writer;

	SaveWriter(FileConnection connection) throws IOException {

		this.writer = new FileWriter(connection.getConnection());
	}

	void writeIdToFile(int id) throws IOException { this.writer.write(id); }

	@Override
	public void close() throws IOException {

		this.writer.close();
	}
}
