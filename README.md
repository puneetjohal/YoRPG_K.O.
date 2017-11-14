# YoRPG_K.O.
YoRPG

##Rundown of Classes

*YoRPG
  Driver class, develops user interface in terminal and allows for player input. Binds the classes together.

*Character
  Master class, all other classes except for YoRPG are subclasses of this one. Initiates attributes that _all_ characters in the game share, along with shared methods.

*Protagonist
  Subclass of Character, superclass of Mage, Jedi, and Assassin. Initiates shared attribute "name" and defines constructors and shared methods among progtagonists in the game.

*Monster
  Subclass of Character, superclass of Trolls, Warlock, and Werewolf. Initiated shared attributes and defines constructors and shared methods among monsters in the game.

*Mage
  Subclass of Protagonist. Protagonist with an increased defense rating and new attribute, mana.

*Jedi
  Subclass of Protagonist. Protagonist with an increased strength rating and new attribute, force.

*Assassin
  Subclass of Protagonist. Protagonist with an increased attack rating and new attribute, sneak.

*Troll
  Subclass of Monster.

*Warlock
  Subclass of Monster. Monster with a lower HP value, but increased defense and attack rating.

*Werewolves
  Subclass of Monster. Monster with a lower HP and defense, but increased attack rating.

### All In-game Characters
Character Name | Type | HP | strength | defense | attack | Special
-------------- | ---- | -- | -------- | ------- | ------ | -------
Mage | Protagonist | 100 | 40 | 40 | 0.4 | Mana
Jedi | Protagonist | 100 | 40 | 40 | 0.4 | Force
Assassin | Protagonist | 100 | 40 | 40 | 0.75 | Sneak
Troll | Monster | 150 | 20-64 | 20 | 1.0 |
Warlock | Monster | 125 | 20-64 | 50 | 1.35 |
Werewolf | Monster | 130 | 20-64 | 20 | 1.35 |