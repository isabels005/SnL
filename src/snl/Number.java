package snl;
import java.awt.*;

public class Number extends Piece
{
    private static int num = 1;

Number(Color _color,int zrow,int zcol)
    {
        super(_color);
        num += numberAdd(zrow,zcol);
    }    
    
    public static int numberAdd(int zrow,int zcol)
    {
        zrow = 0;
        zcol = 0;
        int value = num;
        for(int i=0;i<Board.getNumColumns();i++)
        {
            if(zrow <= 1)
            {
                value++;
                zrow++;
            }
            zrow++;
        }
        return value;
    }    
     

public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
{
    g.setColor(getColor());
    g.setFont (new Font ("Arial",Font.PLAIN,30));
    g.drawString(""+num,Window.getX(column*xdelta)+22, Window.getY(row*ydelta)+42);

//    g.drawString("" + num, Window.getX(ydelta), Window.getX(xdelta*9-1));
//        g.drawString("" + num*2, Window.getX(ydelta*2+5), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*3, Window.getX(ydelta*3+10), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*4, Window.getX(ydelta*4+15), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*5, Window.getX(ydelta*5+20), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*6, Window.getX(ydelta*6+25), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*7, Window.getX(ydelta*7+30), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*8, Window.getX(ydelta*8+35), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*9, Window.getX(ydelta*9+40), Window.getX(xdelta*9-1));
//                    g.drawString("" + num*10, Window.getX(ydelta*10+45), Window.getX(xdelta*9-1));
//                    
//                    g.drawString("" + num*1+1, Window.getX(ydelta*1-8), Window.getX(xdelta*8+5));
//                    g.drawString("" + num*2+1, Window.getX(ydelta-8), Window.getX(xdelta*7+11));
//                    g.drawString("" + num*3+1, Window.getX(ydelta-8), Window.getX(xdelta*6+17));
//                    g.drawString("" + num*4+1, Window.getX(ydelta-8), Window.getX(xdelta*5+23));
//                    g.drawString("" + num*5+1, Window.getX(ydelta-8), Window.getX(xdelta*4+29));
//                    g.drawString("" + num*6+1, Window.getX(ydelta-8), Window.getX(xdelta*3+35));
//                    g.drawString("" + num*7+1, Window.getX(ydelta-8), Window.getX(xdelta*2+41));
//                    g.drawString("" + num*8+1, Window.getX(ydelta-8), Window.getX(xdelta*1+47));
//                    g.drawString("" + num*9+1, Window.getX(ydelta-8), Window.getX(xdelta*0+53));
    }
}