package snl;
import java.awt.*;

public class Number 
{
    private int row;
    private int column;
    private int _num;

    Number(int xdelta, int ydelta, int num) 
    {
        row = xdelta;
        column = ydelta;
        _num = num;
    }
    
public void draw(Graphics2D g,int xdelta,int ydelta) 
{
    g.setColor(Color.green);
    int zcolumn = column;
    int zrow = row;
    int num = _num;
    for (int i=0;i<num;i++) 
    {
        g.drawString("" + num, Window.getX(ydelta), Window.getX(xdelta*9-1));
        if (num <= 100)
        {
        zrow++;
        num*=zrow;
        ydelta*=num;
        }
        else if (num <= 100)
        {
        zcolumn++;
        xdelta*=zcolumn-6;
        }

    }
}
}
