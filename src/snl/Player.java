package snl;
import java.awt.Color;

public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[2];
    private Color color;    
    private boolean winner;
    public static void Reset()
    {
        System.out.println("reset");
        players[0] = new Player(Color.red);
        players[1] = new Player(Color.black);
        players[2] = new Player(Color.black);
        currentTurn = players[0];
    }
    public static Player GetCurrentTurn() {
        return (currentTurn);
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
    public static Player GetOtherTurn() {
        if (currentTurn == players[0])
            return (players[1]);
        else
            return (players[0]);
    }    
    public static void SwitchTurn() {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }
    
    public void Method(){}
    public void Method2(){}


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


}