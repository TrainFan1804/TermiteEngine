package de.o.le.termiteengine.api;

import de.o.le.termiteengine.internal.instance.dialogue.InstanceNPC;
import de.o.le.termiteengine.internal.instance.event.GoEvent;
import de.o.le.termiteengine.internal.instance.event.ISearch;
import de.o.le.termiteengine.internal.instance.event.ITalk;
import de.o.le.termiteengine.internal.instance.event.IUse;
import de.o.le.termiteengine.internal.instance.event.InstanceEvent;
import de.o.le.termiteengine.internal.instance.event.LeaveEvent;
import de.o.le.termiteengine.internal.instance.event.NPCTalkEvent;
import de.o.le.termiteengine.internal.instance.event.SearchEvent;
import de.o.le.termiteengine.internal.instance.event.TalkEvent;
import de.o.le.termiteengine.internal.instance.event.UseEvent;

/**
 * To add a event to a {@link Instance} you can use this factory class to create
 * all events easily. 
 * <p>
 * TODO I am not really happy how this class look like at the moment. I need to
 * find a way to satisfy my desire!
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-4
 */
public class EventFactory {

	public static final EventFactory FACTORY = new EventFactory();

	public InstanceEvent create(ITalk talk) { return new TalkEvent(talk); }

	public InstanceEvent create(InstanceNPC npc) { return new NPCTalkEvent(npc); }

	public InstanceEvent create(ISearch search) { return new SearchEvent(search); }
		
	public InstanceEvent create(IUse use) { return new UseEvent(use); }

	public InstanceEvent createGoEvent() { return new GoEvent(); }

	public InstanceEvent createLeaveEvent() { return new LeaveEvent(); }

	private EventFactory() { }
}
