package snl;
import java.awt.*;

public class Number extends Piece
{
    private static int StaticNum = 100;
    private int num = 1;
Number(Color _color,int zrow,int zcol)
    {
        super(_color);
    num = StaticNum;
    StaticNum--;
    }    
    
public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
{
    g.setColor(getColor());
    g.setFont (new Font ("Arial",Font.PLAIN,30));
    g.drawString(""+num,Window.getX(column*xdelta)+22, Window.getY(row*ydelta)+42);
}
}