/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Saeed
 */
public class Midlet extends MIDlet {
    
    private MyGameCanvase gameCanvas;
    private Thread t;
    private Display d;
    
    public void startApp() {
        this.gameCanvas = new MyGameCanvase();
        this.t = new Thread(gameCanvas);
        t.start();
        d = Display.getDisplay(this);
        d.setCurrent(gameCanvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        gameCanvas.stop();
    }
}
