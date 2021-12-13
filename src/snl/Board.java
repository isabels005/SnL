package snl;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;      
    private static Number number;

    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;
    }
    
    public static void AddPlayer() {
        Player currentPlayer = Player.GetCurrentTurn();
        board[9][0] = new OvalPiece(Color.PINK);
    }
    
    public static int DiceMove() {
        int spaceMoved = Dice.DiceRollNumber();
        return(spaceMoved);
    }
    
//    public static void DiceRoll() {
//        
//    }
    
    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int num = 1;
        number = new Number(xdelta,ydelta,num);
        number.draw(g,xdelta,ydelta);
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
        
    }
}

    
