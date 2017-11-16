# YoRPG_K.O.
YoRPG
#### Roster: Ahnaf Hasan, Puneet Johal

## Instructions
Hello young protagonist. I see you have finally awoken from your slumber. As you will soon come to discover, the world as you know it has changed radically and has descended into chaos. Monsters run rampant where people once lived, and it is your duty, oh chosen hero, to restore order to this world.
You will choose a class, each with its unique powers and abilities.
You will fight monsters, some truly formidable no doubt, but not invincible.
You will find new weapons and potions that can be used to improve your abilities.
The fate of the world now rests in your hands, hero.

## Feature Additions
* Inventory: Displays what weapons you have aquired and the ammount of potions available for use.
* Weapons: Each monster you defeat has a random chance of dropping a weapon, which can be used to improve your attack rating.
* Potions: Each monster you defeat also has a random chance of dropping up to 3 potions, which can be accessed from your inventory and used to increase HP by 20 points.

## Code Restructuring
* Added additional while loop inside method playTurn in class YoRPG in order to allow player to view inventory and access potions during a battle.
* Added randomly called conditionals under success in playTurn to simulate mob drops.
* Added try/catch in newGame method to allow player to manually select their preferred subclass of Protagonist.

## Rundown of Classes

* YoRPG
  * Driver class 
  * Develops user interface in terminal and allows for player input. 
  * Binds the classes together.

* Character
  * Master class 
  * All other classes except for YoRPG are subclasses of this one. 
  * Initiates attributes that _all_ characters in the game share, along with shared methods.

* Protagonist
  * Subclass of Character 
  * Superclass of Mage, Jedi, and Assassin 
  * Initiates shared attribute "name" and defines constructors and shared methods among progtagonists in the game.

* Monster
  * Subclass of Character 
  * Superclass of Trolls, Warlock, and Werewolf 
  * Initiates shared attributes and defines constructors and shared methods among monsters in the game.

* Mage
  * Subclass of Protagonist 
  * Protagonist with an increased defense rating and new attribute, mana.

* Jedi
  * Subclass of Protagonist
  * Protagonist with an increased strength rating and new attribute, force.

* Assassin
  * Subclass of Protagonist 
  * Protagonist with an increased attack rating and new attribute, sneak.

* Troll
  * Subclass of Monster.

* Warlock
  * Subclass of Monster 
  * Monster with a lower HP value, but increased defense and attack rating.

* Werewolves
  * Subclass of Monster 
  * Monster with a lower HP and defense, but increased attack rating.

* Weapons
  * Abstract class that holds abstract methods for use in subclasses

* Hammer
  * Subclass of Weapons
  * Random chance of aquiring after slaying monster
  * Attribute weapVal added to atkRating of Pat if picked up by Pat

* Knives
  * Subclass of Weapons
  * Random chance of aquiring after slaying monster
  * Attribute weapVal added to atkRating of Pat if picked by Pat

* Inventory
  * Stores information about which weapon is available and how many potions Pat has aquired

### All In-game Characters
Character Name | Type | HP | strength | defense | attack | Special
-------------- | ---- | -- | -------- | ------- | ------ | -------
Mage | Protagonist | 100 | 40 | 40 | 0.4 | Mana
Jedi | Protagonist | 100 | 40 | 40 | 0.4 | Force
Assassin | Protagonist | 100 | 40 | 40 | 0.75 | Sneak
Troll | Monster | 150 | 20-64 | 20 | 1.0 |
Warlock | Monster | 125 | 20-64 | 50 | 1.35 |
Werewolf | Monster | 130 | 20-64 | 20 | 1.35 |
