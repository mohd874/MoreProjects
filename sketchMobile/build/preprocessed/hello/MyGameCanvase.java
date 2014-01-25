/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Saeed
 */
public class MyGameCanvase extends GameCanvas implements Runnable{

    boolean running;
    
    public MyGameCanvase(){
        super(true);
        running = true;
    }
    
    public void run() {
        while(running){
            
        }
    }

    public void stop(){
        running = false;
    }
}
