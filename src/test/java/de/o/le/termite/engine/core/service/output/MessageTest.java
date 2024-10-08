package de.o.le.termite.engine.core.service.output;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestInformationPrinter;
import annotations.TestInformation;
 
/**
 * @author o.le
 * @version 1.0
 * @since 1.4.2
 */
@ExtendWith(TestInformationPrinter.class)
public class MessageTest {

	@TestInformation(target = "Message.toString()",
				behavior = "Returned string should be equal the "
					+ "argument pass in the constructor")
	@Test
	public void testToString() {

		final String TEST_STRING = "This is a test message";
		final Message msg = new Message(TEST_STRING);

		final String result = msg.toString();

		assertEquals(TEST_STRING, result);
	}
}
