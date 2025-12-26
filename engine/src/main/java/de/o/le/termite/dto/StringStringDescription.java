package de.o.le.termite.dto;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 */
public record StringStringDescription(
        String name,
        String description
) {
    @Override
    public String toString() {
        return name + ": " + description;
    }
}
