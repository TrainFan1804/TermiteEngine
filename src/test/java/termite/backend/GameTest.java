package termite.backend;

import termite.backend.instances.Instance;
import termite.backend.instances.InstanceDisplayMessage;
import termite.backend.instances.InstanceManager;
import termite.terminal.TerminalApplication;

public class GameTest {

    public static void main(String[] args) {
        
        InstanceManager im = new InstanceManager();
        Game g = new TestGame(im);

        TerminalApplication t = new TerminalApplication(g);
    
        t.start();
    }
}

class TestGame extends Game {

    public TestGame(InstanceManager manager) {
        
        super(manager);
    }

    @Override
    public void init() {
        
        this.manager.addInstance(new TestInstance());

        // here define what instance is first
        this.currentInstance = this.manager.getInstance(1);
    }
}

class TestInstance extends Instance {

    public TestInstance() {

        super(1, new InstanceDisplayMessage("First instance test"));
    }
}
