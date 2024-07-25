package de.o.le;

// custom import
import backend.terminal.TerminalApplication;

/**
 * @author                              o.le
 * @version                             0.5
 * @since                               0.1
 */
public class MainTest {
    
    public static void main(String[] args) {
        
        new TerminalApplication(new TestGame());
    }
}

class TestGame extends Game {

    String title;
    PlayerCharacter playerCharacter;
    Inventory inventory;

    @Override
    public void create() {
    
        this.title = "Test game";
        this.playerCharacter = new PlayerCharacter("John");
        this.inventory = new Inventory();
        this.setInstance(new TestInstance(this));
    }
}

class TestInstance extends Instance {

    protected TestInstance(Game game) {
        super(game);
    }

    @Override
    public String display() {
     
        return this.game.toString();
    }

    @Override
    public void search() {
        
        System.out.println("Find something cool");
        this.game.setInstance(new TestInstanceTwo(game));
    }
}

class TestInstanceTwo extends Instance {

    protected TestInstanceTwo(Game game) {
        super(game);
    }

    @Override
    public String display() {
     
        return "You enterd a new instance";
    }

    @Override
    public void search() {
        
        System.out.println("Find something cool twice!");
        this.game.setInstance(null);
    }
}
