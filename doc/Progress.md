# 24.07.2024

Started with the project. Just collected some ideas and created some requirements.

# 25.07.2024

Started with the coding part of the project. Right now the user of the engine can create a Subtype of the Game and give this Game to the TerminalApplication. This TerminalApplication will call the Game#create method that will create everything that is necessary during the whole game (Like PlayerCharacter or Inventory (At least that's the idea)). In the create method the first Instance the Game do start is also set here.
After the create process the TerminalApplication is going to the TerminalApplication#run method that will call the display method in the subtype of the Instance type. 
*The idea behind the display method is that the user can define his own behaivior each time when the instance is "reloaded"*.
After the Instance is displayed the TerminalApplication will wait for a user input. This user input is transformed into an Command that will determine what action will be excecuted next.

# 26.07.2024

I added the EndInstance marker interface that will tell the engine that the gam reached his end. There could also be multiple EndInstance subtypes so the created games could also have multiple endings. I also cleaned the Game and Instance class a bit so there are more readable.
I got the idea that the developer need to write the dialogs for the NPC in a seperate file and the engine will read the file.