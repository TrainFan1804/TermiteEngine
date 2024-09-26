package api;

import engine.instance.Instance;
import engine.instance.event.InstanceEvent;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
public class InstanceBuilder {

	private Instance instance;

	public InstanceBuilder() {

		this(InstanceIdCounter.ENTITY.getIdCount());
	}

	public InstanceBuilder(int id) {

		this.instance = new Instance(id);
	}

	public InstanceBuilder withEvent(InstanceEvent event) {

		this.instance.addEvent(event);
		return this;
	}

	public InstanceBuilder withNext(Instance next) {

		this.instance.setNextInstance(next);
		return this;
	}

	public InstanceBuilder withPrev(Instance prev) {

		this.instance.setPreInstance(prev);
		return this;
	}

	public Instance build() {

		return this.instance;
	}
}
