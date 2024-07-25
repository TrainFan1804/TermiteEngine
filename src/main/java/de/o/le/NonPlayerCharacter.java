package de.o.le;

// java import
import java.util.Map;

/**
 * @author                              o.le
 * @version                             0.3
 * @since                               0.1
 */
public class NonPlayerCharacter {

    private String name;
    private Map<Integer, String> dialogLines;

    public NonPlayerCharacter(String name, Map<Integer, String> dialogLines) {

        this.name = name;
        this.dialogLines = dialogLines;
    }

    public void talk() {

    }
}
