package de.o.le.termite.application.port;

import de.o.le.termite.core.model.Player;

import java.util.Optional;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.14
 */
public interface PlayerRepository {

    void save(Player player);

    Optional<Player> getPlayer(String name);
}
