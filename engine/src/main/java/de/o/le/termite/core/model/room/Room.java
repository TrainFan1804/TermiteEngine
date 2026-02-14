package de.o.le.termite.core.model.room;

import de.o.le.termite.core.model.ModelIdGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.14
 */
public class Room {

    private String roomId;

    private String name;

    private String description;

    private List<Exit> exits;

    private List<Secret> secrets;

    public Room(String name, String description, List<Exit> exits, List<Secret> secrets) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.secrets = secrets;
        this.roomId = ModelIdGenerator.generateId(this);
    }

    public String getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Exit> getExits() {
        return Collections.unmodifiableList(exits);
    }

    public Optional<Exit> findExit(String targetId) {
        return exits.stream().filter(e -> e.getExitId().equals(targetId)).findFirst();
    }

    public Optional<Exit> findExit(Direction direction) {
        return exits.stream().filter(e -> e.getDirection().equals(direction)).findFirst();
    }

    public List<Secret> getSecrets() {
        return Collections.unmodifiableList(secrets);
    }

    public Optional<Secret> findSecret(String id) {
        return secrets.stream().filter(s -> s.getSecretId().equals(id)).findFirst();
    }

    public List<Secret> getUndiscoveredSecrets() {
        return secrets.stream()
                .filter(s -> !s.isDiscovered())
                .toList();
    }
}
