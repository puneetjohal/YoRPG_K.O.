//Team K.O.
//Team Roster -- Puneet Johal, Ahnaf Hasan
//APCS1 pd1
//HW28 -- Ye Olde Role Playing Game
//2017-11-08

/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 **********************************************/


import java.io.*;
import java.util.*;

public class YoRPG
{
  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;   //Is it man or woman?
  private Monster smaug; //Friendly generic monster name?
  private Weapons knife;
  private Weapons hammer;
    //  private Weapons sword;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG()
  {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:  
    post: according to user input, modifies instance var for difficulty 
    and instantiates a Protagonist
    =============================================*/
  public void newGame()
  {
    String s;
    String name = "", type = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }

    //allow player to choose class
    s = "Choose your destiny, protagonist: Mage, Jedi, or Assassin? ";
    System.out.print( s );

    try {
	type = in.readLine();
    }
    catch ( IOException e ) { }

    //instantiate the player's character
    if (type.equals("Mage")) {
	pat = new Mage( name );
    }
    if (type.equals("Jedi")) {
	pat = new Jedi( name );
    }
    if (type.equals("Assassin")) {
	pat = new Assassin( name );
    }
    knife = new Knives();
    hammer = new Hammer();

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn()
  {
      int i = 1, x = 0;
      int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
    else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
		try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye! \n\t3: Open Inventory" );
          i = Integer.parseInt( in.readLine() );
		}
	  catch ( IOException e ) { }

		if ( i == 3) {
		    while ( x != 2 ) {
			try {
			    System.out.println( Inventory.getInventory() );
			    System.out.println();
			    System.out.println( "Hit 1 to use potion." );
			    System.out.println( "Hit 2 to go back." );
			    x = Integer.parseInt( in.readLine() );
			}
			catch ( IOException e ) { }
			if (x == 1 && Inventory.getPotions() == 0){
			    System.out.println();
			    System.out.println( "No health potions available. Tough luck..." );
			    System.out.println();
			}
			if (x == 1 && Inventory.getPotions() > 0){
			    pat.usePotion();
			    Inventory.setNumPotions(-1);
			    System.out.println();
			    System.out.println( "Health potion consumed. HP: " + pat.getHP());
			    System.out.println();
			}
		    }
		    continue;
		} //Shows you inventory + option of consuming potion and then skips one iteration of the loop, bringing you back to the fight
		    
        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage." +
			    "\n" + pat.getName() + "'s HP is now " + pat.getHP() + "." );
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " + 
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
	if ( Math.random() <= ( difficulty / 3.0 ) ) {
	    int y = (int) (Math.random() * ((1) + 1));
	    if (y == 0) {
		System.out.println("\n");
		System.out.println(knife.getNotif());
		System.out.println(knife.about());
		try {
		    System.out.println("Do you equip?");
		    System.out.println("1:Ye\t2:Nay\n");
		    System.out.print("Selection:");
		    i = Integer.parseInt( in.readLine() );
		}
		catch (IOException e) { }
		if (i == 1) {
		    pat.atkRating += knife.weapVal;
		    Inventory.setKnives();
		}else{
		}
	    }else{
		System.out.println("\n");
		System.out.println(hammer.getNotif());
		System.out.println(hammer.about());
		try {
		    System.out.println("Do you equip?");
		    System.out.println("1:Ye\t2:Nay");
		    System.out.print("Selection:");
		    i = Integer.parseInt( in.readLine() );
		}
		catch (IOException e) { }
		if (i == 1) {
		    pat.atkRating += hammer.weapVal;
		    Inventory.setHammer();
		}else{
		}
	    }
	}
        if ( Math.random() <= ( difficulty / 3.0 ) ) {
	    Inventory.setNumPotions(1);
	    System.out.println("\nYou have acquired 1 health potion.");
	}
	if ( Math.random() <= ( difficulty / 6.0 ) ) {
	    Inventory.setNumPotions(2);
	    System.out.println("\nYou have acquired 2 health potions.");
	}
        return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args )
  {
    //As usual, move the begin-comment bar down as you progressively 
    //test each new bit of functionality...

    
    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
		break;
    encounters++;
    System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
	  ================================================*/
  }//end main

}//end class YoRPG

