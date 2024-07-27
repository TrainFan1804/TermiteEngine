package backend.terminal;

import static backend.terminal.OutputEngine.printMessasge;

// custom import
import backend.TermiteSettings;
import backend.actions.Action;
import backend.actions.ActionFactory;
import backend.actions.CommandType;
import engine.Game;
import engine.utils.EndInstance;

/**
 * @author                              o.le
 * @version                             0.12
 * @since                               0.1
 */
public class TerminalApplication {

    private InputEngine inputEngine;
    private ActionFactory factory;
    private Game game;

    public TerminalApplication(Game game) {
        
        this.inputEngine = InputEngine.getEngine();
        this.factory = ActionFactory.getFactory();
        this.game = game;

        this.initilize();
    }

    private void initilize() {

        this.game.create();
        TermiteSettings.currentInstance = this.game.getInstance();
    }
    
    public void start() {

        CommandType typedCommand;
        Action commandAction;

        while(!this.checkIfEndInstance()) {

            TermiteSettings.currentInstance.display();
            
            typedCommand = this.inputEngine.commandInput();
            commandAction = this.factory.commandToAction(typedCommand);

            // TODO deteminee between error and normal
            printMessasge(commandAction.execute());

            TermiteSettings.currentInstance = this.game.getInstance();
        }
    }

    private boolean checkIfEndInstance() {

        if (TermiteSettings.currentInstance instanceof EndInstance) {

            return true;
        }

        return false;
    }
}
