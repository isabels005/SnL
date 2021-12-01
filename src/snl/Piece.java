package snl;
import java.awt.*;

public abstract class Piece {
    private Color color;
    private int value;
    Piece(Color _color)
    {
        color = _color;
        value = (int)(Math.random()*4);
    }
    public Color getColor()
    {
        return (color);
    }
    public int getValue()
    {
        return(value);
    }

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta)
    {
    
    }
    
}


