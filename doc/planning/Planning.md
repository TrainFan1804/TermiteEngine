# What type of games can be created with this engine?
With this engine the developer can create textadventure games that run on the terminal.

# How does a textadventure look like that was created in the engine?
When a developer create a game in this engine he will have a classic textadventure game where the end-user controll a player character (I will refer to this as a <b>player</b>). The player is always in a <b>instance</b>. In each instance the player has different actions to choose from. Examples for action are:
- Talk
- Open inventory / map
- Search (will expose things to interact with)
- Use (use something in the room)
- leave (go one room back)
- Go (enter a new room)
- save / load
- exit game (will also save the current state)
- help

Some action aren't always possible.

# In which points should the engine help the developer?
The engine should help the developer to create these games as good as possible. My personal goal is it to create a engine where the developer should just create an instance and create the action in those. Then he must connect the different instances and give it to the engine. The engine should handle the rest.