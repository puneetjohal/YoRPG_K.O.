public class Inventory{

    private static boolean hasHammer;
    private static boolean hasKnives;
    private static int numPotions;

    public static void setHammer(){
	hasHammer = true;
    }

    public static void setKnives(){
	hasKnives = true;
    }

    public static void setNumPotions(int potions){
	numPotions += potions;
    }

    public static String getInventory(){
	String retStr = "\n";
	if (hasHammer) {
	    retStr += "Hammer of Time\n";
	}
	if (hasKnives) {
	    retStr += "Knives of Kratos\n";
	}
	retStr += "Health Potions: " + numPotions;
	return retStr;
    }

    public static int getPotions(){
	return numPotions;
    }
}
