//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW31 -- Ye Olde Role Playing Game, Extended
//2017-11-13

public class Mage extends Protagonist{

    //attributes
    private int mana;

    //default constructor
    public Mage(){
	name = "Dumbledore";
	mana = 50;
	defense = 60;
    }

    //overloaded constructor
    public Mage(String nameVal, int manaVal){
	name = nameVal;
	mana = manaVal;
	defense = 60;
    }

    //methods

    //about
    public static String about(){
	return "Mages have been around since the beginning\nof all time. High and mighty, respected\nby all, mages are expected to work for the\ngood of all mankind. Possess the ability to\nuse magic and have increased defense.\nAlso known as 'wizards' or 'sorcerors'.";
    }

    //isAlive
    public boolean isAlive(){
	return super.isAlive();
    }

    //getDefense
    public int getDefense(){
	return super.getDefense();
    }

    //getName
    public String getName(){
	return super.getName();
    }

    //lowerHP
    public int lowerHP(int Hdamage){
	return super.lowerHP(Hdamage);
    }

    //attack
    public int attack(Monster evilName){
	return super.attack(evilName);
    }

    //specialize
    public void specialize(){
	super.specialize();
    }

    //normalize
    public void normalize(){
	super.normalize();
    }
    
    //toString
    public String toString(){
	return "Name: " + name +
               "\nHP: " + HP +
	       "\nStrength: " + strength +
	       "\nDefense: " + defense +
	       "\nAttack rating: " + atkRating +
	       "\nMana: " + mana;
    }

    //main
    public static void main(String args[]){
	Mage Char = new Mage();
	System.out.println(about());
	System.out.println();
	System.out.println(Char);
	System.out.println();
	
	Mage Merlin = new Mage("Merlin", 150);
	System.out.println(Merlin);
    }
}
