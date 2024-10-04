package de.o.le.termiteengine.engine.instance.dialogue;

import java.util.List;

/**
 * A dialogue is internally build like a tree data structure. The root of each
 * node is a {@link DialogueNode} and the children {@link PlayerResponse}.
 * <p>
 * This doesn't need to be implemented by hand because {@link InstanceNPC} will
 * create the tree with the help of a dialogue.json file. See more in the
 * InstanceNPC class.
 * 
 * @author o.le
 * @version 2.0
 * @since 1.3.0-1
 */
final class Dialogue {

	public List<DialogueNode> dialogueTree;
}
