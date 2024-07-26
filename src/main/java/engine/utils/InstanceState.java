package engine.utils;

// custom import
import engine.Instance;
import backend.terminal.Command;

/**
 * When the user enter an {@link Command} into the console that is related to 
 * the {@link InstanceAction} the entered command will be transformed into
 * this type. The new state will determien what action in the {@link Instance}
 * will be executed.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.2
 */
@Deprecated
enum InstanceState {

    TALK, SEARCH, USE, GO, LEAVE;
}
