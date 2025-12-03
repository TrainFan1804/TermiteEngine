package de.o.le.termite.engine.core.service.output;

import annotations.TestClassInformation;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import utils.TestInformationPrinter;
import org.junit.jupiter.api.extension.ExtendWith;
import annotations.TestMethodInformation;
 
/**
 * @author o.le
 * @version 1.1
 * @since 1.4.2
 */
@TestClassInformation(targetClass = OutputService.class)
@ExtendWith(TestInformationPrinter.class)
public class OutputServiceTest {

	private PrintStream ORIGIN_STREAM;
	private ByteArrayOutputStream outStream;

	private final OutputService OUT;

	public OutputServiceTest() {

		this.OUT = new OutputService();
	}

	@BeforeEach
	public void setUp() {

		this.ORIGIN_STREAM = System.out;
		this.outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outStream));
	}

	@AfterEach
	public void tearDown() {

		System.setOut(ORIGIN_STREAM);
	}

	@TestMethodInformation(targetMethod = "printNewLine()",
				behavior = "Service will print a empty line")
	@Test
	public void testPrintNewLine() {

		this.OUT.printNewLine();

		assertTrue(this.outStream.toByteArray().length == 1);
	}

	@TestMethodInformation(targetMethod = "printString(String)",
				behavior = "Service will print the entered string")
	@Test
	public void testPrintString() {

		final String TEST_STRING = "This is a test string";

		this.OUT.printString(TEST_STRING);

		assertEquals(TEST_STRING + "\n", this.outStream.toString());
	}

	@TestMethodInformation(targetMethod = "printMessage(Message)",
				behavior = "Service will print the entered message")
	@Test
	public void testPrintMessage_Message() {

		final Message TEST_MSG = new Message("This is a test message");

		this.OUT.printMessage(TEST_MSG);

		assertEquals(TEST_MSG.toString() + "\n", this.outStream.toString());
	}

	@TestMethodInformation(targetMethod = "printMessage(MessageType)",
				behavior = "Service will print the message that "
					+ "was set for the custom outputs")
	@Test
	@Disabled(value = "Can't be tested because custom message will only be"
		+ " available after game compilation")
	public void testPrintCustomMessages() { }

	@TestMethodInformation(targetMethod = "printError(Exception)",
				behavior = "Service will print the message from "
					+ " the exception")
	@Test
	public void testPrintExceptionMessages() {

		final String TEST_EX_MSG = "This is a exception message";

		this.OUT.printError(new Exception(TEST_EX_MSG));

		assertEquals(TEST_EX_MSG + "\n", this.outStream.toString());
	}
}