// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

public class Cleric extends Character{
    //Attributes
    //all others inherited from parent Character
    
     //default constructor, sets stats, no name
    public Cleric(){
        super(150, 80, 80, 0.4, 0.4); //calls Character overloaded constr.
    }
    
    //overloaded constructor, sets stats, with name
    public Cleric (String newName){
        this(); //class Character overloaded constr., w/ name
        name = newName;
    }
    
    //Methods
    
    //override attack()
    //add hp to cleric equal to  1/3 of damage
    public int attack(Character other){
       int inflictDamage;
        inflictDamage = (int) ( (strength * attackRating) - (other.getDefense() * other.getDefenseRating()) );
        if (inflictDamage < 0){ //prevent doing negative damage
            inflictDamage = 0;
        }
        other.lowerHP(inflictDamage);
        hp += (int) (inflictDamage * 0.33); //heal after attack
        System.out.println("Your devotion to your faith restores your health by " + ((int) (inflictDamage * 0.33)) + ".");
        return inflictDamage;
    }
    //all others inherited from parent Character
}



