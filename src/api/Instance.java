package api;

import engine.instance.InstanceCore;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.0-5
 */
public class Instance {

	private final InstanceCore CORE;

	Instance(InstanceCore core) {

		this.CORE = core;
	}

	public void setNext(Instance next) {

		this.CORE.setNextInstance(next.getCore());
	}

	public void setPre(Instance pre) {

		this.CORE.setPreInstance(pre.getCore());
	}

	InstanceCore getCore() { return this.CORE; }
}
