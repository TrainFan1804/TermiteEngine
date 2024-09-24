package engine.instance.dialog;

import java.util.List;

/**
 * @author o.le
 * @versin 1.0
 * @since 1.3.0-pre
 */
final class DialogueNode {
	
	private int dialogueId;
	private String npcLine;
	private List<PlayerResponse> playerLine;

	public int getDialogueId() { return this.dialogueId; }

	public String getNpcLine() { return this.npcLine; }

	public List<PlayerResponse> getPlayerLine() { return this.playerLine; }
}
