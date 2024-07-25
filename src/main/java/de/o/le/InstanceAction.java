package de.o.le;

/**
 * @author                              o.le
 * @version                             0.4
 * @since                               0.1
 */
public interface InstanceAction {

    /**
     * Return the message that is saved in the {@link Instance}. Don't print
     * something out in this method because the engine will formate the returned
     * String for you.
     * 
     * @return                          Return the saved message.
     */
    String display();
    
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
