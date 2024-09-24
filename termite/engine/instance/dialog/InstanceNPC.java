package engine.instance.dialog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import engine.core.ApplicationResources;
import java.io.File;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.0
 * @since 1.3.0-pre
 */
public class InstanceNPC {

	private final String NAME;
	private final String JSON_PATH;

	private Dialogue dialogue;

	public InstanceNPC(String name, String pathToJson) {

		this.NAME = name;
		this.JSON_PATH = pathToJson;
	}

	public void loadDialog() {

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			this.dialogue = objectMapper.readValue(new File(this.JSON_PATH), Dialogue.class);
		} catch (IOException ex) {

			ApplicationResources.OUT.printError(ex);
		}	
	}

	public void startDialog() {

		// dialogue can be read from file
		// TODO now I need to implement right output and input handling
		for (var v :dialogue.getDialogueTree()) {

			System.out.println("id: " + v.getDialogueId());
			System.out.println("npc line: " + v.getNpcLine());
			for (var j : v.getPlayerLine()) {

				System.out.println("player line: " + j.getPlayerText());
				System.out.println("next line: " + j.getNextNpcLine());
			}
		}
	}
}
