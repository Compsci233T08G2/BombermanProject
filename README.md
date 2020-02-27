# BombermanProject
Files included:
Map.java
Bomb.java
Character.java
Movement.java

To run Bomberman first:
Download files
Movement.java, Map.java, Bomb.java, Character.java.
Download Eclipse.ide for java.
Create a java project and import the above java files into the source file.
Run the Movement class in the command prompt to start playing the game.

-------------------------------------------------------
Map.java
Creates a 2D array that is referenced as the map used for the gameboard.
Contains getters and setters along side methods to distinguish between breakable and un-breakable walls.
Prints out a text based version of the array that is used as reference of the gameboard while running.

-------------------------------------------------------

Bomb.Java
The Bomb class extends the Movement class.
This class contains methods that return integers and booleans too the Movement class. 

-------------------------------------------------------

Character.java
The Character class contains coordinates instances and a string playerid with getters, setters and constructors to initialize character/player objects. 

-------------------------------------------------------

Movement.java
The Movement class contains the method movement which takes in values from all other classes to run our code.
The class calls the method which runs our game in the consol as a text based version of our game.

