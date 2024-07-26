package engine;

// java import
import java.util.List;

/**
 * @author                              o.le
 * @version                             0.3
 * @since                               0.1
 */
public class NonPlayerCharacter {

    private String name;
    private List<String> dialogLines;

    public NonPlayerCharacter(String name, List<String> dialogLines) {

        this.name = name;
        this.dialogLines = dialogLines;
    }

    public void talk() {

    }
}
