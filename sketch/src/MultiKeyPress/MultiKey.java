package MultiKeyPress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class RenderPane extends JPanel {
	int keys[];
	public RenderPane() {
		keys = new int[256];
		Arrays.fill(keys,0); // 0 = key is up
		enableEvents(AWTEvent.KEY_EVENT_MASK);
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
		repaint();
	}
	protected boolean isKeyDown(int key) {
		return (keys[key] != 0);
	}
	protected boolean isKeyUp(int key) {
		return (keys[key] == 0);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.white);
		g.drawString("Keys being pressed:",10,10);
		String s = "";
		for (int j = 0;j < keys.length;j++) {
			if (isKeyDown(j)) {
				s+=KeyEvent.getKeyText(j)+" + ";
			}
		}
		g.drawString(s,10,100);
	}
}
public class MultiKey extends JFrame {
	RenderPane p;
	public MultiKey() {
		super();
		enableEvents(AWTEvent.KEY_EVENT_MASK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500,250));
		p = new RenderPane();
		getContentPane().add(p,BorderLayout.CENTER);
		show();
	}
	public void processKeyEvent(KeyEvent e) {
		p.processKeyEvent(e);
	}
	public static void main(String args[]) {
		new MultiKey();
	}
}