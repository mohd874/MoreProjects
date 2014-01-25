/*
 * RaidenGame.java
 *
 * Created on September 1, 2007, 3:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package raindenGame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Saeed
 */
public class RaidenGame extends JFrame implements WindowListener{

JPanel rc;
int FRAMEWIDTH = 640;
int FRAMEHIGHT = 480;
    /** Creates a new instance of RaidenGame */
    public RaidenGame() {
    this.setSize(FRAMEWIDTH,FRAMEHIGHT);
    rc = new RaidenContainer(this);

    pack();
    //setResizable(false);
    setSize(FRAMEWIDTH,FRAMEHIGHT);
    addWindowListener(this);
    setContentPane(rc);
    setVisible(true);
    }
public static void main(String[] args) {
    new RaidenGame();
}

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
