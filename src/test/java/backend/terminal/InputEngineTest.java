package backend.terminal;

// java import
import java.io.ByteArrayInputStream;
// JUnit import
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author                              o.le
 * @version                             0.3
 * @since                               0.10
 */
public class InputEngineTest {
    
    private static int intToAscii(int num) {

        char c = Integer.toString(num).charAt(0);

        return (int) c;
    }

    @Test
    public void testSingletonCharacteristic() {

        InputEngine firstEngine = InputEngine.getEngine();
        InputEngine secondEngine = InputEngine.getEngine();
        assertEquals(firstEngine, secondEngine);
    }

    @Test
    public void testCommandInput() {

    }

    @Test
    public void intInputRightInput() {

        byte[] testData = "1 2 3 4".getBytes();
        
        ByteArrayInputStream in = new ByteArrayInputStream(testData);
        InputEngine.inputStream = in;
        InputEngine engine = InputEngine.getEngine();

        for (int i = 0; i < testData.length; i+=2) {
            
            int input = engine.intInput();
            assertEquals(testData[i], intToAscii(input));
        }
    }

    @Test
    public void testStrInput() {

    }
}
