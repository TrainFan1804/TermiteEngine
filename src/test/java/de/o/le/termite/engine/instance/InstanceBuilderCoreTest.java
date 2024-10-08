package de.o.le.termite.engine.instance;

import annotations.TestClassInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestInformationPrinter;
import de.o.le.termite.engine.core.service.output.Message;
import de.o.le.termite.engine.instance.event.GoEvent;
import de.o.le.termite.engine.instance.event.InstanceEvent;
import de.o.le.termite.engine.instance.event.NullEvent;
import de.o.le.termite.engine.instance.event.TalkEvent;
import de.o.le.termite.engine.instance.exception.InstanceEventAlreadyPresentException;
import de.o.le.termite.engine.instance.exception.NoValidNeighborException;
import org.junit.jupiter.api.Disabled;
import annotations.TestMethodInformation;
 
/**
 * @author o.le
 * @version 1.0
 * @since 1.4.3
 */
@TestClassInformation(targetClass = InstanceBuilderCore.class)
@ExtendWith(TestInformationPrinter.class)
public class InstanceBuilderCoreTest {

	private InstanceBuilderCore builder;

    	@BeforeEach
    	public void setUp() {
	    
	    	this.builder = new InstanceBuilderCore();
    	}

	@TestMethodInformation(targetMethod = "build()",
				behavior = "When building a instance without "
					+ "using any of it's method return "
					+ "instance with default values")
    	@Test
    	public void testWithDefaultBuilder() {

		final InstanceCore TEST_INS = this.builder.build();

	    	assertTrue(TEST_INS.display().toString().contains(TEST_INS.toString()));
	    	assertNull(TEST_INS.getNextInstance());
	    	assertNull(TEST_INS.getPreInstance());
	    	assertEquals(0, TEST_INS.ID_INSTANCE);
		assertInstanceOf(NullEvent.class, TEST_INS.getEventById(0));
    	}

	@TestMethodInformation(targetMethod = "withId(int)",
				behavior = "Builder will set instance id properly")
	@Test
	public void testWithId() {
		
		final int TEST_ID = 42;
		final InstanceCore TEST_INS = this.builder
							.withId(42)
							.build();

		assertEquals(TEST_ID, TEST_INS.ID_INSTANCE);
	}

	@TestMethodInformation(targetMethod = "withMessage(Message)",
				behavior = "Builder will set message properly")
	@Test
	public void testWithMessage() {
		
		final Message TEST_MSG = new Message("This is a test message");

		final InstanceCore TEST_INS = this.builder
							.withMessage(TEST_MSG)
							.build();

		assertEquals(TEST_MSG, TEST_INS.display());
	}

	@TestMethodInformation(targetMethod = "withEvent(InstanceEvent)",
				behavior = "Builder will set event properly")
	@Test
	public void testWithEvent() {
		
		final InstanceEvent TEST_EVENT = new TalkEvent(() -> System.out.println(""));
		final int TEST_EVENT_ID = TEST_EVENT.getEventTypeId();
		
		final InstanceCore TEST_INS = this.builder
							.withEvent(TEST_EVENT)
							.build();

		
		assertEquals(TEST_EVENT, TEST_INS.getEventById(TEST_EVENT_ID));
	}
	
	@TestMethodInformation(targetMethod = "withEvent(InstanceEvent)",
				behavior = "Builder will throw an exception when "
					+ "adding the same event type multiple times")
	@Test
	public void testWithEventThrowExceptionWhenAddingSameEventTypeTwoTimes() {
		
		final InstanceEvent TEST_EVENT = new TalkEvent(() -> System.out.println(""));
		
		this.builder.withEvent(TEST_EVENT);

		assertThrows(InstanceEventAlreadyPresentException.class, () ->
						this.builder.withEvent(TEST_EVENT));
	}

	@TestMethodInformation(targetMethod = "withEvent(InstanceEvent)",
				behavior = "Builder will throw an exception when "
					+ "adding a move event without setting "
					+ "a neighbor")
	@Test
	public void testWithEventThrowsExceptionWhenAddingMoveEventWithoutNeighbor() {

		final InstanceEvent TEST_EVENT = new GoEvent();

		assertThrows(NoValidNeighborException.class, () ->
						this.builder.withEvent(TEST_EVENT));
	}

	@TestMethodInformation(targetMethod = "withNext(InstanceCore)",
				behavior = "Builder will set next instance properly")
	@Test
	@Disabled(value = "See issue #2 on the github page")
	public void testWithNext() {
		
		final InstanceCore NULL_INS = this.builder.build();

		final InstanceCore TEST_INS = this.builder
							.withNext(NULL_INS)
							.build();

		assertEquals(NULL_INS, TEST_INS.getNextInstance());
	}

	@TestMethodInformation(targetMethod = "withPrev(InstanceCore)",
				behavior = "Builder will set pre instance properly")	
	@Test
	@Disabled(value = "See issue #2 on the github page")
	public void testWithPrev() {

		final InstanceCore NULL_INS = this.builder.build();

		final InstanceCore TEST_INS = this.builder
							.withPrev(NULL_INS)
							.build();

		assertEquals(NULL_INS, TEST_INS.getPreInstance());
	}
}