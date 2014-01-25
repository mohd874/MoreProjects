/*
 * MSWK2.java
 *
 * Created on September 4, 2007, 7:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package MoveShapeWithKeyboard;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Saeed
 */
class DrawingPanel extends JPanel{
    boolean key[];
    int recX, recY;
    Thread animation;
    /** Creates a new instance of DrawingPanel */
    public DrawingPanel() {
        key = new boolean[256];
        enableEvents(AWTEvent.KEY_EVENT_MASK);
        recX = this.getWidth()/2;
        recY = this.getHeight()/2;
        animation = new Thread(new Runnable() {
            public void run() {
                while(true){
            if (key[KeyEvent.VK_LEFT]) recX -= 1;
            if (key[KeyEvent.VK_RIGHT]) recX += 1;
            if (key[KeyEvent.VK_UP]) recY -= 1;
            if (key[KeyEvent.VK_DOWN]) recY += 1;
            repaint();
        }
            }
        });
        setVisible(true);
        animation.start();
    }

    public void paintComponents(Graphics g) {
                super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.white);
		g.fillRect(recX,recY,5,5);
		String s = "Running";
		
		g.drawString(s,10,100);
    }


    protected void processKeyEvent(KeyEvent e) {
		key[e.getKeyCode()] = e.getID() == KeyEvent.KEY_PRESSED;
    }

    private void animationStart() {
                
    }
}

public class MSWK2 extends JFrame{
    DrawingPanel p;
	public MSWK2() {
		super();
		enableEvents(AWTEvent.KEY_EVENT_MASK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500,250));
		p = new DrawingPanel();
		getContentPane().add(p,BorderLayout.CENTER);
		setVisible(true);
	}
	public void processKeyEvent(KeyEvent e) {
		p.processKeyEvent(e);
	}
	public static void main(String args[]) {
		new MSWK2();
	}
}
