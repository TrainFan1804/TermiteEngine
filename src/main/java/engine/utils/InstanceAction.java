package engine.utils;

// custom import
import engine.Instance;
import engine.Item;
import engine.Secret;
import engine.PlayerCharacter;
import engine.NonPlayerCharacter;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               0.1
 */
public interface InstanceAction {

    /**
     * Will execute the talk action of the {@link NonPlayerCharacter} of the 
     * {@link Instance}.
     */
    void talk();

    /**
     * Will execute the expose action of the {@link Secret} of the
     * {@link Instance}.
     */
    void search();

    /**
     * Will execute the use item action of the {@link Item} of the
     * {@link Instance}.
     */
    void use();

    /**
     * Will move the {@link PlayerCharacter} to the next instance.
     */
    void go();

    /**
     * When possible the {@link PlayerCharacter} will return to the previous
     * instance.
     */
    void leave();
}
