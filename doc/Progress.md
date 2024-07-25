# 24.07.2024

Started with the project. Just collected some ideas and created some requirements.

# 25.07.2024

Started with the coding part of the project. Right now the user of the engine can create a Subtype of the Game and give this Game to the TerminalApplication. This TerminalApplication will call the Game#create method that will create everything that is necessary during the whole game (Like PlayerCharacter or Inventory (At least that's the idea)). In the create method the first Instance the Game do start is also set here.
After the create process the TerminalApplication is going to the TerminalApplication#run method that will call the display method in the subtype of the Instance type. 
*The idea behind the display method is that the user can define his own behaivior each time when the instance is "reloaded"*.
After the Instance is displayed the TerminalApplication will wait for a user input. This user input is transformed into an Command that will determine what action will be excecuted next.