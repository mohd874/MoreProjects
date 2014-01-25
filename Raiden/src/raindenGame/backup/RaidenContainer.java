/*
 * RaidenContainer.java
 *
 * Created on September 1, 2007, 3:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package raindenGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Saeed
 */
public class RaidenContainer extends JPanel implements KeyListener, Runnable{
    JFrame rg;
    Player p;
    int loops = 0;
    Image image2Render;

    int LEFT,RIGHT,DOWN,UP;
    /** Creates a new instance of RaidenContainer */
    public RaidenContainer(JFrame rg) {
        LEFT = KeyEvent.VK_LEFT;
        RIGHT = KeyEvent.VK_RIGHT;
        UP = KeyEvent.VK_UP;
        DOWN = KeyEvent.VK_DOWN;
        
        this.rg = rg;
        this.setSize(rg.getSize());
        setFocusable(true);
        requestFocus();
        
        p = new Player(this);
        image2Render = createImage(this.getWidth(),this.getHeight());
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        
       if(e.getKeyCode() == LEFT){
           p.setPositionX(p.getPositionX()-p.getSpeed()); 
           System.out.println("Player potition: X="+p.getPositionX()+" Y="+p.getPositionY());
       }
       if(e.getKeyCode() == RIGHT){
           p.setPositionX(p.getPositionX()+p.getSpeed()); 
System.out.println("Player potition: X="+p.getPositionX()+" Y="+p.getPositionY());
       }
       if(e.getKeyCode() == UP){
           p.setPositionX(p.getPositionY()-p.getSpeed()); 
System.out.println("Player potition: X="+p.getPositionX()+" Y="+p.getPositionY());
       }
       if(e.getKeyCode() == DOWN){
           p.setPositionX(p.getPositionY()+p.getSpeed()); 
System.out.println("Player potition: X="+p.getPositionX()+" Y="+p.getPositionY());
       }

    }

    public void keyReleased(KeyEvent e) {
    }

    public void run() {
    
        
    }

    protected void paintComponent() {
        Graphics g;
    try {
      g = this.getGraphics();
      if ((g != null) && (image2Render != null))
        g.drawImage(image2Render, 0, 0, null);
      Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
      g.dispose();
    }
    catch (Exception e)
    { System.out.println("Graphics error: " + e);  }
    }

    public void gameUpdate(){
        loops++;
    }
    public void gameRender(){
        Graphics g = image2Render.getGraphics();
        //g.drawRect(0,0,this.getWidth(),this.getHeight());
        g.drawOval(p.getPositionX(),p.getPositionY(),p.getWIDTH(),p.getHIGHT());
    }
    public void gamePaint(){
        this.paintComponent();
    }

}


