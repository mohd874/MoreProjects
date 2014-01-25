package MoveShapeWithKeyboard;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/*
 * Raiden 4K Game
 * Code Copyright 2007 - Alexander Hristov. http://www.ahristov.com/tutorial
 * 
 * Code is provided as is for educational purposes. It cannot be posted publicly (either in 
 * electronic or printed form) or used in any other way without permission.
 */


public class MSWK3 extends JFrame {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;

	private int recX;
	private int recY;

        private int speed;
        
        //this will represent the bullet class
        private boolean isAlive;
        private int x,y;
        private int bulletSpeed;
        
        private boolean key[] = new boolean[65535];
	public static void main(String[] x) {
		new MSWK3();
	}

	public MSWK3() {
                
		setSize(WIDTH, HEIGHT);
                recX = WIDTH/2;
                recY = HEIGHT/2;
		setResizable(false);
		/***************************************************************************
		 * GLOBAL INITIALIZATION
		 **************************************************************************/
                 
                 speed = 1;
                setVisible(true);
		createBufferStrategy(2);
		BufferStrategy strategy = getBufferStrategy();

		long lastFrame = 0;
		Graphics g;
		// GAME LOOP
		while (true) {
                        if (!isVisible()) {
				System.exit(0);
			}
                        if (key[KeyEvent.VK_UP]) recY -= speed;
                        if (key[KeyEvent.VK_DOWN]) recY += speed;
                        if (key[KeyEvent.VK_LEFT]) recX -= speed;
                        if (key[KeyEvent.VK_RIGHT]) recX += speed;
//                        if (key[KeyEvent.VK_SPACE]){ 
//                        x = recX/2;
//                        y = recY/2;
//                        isAlive = true;
//                        Thread t = new Thread(new Runnable() {
//
//                                                        public void run() {
//                                                        while(isAlive){
//                                                            //x++;
//                                                            y -= 0.01;
//                                                            
//                                                            }
//                                                        }
//                                                });
//                        t.start();
//                        }

                        if(recX > WIDTH)recX=-5;
                        if(recX < -5)recX=WIDTH;
                        if(recY > HEIGHT)recY=-5;
                        if(recY < -5)recY=HEIGHT;

                        g = strategy.getDrawGraphics();
                        
                        g.setColor(Color.WHITE);
                        g.fillRect(0,0,WIDTH,HEIGHT);
                        g.setColor(Color.BLACK);
                        g.fillRect(recX,recY,5,5);
                        g.setColor(Color.RED);
                        g.fillRect(x,y,2,2);
                        
                        strategy.show();
		}
	}

	protected void processKeyEvent(KeyEvent e) {
		key[e.getKeyCode()] = e.getID() == KeyEvent.KEY_PRESSED;
	}

}

/*
 * 2160 - Basic Game mechanics completed ( opt : 2080 ) 
 * 2389 - 5 Different
 * movement patterns 
 * 2599 - 7 movement patterns + 4 firing patterns 
 * 2700 - Wave scripting, 2 waves 
 * 3442 - Scrolling scenery + boulder generation - Optimized  to 3301 
 * 3514 - scenery : boulder+random lines 
 * 3430 - removed add-on graphics initialization 
 * 3831 - scenery : trees+random lines+lakes - Optimized to 3623
 * 3820 - no lakes, player graphics 
 * 3854 - 1 bullet graphics 
 * 3993 - 1 enemy graphics  
 * 3847 - no fps, no extended game over text. Optimized to 3671 
 * 3969 - explosions 
 * 3784 - radical code simplification.Collision must be improved.  Optimized to 3616 
 * 3920 - two powerups 
 * 4143 - four different powerups - 3992
 * 4204 - bullet powerup graphics = diamonds - 4037 
 * 4168 - Simplified explosion graphics 
 * 4170 - Three waves 
 * 4147 - Defender.class - >D.class 
 * 4110 - Further color optimizations -- 3963 
 * 4087 - Eearth gradient removed, new GeneralPath()  replaced by path.reset() 
 * 4026 - Replaced all Color.xx constants with new Color() 
 * 4006 - Reused for variable declarations 
 * 4004 - Reused slot variable - 3860 
 * 4044 - Two different bullet types 
 * 4105 - Image sizes, proper collision detection -- 3956 
 * 4116 - Three bullet types, status in the lower part 4084 Player graphics (propulsion) optimized. 
 * 4125 - Variable enemy speed + shield  red if low 
 * 4159 - 6 powerups 
 * 4157 - Random wave generation 
 * 4239 - Variable  player firing speed - 4093 
 * 4244 - Correct random wave generation. Removed horizontal firing stance - no use - 4088 
 * 4257 - Set enemy speed to 1 -- 4097 
 * 4255 - Slight displacement of the GAME OVER text 
 * 4252 - "Score :" to "Score"
 * 4237 - Fixed pause to next wave to 5 sec 
 * 4225 - All player bullets have the same aspect 
 * 4140 - Removed gradientpaint usage 
 * 4206 - 2 different enemies
 * 4279 - 3 different enemies -- 4118 
 * 4226 - simplified 1st enemy and converted it to a simpler fighter -- 4068 
 * 4237 - everything fixed 
 * 4261 - Changed powerup image to microchip 
 * 4245 - Small powerup calculation fix 
 * 4164 - Simplified tree drawing, increased tree color contrast 
 * 4184 - Better trees
 * 4274 - Boss + Boss battle each 10 levels. 
 * 4256 - Color simplification in trees 
 * 4245 - Scratching bytes with my bloody nails here and there :-/
 * 
 * (Optimized size)
 * 4067 - Yay! After very extensive optimization of arrays, there's now
 *        1 more enemy (albeit partially reusing an image) and some more
 *        bytes available 
 *        
 * 4063 - Optimization of the laserPower stuff. (JOGA+PROGUARD+kzip/256)
 * 
 * 4280
 * 4246
 */
