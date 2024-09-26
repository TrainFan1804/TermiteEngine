package api;

import engine.instance.dialog.InstanceNPC;
import engine.instance.event.GoEvent;
import engine.instance.event.ISearch;
import engine.instance.event.ITalk;
import engine.instance.event.IUse;
import engine.instance.event.InstanceEvent;
import engine.instance.event.LeaveEvent;
import engine.instance.event.NPCTalkEvent;
import engine.instance.event.SearchEvent;
import engine.instance.event.TalkEvent;
import engine.instance.event.UseEvent;

/**
 * TODO I am not really happy how this class look like at the moment. I need to
 * find a way to satisfy my desire!
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-4
 */
public class EventFactory {

	public final EventFactory FACTORY = new EventFactory();

	public InstanceEvent create(ITalk talk) { return new TalkEvent(talk); }

	public InstanceEvent create(InstanceNPC npc) { return new NPCTalkEvent(npc); }

	public InstanceEvent create(ISearch search) { return new SearchEvent(search); }
		
	public InstanceEvent create(IUse use) { return new UseEvent(use); }

	public InstanceEvent createGoEvent() { return new GoEvent(); }

	public InstanceEvent createLeaveEvent() { return new LeaveEvent(); }

	private EventFactory() { }
}
