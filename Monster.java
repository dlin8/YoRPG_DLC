// DLC -- Derek Lin, Lisa Shi, Calvin Vuong
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game, Expanded
// 2015-11-16

public class Monster extends Character{
    
    //Attributes
    //all are inherited
    
    //Constructors
    public Monster() {
	    //call overloaded constructor from parent to set stats
	    super(150, (int) ((Math.random() * 45) + 65), 20, 1.0, 1.0);
    }
    //methods
    //all methods inherited
}