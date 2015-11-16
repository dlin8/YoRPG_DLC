// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

//Class Mage
//slightly higher attack, low defense, high specialize damage

public class Mage extends Character{
    //Attributes
    //all attributes inherited
    
    //methods
    //all other methods inherited
    
    //default constructor, sets stats, no name
    public Mage(){
        super(120, 100, 70, 0.8, 0.8); //calls Character overloaded constr.
        mana = 3;
    }
    
    //overloaded constructor, sets stats, with name
    public Mage(String newName){
        this(); //class Character overloaded constr., w/ name
        name = newName;
    }
    public void specialize(){
        if (hasMana()){
            attackRating = 5;
            defenseRating = 5;
            mana -= 1;
        }
        else{
            attackRating = 0.5;
            defenseRating = 0.5;
            System.out.println("Your well of mana has run dry, you become unlucky and your strength and defense fall by half instead.");
        }
    }
    public void normalize(){
        attackRating = baseAttackRating;
        defenseRating = baseDefenseRating;
        mana += 1;
        System.out.println("You restore 1 point of mana.");
    }
}