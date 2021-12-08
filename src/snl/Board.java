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
//<<<<<<< HEAD
        int num = 1;
        g.setColor(Color.MAGENTA);
//=======
        
        g.setColor(Color.cyan);
//>>>>>>> 7a439042ff7391e8adc7b02d2c402c2bec8183d9
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
        number = new Number(xdelta,ydelta,num);
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
            if (num <= 100)
                {
                    if(NUM_ROWS==10)
                    {
                    g.drawString("" + num, Window.getX(ydelta), Window.getX(xdelta*9-1));
                    g.drawString("" + num*2, Window.getX(ydelta*2+5), Window.getX(xdelta*9-1));
                    g.drawString("" + num*3, Window.getX(ydelta*3+10), Window.getX(xdelta*9-1));
                    g.drawString("" + num*4, Window.getX(ydelta*4+15), Window.getX(xdelta*9-1));
                    g.drawString("" + num*5, Window.getX(ydelta*5+20), Window.getX(xdelta*9-1));
                    g.drawString("" + num*6, Window.getX(ydelta*6+25), Window.getX(xdelta*9-1));
                    g.drawString("" + num*7, Window.getX(ydelta*7+30), Window.getX(xdelta*9-1));
                    g.drawString("" + num*8, Window.getX(ydelta*8+35), Window.getX(xdelta*9-1));
                    g.drawString("" + num*9, Window.getX(ydelta*9+40), Window.getX(xdelta*9-1));
                    g.drawString("" + num*10, Window.getX(ydelta*10+45), Window.getX(xdelta*9-1));
                    }
                    
                    g.drawString("" + num*1+1, Window.getX(ydelta-8), Window.getX(xdelta*8+5));
                    g.drawString("" + num*2+1, Window.getX(ydelta-8), Window.getX(xdelta*7+11));
                    g.drawString("" + num*3+1, Window.getX(ydelta-8), Window.getX(xdelta*6+17));
                    g.drawString("" + num*4+1, Window.getX(ydelta-8), Window.getX(xdelta*5+23));
                    g.drawString("" + num*5+1, Window.getX(ydelta-8), Window.getX(xdelta*4+29));
                    g.drawString("" + num*6+1, Window.getX(ydelta-8), Window.getX(xdelta*3+35));
                    g.drawString("" + num*7+1, Window.getX(ydelta-8), Window.getX(xdelta*2+41));
                    g.drawString("" + num*8+1, Window.getX(ydelta-8), Window.getX(xdelta*1+47));
                    g.drawString("" + num*9+1, Window.getX(ydelta-8), Window.getX(xdelta*0+53));
                }
            }
        }
    }
}

    
