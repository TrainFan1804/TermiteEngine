package engine.utils;

// custom import
import backend.terminal.Message;
import engine.Instance;
import engine.Item;
import engine.Secret;
import engine.events.MoveEvent;
import engine.PlayerCharacter;
import engine.NonPlayerCharacter;

/**
 * @author                              o.le
 * @version                             1.4
 * @since                               0.1
 */
public interface InstanceAction {

    /**
     * Will execute the talk action of the {@link NonPlayerCharacter} of the 
     * {@link Instance}.
     * @return TODO
     */
    Message talk();

    /**
     * Will execute the expose action of the {@link Secret} of the
     * {@link Instance}.
     * @return TODO
     */
    Message search();

    /**
     * Will execute the use item action of the {@link Item} of the
     * {@link Instance}.
     * @return TODO
     */
    Message use();

    /**
     * Will move the {@link PlayerCharacter} to the next instance.
     * @return TODO
     */
    MoveEvent move();

    /**
     * When possible the {@link PlayerCharacter} will return to the previous
     * instance.
     * @return TODO
     */
    Message leave();
}
