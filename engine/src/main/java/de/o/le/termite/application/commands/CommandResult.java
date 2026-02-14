package de.o.le.termite.application.commands;

import de.o.le.termite.application.dto.trans.TransContext;

import org.jetbrains.annotations.Nullable;

/**
 * This DTO is used to transfer information about state changes after an executed command
 * from the backend to the frontend controller.
 *
 * @author                              o.le
 * @version                             2.0
 * @since                               25.12.24
 */
public class CommandResult {

    public enum Type {
        SUCCESS,
        FAILURE
    }

    public static CommandResult success(String msg) {
        return success(msg, null);
    }

    public static CommandResult success(String msg, TransContext ctx) {
        return new CommandResult(Type.SUCCESS, msg, ctx);
    }

    public static CommandResult failure(String msg) {
        return new CommandResult(Type.FAILURE, msg, null);
    }

    private Type type;
    private String message;

    private TransContext ctx;

    public CommandResult(Type type, String message, @Nullable TransContext ctx) {
        this.type = type;
        this.message = message;
        this.ctx = ctx;
    }

    public boolean isSuccess() { return this.type.ordinal() == Type.SUCCESS.ordinal(); }

    public String getMessage() { return this.message; }

    @Nullable
    public TransContext getCtx() { return this.ctx; }
}
