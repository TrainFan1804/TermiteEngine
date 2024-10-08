package de.o.le.termite.api;

import de.o.le.termite.engine.instance.dialogue.InstanceNPC;
import de.o.le.termite.engine.instance.event.GoEvent;
import de.o.le.termite.engine.instance.event.ISearch;
import de.o.le.termite.engine.instance.event.ITalk;
import de.o.le.termite.engine.instance.event.IUse;
import de.o.le.termite.engine.instance.event.InstanceEvent;
import de.o.le.termite.engine.instance.event.LeaveEvent;
import de.o.le.termite.engine.instance.event.NPCTalkEvent;
import de.o.le.termite.engine.instance.event.SearchEvent;
import de.o.le.termite.engine.instance.event.TalkEvent;
import de.o.le.termite.engine.instance.event.UseEvent;

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
