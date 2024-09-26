package engine.core.subsystems.filesystem.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import engine.core.ApplicationResourcesSingleton;
import java.util.Date;

/**
 * This class contains all the information that is write to the save game.
 * A save game will store the current instance and a formate time stamp.
 * 
 * @author 								o.le
 * @version 							1.0
 * @since								0.42
 */
public final class SaveGame {

	public static SaveGame generateSaveGame() { return new SaveGame(); }

	private final int instanceId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd_HH:mm:ss")
	private final Date dateStamp;
	
	private SaveGame() {

		this.instanceId = ApplicationResourcesSingleton.INSTANCE.GAME.getCurrentInstanceId();
		this.dateStamp = new Date();
	}
	
	public int getInstanceId() { return this.instanceId; }

	public Date getDateStamp() { return this.dateStamp; }
}
