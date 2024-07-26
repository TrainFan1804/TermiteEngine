package backend.actions;

// custom import
import backend.Termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class SearchAction implements Action {

    @Override
    public void execute() {
     
        Termite.currentInstance.search();
    }
}
