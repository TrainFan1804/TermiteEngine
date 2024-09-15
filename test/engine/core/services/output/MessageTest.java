package engine.core.services.output;

import annotations.TestInformation;
import utils.TestInformationPrinter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.4
 */
@ExtendWith(TestInformationPrinter.class)
public class MessageTest {
	
	@Test
	@TestInformation(testedClass = Message.class, 
						testedMethod = "toString()", 
						behavior = "Returned string should be equal the entered"
									+ "arument from the constructor")
	public void message_toString_containsConstructorParam() {

		final String TEST_STRING = "This is a test message";

		Message instance = new Message(TEST_STRING);

		String result = instance.toString();
		assertEquals(TEST_STRING, result);
	}
}
