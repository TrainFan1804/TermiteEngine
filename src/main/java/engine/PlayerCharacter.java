package engine;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.1
 */
public class PlayerCharacter {

    private String name;

    public PlayerCharacter(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
    
        return "Your name is: " + this.name;
    }
}
