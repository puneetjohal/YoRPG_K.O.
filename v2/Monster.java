//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW30 -- Ye Olde Role Playing Game, Improved
//2017-11-10

public class Monster extends Character{
    public int HP;
    public int strength;
    public int defense;
    public double atkRating;
    /*=====================================
      Default Constructor:
      Set HP to 150, strength to a random
      number between 20 and 65, defense to 20
      and attack rating to 1.
      =======================================*/
    public Monster() {
	HP = 150;
	strength = (int) ((Math.random() * 46) + 20);
	defense = 20;
	atkRating = 1;
    }
    /*=======================================
      isAlive():
      Checks if the Monster in question is 
      still alive. True if so, false otherwise.
      ========================================*/
    public boolean isAlive() {
	if (HP <= 0) {
	    return = false;
	}
	return true;
    }
    public int getDefense() {
	return defense; //returns Monster's defense
    }
    public int lowerHP(int Hdamage) {
	HP -= Hdamage; //lowers HP by the damage amount
	return HP; //returns HP
    }
    public int attack(Protagonist opposed) {
	int damage = (int) ((strength * atkRating) - opposed.getDefense());
	//as per instructions on HW page
	opposed.lowerHP(damage); //lower HP for the protagonist
	return damage; //return the damage to be printed
    }
}
