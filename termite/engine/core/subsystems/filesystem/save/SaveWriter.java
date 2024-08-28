package engine.core.subsystems.filesystem.save;

import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
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

	void writeIdToFile(SaveGame save) throws IOException { 
		
		StringBuilder sb = new StringBuilder();
		sb.append(save.getInstanceId())
			.append("\n")
			.append(save.getFormatDate());

		this.writer.write(sb.toString());
	}

	@Override
	public void close() throws IOException {

		this.writer.close();
	}
}
