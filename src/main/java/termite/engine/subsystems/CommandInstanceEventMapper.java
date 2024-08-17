package termite.engine.subsystems;

import termite.engine.Command;
import termite.instance.event.InstanceEventType;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
final class CommandInstanceEventMapper {

    /**
     * Map a command to his {@link InstanceEventType} counterpart.
     * 
     * @param command                   The command to map.
     * @return                          The commands' counterpart.
     */
    public InstanceEventType mapCommandToInstanceEventType(Command command) {

        return switch (command) {
            case TALK -> InstanceEventType.TALK_EVENT;
            case SEARCH -> InstanceEventType.SEARCH_EVENT;
            case USE -> InstanceEventType.USE_EVENT;
            case GO -> InstanceEventType.GO_EVENT;
            case LEAVE -> InstanceEventType.LEAVE_EVENT;
            default -> throw new IllegalArgumentException();  // shouldn't even happen
        };
    }
}
