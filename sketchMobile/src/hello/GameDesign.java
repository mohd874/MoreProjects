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
public class GameDesign {

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image platform_tiles;
    private Image ARC1;
    private Image topview_tiles;
    public int anime1seq001Delay = 200;
    public int[] anime1seq001 = {0};
    private TiledLayer layer1;
    private Sprite sprite1;
    public int sprite1_downDelay = 200;
    public int[] sprite1_down = {88, 89, 90, 91};
    public int sprite1_upDelay = 200;
    public int[] sprite1_up = {94, 95, 96, 97};
    public int sprite1_sideDelay = 200;
    public int[] sprite1_side = {100, 101, 102, 103};
    private TiledLayer layer2;
    //</editor-fold>//GEN-END:|fields|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|



    public Image getPlatform_tiles() throws java.io.IOException {//GEN-BEGIN:|2-getter|0|2-preInit
        if (platform_tiles == null) {//GEN-END:|2-getter|0|2-preInit
            // write pre-init user code here
            platform_tiles = Image.createImage("/platform_tiles.png");//GEN-BEGIN:|2-getter|1|2-postInit
        }//GEN-END:|2-getter|1|2-postInit
        // write post-init user code here
        return this.platform_tiles;//GEN-BEGIN:|2-getter|2|
    }
//GEN-END:|2-getter|2|



    public Image getTopview_tiles() throws java.io.IOException {//GEN-BEGIN:|8-getter|0|8-preInit
        if (topview_tiles == null) {//GEN-END:|8-getter|0|8-preInit
            // write pre-init user code here
            topview_tiles = Image.createImage("/topview_tiles.png");//GEN-BEGIN:|8-getter|1|8-postInit
        }//GEN-END:|8-getter|1|8-postInit
        // write post-init user code here
        return this.topview_tiles;//GEN-BEGIN:|8-getter|2|
    }
//GEN-END:|8-getter|2|





    public Image getARC1() throws java.io.IOException {//GEN-BEGIN:|38-getter|0|38-preInit
        if (ARC1 == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            ARC1 = Image.createImage("/ARC1.png");//GEN-BEGIN:|38-getter|1|38-postInit
        }//GEN-END:|38-getter|1|38-postInit
        // write post-init user code here
        return this.ARC1;//GEN-BEGIN:|38-getter|2|
    }
//GEN-END:|38-getter|2|





    public void updateLayerManagerForScene1(LayerManager lm) throws java.io.IOException {//GEN-LINE:|42-updateLayerManager|0|42-preUpdate
        // write pre-update user code here
//GEN-LINE:|42-updateLayerManager|1|42-postUpdate
        // write post-update user code here
    }//GEN-BEGIN:|42-updateLayerManager|2|
//GEN-END:|42-updateLayerManager|2|

    public TiledLayer getLayer1() throws java.io.IOException {//GEN-BEGIN:|43-getter|0|43-preInit
        if (layer1 == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            layer1 = new TiledLayer(24, 24, getPlatform_tiles(), 16, 16);//GEN-BEGIN:|43-getter|1|43-midInit
            int[][] tiles = {
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
            };//GEN-END:|43-getter|1|43-midInit
            // write mid-init user code here
            for (int row = 0; row < 24; row++) {//GEN-BEGIN:|43-getter|2|43-postInit
                for (int col = 0; col < 24; col++) {
                    layer1.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|43-getter|2|43-postInit
        // write post-init user code here
        return layer1;//GEN-BEGIN:|43-getter|3|
    }
//GEN-END:|43-getter|3|

    public Sprite getSprite1() throws java.io.IOException {//GEN-BEGIN:|45-getter|0|45-preInit
        if (sprite1 == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            sprite1 = new Sprite(getTopview_tiles(), 16, 16);//GEN-BEGIN:|45-getter|1|45-postInit
            sprite1.setFrameSequence(sprite1_down);//GEN-END:|45-getter|1|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return sprite1;
    }
//GEN-END:|45-getter|2|

    public TiledLayer getLayer2() throws java.io.IOException {//GEN-BEGIN:|53-getter|0|53-preInit
        if (layer2 == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            layer2 = new TiledLayer(24, 24, getPlatform_tiles(), 16, 16);//GEN-BEGIN:|53-getter|1|53-midInit
            int[][] tiles = {
                { 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 67, 67, 67, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 67, 67, 67, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 28, 72, 0, 67, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 28, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 25, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 25, 0, 25, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 25, 0, 25, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
            };//GEN-END:|53-getter|1|53-midInit
            // write mid-init user code here
            for (int row = 0; row < 24; row++) {//GEN-BEGIN:|53-getter|2|53-postInit
                for (int col = 0; col < 24; col++) {
                    layer2.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|53-getter|2|53-postInit
        // write post-init user code here
        return layer2;//GEN-BEGIN:|53-getter|3|
    }
//GEN-END:|53-getter|3|

}
