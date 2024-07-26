package backend.terminal;

// custom import
import engine.Game;
import engine.Instance;
import engine.utils.EndInstance;

/**
 * @author                              o.le
 * @version                             0.8
 * @since                               0.1
 */
public class TerminalApplication {

    private Game game;
    private Instance currentInstance;
    private KeyWordInputEngine inputEngine;

    public TerminalApplication(Game game) {

        this.game = game;
        this.inputEngine = new KeyWordInputEngine();
        this.game.create();
        this.currentInstance = this.game.getInstance();
    }
    
    public void start() {

        while(!this.checkIfEndInstance()) {

            OutputEngine.printMessasgeToTerminal(this.currentInstance
            .display());
            
            this.executeCommand(this.inputEngine.waitForInput());

            this.currentInstance = this.game.getInstance();
        }
    }

    private void executeCommand(Command command) {

        switch (command) {
            case SAVE:
                System.out.println("Save game");
                break;
            case LOAD:
                System.out.println("Load game");;
                break;
            case EXIT:
                System.out.println("Exit game");;
                break;
            case HELP:
                System.out.println("Help");;
                break;
            default:
                this.executeInstanceCommand(command);
                break;
        }
    }

    private void executeInstanceCommand(Command command) {

        switch (command) {
            case TALK:
                this.currentInstance.talk();
                break;
            case SEARCH:
                this.currentInstance.search();
                break;
            case USE:
                this.currentInstance.use();
                break;
            case GO:
                this.currentInstance.go();
                break;
            case LEAVE:
                this.currentInstance.leave();
                break;
            default:
                // this is fine (I guess)
                break;
        }
    }

    private boolean checkIfEndInstance() {

        if (this.currentInstance instanceof EndInstance) {

            return true;
        }

        return false;
    }
}
