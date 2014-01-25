/*
 * player.java
 *
 * Created on September 1, 2007, 3:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package raindenGame;

import javax.swing.JPanel;

/**
 *
 * @author Saeed
 */
public class Player extends BaseGameElement{

private Bullet bullets[];
private JPanel rc;
    private int WIDTH;
    private int HIGHT;
    /** Creates a new instance of player */

    public Player(JPanel rc){
        super();
        this.setRc(rc);
        setWIDTH(10);
        setHIGHT(10);
        setHitPoints(1);
        setBullets(new Bullet[10]);
        for (int i = 0; i < getBullets().length; i++) {
            getBullets()[i] = new Bullet();
        }
}

    public Bullet[] getBullets() {
        return bullets;
    }

    public void setBullets(Bullet[] bullets) {
        this.bullets = bullets;
    }

    public JPanel getRc() {
        return rc;
    }

    public void setRc(JPanel rc) {
        this.rc = rc;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHIGHT() {
        return HIGHT;
    }

    public void setHIGHT(int HIGHT) {
        this.HIGHT = HIGHT;
    }
    }
