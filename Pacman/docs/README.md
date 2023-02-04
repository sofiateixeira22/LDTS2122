# LDTS_T07G02 - Kinda Pacman

This game is based on the well known game Pacman where you have to stay away from the ghosts, get your coins and survive.
The Kinda Pacman game has a variety of levels where the number of ghosts and walls varies to make your win more dificult to obtain.

This project was developed by *Ana Sofia Teixeira* (*up201906031*@fc.up.pt), *Luís Paulo Miranda* (*up201306340*@fe.up.pt) and Luís Soares (*up201406356*@fe.up.pt) for LTDS 2021/22.


## IMPLEMENTED FEATURES

- **Menus** - The user has the capability of browsing through the different menus (Ex: Main Menu, Next Level Menu, End Game Menu).
- **Buttons** - Functional and interactive buttons.
- **Keyboard control** - The keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Player control** - The player may move the pacman with the keyboard control.
- **Collisions detection** - Collisions between different objects are verified. (Ex: Pacman, ghosts, walls, coins)
- **Different levels** - There are x different levels with an increasing difficulty implemented.
- **Lives** - Pacman has a finite number of lives. If that number reaches zero, it's game over.


## PLANNED FEATURES

All the planed features were successfully implemented.

## DESIGN

During the development of the project, diferent design patterns were used to achieve a more structured and robust solution.
Due to its scope in the proposed solution, the MVC it's not just a design pattern it's not just a design pattern but the architecture used for the project.
Other design patterns were used, like the composite design pattern.

### MVC

"MVC consists of three kinds of objects. The Model is the application object, the View is its screen presentation, and the Controller defines the way the user interface reacts to user input. Before MVC, user interface designs tended to lump these objects together. MVC decouples them to increase flexibility and reuse." In Gamma, E. (1995). Design patterns: elements of reusable object-oriented software. Pearson Education India, pp.14

MVC is an acronym for Model-View-Controller. This pattern is used to divide the project into well defined layers. Each layer, Model, Controller and View, do what they were designed to do and nothing else.
- Model: Represents the object and its information;
- View : Represents the view of the data that the model contains.
- Controller: Its used to control the flow of information of the model and render the view when the information is changed.

![MVC](https://user-images.githubusercontent.com/93602630/151638754-2dfd970c-d407-45bc-86e4-fb366867d441.png)


### Composite

"Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly. In Gamma, E. (1995). Design patterns: elements of reusable object-oriented software. Pearson Education India, pp.183

In the definition of some classes, it was found that there were attributes and methods that, at certain level, could be shared.

In fact, it's a situation in which one intends to represent hierarchies of objects, but at another level to represent the specifics of each one.
The use of this pattern allows, for example, to define the structure of the position, which is shared by several objects.
For example, PacMan, which is completely different from a coin, shares with it being elements of a Position.

Consequently, the application of this pattern allows an easier maintenance in the different classes. It is possible to make a change to a higher level class with reduced impact on the others. But the real power comes from the reverse situation, it's possible to change a whole structure keeping the basic and common characteristics to the others. This implies structural simplification and avoids the need to write repeated functions.

![model_uml](https://user-images.githubusercontent.com/93602630/151638772-5cdf4095-2bae-46b7-8257-786d00f7fca4.png)

## KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

All code smells that we could identify were properly treated, although there is always a need to develop work on this component.
However, we believe that some parts may have been forgotten that could be optimized or removed or even fragmented to reduce the level of complexity.
Regarding the refactoring techniques, the extraction method and the replacement algorithm were intensively used and whenever possible we encapsulated the fields, replaced the data value with objects and changed the reference to value.

Button (x) does not work. To exit the game, the key ESC needs to be pressed.

## TESTING

### Coverage report

#### Models

![model](https://user-images.githubusercontent.com/93602630/148653759-2a265327-1f9e-408b-b96d-8ac91111e80c.png)

(Coin and Coin Model are 0% because they haven't been implemented)

#### Views
 
![view](https://user-images.githubusercontent.com/93602630/148653770-888c36d5-db4c-44ab-a6c0-c510dc9bfb02.png)

(InstructionsView is 0% because it has not been implemented)

#### Link to mutation testing report
[Mutation tests](../build/reports/pitest/202201081658/index.html)


## SELF-EVALUATION

The work was divided in a mutual way and all the members contributed with our best. It helped us to enrich java and principle/pattern knowledge, as well as team work.

- Ana Sofia Teixeira: 33%
- Luís Paulo Miranda: 33%
- Luís Soares: 33%
