package de.o.le;

// custom import
import backend.terminal.TerminalApplication;
import engine.Game;
import engine.Instance;
import engine.PlayerCharacter;

/**
 * @author                              o.le
 * @version                             0.5
 * @since                               0.1
 */
public class MainTest {
    
    public static void main(String[] args) {
        
        new TerminalApplication(new TestGame()).start();
    }
}

class TestGame extends Game {

    String title;
    PlayerCharacter playerCharacter;

    @Override
    public void create() {
    
        this.title = "Test game";
        this.playerCharacter = new PlayerCharacter("John");

        this.setInstance(new TestInstance(this));
    }
}

class TestInstance extends Instance {

    final Game game;

    TestInstance(Game game) {
        
        this.game = game;
    }

    @Override
    public void enter() {
        
        System.out.println("This is the enter method in TestInstance");
    }

    @Override
    public String display() {
     
        return "This is the display method in TestInstance";
    }

    @Override
    public void search() {
        
        System.out.println("Find something cool");
        this.game.setInstance(new TestInstanceTwo(game));
    }
}

class TestInstanceTwo extends Instance {

    final Game game;

    TestInstanceTwo(Game game) {
        
        this.game = game;
    }

    
    @Override
    public void enter() {
        
        System.out.println("This is the enter method in TestInstanceTwo");
    }


    @Override
    public String display() {
     
        return "This is the display method in TestInstanceTwo";
    }

    @Override
    public void use() {
        
        System.out.println("Use something cool");
        this.game.setInstance(new EndInstance(this.game));
    }
}

class EndInstance extends Instance implements engine.utils.EndInstance {

    final Game game;

    EndInstance(Game game) {
        
        this.game = game;
    }
    
    @Override
    public void enter() {
        
        System.out.println("This is the enter method in EndInstance");
    }

    @Override
    public String display() {
     
        // this shouldn't be printed
        return "This is the display method in EndInstance";
    }
}
