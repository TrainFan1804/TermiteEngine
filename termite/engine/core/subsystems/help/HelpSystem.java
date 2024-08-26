package engine.core.subsystems.help;

import engine.core.Command;
import engine.core.subsystems.EngineCommandSystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class HelpSystem implements EngineCommandSystem {

    private static final String msg;
    
    static {
        
        StringBuilder sb = new StringBuilder();
    
        sb.append("Available commands:\n");
	Command[] allCommand = Command.values();
	for (Command c : allCommand) {

	    sb.append(c.toString())
		.append("\n");
	}
        msg = sb.toString();
    }
    
    @Override
    public void execute() {

        System.out.println(msg);
    }
}
