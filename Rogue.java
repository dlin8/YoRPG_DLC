// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

public class Rogue extends Character{
    //Attributes
    //all other attributes inherited
    int koTimes = 0; //number of times HP < 0
    boolean oneHitKO = false; //true if Rogue will execute OHKO move
    
    //default constructor, sets stats, no name
    public Rogue(){
        super(100, 85, 75, 0.6, 0.7); //calls Character overloaded constr.
    }
    //overloaded constructor, sets stats, with name
    public Rogue(String newName){
        this(); //class Character overloaded constr., w/ name
        name = newName;
    }
    
    //override isAlive() to ensure survival after first KO
    //returns true if character alive
    public boolean isAlive(){
        if ((hp < 0) && (koTimes < 1)){ //if first time KOd and first time KOd...
            koTimes += 1;
            System.out.println("Back from the brink of death, your health is failing...");
            hp = 1;
            return true; //is alive
        }
        else{ //if not first KOd time...
            return (hp > 0); //return false if HP < 0
        }
    }
    
    //override specialize() to fit class specialty
    //small chance for one-hit-KO, but defense drops sharply
    public void specialize(){
        attackRating *= 4.0; //higher attack increase than usual
        defenseRating /= 5.0; //steep defense drop
        if (Math.random() < 0.1){ //10% chance OHKO
            oneHitKO = true;
        }
    }
    public void normalize(){
        attackRating = baseAttackRating;
        defenseRating = baseDefenseRating;
        oneHitKO = false;
    }
    
    //override attack() to fit class specialty
    //attack character specified in other
    //if oneHitKO is true, one hit ko other
    public int attack(Character other){
        int inflictDamage;
        if (oneHitKO == true){ //if KO
            inflictDamage = other.getHP(); //damage equal to opponent's HP
            System.out.println("ONE-HIT-KO!");
        }
        else{
            inflictDamage = (int) ( (strength * attackRating) - (other.getDefense() * other.getDefenseRating()) );
            if (inflictDamage < 0){ //prevent doing negative damage
                inflictDamage = 0;
            }
        }
        other.lowerHP(inflictDamage);
        return inflictDamage;
    }
    
}