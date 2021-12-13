package snl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[2];
    private Color color;    
    private boolean winner;
    public static void Reset()
    {
        NumPlayers();
        int number = 0;
        PlayerSelection(number);
    }
    
    public static Player GetCurrentTurn() {
        return (currentTurn);
    }
    public static void MakeTie()
    {
        players[0].winner = true;
        players[1].winner = true;
    }
    
    public static Player GetPlayer1()
    {
        return players[0];
    }
    public static Player GetPlayer2()
    {
        return players[1];
    }    
    public static Player GetPlayer3()
    {
        return players[2];
    }
    public static Player GetPlayer4()
    {
        return players[3];
    }    
    
    public static boolean PlayerDisplay()
    {
        return true;
    }
    
    public static int NumPlayers()
    {
        int players = 0;
        players++;
        return(players);
    }
    
    public static int PlayerSelection(int numberPlayers) {
    int numPlayers = numberPlayers;
    
    if (numPlayers == 2)
    {
        players[0] = new Player(Color.red);
        players[1] = new Player(Color.blue);
        currentTurn = players[0];
    }
    if (numPlayers == 3)
    {
        players[0] = new Player(Color.red);
        players[1] = new Player(Color.blue);
        players[2] = new Player(Color.yellow);
        currentTurn = players[0];
    }
    if (numPlayers == 4)
    {
        players[0] = new Player(Color.red);
        players[1] = new Player(Color.blue);
        players[2] = new Player(Color.yellow);
        players[3] = new Player(Color.green);
        currentTurn = players[0];
    }
    return(numPlayers);
}
    
    
    public static Player GetOtherTurn() {
        if (currentTurn == players[0])
            return (players[1]);
        if (currentTurn == players[1])
            return (players[2]);
        if (currentTurn == players[2])
            return (players[3]);
        else
            return (players[0]);
    }    
    public static void SwitchTurn() {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else if (currentTurn == players[1])
            currentTurn = players[2];
        else if (currentTurn == players[2])
            currentTurn = players[3];
        else
            currentTurn = players[0];
    }
    
    Player(Color _color)
    {
        winner = false;
        color = _color;
    }
    public Color getColor() {
        return (color);
    }
    public boolean isWinner() {
        return (winner);
    }
    public void setWinner() {
        winner = true;
    }


//    public static void StringCentered(Graphics2D g,int xpos,int ypos,String text,String font,int size)
//    {
//        g.setFont (new Font (font,Font.PLAIN, size)); 
//        int width = g.getFontMetrics().stringWidth(text);
//        int height = g.getFontMetrics().getHeight();
//        xpos = xpos - width/2;
//        ypos = ypos - height/4;
//        xpos = Window.getX(xpos);
//        ypos = Window.getYNormal(ypos);
//        g.drawString(text, xpos, ypos);           
//    }   
    
}