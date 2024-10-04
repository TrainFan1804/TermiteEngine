package de.o.le.termiteengine.engine.instance.event;

import de.o.le.termiteengine.engine.instance.dialogue.InstanceNPC;

/**
 * This may be talk event but is **NOT** a subtype of {@link TalkEvent}!
 * <p>
 * Important: internally this class will use the same id as the TalkEvent so you
 * can't add both classes in the same instance.
 * <p>
 * Right now this event provide just something where the user can get new information
 * about the game itself. In a further version they could things happen when the
 * user choose a specific response.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.3.0-1
 */
public final class NPCTalkEvent extends InstanceEvent {

	private final InstanceNPC npc;
	private boolean wasLoad;

	/**
	 * Create a new NPCTalkEvent instance.
	 * <p>
	 * Add support for multiple npc's.
	 * 
	 * @param npc The npc that is contained in the event.
	 */
	public NPCTalkEvent(InstanceNPC npc) {

		super(InstanceEventType.TALK_EVENT);
		this.npc = npc;
		this.wasLoad = false;
	}

	@Override
	public void startEvent() {

		// make sure the dialog is only load once!
		if (!this.wasLoad) {

			this.npc.loadDialogue();
		 	this.wasLoad = true;
		}

		this.npc.startDialog();
	}
}
