// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

public class Character{
    // Instance Variables
    //protected so that only visible to subclasses
    protected String name = "";
    protected int hp;
    protected int mana;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected double baseAttackRating;
    protected double defenseRating;
    protected double baseDefenseRating;
        
    // Constructors
    // Default Constructor; set instance vars to default vals
    public Character(){
        hp = 10;
        strength = 10;
        defense = 10;
        attackRating = 1.0;
        baseAttackRating = attackRating;
        defenseRating = 1.0;
        baseDefenseRating = defenseRating;
    }
    //Overloaded Constructor; set instance vars to input params, no name
    public Character(int inputHp, int inputStrength, int inputDefense, 
                    double inputAttackRating, double inputDefenseRating){
        this();
        hp = inputHp;
        strength = inputStrength;
        defense = inputDefense;
        attackRating = inputAttackRating;
        defenseRating = inputDefenseRating;
        baseAttackRating = attackRating;
        baseDefenseRating = defenseRating;
    }
    //Overloaded Constructor; set instance vars to input params, w/ name
    public Character(String inputName, int inputHp, int inputStrength, int inputDefense,
                    double inputAttackRating, double inputDefenseRating){
        this(inputHp, inputStrength, inputDefense, inputAttackRating, inputDefenseRating);
        name = inputName;
    }
    
    // Methods
    //returns string with all info about this character
    public static String about(){
        String s;
        s = "Warrior: A mighty hero that overwhelms his foes with sheer power. Nothing will stand in his way.\n";
        s += "\tThe warrior posseses the highest strength and defense of any class, however he has no special skills.\n";
        s += "Mage: A member of the elite group of magic users who will blast his foes off the face of this realm.\n";
        s += "\tThe mage has many spells in his arsenel to turn the tide of battle in his favor.\n";
        s += "Rogue: A scoundrel who will employ every trick to gain the upper hand.\n";
        s += "\tThe rogue has no honor and will strike where it hurts the most, the rogue can kill enemies with one strike and excape death.\n";
        s += "Cleric: A member of the Bishop's Order who can strike fear in the heart's of evildoers.\n";
        s += "\tRepresenting the church, the cleric can heal his allies and himself.\n";
        s += "Bard: A musician, the bard can enchant enemies.\n";
        s += "\tThe bard can sing powerful songs that can have drastic effects on both ally and foe.";
        return s;
    }
    
    //for debugging purposes
    public String stats(){
        String retStr = "";
        retStr += "Name: " + name + "\n";
        retStr += "HP: " + hp + "\n";
        retStr += "Strength: " + strength + "\n";
        retStr += "Defense: " + defense + "\n";
        retStr += "Base Attack Rating: " + baseAttackRating + "\n";
        retStr += "Base Defense Rating: " + baseDefenseRating;
        return retStr;
    }
    //returns true if character alive
    public boolean isAlive(){
        return (hp > 0);
    }
    //returns true if character has mana
    public boolean hasMana(){
        return (mana > 0);
    }
    //returns value of character's HP
    public int getHP(){
        return hp;
    }
    //returns value of character's defense
    public int getDefense(){
        return defense;
    }
    //returns value of charater's defense rating
    public double getDefenseRating(){
        return defenseRating;
    }
    // return name of character
    public String getName(){
        return name;
    }
    //lower character's HP by int specified in param
    public int lowerHP(int recieveDamage){
        hp -= recieveDamage;
        return recieveDamage;
    }
    //attack character specified in other
    public int attack(Character other){
        int inflictDamage;
        inflictDamage = (int) ( (strength * attackRating) - (other.getDefense() * other.getDefenseRating()) );
        if (inflictDamage < 0){ //prevent doing negative damage
            inflictDamage = 0;
        }
        other.lowerHP(inflictDamage);
        return inflictDamage;
    }

     /* prepares the player for a special attack. 
        if used in succession, attackRating increases from attackRating last turn, not base
        likewise for defense */
    public void specialize(){
        attackRating *= 1.5; //increase attack rating
        defenseRating /= 1.5; //decrease defense rating
    }
    /* prepares the player for a normal attack. */
    public void normalize(){
        attackRating = baseAttackRating;
        defenseRating = baseDefenseRating;
    }
}