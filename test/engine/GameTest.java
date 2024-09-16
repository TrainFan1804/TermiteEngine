package engine;

import annotations.TestInformation;
import engine.instance.Instance;
import engine.instance.exceptions.DuplicateInstanceIdException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestInformationPrinter;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.5
 */
@ExtendWith(TestInformationPrinter.class)
public class GameTest {
	
	@Test
	@TestInformation(testedClass = Game.class,
						testedMethod = {"getCurrentInstance()", 
										"getCurrentInstanceId()"},
						behavior = "Game will return instance / id that was set first")
	public void gameSetFirstAddedInstanceAsCurrent() {

		final int TESTED_ID = 0;

		Game game = new Game();
		Instance firstInstance = new Instance(TESTED_ID);

		game.addInstance(firstInstance);

		Instance resultInstance = game.getCurrentInstance();
		int resultId = game.getCurrentInstanceId();
		assertEquals(firstInstance, resultInstance);
		assertEquals(TESTED_ID, resultId);
	}

	@Test
	@TestInformation(testedClass = Game.class,
						testedMethod = "setCurrentInstance(int)",
						behavior = "Game will set the right instance by id")
	public void gameSetCurrentById() {

		final int TESTED_ID = 1;

		Game game = new Game();
		Instance firstInstance = new Instance(0);
		Instance secondInstance = new Instance(TESTED_ID);

		game.addInstance(firstInstance);
		game.addInstance(secondInstance);

		game.setCurrentInstance(TESTED_ID);

		Instance resultInstance = game.getCurrentInstance();
		int resultId = game.getCurrentInstanceId();
		assertEquals(secondInstance, resultInstance);
		assertEquals(TESTED_ID, resultId);
	}

	@Test
	@TestInformation(testedClass = Game.class,
						testedMethod = "gettInstanceById(int)",
						behavior = "Game will return instance by id")
	public void gameGetInstanceById() {

		final int TESTED_ID = 1;

		Game game = new Game();
		Instance firstInstance = new Instance(0);
		Instance secondInstance = new Instance(TESTED_ID);

		game.addInstance(firstInstance);
		game.addInstance(secondInstance);

		Instance resultInstance = game.getInstanceById(TESTED_ID);
		assertEquals(secondInstance, resultInstance);
	}

	@Test
	@TestInformation(testedClass = Game.class,
						testedMethod = "addInstance(Instance)",
						behavior = "Game will thrown an exception when adding null")
	public void gameAddNullThrowException() {

		Game game = new Game();

		assertThrows(IllegalArgumentException.class, () -> game.addInstance(null));
	}

	@Test
	@TestInformation(testedClass = Game.class,
						testedMethod = "getInstanceById(int)",
						behavior = "Game will thrown an exception when calling"
								+ " getInstanceById method")
	public void gameGetUnknownInstanceIdThrowException() {

		Game game = new Game();

		assertThrows(IllegalArgumentException.class, () -> game.getInstanceById(0));
	}

	@Test
	@TestInformation(testedClass = Game.class,
						testedMethod = "addInstance(Instance)",
						behavior = "Game will thrown an exception when adding"
								+ " instances with the same id")
	public void gameCanNotAddTwoInstanceWithSameId() {

		final int TEST_ID = 0;

		Game game = new Game();

		Instance firstInstance = new Instance(TEST_ID);
		Instance secondInstance = new Instance(TEST_ID);

		game.addInstance(firstInstance);

		assertThrows(DuplicateInstanceIdException.class, () -> game.addInstance(secondInstance));
	}
}
