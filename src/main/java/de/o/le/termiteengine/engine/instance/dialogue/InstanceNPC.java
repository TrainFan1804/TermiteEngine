package de.o.le.termiteengine.engine.instance.dialogue;

import de.o.le.termiteengine.engine.core.EngineInputResource;
import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.filesystem.JsonLoadHandler;
import de.o.le.termiteengine.engine.filesystem.JsonValidater;
import de.o.le.termiteengine.engine.filesystem.ResourceLoader;
import de.o.le.termiteengine.engine.instance.event.NPCTalkEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * A InstanceNPC is something that can be inside of a {@link NPCTalkEvent}. The
 * ncp contains a dialogue that can help you to create simple dialogues with json
 * files that follow a specific schema.
 * <p>
 * TODO implement some oop
 * 
 * @author o.le
 * @version 1.1
 * @since 1.3.0-1
 */
public class InstanceNPC {

	private static final File SCHEME = ResourceLoader.loadRes(InstanceNPC.class, "dialogueSchema.json");

	private final String NAME;
	private final File DIALOGUE_FILE;

	private Dialogue dialogue;

	/**
	 * Create a new InstanceNPC instance.
	 * 
	 * @param name The name of the npc. Currently not used.
	 * @param pathToJson The path to the json that contains the dialogue.
	 */
	public InstanceNPC(String name, String pathToJson) {

		this.NAME = name;

		final JsonValidater val = new JsonValidater();
		final File temp = new File(pathToJson);
		val.validateJson(temp, SCHEME);

		this.DIALOGUE_FILE = temp;
	}

	/**
	 * Load the dialogue from the file that is saved in the npc instance.
	 * <p>
	 * Will only be executed once after enter a instance with the 
	 * {@link NPCTalkEvent}.
	 */
	public void loadDialogue() {

		final JsonLoadHandler loader = new JsonLoadHandler();
		try {

			this.dialogue = loader.loadFileValue(this.DIALOGUE_FILE, Dialogue.class);
		} catch (IOException e) {

			EngineOutputResource.getInstance().OUT.printError(e);
		}	
	}

	/**
	 * Start the dialogue with the npc.
	 */
	public void startDialog() {

		final EngineOutputResource RES = EngineOutputResource.getInstance();

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
			inputChoice = EngineInputResource.getInstance().IN.readInt(0, playerResponse.size()) - 1;

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
