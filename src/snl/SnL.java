package snl;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class SnL extends JFrame implements Runnable {
    boolean animateFirstTime = true;
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

    Image vaporwaveBackground;
    Image partlyTransparent;
    
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
                    
                }

                if (e.BUTTON3 == e.getButton()) {

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

        Board.Draw(g);

        g.drawImage(ladderImage,180,145,130,110,this); 
        g.drawImage(ladderImage,0,245,130,75,this);   //     
        g.drawImage(ladderImage,480,200,130,110,this);  
        g.drawImage(ladderImage,240,470,130,75,this);  //
        g.drawImage(ladderImage,60,430,130,160,this);  
//        g.drawRotImage(ladderImage,60,430,0.0,-1.0,1.0);         
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
        

        

        gOld.drawImage(image, 0, 0, null);
    }
    
////////////////////////////////////////////////////////////////////////////
//public void drawRotImage(Image image,int xpos,int ypos,double rot,double xscale,double yscale) {
//        int width = image.getWidth(thisObj);
//        int height = image.getHeight(thisObj);
//        g.translate(xpos,ypos);
//        g.rotate(rot  * Math.PI/180.0);
//        g.scale( xscale , yscale );
//
//        g.drawImage(image,-width/2,-height/2,
//        width,height,thisObj);
//
//        g.scale( 1.0/xscale,1.0/yscale );
//        g.rotate(-rot  * Math.PI/180.0);
//        g.translate(-xpos,-ypos);
//    }  

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

            bwSnakeHiss = Toolkit.getDefaultToolkit().getImage("./bwSnakeHiss.png");
            bwSnakeUp = Toolkit.getDefaultToolkit().getImage("./bwSnakeUp.png");
            bwSnakeRight = Toolkit.getDefaultToolkit().getImage("./bwSnakeRight.png");
            bwSnakeLeft = Toolkit.getDefaultToolkit().getImage("./bwSnakeLeft.png");
            smolSnake = Toolkit.getDefaultToolkit().getImage("./smolSnake.png");


            vaporwaveBackground = Toolkit.getDefaultToolkit().getImage("./vaporwaveBackground.png");
            partlyTransparent = Toolkit.getDefaultToolkit().getImage("./partlyTransparent.png");
            
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