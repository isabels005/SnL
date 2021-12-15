package snl;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class SnL extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    boolean chooseNumPlayers = true;
    Image image;
    Graphics2D g;
    
    //ladder image
    Image ladderImage;
    //snake images
    Image bwSnakeHiss;
    Image bwSnakeUp;
    Image bwSnakeRight;
    Image bwSnakeLeft;
    Image smolSnake;

    //background images
    Image vaporwaveBackground;
    Image partlyTransparent;
    
    //dice images
    Image dice1;
    Image dice2;
    Image dice3;
    Image dice4;
    Image dice5;
    Image dice6;
    
    public static void main(String[] args) {
        SnL frame = new SnL();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public SnL() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    Dice.Roll();
                }

                if (e.BUTTON3 == e.getButton()) {
                    Board.AddPlayer();
                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
//        g.setColor(Color.ORANGE);
//        g.fillRect(0, 0, Window.xsize, Window.ysize);
          g.drawImage(vaporwaveBackground,0,0,700,700,this);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
//        g.setColor(Color.white);
//        g.fillPolygon(x, y, 4);
        g.drawImage(partlyTransparent,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
// draw border

        g.setColor(Color.cyan);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        if (chooseNumPlayers) {
             g.setColor(Color.black);
            StringCentered(g,250,554,"Welcome! Type in your amount of players (1,2,3,4).","Arial",30);
            
            chooseNumPlayers = false;
        }

        
        
        g.drawImage(ladderImage,180,145,130,110,this); 
        g.drawImage(ladderImage,0,245,130,75,this);   //     
        g.drawImage(ladderImage,480,200,130,110,this);  
        g.drawImage(ladderImage,240,270,130,160,this);  
        g.drawImage(ladderImage,60,430,130,160,this);  
        g.drawImage(ladderImage,240,470,130,75,this);  //
//        g.drawRotImage(ladderImage,60,430,0.0,-1.0,1.0,this);         
        //g.drawImage(bwSnakeHiss,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
       

        g.drawImage(bwSnakeHiss,450,505,60,60,this);
        g.drawImage(bwSnakeHiss,150,235,60,60,this);
        
        g.drawImage(bwSnakeUp,340,240,200,240,this);
        g.drawImage(bwSnakeUp,10,80,150,200,this);
        
        g.drawImage(bwSnakeRight,100,320,150,100,this);
        
        g.drawImage(bwSnakeLeft,160,470,150,120,this);
        g.drawImage(bwSnakeLeft,510,400,100,90,this);
        
        g.drawImage(smolSnake,270,120,60,60,this);
        g.drawImage(smolSnake,330,388,60,60,this);
        
        Board.Draw(g);
        
        if (Dice.number == 1)
            g.drawImage(dice1,580,30,40,40,this); 
        if(Dice.number == 2)
            g.drawImage(dice2,580,30,40,40,this); 
        if(Dice.number == 3)
            g.drawImage(dice3,580,30,40,40,this); 
        if(Dice.number == 4)
            g.drawImage(dice4,580,30,40,40,this); 
        if(Dice.number == 5)
            g.drawImage(dice5,580,30,40,40,this); 
        if(Dice.number == 6)
            g.drawImage(dice6,580,30,40,40,this); 
        
        
        gOld.drawImage(image, 0, 0, null);
    }
    
////////////////////////////////////////////////////////////////////////////
public static void StringCentered(Graphics2D g,int xpos,int ypos,String text,String font,int size)
    {
        g.setFont (new Font (font,Font.PLAIN, size)); 
        int width = g.getFontMetrics().stringWidth(text);
        int height = g.getFontMetrics().getHeight();
        xpos = xpos - width/2;
        ypos = ypos - height/4;
        xpos = Window.getX(xpos);
        ypos = Window.getYNormal(ypos);
        g.drawString(text, xpos, ypos);           
    }   

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Board.Reset();
        Player.Reset();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            ladderImage = Toolkit.getDefaultToolkit().getImage("./ladder.png");  

            bwSnakeHiss = Toolkit.getDefaultToolkit().getImage("./bwSnakeHiss2.png");
            bwSnakeUp = Toolkit.getDefaultToolkit().getImage("./bwSnakeUp2.png");
            bwSnakeRight = Toolkit.getDefaultToolkit().getImage("./bwSnakeRight2.png");
            bwSnakeLeft = Toolkit.getDefaultToolkit().getImage("./bwSnakeLeft2.png");
            smolSnake = Toolkit.getDefaultToolkit().getImage("./smolSnake.png");


            vaporwaveBackground = Toolkit.getDefaultToolkit().getImage("./vaporwaveBackground.png");
            partlyTransparent = Toolkit.getDefaultToolkit().getImage("./partlyTransparent.png");
            
            dice1 = Toolkit.getDefaultToolkit().getImage("./dice1.png");
            dice2 = Toolkit.getDefaultToolkit().getImage("./dice2.png");
            dice3 = Toolkit.getDefaultToolkit().getImage("./dice3.png");
            dice4 = Toolkit.getDefaultToolkit().getImage("./dice4.png");
            dice5 = Toolkit.getDefaultToolkit().getImage("./dice5.png");
            dice6 = Toolkit.getDefaultToolkit().getImage("./dice6.png");
            
            reset();

        }

        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}