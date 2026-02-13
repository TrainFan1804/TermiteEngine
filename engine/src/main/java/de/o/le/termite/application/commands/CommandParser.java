package de.o.le.termite.application.commands;

import de.o.le.termite.core.commands.ICommandHandler;
import de.o.le.termite.core.commands.NullCommand;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
public class CommandParser {

    public ICommandHandler parse(String input) {

        String[] tokens = input.trim().toLowerCase().split("\\s+"); // split at whitespaces

        if (tokens.length == 0) { return new NullCommand(); }

        List<String> args = List.of(tokens).subList(1, tokens.length);

        return switch (tokens[0]) {
            case "walk" -> new WalkCommand(args);
            case "look" -> new LookCommand(args);
            case "show" -> new ShowCommand();
            case "inv", "inventory" -> new InvCommand();
            case "save" -> new SaveCommand();
            default -> new NullCommand();
        };
    }
}
