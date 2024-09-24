package engine.instance.dialog;

import com.fasterxml.jackson.databind.ObjectMapper;
import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author o.le
 * @version 1.0
 * @since 1.3.0-pre
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

	public void loadDialog() {

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			this.dialogue = objectMapper.readValue(new File(this.JSON_PATH), Dialogue.class);
		} catch (IOException ex) {

			ApplicationResources.OUT.printError(ex);
		}	
	}

	public void startDialog() {

		// TODO now I need to implement right output and input handling

		/*
			First prototype. This works perfectly when the user
			would enter always the corrent input
		*/
		List<DialogueNode> tree = this.dialogue.dialogueTree;
		DialogueNode current = tree.getFirst();
		do {

			ApplicationResources.OUT.printString(current.npcLine);
			ApplicationResources.OUT.printMessage(MessageType.MSG_TALK_RESPONSE_CHOICE);

			List<PlayerResponse> playerResponse = current.playerLine;
			for (int responseCount = 0; 
				responseCount < playerResponse.size(); 
				responseCount++) {

				ApplicationResources.OUT.printString((responseCount + 1) 
									+ ": "
									+ playerResponse.get(responseCount).playerText);
			}

			/*
				Make this is an int read an catch exception that is
				thrown when enter something wrong and print error
				message and then ask again
			 */

			String choice = ApplicationResources.IN.read();
			int iChoice = Integer.parseInt(choice);
			int pChoice = playerResponse.get(iChoice - 1).nextNpcLine - 1;
			if (pChoice < 0) break;
			current = tree.get(pChoice);
			System.out.println();

		} while(current != null);

		// TODO print out current instance?
	}
}
