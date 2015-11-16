// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

/* Thanks for choosing the Warrior class! You are a Warrior, a class of fighters with powerful weapons and armor! You will fight on 
the front of the battle field with increased strength to defeath your enemies. Fight! */

public class Warrior extends Character{
    // Attributes and Stats
    // all inherited from parent class Character
    
    // Constructors
    
    /* Default Constructor
       Sets default values for attributes. */
    public Warrior(){
        super(200, 100, 85, 0.4, 0.8); //call superclass overloaded constructor w/ these stats
        //empty name
    }
    
    /* Overloaded Constructor
       Sets Warrior name equal to input parameter and stats */
    public Warrior(String newName){
        this();
        name = newName;
        //with this name and these stats
    }
    
    // METHODS
    //all necessary ones inherited from Character superclass
}