// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

//Class Bard
//average stats

//DON'T KNOW WHAT TO DO, SOMEONE HELP

public class Bard extends Character{
    //Attributes
    //all others inherited from parent Character
    //default constructor, sets stats, no name
    public Bard(){
        super(120, 90, 90, 0.5, 0.7); //calls Character overloaded constr.
        mana = 2;
    }
    
    //overloaded constructor, sets stats, with name
    public Bard (String newName){
        this(); //class Character overloaded constr., w/ name
        name = newName;
    }
    
    //Methods
    // all inherited from parent Character
    
    //sing your song, immobilizes foe
    public void specialize(){
        if (hasMana()){ //if you can sing...
            defenseRating = 9999.0;
            if (Math.random()*2 == 1){
                System.out.println("You sing a sorrow song\n" + "Your foe begins to weep and cannot attack this turn.");
            }
            else {
                System.out.println("You sing a lullaby\n" + "Your foe falls into a state of repose and cannot attack this turn.");
            }
            mana -= 2;
        }
        else{ //if no more voice...
            attackRating = 0.0; //attack is futile
            defenseRating = baseDefenseRating;
            System.out.println("You strain your vocal chords\n" + "You grasp your thorat in intense pain and are unable to attack this turn.");
        }
    }
    
    //attack regularly, and rest yourself
    public void normalize(){
        attackRating = baseAttackRating;
        defenseRating = baseDefenseRating;
        mana += 1; //takes two normal turns to recharge voice
        System.out.println("You rest your vocal chords. And drink from a bottle of \"Poland Spring\" water.");
        if (mana >= 2){
            System.out.println("You can sing another song next turn.");
        }
        else if (mana == 1){
            System.out.println("You can sing another song if you rest for another turn.");
        }
        else{
            System.out.println("Your last song has you exhausted, take a break. (2 turns)");
        }
    }
}