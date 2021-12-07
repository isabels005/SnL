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

    public void setHighlight(int _row,int _column,int _num) {
        row = _row;
        column = _column;
        num = _num;     
    }
    
public void draw(Graphics2D g,int xdelta,int ydelta) 
{

}
}
