package snl;
import java.awt.*;

public class Number 
{
    private int _num;

    Number(int xdelta, int ydelta, int num) 
    {
        _num = num;
    }
    
public void draw(Graphics2D g,int xdelta,int ydelta) 
{
    g.setColor(Color.green);
    int num = _num;

        g.drawString("" + num, Window.getX(ydelta), Window.getX(xdelta*9-1));
        
    }
}
