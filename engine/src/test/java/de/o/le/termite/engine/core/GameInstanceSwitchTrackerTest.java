package de.o.le.termite.engine.core;

import annotations.TestClassInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestInformationPrinter;
import annotations.TestMethodInformation;
 
/**
 * @author o.le
 * @version 1.0
 * @since 1.4.8
 */
@TestClassInformation(targetClass = GameInstanceSwitchTracker.class)
@ExtendWith(TestInformationPrinter.class)
public class GameInstanceSwitchTrackerTest {

	@TestMethodInformation(targetMethod = "GameInstanceSwitchTracker()",
				behavior = "Default value is true")
	@Test
	public void testDefaultValueIsTrue() {
		
		final GameInstanceSwitchTracker INSTANCE = new GameInstanceSwitchTracker();

		final boolean RES = INSTANCE.getChanged();

		assertTrue(RES);
	}

	@TestMethodInformation(targetMethod = "setChanged(boolean)",
				behavior = "Value is false after setting false")
	@Test
	public void testValueIsFalseAfterSetFalse() {

		final GameInstanceSwitchTracker INSTANCE = new GameInstanceSwitchTracker();

		INSTANCE.setChanged(false);
		final boolean RES = INSTANCE.getChanged();

		assertFalse(RES);
	}
}
