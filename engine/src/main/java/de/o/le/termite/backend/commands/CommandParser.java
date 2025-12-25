package de.o.le.termite.backend.commands;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
public class CommandParser {

    public ParsedCommand parse(String input) {

        String[] tokens = input.trim().toLowerCase().split("\\s+"); // split at whitespaces

        if (tokens.length == 0) { return null; }

        CommandType type = switch (tokens[0]) {
            case "walk" -> CommandType.WALK;
            case "look" -> CommandType.LOOK;
            case "show" -> CommandType.SHOW;
            default -> null;
        };

        if (type == null) { return null; }

        return new ParsedCommand(type, List.of(tokens).subList(1, tokens.length));
    }
}
