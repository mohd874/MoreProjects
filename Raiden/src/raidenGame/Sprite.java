/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raidenGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Saeed
 */
public class Sprite {

    Image[] sequence; 
    
    int currentSequnce;
    
    public Sprite(List<String> imagesPath){
        sequence = new Image[imagesPath.size()];
        for (int i = 0; i < sequence.length; i++) {
            try {
                sequence[i] = ImageIO.read(getClass().getResource(imagesPath.get(i)));
            } catch (IOException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void play(Graphics2D g2d){
        g2d.drawImage(sequence[currentSequnce],0,0,null);
        currentSequnce++;
    }
}
