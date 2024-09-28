package de.o.le.termiteengine.engine.core.service.output;

import annotations.TestInformation;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import utils.TestInformationPrinter;
import org.junit.jupiter.api.extension.ExtendWith;
 
/**
 * @author o.le
 * @version 1.0
 * @since 1.4.2
 */
@ExtendWith(TestInformationPrinter.class)
public class OutputServiceTest {

	private PrintStream ORIGIN_STREAM;
	private ByteArrayOutputStream outStream;

	private final OutputService OUT;

	public OutputServiceTest() {

		this.OUT = new OutputService();
	}

	@BeforeEach
	public void setUpStream() {

		this.ORIGIN_STREAM = System.out;
		this.outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outStream));
	}

	@AfterEach
	public void restoreOriginStream() {

		System.setOut(ORIGIN_STREAM);
	}

	@TestInformation(target = "OutputService.printNewLine()",
				behavior = "Service will print a empty line")
	@Test
	public void testPrintNewLine() {

		this.OUT.printNewLine();

		assertTrue(this.outStream.toByteArray().length == 1);
	}

	@TestInformation(target = "OutputService.printString(String)",
				behavior = "Service will print the entered string")
	@Test
	public void testPrintString() {

		final String TEST_STRING = "This is a test string";

		this.OUT.printString(TEST_STRING);

		assertEquals(TEST_STRING + "\n", this.outStream.toString());
	}

	@TestInformation(target = "OutputService.printMessage(Message)",
				behavior = "Service will print the entered message")
	@Test
	public void testPrintMessage_Message() {
	}

	@TestInformation(target = "OutputService.printMessage(MessageType)",
				behavior = "Service will print the message that "
					+ "was set for the custom outputs")
	@Test
	@Disabled(value = "Can't be tested because custom message will only be"
		+ " available after game compilation")
	public void testPrintCustomMessages() { }

	@TestInformation(target = "OutputService.printError(Exception)",
				behavior = "Service will print the message from "
					+ " the exception")
	@Test
	public void testPrintExceptionMessages() {

		final String TEST_EX_MSG = "This is a exception message";

		this.OUT.printError(new Exception(TEST_EX_MSG));

		assertEquals(TEST_EX_MSG + "\n", this.outStream.toString());
	}
}