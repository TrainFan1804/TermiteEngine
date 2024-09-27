package engine.instance.event;

import engine.instance.dialog.InstanceNPC;

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

	public NPCTalkEvent(InstanceNPC npc) {

		super(InstanceEventType.TALK_EVENT);
		this.npc = npc;
		this.wasLoad = false;
	}

	@Override
	public void startEvent() {

		// make sure the dialog is only load once!
		if (!this.wasLoad) {

			this.npc.loadDialog();
		 	this.wasLoad = true;
		}

		this.npc.startDialog();
	}
}
