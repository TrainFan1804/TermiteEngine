package backend.actions;

import backend.terminal.GameMessage;

/**
 * This action will show the help menu. The help menu will display all avaiable 
 * commands.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.8
 */
class HelpAction implements Action {

    @Override
    public void executeEvent() {
     
        StringBuilder sb = new StringBuilder();

        for (CommandType c : CommandType.getKeywordList()) {

            sb.append(c.toString());
        }

        return new GameMessage(sb.toString());
    }
}
