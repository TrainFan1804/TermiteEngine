package engine;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               0.1
 */
public class NonPlayerCharacter {

    private String name;
    private Dialog dialog;

    /**
     * Use this constructor when the NPC should have nothing to say. The default
     * {@link NonPlayerCharacter#getDialog()} will be executed.
     * 
     * @param name                      The name of the NPC.
     */
    public NonPlayerCharacter(String name) {

        this(name, null);
    }

    /**
     * Use this constructor when the NPC should have something to say. Need to
     * override the {@link NonPlayerCharacter#getDialog()} method.
     * 
     * @param name                      The name of the NPC.
     * @param dialog                    The dialog of the NPC.
     */
    public NonPlayerCharacter(String name, Dialog dialog) {

        this.dialog = dialog;
    }

    public String getDialog() {

        return null;
    }

    @Override
    public String toString() {
    
        return "The NPC name is " + this.name;
    }
}
