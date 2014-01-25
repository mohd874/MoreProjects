package animationFramework;

/* 
Based on 
WormChase.java
Andrew Davison, April 2005, ad@fivedots.coe.psu.ac.th
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameFrame extends JFrame implements WindowListener
{
  private static int DEFAULT_FPS = 80;

  private GamePanel gp;        // where the game elements is drawn

  public GameFrame(int period)
  { super("The Worm Chase");
    makeGUI(period);

    addWindowListener( this );
    pack();
    setResizable(false);
    setVisible(true);
  }  // end of WormChase() constructor


  private void makeGUI(int period)
  {
    Container c = getContentPane();    // default BorderLayout used

    gp = new GamePanel(this, period);
    c.add(gp, "Center");

    JPanel ctrls = new JPanel();   // a row of textfields
    ctrls.setLayout( new BoxLayout(ctrls, BoxLayout.X_AXIS));

  }  // end of makeGUI()


  // ----------------- window listener methods -------------

  public void windowActivated(WindowEvent e) 
  { gp.resumeGame();  }

  public void windowDeactivated(WindowEvent e) 
  {  gp.pauseGame();  }


  public void windowDeiconified(WindowEvent e) 
  {  gp.resumeGame();  }

  public void windowIconified(WindowEvent e) 
  {  gp.pauseGame(); }


  public void windowClosing(WindowEvent e)
  {  gp.stopGame();  }

  public void windowClosed(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}

  // ----------------------------------------------------

  public static void main(String args[])
  { 
    int fps = DEFAULT_FPS;
    if (args.length != 0)
      fps = Integer.parseInt(args[0]);

    int period = (int) 1000.0/fps;
    System.out.println("fps: " + fps + "; period: " + period + " ms");

    new GameFrame(period);    // ms
  }

} // end of WormChase class


