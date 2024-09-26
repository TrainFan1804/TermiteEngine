package api;

import engine.instance.Instance;
import engine.instance.InstanceBuilderCore;
import engine.instance.event.InstanceEvent;

/**
 * @author o.le
 * @version 1.0
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

		this.withId(counter.getIdCount());
		return this;
	}

	public InstanceBuilder withEvent(InstanceEvent event) {

		this.CORE.withEvent(event);
		return this;
	}

	public InstanceBuilder withNext(Instance next) {

		this.CORE.withNext(next);
		return this;
	}

	public InstanceBuilder withPrev(Instance prev) {

		this.CORE.withPrev(prev);
		return this;
	}

	public Instance build() {

		return this.CORE.build();
	}
}
