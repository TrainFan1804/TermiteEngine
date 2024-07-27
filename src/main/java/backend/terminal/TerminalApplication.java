package backend.terminal;

// custom import
import backend.Termite;
import backend.actions.Action;
import backend.actions.ActionFactory;
import backend.actions.CommandType;
import engine.Game;
import engine.utils.EndInstance;

/**
 * @author                              o.le
 * @version                             0.10
 * @since                               0.1
 */
public class TerminalApplication {

    private Game game;
    private InputEngine inputEngine;

    public TerminalApplication(Game game) {
        
        this.inputEngine = InputEngine.getEngine();

        this.game = game;
        this.game.create();
        
        Termite.currentInstance = this.game.getInstance();
    }
    
    public void start() {

        ActionFactory factory = ActionFactory.getFactory();
        CommandType typedCommand;
        Action commandAction;

        while(!this.checkIfEndInstance()) {

            Termite.currentInstance.display();
            
            typedCommand = this.inputEngine.commandInput();
            commandAction = factory.commandToAction(typedCommand);
            commandAction.execute();

            Termite.currentInstance = this.game.getInstance();
        }
    }

    private boolean checkIfEndInstance() {

        if (Termite.currentInstance instanceof EndInstance) {

            return true;
        }

        return false;
    }
}
