package snl;
import java.awt.*;

public class Number 
{
    private int row;
    private int column;
    private int num;
    
 Number(int _row,int _column,int _num)
    {
        row = _row;
        column = _column;
        num = _num;
    }


    public void Number(int _row,int _column,int _num) {
        row = _row;
        column = _column;
        num = _num;     
    }
    
public void draw(Graphics2D g,int xdelta,int ydelta) 
{
    g.setColor(Color.green);
    int zcolumn = column;
    int zrow = row;
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
        zcolumn++;
        xdelta*=zcolumn-6;
    }
}
}
