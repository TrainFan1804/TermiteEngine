package termite;

public final class CommandToGameHandler {

    private CommandToGameHandler() { }

    public static void sendToGame(Game game, Command command) {

        InstanceEvent type = CommandInstanceEventMapper
                                .mapCommandToInstanceEventType(command);
        InstanceEvent event game.getInstanceManger().getInstanceById(0)
                                    .getEventHandler().getEventById(type.ID);
        event.startEvent();
    }
}
