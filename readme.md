# Riddle
Riddle is a little and simple implementation of the More or less game in java, implemented as part of a class project.

# Features
- Player scores
- Top scores management
- Versus mode/Solo mode

# How to run it ?
1. Using netbeans
    - Launch netbeans, then open the project located at the src folder
    - Run the project

2. Standalone version
    **You need to have java installed first**
Make sure Java (JDK 8 or higher) is installed, and then just launch the `Riddle.jar` file located at the `dist` folder.

# What lacks ?
- The best the management of the best scores is not fully developed;
- The game needs to be more attractive, may be some animations or something like;
- Save game to continue later;
- Level numeration as for now we only have the management of game difficulties.

# Project Structure

We made some efforts to separate the logical layer from the presentation layer. Almost all the game logic is implemented in the "GameEngine" class.
The `Player` class represents the player who has a score, a number of tries, etc...

1. GUI
The GUI files are : 
- `MainWindow.java` that represents the JFrame element
- `MainPanel.java` that represents the home screen which is the first page showed when is opened
- `NewGameScreen.java` represents the page where one sets the options for a new game
- `BestScores.java` _(Not used)_ represents the view for the best scores

2. Logic
The logic files are :
- `Player.java` that is the class that represents the player;
- `GameEngine.java` that contains all the game logic;
- `GameData.java` that stores the actual game data;
- `Helper.java` _(Not used)_ That should give some help to stucked players

# Author
- Steve Nosse, Fullstack js developer.
