package snl;

public class Dice {
    static int number = DiceRollNumber();
    
    public static int DiceRollNumber() 
    {
        int number = (int)(Math.random()*6+1);
        System.out.println(number);
        return(number);
    }
    
    public static int Roll()
    {
        int value = number;
        number = DiceRollNumber();
        return(number);
    }
    
    public static boolean NumDisplay()
    {
        return true;
    }
    
}
