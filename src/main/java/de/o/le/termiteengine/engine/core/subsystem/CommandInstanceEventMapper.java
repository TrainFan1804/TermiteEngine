package de.o.le.termiteengine.engine.core.subsystem;

import de.o.le.termiteengine.engine.core.Command;
import de.o.le.termiteengine.engine.instance.event.InstanceEventType;

/**
 * When the entered command was the command for a event like TALK, USE, etc. the
 * command must be mapped to the right {@link InstanceEventType}.
 * <p>
 * TODO this can get kinda messy when adding more event types. So I should
 * consider to rewrite this.
 * 
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
    	InstanceEventType mapCommandToInstanceEventType(Command command) {

        	return switch (command) {
            	case TALK -> InstanceEventType.TALK_EVENT;
            	case SEARCH -> InstanceEventType.SEARCH_EVENT;
            	case USE -> InstanceEventType.USE_EVENT;
            	case GO -> InstanceEventType.GO_EVENT;
            	case LEAVE -> InstanceEventType.LEAVE_EVENT;
            	default -> throw new AssertionError("This shouldn't be happen!");
        	};
    	}
}
