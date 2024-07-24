# What type of games can be created with this engine?

With this engine the developer can create textadventure games that run on the terminal.

# How does a textadventure look like that was created in the engine?

When a developer create a game in this engine he will have a classic textadventure game where the end-user controll a player character (I will refer to this as a **player**). The player is always in an **instance**. 

# What is an **instance**?

A instance is something the **player** can be inside. The most common explanation is the concept of a "room". But the instance isn't limited to just a room. The instance can e.g. be a forest. In each instance the player has different **actions** to interact with the instance itself.

# What are **action**?

Actions are options the user can enter to continue in the game loop. There are two types of actions:

    1. Gameactions
    2. Instanceaction

An *Gameaction* is a action the user can **always** execute regardless of the current instance. The following actions belong to this type:

    - save / load
    - open inventory / map
    - exit game (will also save the current state)
    - help

An *Instanceaction* is a action the user can **only** perfrom if the current instance allow this action. The following action belong to this type:

    - talk
    - search (will expose things to interact with)
    - use (use something in the room)
    - go (enter a new room)
    - leave (go one room back)