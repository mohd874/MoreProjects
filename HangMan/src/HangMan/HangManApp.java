/*
 * HangManApp.java
 *
 * Created on May 15, 2007, 9:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package HangMan;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author S200200874
 */
public class HangManApp extends JPanel implements Runnable,MouseListener{
    
    Thread gameLoop;
    BufferedImage backbuffer;
    Graphics2D g2d;
    
    /** Creates a new instance of HangManApp */
    public HangManApp() {
        setFocusable(true);
        requestFocus();
        
        backbuffer = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
        g2d = backbuffer.createGraphics();
        
        addMouseListener(this);
    }
    
    public void start(){
        gameLoop = new Thread(this);
        gameLoop.start();
    }
    
    public void run() {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("HangMan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        HangManApp hm = new HangManApp();
        frame.getContentPane().add(hm,BorderLayout.CENTER);
        
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        hm.start();
    }
    
}
