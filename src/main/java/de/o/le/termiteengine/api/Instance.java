package de.o.le.termiteengine.api;

import de.o.le.termiteengine.engine.instance.InstanceCore;
import de.o.le.termiteengine.engine.instance.event.GoEvent;
import de.o.le.termiteengine.engine.instance.event.LeaveEvent;

/**
 * A instance can be build via the {@link InstanceBuilder},
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-5
 */
public class Instance {

	private final InstanceCore CORE;

	Instance(InstanceCore core) {

		this.CORE = core;
	}

	/**
	 * Set the next instance of the instance. Will set the {@link GoEvent}
	 * automatically. Can only set <b>once</b>!
	 * 
	 * @param next The next instance.
	 */
	public void setNext(Instance next) {

		this.CORE.setNextInstance(next.getCore());
	}

	/**
	 * Set the previous instance of the instance. Will set the {@link LeaveEvent}
	 * automatically. Can only set <b>once</b>!
	 * 
	 * @param pre the previous instance.
	 */
	public void setPre(Instance pre) {

		this.CORE.setPreInstance(pre.getCore());
	}

	InstanceCore getCore() { return this.CORE; }
}
