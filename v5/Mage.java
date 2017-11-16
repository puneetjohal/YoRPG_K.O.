public class Mage extends Protagonist {
    public String name;
    
    public Mage() {
	name = "Mage";
	HP = 100;
	strength = 40;
	defense = 40;
	atkRating = 0.4;
	oldAtkR = 0.4;
    }
    
    public Mage(String pName) {
	this();
	name = pName;
    }

    public String getName() {
	return name; //returns the name of the person
    }
    
    public void specialize() { //special attack
	System.out.println("Special Attack!"); //to distinguish
	defense -= 10; //lower defense...
	atkRating += 0.5;//and increase attack
    }
    
    public void normalize() {
	System.out.println("Normal Attack!"); //to distinguish
	//reset values to previous values
	defense = 20;
	atkRating = oldAtkR;
    }
}
