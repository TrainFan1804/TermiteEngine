package termite.backend;

// custom import
import termite.backend.utils.SameArgumentObjectException;
// JUnit import
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.12
 */
public class InstanceManagerTest {

    private InstanceManager testManager;
    private final String TESTNAME = "Germany";
    private Instance testInstance;

    @Before
    public void init() {

        this.testManager = new InstanceManager();
        this.testInstance = new TestInstance(this.TESTNAME);
    }

    @Test
    public void testGetInstanceIsNullWhenEmpty() {

        assertNull(this.testManager.getInstance(this.TESTNAME));
    }

    @Test
    public void testExceptions() {

        assertThrows(IllegalArgumentException.class,
                () -> this.testManager.addInstance(null));

        assertThrows(IllegalArgumentException.class,
                () -> this.testManager.addInstanceConnection(null, null, null));
        assertThrows(SameArgumentObjectException.class,
                () -> this.testManager.addInstanceConnection(
                        this.testInstance, this.testInstance,
                                 (first, second) -> first.addNeighbor(second)));
    }

    @Test
    public void testAddOneInstance() {

        this.testManager.addInstance(this.testInstance);
        assertEquals(this.testInstance, 
                this.testManager.getInstance(this.TESTNAME));
    }

    @Test
    public void testAddMultipleInstance() {
        
        this.testManager.addInstance(new TestInstance("First Dummy"));
        this.testManager.addInstance(this.testInstance);
        this.testManager.addInstance(new TestInstance("Second Dummy"));

        assertEquals(this.testInstance, 
                this.testManager.getInstance(this.TESTNAME));
    }
    
    @Test
    public void testAddInstanceWithUniConnection() {

        Instance instance = new TestInstance("Japan");

        this.testManager.addInstanceConnection(this.testInstance, instance, 
                new UniDirectionalConnection());


        assertEquals(instance, this.testInstance.getNeighborList().get(0));
        // must be 0 because there shouldn't be any neighbors
        assertEquals(0, instance.getNeighborList().size());
    }

    @Test
    public void testAddInstanceWithBiConnection() {

        Instance instance = new TestInstance("Japan");

        this.testManager.addInstanceConnection(this.testInstance, instance, 
                new BiDirectionalConnection());


        assertEquals(instance, this.testInstance.getNeighborList().get(0));
        assertEquals(testInstance, instance.getNeighborList().get(0));
    }
}

class TestInstance extends Instance {

    protected TestInstance(String name) {
        
        super(name);
    }
}