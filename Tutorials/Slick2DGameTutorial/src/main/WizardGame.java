/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Saeed
 */
public class WizardGame extends BasicGame{

    public WizardGame() {
        super("Wizard Game");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            AppGameContainer app = new AppGameContainer(new WizardGame());
            app.setDisplayMode(500, 400, false);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer arg0) throws SlickException {
    }

    @Override
    public void update(GameContainer arg0, int arg1) throws SlickException {
    }

    public void render(GameContainer arg0, Graphics arg1) throws SlickException {
    }

}
