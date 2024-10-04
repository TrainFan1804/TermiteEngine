package de.o.le.termiteengine.engine.instance.event;

import de.o.le.termiteengine.engine.instance.InstanceCore;

/**
 * When you want to create a talk event create an object of this type and give it
 * the {@link InstanceCore}. See {@link ITalk}
 * for more information.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public final class TalkEvent extends InstanceEvent {

    	private final ITalk talk;

    	/**
     	 * Create a new talk event with the behavior of the given
     	 * {@link ITalk}.
     	 *
     	 * @param talk                      The wanted talk behavior that should
     	 *                                  be executed when stating the talk event.
     	 */
    	public TalkEvent(ITalk talk) {

        	super(InstanceEventType.TALK_EVENT);
        	this.talk = talk;
    	}

    	@Override
    	public void startEvent() { this.talk.talk(); }
}
