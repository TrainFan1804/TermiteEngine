package de.o.le.termite.backend.commands;

import java.util.List;

/**
 * Because the frontend sends per turn a raw strings (the command itself and
 * the arguments, if the input is valid) the engine needs to parse
 * these information in the right format. And this record are the representation
 * of named format.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
@Deprecated(since = "26.01.13", forRemoval = true)
public record ParsedCommand(
        CommandType type,
        List<String> args
) { }
