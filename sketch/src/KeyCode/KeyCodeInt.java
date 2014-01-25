/*
 * KeyCodeInt.java
 *
 * Created on September 1, 2007, 6:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Saeed
 */
public class KeyCodeInt extends JFrame implements KeyListener,MouseListener{

    /** Creates a new instance of KeyCodeInt */
    public KeyCodeInt() {
        super("keyCodeInt");
        setFocusable(true);
    requestFocus();
    setVisible(true);
    addKeyListener(this);
    addMouseListener(this);
System.out.println("e.getKeyCode(): ");
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("e.getKeyCode(): "+e.getKeyCode());
                
        if(e.getKeyCode() == e.VK_ENTER){
            System.exit(0);
}
    }

    public void keyPressed(KeyEvent e) {
         System.out.println("e.getKeyCode(): "+e.getKeyCode());
                
        if(e.getKeyCode() == e.VK_ENTER){
            System.exit(0);
    }
}
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
    new KeyCodeInt();
}

    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
