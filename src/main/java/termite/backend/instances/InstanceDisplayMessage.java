package termite.backend.instances;

import termite.backend.Message;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.14
 */
public class InstanceDisplayMessage implements Message {

    private String message;

    public InstanceDisplayMessage(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {

        return this.message;
    }
}
