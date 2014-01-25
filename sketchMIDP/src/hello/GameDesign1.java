/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author Saeed
 */
public class GameDesign1 {

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image topview_tiles;
    private Sprite sprite1;
    public int sprite1seq001Delay = 200;
    public int[] sprite1seq001 = {88, 89, 90, 91};
    //</editor-fold>//GEN-END:|fields|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    public Image getTopview_tiles() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (topview_tiles == null) {//GEN-END:|1-getter|0|1-preInit
            // write pre-init user code here
            topview_tiles = Image.createImage("/topview_tiles.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
        // write post-init user code here
        return this.topview_tiles;//GEN-BEGIN:|1-getter|2|
    }
//GEN-END:|1-getter|2|

    public Sprite getSprite1() throws java.io.IOException {//GEN-BEGIN:|2-getter|0|2-preInit
        if (sprite1 == null) {//GEN-END:|2-getter|0|2-preInit
            // write pre-init user code here
            sprite1 = new Sprite(getTopview_tiles(), 16, 16);//GEN-BEGIN:|2-getter|1|2-postInit
            sprite1.setFrameSequence(sprite1seq001);//GEN-END:|2-getter|1|2-postInit
            // write post-init user code here
        }//GEN-BEGIN:|2-getter|2|
        return sprite1;
    }
//GEN-END:|2-getter|2|

}
