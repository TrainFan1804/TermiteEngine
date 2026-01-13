package de.o.le.termite.dto;

/**
 * This DTO is used to transfer information about state changes after an executed command
 * from the backend to the frontend controller.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.24
 */
public class CommandResult {

    public enum Type {
        SUCCESS,
        FAILURE
    }

    public static CommandResult success(String msg) {
        return success(msg, new CommandContext());
    }

    public static CommandResult success(String msg, CommandContext context) {
        return new CommandResult(Type.SUCCESS, msg, context);
    }

    public static CommandResult failure(String msg) {
        return new CommandResult(Type.FAILURE, msg, new CommandContext());
    }

    private Type type;
    private String message;
    private CommandContext context;

    public CommandResult(Type type, String message, CommandContext context) {
        this.type = type;
        this.message = message;
        this.context = context;
    }

    public boolean isSuccess() { return this.type.ordinal() == Type.SUCCESS.ordinal(); }

    public String getMessage() { return this.message; }

    public CommandContext getContext() { return this.context; }
}
