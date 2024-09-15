package engine.core.services.output;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.0
 */
public enum MessageType {
	
	MSG_SAVE_ASK_FILE,
	MSG_SAVE_OVR_FILE,
	MSG_SAVE_SUC,
	MSG_SAVE_CANCEL,

	MSG_LOAD_ASK_FILE,
	MSG_LOAD_SUC,
	MSG_LOAD_CANCEL,

	MSG_EXIT,
	MSG_HELP,

	MSG_WRONG_INPUT,
	MSG_UNKNOWN_COMMAND,
	MSG_EVENT_ID_NOT_PRESENT
}
