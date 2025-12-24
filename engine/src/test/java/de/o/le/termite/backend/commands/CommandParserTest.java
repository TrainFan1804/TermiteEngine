package de.o.le.termite.backend.commands;

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

        assertNull(this.parser.parse(""));
        assertNull(this.parser.parse("unknown_command"));

        assertInstanceOf(ParsedCommand.class, this.parser.parse("walk"));
        assertEquals(CommandType.WALK, this.parser.parse("walk").type());
        assertEquals(CommandType.LOOK, this.parser.parse("look").type());
    }
}
