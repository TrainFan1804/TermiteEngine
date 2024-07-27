package backend.actions;

// custom import
import backend.TermiteSettings;

/**
 * This action will execute the use process in the current instance.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class UseAction implements Action{

    @Override
    public void executeEvent() {
        
        return TermiteSettings.currentInstance.use();   
    }
}
