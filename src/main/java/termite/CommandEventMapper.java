package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public final class CommandEventMapper {

    private CommandEventMapper() { }

    /**
     * Map a command to his {@link EventType} counterpart.
     * 
     * @param command                   The command to map.
     * @return                          The commands counterpart.
     */
    public static EventType mapCommandToEventType(Command command) {

        switch (command) {
            case TALK: return EventType.TALK_EVENT;
            case SEARCH: return EventType.SEARCH_EVENT;
            case USE: return EventType.USE_EVENT;
            case GO: return EventType.GO_EVENT;
            case LEAVE: return EventType.LEAVE_EVENT;
            default: throw new IllegalArgumentException();
        }
    }
}
