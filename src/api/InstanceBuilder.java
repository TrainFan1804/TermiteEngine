package api;

import engine.core.services.output.Message;
import engine.instance.InstanceCore;
import engine.instance.InstanceBuilderCore;
import engine.instance.event.InstanceEvent;

/**
 * @author o.le
 * @version 1.1
 * @since 1.4.0-3
 */
public class InstanceBuilder {

	private final InstanceBuilderCore CORE;

	public InstanceBuilder() {

		this.CORE = new InstanceBuilderCore();
	}

	public InstanceBuilder withId(int id) {

		this.CORE.withId(id);
		return this;
	}

	public InstanceBuilder withId(InstanceIdCounter counter) {

		this.CORE.withId(counter.getIdCount());
		return this;
	}

	public InstanceBuilder withMessage(Message msg) {

		this.CORE.withMessage(msg);
		return this;
	}

	public InstanceBuilder withEvent(InstanceEvent event) {

		this.CORE.withEvent(event);
		return this;
	}

	/**
	 * You will rather set the next instance {@link Instance#setNext(api.Instance)}.
	 * 
	 * @param next
	 * @return 
	 */
	public InstanceBuilder withNext(InstanceCore next) {

		this.CORE.withNext(next);
		return this;
	}

	/**
	 * You will rather set the previous instance {@link Instance#setPre(api.Instance)}.
	 * 
	 * @param pre
	 * @return 
	 */
	public InstanceBuilder withPrev(InstanceCore pre) {

		this.CORE.withPrev(pre);
		return this;
	}

	public Instance build() {

		Instance instance = new Instance(this.CORE.build());
		return instance;
	}
}
