package engine;

// java import
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
// JSON import
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.10
 */
public class Dialog {

    private Map<String, List<String>> dialogLines;

    /**
     * @param dialogFilePath            The path to the Dialog_[NPC].json file
     */
    public Dialog(String dialogFilePath) throws IOException {

        this.dialogLines = this.loadDialog(dialogFilePath);
    }

    private Map<String, List<String>> loadDialog(String path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, List<String>>> type 
                        = new TypeReference<Map<String, List<String>>>() {};
    
        return mapper.readValue(new File(path), type);
    }

    public Map<String, List<String>> getDialog() {

        return this.dialogLines;
    }
}
