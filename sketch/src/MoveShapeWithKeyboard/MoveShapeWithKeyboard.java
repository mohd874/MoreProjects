/*
 * MoveShapeWithKeyboard.java
 *
 * Created on September 3, 2007, 11:45 AM
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
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Saeed
 */
class panel extends JPanel implements Runnable, ImageProducer{
    int keys[];
    boolean  bokey[] ;
    int recX, recY;
    Image img;
    MoveShapeWithKeyboard mswk;
    /** Creates a new instance of MoveShapeWithKeyboard */
    public panel(MoveShapeWithKeyboard mswk) {
        this.mswk = mswk;
        bokey = new boolean[65535];
        keys = new int[256];
        Arrays.fill(keys,0); // 0 = key is up
        enableEvents(AWTEvent.KEY_EVENT_MASK);
        recX = mswk.getWidth()/2;
        recY = mswk.getHeight()/2;
//        img = createImage(mswk.getWidth(),mswk.getHeight());
//                this.run();
    }
    
public void processKeyEvent(KeyEvent e) {
                
		// the 0xff below binds the key code to below 256
		int key = (e.getKeyCode()&0xff);
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			keys[key] = 1; // 1 = key is down
		}
		else if (e.getID() == KeyEvent.KEY_RELEASED) {
			keys[key] = 0; // 0 = key is up
		}
                
//                if(e.getKeyCode() == e.VK_LEFT)
//                    recX -= 1;
//                if(e.getKeyCode() == e.VK_RIGHT)
//                    recX += 1;
//                if(e.getKeyCode() == e.VK_UP)
//                    recY -= 1;
//                if(e.getKeyCode() == e.VK_DOWN)
//                    recY += 1;

                bokey[e.getKeyCode()] = e.getID() == KeyEvent.KEY_PRESSED;
                if (bokey[KeyEvent.VK_LEFT]) recX -= 1;
                if (bokey[KeyEvent.VK_RIGHT]) recX += 1;
                if (bokey[KeyEvent.VK_UP]) recY -= 1;
                if (bokey[KeyEvent.VK_DOWN]) recY += 1;
		repaint();
	}
	protected boolean isKeyDown(int key) {
		return (keys[key] != 0);
	}
	protected boolean isKeyUp(int key) {
		return (keys[key] == 0);
	}
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.white);
		//g.drawString("Keys being pressed:",10,10);
                g.fillRect(recX,recY,5,5);
		String s = "";
		for (int j = 0;j < keys.length;j++) {
			if (isKeyDown(j)) {
				s+=KeyEvent.getKeyText(j)+" + ";
			}
		}
		g.drawString(s,10,100);
	}

    public void run() {
        while(true){
                if (bokey[KeyEvent.VK_UP]) recX -= 1;
                if (bokey[KeyEvent.VK_DOWN]) recX += 1;
                if (bokey[KeyEvent.VK_LEFT]) recY -= 1;
                if (bokey[KeyEvent.VK_RIGHT]) recY += 1;
		//repaint();
//                img = createImage(mswk.getWidth(),mswk.getHeight());
                img = createImage(this);
                if(img == null)
                    System.out.println("img is null");
                paintComponent(img.getGraphics());
        }
    }

    public void addConsumer(ImageConsumer ic) {
    }

    public boolean isConsumer(ImageConsumer ic) {
        return true;
    }

    public void removeConsumer(ImageConsumer ic) {
    }

    public void startProduction(ImageConsumer ic) {
    }

    public void requestTopDownLeftRightResend(ImageConsumer ic) {
    }

}
public class MoveShapeWithKeyboard extends JFrame {
	panel p;
	public MoveShapeWithKeyboard() {
		super();
		enableEvents(AWTEvent.KEY_EVENT_MASK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500,250));
		p = new panel(this);
		getContentPane().add(p,BorderLayout.CENTER);
		show();
	}
	public void processKeyEvent(KeyEvent e) {
		p.processKeyEvent(e);
	}
	public static void main(String args[]) {
		new MoveShapeWithKeyboard();
	}
}

