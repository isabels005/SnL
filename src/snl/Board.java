package snl;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;      
    static int Num = 1;

    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;        
    }
    
    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        g.setColor(Color.black);
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
            if (Num <= 100)
                {
                    g.drawString("" + Num, Window.getX(ydelta-3), Window.getX(xdelta*9-1));
                    g.drawString("" + Num*11, Window.getX(ydelta-8), Window.getX(xdelta*8+5));
                    g.drawString("" + Num*21, Window.getX(ydelta-8), Window.getX(xdelta*7+11));
                    g.drawString("" + Num*31, Window.getX(ydelta-8), Window.getX(xdelta*6+17));
                    g.drawString("" + Num*41, Window.getX(ydelta-8), Window.getX(xdelta*5+23));
                    g.drawString("" + Num*51, Window.getX(ydelta-8), Window.getX(xdelta*4+29));
                    g.drawString("" + Num*61, Window.getX(ydelta-8), Window.getX(xdelta*3+35));
                    g.drawString("" + Num*71, Window.getX(ydelta-8), Window.getX(xdelta*2+41));
                    g.drawString("" + Num*81, Window.getX(ydelta-8), Window.getX(xdelta*1+47));
                    g.drawString("" + Num*91, Window.getX(ydelta-8), Window.getX(xdelta*0+53));
                }
            }
        }
    }
}

    
