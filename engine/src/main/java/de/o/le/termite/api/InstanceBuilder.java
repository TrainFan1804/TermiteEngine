package de.o.le.termite.api;

import de.o.le.termite.engine.core.service.output.Message;
import de.o.le.termite.engine.instance.InstanceCore;
import de.o.le.termite.engine.instance.InstanceBuilderCore;
import de.o.le.termite.engine.instance.event.InstanceEvent;
import de.o.le.termite.engine.util.ToBeImplemented;

/**
 * This builder class will help you define your own {@link Instance} easily.
 * <p>
 * A instance can have multiple {@link InstanceEvent}. A event is something that
 * will execute a behavior that was defined by the developer.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.4.0-3
 */
public class InstanceBuilder {

	private final InstanceBuilderCore CORE;

	/**
	 * Create a simple InstanceBuilder instance. You can create
	 * one instance and use the instance multiple times.
	 */
	public InstanceBuilder() {

		this.CORE = new InstanceBuilderCore();
	}

	/**
	 * Will set the id of your created instance.
	 * <p>
	 * <b>Caution</b>: You need to make sure you don't add the same id
	 * two times because that can lead to unexpected behavior. If you
	 * don't want to handle the id's on your own use 
	 * {@link InstanceBuilder#withId(InstanceIdCounter)} instead.
	 * 
	 * @param id The id that is set to your instance.
	 */
	public InstanceBuilder withId(int id) {

		this.CORE.withId(id);
		return this;
	}

	/**
	 * Will set the id of your created instance.
	 * <p>
	 * When using {@link InstanceIdCounter} to manage the instance id's
	 * don't use {@link InstanceBuilder#withId(int)} anymore because that
	 * can lead to unexpected behavior when you don't know what you are
	 * doing!
	 * 
	 * @param counter The counter that will set the id of the instance.
	 */
	@ToBeImplemented(message = "May be replaced by an method without a paramter"
		+ " so you don't need to create a counter instance by hand")
	public InstanceBuilder withId(InstanceIdCounter counter) {

		this.CORE.withId(counter.getIdCount());
		return this;
	}

	/**
	 * Will set the {@link Message} that is displayed when enter a instance.
	 * <p>
	 * When you don't use this method the instance will be initialize with 
	 * a pre defined message. <b>That is properly NOT what you want!</b>
	 *  
	 * @param msg The message that is added to your instance.
	 */
	public InstanceBuilder withMessage(Message msg) {

		this.CORE.withMessage(msg);
		return this;
	}

	/**
	 * Will add a {@link InstanceEvent} to your instance.
	 * <p>
	 * When you don't use this method the instance will be initialize without
	 * any event. So the player can't do anything in it.
	 * 
	 * @param event The event that is added to your instance.
	 */
	public InstanceBuilder withEvent(InstanceEvent event) {

		this.CORE.withEvent(event);
		return this;
	}

	/**
	 * You will rather set the next instance {@link Instance#setNext(Instance)}.
	 * 
	 * @param next Will set the next instance to the created instance.
	 */
	@ToBeImplemented
	public InstanceBuilder withNext(InstanceCore next) {

		this.CORE.withNext(next);
		return this;
	}

	/**
	 * You will rather set the previous instance {@link Instance#setPre(Instance)}.
	 * 
	 * @param pre Will set the previos instance to the created instance.
	 */
	@ToBeImplemented
	public InstanceBuilder withPrev(InstanceCore pre) {

		this.CORE.withPrev(pre);
		return this;
	}

	/**
	 * Will return the instance that you build. Will reset the builder so you
	 * can build a new instance with the same builder instance.
	 * 
	 * @return The created instance.
	 */
	public Instance build() {

		Instance instance = new Instance(this.CORE.build());
		return instance;
	}
}
