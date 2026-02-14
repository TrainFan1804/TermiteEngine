package de.o.le.termite.core.commands;

import de.o.le.termite.application.commands.CommandParser;
import de.o.le.termite.application.commands.LookCommand;
import de.o.le.termite.application.commands.NullCommand;
import de.o.le.termite.application.commands.WalkCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.24
 */
class CommandParserTest {

    private CommandParser parser;

    @BeforeEach
    public void beforeEach() {

        this.parser = new CommandParser();
    }

    @Test
    public void testParse() {

        assertInstanceOf(NullCommand.class, this.parser.parse(""));
        assertInstanceOf(NullCommand.class, this.parser.parse("unknown_command"));

        assertInstanceOf(WalkCommand.class, this.parser.parse("walk"));
        assertInstanceOf(LookCommand.class, this.parser.parse("look"));
    }
}
