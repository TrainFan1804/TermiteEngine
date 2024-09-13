# Introduction

The **TermiteEngine** is a java engine for the development for textadventure games.
The **TermiteEngine** provide some tools to create the game of your dreams.

# Features

You don't need much classes to create your own game with the help of this engine.

The package termite/example contains a very small example that represent the
most basic features of a game that can be created with this engine.

# How to use

You just need a few classes to create a simple textadventure game.

1. Create a object of the Instance class. You need to enter a **id** into the constructor.
2. You can add different **Event** objects into the instance with instanceObject.addEvent(InstanceEvent).
3. After setting up all instances you must create a **Game** object and add all instances to the Game.
4. Adding the game object to an **Application** object and call the start method.
