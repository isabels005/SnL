package snl;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;

    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;
    }
    
    public static void DisplayPlayer()
    {
        Player currentPlayer = Player.GetCurrentTurn();
        board[9][0] = new OvalPiece(Player.GetCurrentTurn().getColor());
    }
    
    
//    public static void AddPlayer() {
//        Player.AddPlayers(Player.getStartingPlayers());
//    }
    
    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        g.setColor(Color.cyan);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
            }
        }    
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                
                    
                    
                    board[zrow][zcol] = new Number(Color.GREEN,NUM_ROWS,NUM_COLUMNS);
                    
//                    board[zrow][1] = new Number(Color.GREEN,NUM_ROWS,NUM_COLUMNS);
//                    board[zrow][2] = new Number(Color.GREEN,NUM_ROWS,NUM_COLUMNS);
//                    board[zrow][3] = new Number(Color.GREEN,NUM_ROWS,NUM_COLUMNS);
//                    board[zrow][4] = new Number(Color.GREEN,NUM_ROWS,NUM_COLUMNS);
//                    board[zrow][5] = new Number(Color.GREEN,NUM_ROWS,NUM_COLUMNS);

                
            }
        }         
        
        DisplayPlayer();
        
        if(Player.PlayerDisplay() == true) {
        g.setColor(Color.orange);
        StringCentered(g,60,554,"Number of Players: "+" "+ Player.NumPlayers(),"Arial",12);
        }
        
        if(Dice.NumDisplay() == true) {
        g.setColor(Color.orange);
        StringCentered(g,490,554,"Dice Roll Number: "+" "+ Dice.number,"Arial",12);
        }
        
        
        //needs fixes
//        if (Player.GetCurrentTurn().isWinner() && Player.GetOtherTurn().isWinner())
//        {
//            g.setColor(Color.blue);
//            StringCentered(g,250,554,"We Have World Peace","Arial",30);
//        }
//        else if (Player.GetPlayer1().isWinner())
//        {
//            g.setColor(Player.GetPlayer1().getColor());
//            StringCentered(g,250,554,"Player 1 is the Winner","Arial",30);
//        }
//        else if (Player.GetPlayer2().isWinner())
//        {
//            g.setColor(Player.GetPlayer2().getColor());
//            StringCentered(g,250,554,"Player 2 is the Winner","Arial",30);
//         }      
    }
    
    public static int getNumColumns()
        {
            return(NUM_COLUMNS);
        }
    
    public static int getNumRows()
        {
            return(NUM_ROWS);
        }
    
    public static void StringCentered(Graphics2D g,int xpos,int ypos,String text,String font,int size)
    {
        g.setFont (new Font (font,Font.PLAIN, size)); 
        int width = g.getFontMetrics().stringWidth(text);
        int height = g.getFontMetrics().getHeight();
        xpos = xpos - width/2;
        ypos = ypos - height/4;
        xpos = Window.getX(xpos);
        ypos = Window.getYNormal(ypos);
        g.drawString(text, xpos, ypos);           
    }   
}
