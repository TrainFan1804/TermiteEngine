package de.o.le.termite.application.port;

import de.o.le.termite.core.state.SaveState;
import de.o.le.termite.core.model.GameObject;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.13
 */
public interface GameObjectRepository {

    <T> T getData(GameObject type, String data);

    void loadData(SaveState state);
}
