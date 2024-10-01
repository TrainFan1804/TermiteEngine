package de.o.le.termiteengine.engine.instance.dialogue;

import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.filesystem.JsonLoader;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * TODO implement some oop
 * 
 * @author o.le
 * @version 1.1
 * @since 1.3.0-1
 */
public class InstanceNPC {

	private final String NAME;
	private final String JSON_PATH;

	private Dialogue dialogue;

	/*
		This isn't good because the path could be incorrect, the json
		could be in a wrong format. This would throw a runtime exception
		and this isn't very good
	*/
	public InstanceNPC(String name, String pathToJson) {

		this.NAME = name;
		this.JSON_PATH = pathToJson;
	}

	/*
		This method is called during runtime. That's fine but the JSON
		should be checked during compile time.
	*/
	public void loadDialogue() {

		JsonLoader loader = new JsonLoader();
		try {

			this.dialogue = loader.loadFileValue(new File(this.JSON_PATH), Dialogue.class);
		} catch (IOException e) {

			EngineResources.INSTANCE.OUT.printError(e);
		}	
	}

	public void startDialog() {

		final EngineResources RES = EngineResources.getInstance();

		List<DialogueNode> tree = this.dialogue.dialogueTree;
		DialogueNode current = tree.getFirst();
		do {

			RES.OUT.printString(current.npcLine);
			RES.OUT.printMessage(MessageType.MSG_TALK_RESPONSE_CHOICE);

			List<PlayerResponse> playerResponse = current.playerLine;
			for (int responseCount = 0; 
				responseCount < playerResponse.size(); 
				responseCount++) {

				RES.OUT.printString((responseCount + 1) 
									+ ": "
									+ playerResponse.get(responseCount).playerText);
			}

			int inputChoice = 0;
			inputChoice = RES.IN.readInt(0, playerResponse.size()) - 1;

			int nextNpcLineId = playerResponse.get(inputChoice).nextNpcLine - 1;
			/* 
				nextNpcLineId is -1 when nextNpcLine is set with 
				null in the JSON. null represent the last dialog
				line!
			 */
			if (nextNpcLineId <= 0) break;
			current = tree.get(nextNpcLineId);
			RES.OUT.printNewLine();
		} while(current != null);
	}
}
