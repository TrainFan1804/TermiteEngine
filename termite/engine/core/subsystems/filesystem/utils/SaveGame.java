package engine.core.subsystems.filesystem.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import engine.core.ApplicationResources;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains all the information that is write to the save game.
 * A save game will store the current instance and a formate time stamp.
 * 
 * @author 								o.le
 * @version 							1.0
 * @since								0.42
 */
public class SaveGame {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-mm-dd_hh-mm-ss");

	public static SaveGame generateSaveGame() { return new SaveGame(); }

	private final int instanceId;
	private final Date date;
	
	private SaveGame() {

		this.instanceId = ApplicationResources.GAME.getCurrentInstanceId();
		this.date = new Date();
	}
	
	public int getInstanceId() { return this.instanceId; }

	public String getFormatDate() { return FORMAT.format(this.date); }
}
