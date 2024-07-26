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

# Further explanation on the different instanceactions

|Instanceaction |Explanation|
|---|---|
|TALK   |The player talks to the NPC in the current instance. When there are multiple NPC the user need to enter TALK [NPC name]| 
|SEARCH |The player search for secrets in the current room. When the player found a secret an event will be triggered. E.g a hidden lever was found, the player goes to a trap, the player found a hidden instance, etc.| 
|USE    |The player will use an Item that is in the room. When there are multiple Items the user need to enter USE [Item name]|
|GO     |The player will go to the next instance. When there are multiple direction the user need to enter GO [direction]. Some instances may have hidden doors that must be find with SEARCH first or the player need to reach other requirements first|
|LEAVE  |The player will go back to the previous instance. Some instances may not have a way back.|