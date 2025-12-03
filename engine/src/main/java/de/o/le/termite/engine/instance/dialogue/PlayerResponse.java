package de.o.le.termite.engine.instance.dialogue;

/**
 * A player response contains the text the player is saying and a id to the next
 * {@link DialogueNode}.
 * 
 * @author o.le
 * @version 2.0
 * @since 1.3.0-1
 */
final class PlayerResponse {
	
	public String playerText;
	public int nextNpcLine;
}