/*
 * BaseGameElement.java
 *
 * Created on September 1, 2007, 3:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package raindenGame;

/**
 *
 * @author Saeed
 */
public class BaseGameElement {
    private int positionX;
    private int positionY;
    private int speed;
    private int hitPoints;
    
    /** Creates a new instance of BaseGameElement */
    public BaseGameElement() {
        setPositionX(0);
setPositionY(0);
setSpeed(1);
setHitPoints(3);
    }

    public BaseGameElement(int x, int y, int s, int hp){
    setPositionX(x);
setPositionY(y);
setHitPoints(hp);
setSpeed(s);
}

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
