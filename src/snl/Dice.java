package snl;

public class Dice {
    
    public static int DiceRollNumber() 
    {
        int number = (int)(Math.random()*6+1);
        System.out.println(number);
        return(number);
    }
    
//    public static void DiceRoll(int number) {
//        if (number == 1)
//            g.drawImage(dice1,580,30,40,40,this); 
//        if(number == 2)
//            g.drawImage(dice2,580,30,40,40,this); 
//        if(number == 3)
//            g.drawImage(dice3,580,30,40,40,this); 
//        if(number == 4)
//            g.drawImage(dice4,580,30,40,40,this); 
//        if(number == 5)
//            g.drawImage(dice5,580,30,40,40,this); 
//        if(number == 6)
//            g.drawImage(dice6,580,30,40,40,this); 
//    }
    
}
