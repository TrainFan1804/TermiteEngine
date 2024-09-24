package engine.instance.dialog;

import com.fasterxml.jackson.databind.ObjectMapper;
import engine.core.ApplicationResources;
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
		List<DialogueNode> tree = this.dialogue.DIALOGUE_TREE;
		DialogueNode current = tree.getFirst();
		do {

			ApplicationResources.OUT.printString(current.NPC_LINE);
			ApplicationResources.OUT.printString("Choose you line: ");

			List<PlayerResponse> playerResponse = current.PLAYER_LINE;
			for(PlayerResponse responses : playerResponse) {

				ApplicationResources.OUT.printString(responses.PLAYER_TEXT);
			}

			String choice = ApplicationResources.IN.read();
			int iChoice = Integer.parseInt(choice);
			System.out.println("iChoice: " + iChoice);
			int pChoice = playerResponse.get(iChoice).NEXT_NPC_LINE - 1;
			if (pChoice < 0) break;
			current = tree.get(pChoice);
			System.out.println();

		} while(current != null);
	}
}
