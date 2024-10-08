package de.o.le.termite.engine.instance.dialogue;

import java.util.List;

/**
 * A dialogue node contains a id, a line that is sayed by the {@link InstanceNPC}
 * and possible responses by the player.
 * 
 * @author o.le
 * @version 2.0
 * @since 1.3.0-1
 */
final class DialogueNode {

	public int dialogueId;
	public String npcLine;
	public List<PlayerResponse> playerLine;
}
