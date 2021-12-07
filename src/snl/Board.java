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
    
    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int Num = 1;
        g.setColor(Color.MAGENTA);
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
                    if(NUM_ROWS==10)
                    {
                    g.drawString("" + Num, Window.getX(ydelta), Window.getX(xdelta*9-1));
                    g.drawString("" + Num*2, Window.getX(ydelta*2), Window.getX(xdelta*9-1));
                    g.drawString("" + Num*3, Window.getX(ydelta*3), Window.getX(xdelta*9-1));
                    g.drawString("" + Num*4, Window.getX(ydelta*4), Window.getX(xdelta*9-1));
                    g.drawString("" + Num*5, Window.getX(ydelta*5), Window.getX(xdelta*9-1));
                    }
                    
                    g.drawString("" + Num*1+1, Window.getX(ydelta*1+1), Window.getX(xdelta*8+5));
                    g.drawString("" + Num*2+2, Window.getX(ydelta*2+1), Window.getX(xdelta*7+11));
                    g.drawString("" + Num*3+1, Window.getX(ydelta-8), Window.getX(xdelta*6+17));
                    g.drawString("" + Num*4+1, Window.getX(ydelta-8), Window.getX(xdelta*5+23));
                    g.drawString("" + Num*5+1, Window.getX(ydelta-8), Window.getX(xdelta*4+29));
                    g.drawString("" + Num*6+1, Window.getX(ydelta-8), Window.getX(xdelta*3+35));
                    g.drawString("" + Num*7+1, Window.getX(ydelta-8), Window.getX(xdelta*2+41));
                    g.drawString("" + Num*8+1, Window.getX(ydelta-8), Window.getX(xdelta*1+47));
                    g.drawString("" + Num*9+1, Window.getX(ydelta-8), Window.getX(xdelta*0+53));
                }
            }
        }
    }
}

    
