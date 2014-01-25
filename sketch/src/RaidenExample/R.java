package RaidenExample;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

/*
 * Raiden 4K Game
 * Code Copyright 2007 - Alexander Hristov. http://www.ahristov.com/tutorial
 * 
 * Code is provided as is for educational purposes. It cannot be posted publicly (either in 
 * electronic or printed form) or used in any other way without permission.
 */


public class R extends JFrame {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final int SCENERY_BAND = 200;
	private static final int SCENERY_HEIGHT = HEIGHT + SCENERY_BAND;
	private static final int SCENERY_WIDTH = WIDTH;
	// private static final int STATE_NEW_GAME = 0;
	private static final int STATE_PLAYING = 1;
	private static final int STATE_GAME_OVER = 2;
	private static final int STATE_INIT = 3;
	private static final int STATE_INIT_LEVEL = 4;
	private static final int STATE_LIFE_LOST = 5;

	private boolean key[] = new boolean[65535];

	private static final int MAX_ITEMS = 200;
	private static final int MAX_LIFE = 1650;
	private static final int ITEM_TYPE_ENEMY = 1;
	private static final int ITEM_TYPE_POWERUP = 2;
	private static final int ITEM_TYPE_PLAYER_BULLET = 3;
	private static final int ITEM_TYPE_ENEMY_BULLET = 4;
	private static final int ITEM_TYPE_PLAYER = 5;
	private static final int ITEM_TYPE_EXPLOSION = 6;

	private static final int PLAYER_SIZE = 32;
	private static final int STATUS_LINE = HEIGHT - 50;

	private static final int IMAGE_PLAYER = 18;
	private static final int IMAGE_PLAYER_BULLET = 7;
	private static final int IMAGE_ENEMY_BULLET = 3;
	private static final int IMAGE_PROTECTION_BULLET = 6;
	private static final int IMAGE_ENEMY_1 = 19;
	private static final int IMAGE_ENEMY_2 = 20;
	private static final int IMAGE_ENEMY_3 = 21;
	private static final int IMAGE_ENEMY_4 = 22;  // Not used explicitly, but here
	private static final int IMAGE_ENEMY_BOSS_1 = 90;

	private static final int IMAGE_POWERUP_SHIELD = 12;
	private static final int IMAGE_POWERUP_LIFE = 13;
	private static final int IMAGE_POWERUP_LASERPOWER = 14;
	private static final int IMAGE_POWERUP_PROTECTION = 15;
	private static final int IMAGE_POWERUP_BOMB = 16;
	private static final int IMAGE_POWERUP_FIREUP = 17;
	
	private static final int MAX_IMAGES = 91;
	private static final int MAX_POWERUPS = 6;

	private static final int MOVEMENT_SPEED = 5;

	/**
	 * Movement patterns
	 */
	// Downwards movement in the same column
	private static final int MOVE_DOWN = 1;

	// Sine wave ( frequency = movementParam )
	private static final int MOVE_SINE = 2;

	// Elliptical ( ry = movementParam )
	private static final int MOVE_ELLIPTICAL = 3;

	// First downwards, then after reaching height/movementParam of the screen -
	// stationary
	private static final int MOVE_STATIONARY = 4;

	// Cycloid (horizontal)
	private static final int MOVE_CYCLOID = 5;

	// Horizontal movement at y = movementParam
	private static final int MOVE_HORIZONTAL = 6;
	
	// Homing movement towards StartX/StartY
	//private static final int MOVE_HOMING = 7;

	// Movement according to VX and VY
	private static final int MOVE_VELOCITY = 7;

	// Protective movement around player
	private static final int MOVE_PROTECTIVE = 8;

	/**
	 * Firing patterns
	 * 
	 */
	// Fire downwards
	private static final int FIRE_DOWN = 0;

	// Fire towards player
	private static final int FIRE_TOWARDS = 1;

	// Sine firing pattern
	private static final int FIRE_SINE = 2;

	/**
	 * Wave information
	 */
	private static final int WAVE_ENEMIES = 0;
	private static final int WAVE_ENEMY_IMAGE = 1;
	private static final int WAVE_MOVEMENT_PATTERN = 2;
	private static final int WAVE_MOVEMENT_PARAM = 3;
	private static final int WAVE_X = 4;
	private static final int WAVE_Y = 5;
	private static final int WAVE_TIME_BETWEEN_ENEMIES = 6;
	private static final int WAVE_FIRING_PATTERN = 7;
	private static final int WAVE_FIRING_FREQUENCY = 8;
	private static final int WAVE_ENEMY_LIFE = 9;
	//private static final int WAVE_PAUSE_TO_NEXT_WAVE = 11;

	public static void main(String[] x) {
		new R();
	}

	public R() {
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		/***************************************************************************
		 * GLOBAL INITIALIZATION
		 **************************************************************************/
		Random rnd = new Random();
		int state = STATE_GAME_OVER;
		int score = 0;
		int lives = 4;
		int playerFireSpeed = 25;
		int playerFireTimer = playerFireSpeed;
		int laserPower = 0;
		int sceneryY = SCENERY_HEIGHT - HEIGHT;
		Graphics2D g;
		GeneralPath path = new GeneralPath();

		int[] enemyX = new int[MAX_ITEMS];
		int[] enemyY = new int[MAX_ITEMS];
		int[] enemyVX = new int[MAX_ITEMS];
		int[] enemyVY = new int[MAX_ITEMS];
		int[] enemyImage = new int[MAX_ITEMS];
		int[] enemyType = new int[MAX_ITEMS];
		int[] enemyStartX = new int[MAX_ITEMS];
		int[] enemyStartY = new int[MAX_ITEMS];
		int[] enemyTimer = new int[MAX_ITEMS];
		int[] enemyLife = new int[MAX_ITEMS];
		int[] movementPattern = new int[MAX_ITEMS];
		int[] movementParam = new int[MAX_ITEMS];
		int[] firePattern = new int[MAX_ITEMS];
		int[] fireFrequency = new int[MAX_ITEMS];
		int[] fireTimer = new int[MAX_ITEMS];
		int slot, i, dx, dy, size;
		//int closest=-1;
		boolean boss = false;
		enemyX[0] = WIDTH / 2;
		enemyY[0] = STATUS_LINE - 2 * PLAYER_SIZE;
		BufferedImage[] images = new BufferedImage[MAX_IMAGES];
		for (i = 0; i < MAX_IMAGES; i++) {
			images[i] = new BufferedImage((i/6+1)*8, (i/6+1)*8,BufferedImage.TYPE_INT_ARGB);
		}
		// ---- START OF IMAGE enemy

		g = images[IMAGE_ENEMY_1].createGraphics();
		g.setColor(new Color(0xaa0000));
		path.reset();
		path.moveTo(9, 5);
		path.lineTo(6, 1);
		path.lineTo(5, 2);
		path.lineTo(7, 5);
		path.lineTo(7, 9);
		path.lineTo(1, 7);
		path.lineTo(0, 9);
		path.lineTo(8, 17);
		path.lineTo(8, 22);
		path.closePath();
		g.fill(path);
		g.setColor(new Color(0x22));
		g.draw(path);
		g.setColor(new Color(0xaa));
		g.drawLine(17, 4, 17, 15);
		g.scale(-1, 1);
		g.translate(-18, 0);
		g.drawImage(images[IMAGE_ENEMY_1], 0, 0, null);
		// END of image enemy

		g = images[IMAGE_ENEMY_2].createGraphics();
		g.setColor(new Color(0xaa));
		path.reset();
		path.moveTo(0, 11);
		path.lineTo(15, 23);
		path.lineTo(31, 11);
		path.lineTo(22, 15);
		path.lineTo(21, 12);
		path.lineTo(10, 12);
		path.lineTo(8, 15);
		path.closePath();
		g.fill(path);
		g.setColor(new Color(0x0));
		g.draw(path);
		g.setColor(new Color(0xffff00));
		g.fillOval(12, 18, 2, 2);
		g.fillOval(17, 18, 2, 2);
		g.setColor(new Color(0xffff00));
		g.fillRect(10, 10, 11, 2);
		g.setColor(new Color(0xff0000));
		g.fillRect(13, 8, 6, 2);

		g = images[IMAGE_ENEMY_3].createGraphics();
		g.setColor(new Color(0x0));
		g.fillOval(7, 5, 17, 14);
		g.setColor(new Color(0x492df3));
		g.fillOval(8, 6, 15, 12);
		g.setColor(new Color(0x0));
		g.fillOval(0, 15, 31, 5);
		g.setColor(new Color(0xff));
		g.fillOval(0, 16, 30, 4);
		g.setColor(new Color(0xff0000));
		g.drawLine(9, 17, 10, 17);
		g.drawLine(13, 17, 15, 17);
		g.drawLine(16, 17, 17, 17);
		g.drawLine(20, 17, 21, 17);

		// boss image
		g = images[IMAGE_ENEMY_BOSS_1].createGraphics();

		g.setColor(new Color(0xaa));
		g.fillOval(0, 0, 127, 127);
		g.setColor(new Color(0x00));
		g.fillOval(1, 1, 125, 125);
		g.scale(4, 4);
		g.drawImage(images[IMAGE_ENEMY_2], 0, 0, null);
		g.drawImage(images[IMAGE_ENEMY_2], 0, 8, null);

		// ---- START OF IMAGE playerImage
		for (i=0; i<=1;i++) {
			// 0 1
			
			g = images[IMAGE_PLAYER+i*4].createGraphics();
			if (i == 1) {
				g.scale(1,-1);
				g.translate(0,-32);
				dx = 0x808000;
			} else
				dx = 0x4aadce;
				
			g.setColor(new Color(dx));
			path.reset();
			path.moveTo(13, 3);
			path.lineTo(12, 12);
			path.lineTo(3, 22);
			path.lineTo(3, 27);
			path.lineTo(13, 27);
			path.closePath();
			g.fill(path);
			g.setColor(new Color(0x0));
			g.draw(path);
			g.fillRect(8, 12, 1+i, 4+i);
			g.drawLine(2, 17, 2, 29);
			g.setColor(new Color(0xb59c08));
			g.fillRect(14, 7, 1, 6);
			g.setColor(new Color(0x82963));
			g.drawLine(12, 20, 12, 26);
			g.setColor(new Color(0xFF0000));
			
			g.drawLine(7, 30, 11, 30);
			g.drawLine(9, 31, 10, 31);
			g.setColor(new Color(0x84847b));
			g.fillRect(5, 27, 7, 2);
			g.setColor(new Color(0xffff00));
			g.drawLine(5, 29, 11, 29);
			if (i == 0) {
				g.scale(-1, 1);
				g.translate(-28, 0);
			} else {
				g.scale(-1, -1);
				g.translate(-26, -32);
			}
			g.drawImage(images[IMAGE_PLAYER+i*4], 0, 0, null);
			
		}
		// END of image playerImage

		// Player bullet
		g = images[IMAGE_PLAYER_BULLET].createGraphics();
		/*g.setColor(new Color(0x84bdff));
		path.reset();
		path.moveTo(7,15);
		path.quadTo(3,3,6,0);
		path.lineTo(9,0);
		path.quadTo(15,5,8,15);
		path.closePath();
		g.fill(path);
		g.setColor(new Color(0x94ef));
		g.draw(path);*/
		g.setColor(new Color(0x84bdff));
		path.reset();
		path.moveTo(0,7);
		path.quadTo(13,3,15,6);
		path.lineTo(15,9);
		path.quadTo(13,15,0,8);
		path.closePath();
		g.fill(path);
		g.setColor(new Color(0x94ef));
		g.draw(path);
		

		// Enemy bullet
		g = images[IMAGE_ENEMY_BULLET].createGraphics();
		g.setColor(new Color(0xFF8000));
		g.fillOval(0, 0, 8, 8);
		g.setColor(new Color(0xFFFFFF));
		g.fillOval(2, 2, 4, 4);

		// Protection bullet
		g = images[IMAGE_PROTECTION_BULLET].createGraphics();
		g.setColor(new Color(0));
		g.fillOval(0, 0, 13, 13);
		g.setColor(new Color(0xAAAAAA));
		g.fillOval(1, 1, 12, 12);

		// Powerup images - microchips
		for (i = IMAGE_POWERUP_SHIELD; i < IMAGE_POWERUP_SHIELD + MAX_POWERUPS; i++) {
			g = images[i].createGraphics();

			// i = 3,4,5,6
			g.setColor(Color.getHSBColor(i / 6f, 1, 1));
			path.reset();
			path.moveTo(5, 4);
			path.lineTo(0, 9);
			path.lineTo(0, 13);
			path.lineTo(19, 13);
			path.lineTo(23, 7);
			path.lineTo(23, 4);
			path.closePath();
			g.fill(path);
			g.setColor(new Color(0x0));
			g.draw(path);
			g.drawLine(17, 12, 17, 16);
			g.drawLine(0, 9, 20, 9);
			g.drawLine(19, 9, 24, 4);
			g.drawLine(19, 13, 20, 10);
			for (dx = 1; dx <= 6; dx++)
				g.drawLine(3 * dx, 12, 3 * dx, 16);
		}

		BufferedImage scenery = new BufferedImage(SCENERY_WIDTH, SCENERY_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		g = scenery.createGraphics();
		g.setColor(new Color(0x004000));
		g.fillRect(0, 0, SCENERY_WIDTH, SCENERY_HEIGHT);

		enableEvents(8);

		// For mouse events
		// enableEvents(KeyEvent.MOUSE_EVENT_MASK);

		int waveData[] = new int[WAVE_ENEMY_LIFE  + 1];
		int waveNum = -1;
		int enemyNum = 0;
		long lastEnemyAppeared = 0;

		show();
		createBufferStrategy(2);
		BufferStrategy strategy = getBufferStrategy();

		long lastFrame = 0;
		
		// GAME LOOP
		while (true) {
			if (System.currentTimeMillis()-lastFrame < 30) {
				Thread.yield();
				continue;
			}
			lastFrame = System.currentTimeMillis();
			if (!isVisible()) {
				System.exit(0);
			}
			if (state == STATE_INIT || state == STATE_INIT_LEVEL) {
				// LEVEL INITIALIZATION

				playerFireTimer = playerFireSpeed = 25;

				enemyX = new int[MAX_ITEMS];
				enemyY = new int[MAX_ITEMS];
				enemyVX = new int[MAX_ITEMS];
				enemyVY = new int[MAX_ITEMS];
				enemyStartX = new int[MAX_ITEMS];
				enemyStartY = new int[MAX_ITEMS];
				enemyType = new int[MAX_ITEMS];
				enemyTimer = new int[MAX_ITEMS];
				enemyLife = new int[MAX_ITEMS];
				movementPattern = new int[MAX_ITEMS];
				movementParam = new int[MAX_ITEMS];
				firePattern = new int[MAX_ITEMS];
				fireFrequency = new int[MAX_ITEMS];
				fireTimer = new int[MAX_ITEMS];

				enemyNum = 1;
				boss=false;
				lastEnemyAppeared = 0;
				laserPower = 0;
				waveNum = -1;

				enemyX[0] = WIDTH / 2;
				enemyY[0] = STATUS_LINE - 2 * PLAYER_SIZE;
				enemyType[0] = ITEM_TYPE_PLAYER;
				//movementPattern[0] = MOVE_FREE;
				enemyLife[0] = MAX_LIFE;
				enemyImage[0] = IMAGE_PLAYER;

				if (state == STATE_INIT) {
					score = 0;
					lives = 4;
					sceneryY = SCENERY_HEIGHT - HEIGHT;
				}
				state = STATE_PLAYING;
			}

			/*************************************************************************
			 * EVOLUTION
			 ************************************************************************/
			if (key[KeyEvent.VK_ENTER]) {
				if (state == STATE_LIFE_LOST) {
					state = STATE_INIT_LEVEL;
				}
				if (state == STATE_GAME_OVER) {
					state = STATE_INIT;
				}
			}

			// Process input
			if (state == STATE_PLAYING) {

				if (enemyNum >= waveData[WAVE_ENEMIES] && lastFrame - lastEnemyAppeared > 5000 && !boss) {

					// Create random wave data
					waveNum++;
					if ((waveNum + 1) % 11 != 0) {
						waveData[WAVE_ENEMIES] = 5 + waveNum / 5;
						dx = 1 + rnd.nextInt(MOVE_HORIZONTAL);
						waveData[WAVE_MOVEMENT_PARAM] = 100 + rnd.nextInt(100);
						waveData[WAVE_X] = 0;
						waveData[WAVE_Y] = 25;
						//waveData[WAVE_TIME_BETWEEN_ENEMIES] = 4;  / (waveNum / 10 + 1);
						waveData[WAVE_FIRING_FREQUENCY] = 40 - waveNum % 38;
						waveData[WAVE_FIRING_PATTERN] = rnd.nextInt(FIRE_SINE + 1);

						if (dx == MOVE_STATIONARY) {
							waveData[WAVE_FIRING_PATTERN] = FIRE_TOWARDS;
						}

						if (waveData[WAVE_FIRING_PATTERN] == FIRE_SINE) {
							dx = MOVE_STATIONARY;
							waveData[WAVE_FIRING_FREQUENCY] = 20 - waveNum % 8;
						}

						if (dx == MOVE_CYCLOID || dx == MOVE_ELLIPTICAL) {
							waveData[WAVE_Y] = 100 + rnd.nextInt(300);
							waveData[WAVE_X] = 100 + rnd.nextInt(WIDTH - 100);
						}

						waveData[WAVE_ENEMY_LIFE] = 100 * (1 + waveNum / 10);
						waveData[WAVE_ENEMY_IMAGE] = IMAGE_ENEMY_1+ (dx-1) % 4;
						waveData[WAVE_MOVEMENT_PATTERN] = dx;
						boss = false;
					} else {
						waveData[WAVE_ENEMIES] = 1;
						waveData[WAVE_MOVEMENT_PATTERN] = MOVE_STATIONARY;
						waveData[WAVE_MOVEMENT_PARAM] = 150;
						waveData[WAVE_X] = WIDTH / 2 - 50;
						waveData[WAVE_Y] = 25;
						//waveData[WAVE_TIME_BETWEEN_ENEMIES] = 0;
						waveData[WAVE_FIRING_FREQUENCY] = 2;
						waveData[WAVE_FIRING_PATTERN] = FIRE_TOWARDS;//FIRE_SINE;
						waveData[WAVE_ENEMY_LIFE] = 1000 * waveNum;
						waveData[WAVE_ENEMY_IMAGE] = IMAGE_ENEMY_BOSS_1;
						boss = true;
					}
					enemyNum = 0;
				}

				// Enemy spawn
				if (enemyNum < waveData[WAVE_ENEMIES]
						&& (lastFrame - lastEnemyAppeared) >= 1000/*/ 250 >= waveData[WAVE_TIME_BETWEEN_ENEMIES]*/) {
					for (i = 1; i < MAX_ITEMS; i++) {
						if (enemyType[i] == 0) {
							enemyImage[i] = waveData[WAVE_ENEMY_IMAGE];
							enemyLife[i] = waveData[WAVE_ENEMY_LIFE];
							movementPattern[i] = waveData[WAVE_MOVEMENT_PATTERN];
							movementParam[i] = waveData[WAVE_MOVEMENT_PARAM];
							firePattern[i] = waveData[WAVE_FIRING_PATTERN];
							fireFrequency[i] = waveData[WAVE_FIRING_FREQUENCY];
							
							if (waveData[WAVE_X] == 0)
								enemyX[i] = rnd.nextInt(WIDTH - 32);
							else
								enemyX[i] = waveData[WAVE_X];

							if (waveData[WAVE_Y] == 0) {
								enemyY[i] = rnd.nextInt(HEIGHT / 3);
							} else {
								enemyY[i] = waveData[WAVE_Y];
							}

							enemyStartX[i] = enemyX[i];
							enemyStartY[i] = enemyY[i];
							enemyType[i] = ITEM_TYPE_ENEMY;
							enemyTimer[i] = 1;
							fireTimer[i] = 1;
							enemyNum++;
							lastEnemyAppeared = lastFrame;
							break;
						}
					}
				}

				// Process input
				if (key[KeyEvent.VK_UP]) enemyY[0] -= MOVEMENT_SPEED;
				if (key[KeyEvent.VK_DOWN]) enemyY[0] += MOVEMENT_SPEED;
				if (key[KeyEvent.VK_LEFT]) enemyX[0] -= MOVEMENT_SPEED;
				if (key[KeyEvent.VK_RIGHT]) enemyX[0] += MOVEMENT_SPEED;
				if (key[KeyEvent.VK_SPACE] && playerFireTimer >= playerFireSpeed) {
					playerFireTimer = 0;
					
					
					int lp = laserPower;
					if (lp > 2) lp=2;
					for (dx=0;dx<=laserPower;dx++) {
						for (slot = 1; slot < MAX_ITEMS - 1 && enemyType[slot] != 0; slot++);
						enemyType[slot] = ITEM_TYPE_PLAYER_BULLET;
						enemyImage[slot] = IMAGE_PLAYER_BULLET;
						fireFrequency[slot] = 0;
						movementPattern[slot] = MOVE_VELOCITY;
						if (dx <=2) {
							enemyY[slot] = enemyY[0];
							enemyX[slot] = enemyX[0]+6-10*lp+20*dx;
							enemyStartX[slot] = 90;
						} else {
							enemyY[slot] = enemyY[0]+16;
							enemyX[slot] = enemyX[0]+14;
							enemyStartX[slot] = 270 - 20*(laserPower-3)+40*(dx-3);
						}
						enemyVX[slot] = (int)(10*Math.cos(enemyStartX[slot]*Math.PI/180));
						enemyVY[slot] = -(int)(10*Math.sin(enemyStartX[slot]*Math.PI/180));
					}
				}
				if (enemyY[0] < 0) enemyY[0] = 0;
				if (enemyY[0] > STATUS_LINE - PLAYER_SIZE) enemyY[0] = STATUS_LINE - PLAYER_SIZE;
				if (enemyX[0] < 0) enemyX[0] = 0;
				if (enemyX[0] > WIDTH - PLAYER_SIZE) enemyX[0] = WIDTH - PLAYER_SIZE;

				// Item evolution
				playerFireTimer++;
				if (playerFireTimer > playerFireSpeed)
					playerFireTimer = playerFireSpeed;
				
					
				for (i = 0; i < MAX_ITEMS; i++) {
					if (enemyType[i] > 0) {
						enemyTimer[i]++;

						// boss changes firing patterns
						if (enemyTimer[i] % 400 == 0 && enemyImage[i] == IMAGE_ENEMY_BOSS_1) {
							firePattern[i] = (firePattern[i] + 1) % (FIRE_SINE + 1);
							enemyTimer[i] = 0;
						}

						fireTimer[i]++;
						if (movementPattern[i] == MOVE_VELOCITY) {
							enemyY[i] += enemyVY[i];
							enemyX[i] += enemyVX[i];
						}
						if (movementPattern[i] == MOVE_DOWN) {
							enemyY[i] += MOVEMENT_SPEED;
						}
						if (movementPattern[i] == MOVE_SINE) {
							enemyX[i] = enemyStartX[i]+(int)(movementParam[i]*Math.sin(enemyTimer[i]/20.0));
							enemyY[i] += MOVEMENT_SPEED/2;
						}
						if (movementPattern[i] == MOVE_ELLIPTICAL) {
							enemyX[i] = -(int) ((WIDTH/2.0-32)*Math.cos(enemyTimer[i] / 60.0))+ WIDTH / 2;
							enemyY[i] = -(int) (movementParam[i] * Math.sin(enemyTimer[i] / 60.0))+ enemyStartY[i];
						}
						if (movementPattern[i] == MOVE_STATIONARY) {
							if (enemyY[i] <= movementParam[i]) enemyY[i] += MOVEMENT_SPEED;
						}
						if (movementPattern[i] == MOVE_CYCLOID) {
							enemyX[i] = (int) (enemyTimer[i] /** 1.5 */+ 100*Math.sin(enemyTimer[i] / 20.0));
							enemyY[i] = enemyStartY[i] + (int) (/*1.5 */- 100*Math.cos(enemyTimer[i] / 20.0));
						}
						if (movementPattern[i] == MOVE_HORIZONTAL) {
							enemyX[i] = (int) (enemyTimer[i]*2);
							enemyY[i] = movementParam[i];
						}
						/*if (movementPattern[i] == MOVE_HOMING) {
							dx = enemyStartX[i] - enemyX[i];
							dy = enemyStartY[i] - enemyY[i];
							enemyVX[i] = (int) (10 * Math.cos(Math.atan2(dy, dx)));
							enemyVY[i] = (int) (10 * Math.sin(Math.atan2(dy, dx)));
						}*/

						if (movementPattern[i] == MOVE_PROTECTIVE) {
							enemyX[i] = (int) (enemyX[0]+14 + movementParam[i]*Math.sin(enemyTimer[i] / 5.0));
							enemyY[i] = (int) (enemyY[0]+16 + movementParam[i]*Math.cos(enemyTimer[i] / 5.0));
						}

						/* START */
						/*dx = enemyX[0] - enemyX[i];
						dy = enemyY[0] - enemyY[i];
						dx = dx*dx+dy*dy;
						int closestDistance = WIDTH*WIDTH;
						if (enemyType[i] == ITEM_TYPE_ENEMY && dx < closestDistance) {
							closestDistance = dx;
							closest =i;
						}*/
						/* END */	


						// Enemy firing stance
						if (fireFrequency[i] != 0 && fireTimer[i] % fireFrequency[i] == 0) {
							for (slot = 1; slot < MAX_ITEMS - 1 && enemyType[slot] != 0; slot++);

							enemyType[slot] = ITEM_TYPE_ENEMY_BULLET;
							enemyImage[slot] = IMAGE_ENEMY_BULLET;
							enemyX[slot] = enemyX[i] + (enemyImage[i]/6+1)*4;
							enemyY[slot] = enemyY[i] + (enemyImage[i]/6+1)*4;
							movementPattern[slot] = MOVE_VELOCITY;
							fireFrequency[slot] = 0;
							if (firePattern[i] == FIRE_DOWN) {
								enemyVX[slot] = 0;
								enemyVY[slot] = 10;
							}
							if (firePattern[i] == FIRE_TOWARDS) {
								dx = enemyX[0] - enemyX[slot];
								dy = enemyY[0] - enemyY[slot];
								enemyVX[slot] = (int) (10 * Math.cos(Math.atan2(dy, dx)));
								enemyVY[slot] = (int) (10 * Math.sin(Math.atan2(dy, dx)));
							}
							if (firePattern[i] == FIRE_SINE) {
								enemyVX[slot] = (int) (10 * Math.cos(fireTimer[i] / 20.0));
								enemyVY[slot] = (int) (10 * Math.sin(fireTimer[i] / 20.0));
							}
						}

						// Enemies that go out of the screen
						if (enemyType[i] == ITEM_TYPE_ENEMY) {
							if (enemyY[i] > HEIGHT) {
								enemyType[i] = 0;
							}
							if (enemyX[i] < 0) enemyX[i] = WIDTH;
							if (enemyX[i] > WIDTH) enemyType[i] = 0;
						}

						// Bullets and powerups that go off the screen disappear
						if ((enemyImage[i] == IMAGE_PLAYER_BULLET || enemyImage[i] == IMAGE_ENEMY_BULLET || enemyType[i] == ITEM_TYPE_POWERUP)
								&& (enemyX[i] < 0 || enemyX[i] > WIDTH || 
										enemyY[i] < 0 || enemyY[i] > STATUS_LINE))
							enemyType[i] = 0;

						// Check possible collisions of this item with the rest of the items
						int powerUpSlot = 0;
						for (int b = i + 1; b < MAX_ITEMS; b++) {
							if (enemyType[b] != 0) {
								dx = enemyX[i] + (enemyImage[i]/6+1)*8;
								dy = enemyY[i] + (enemyImage[i]/6+1)*8;
								if (!(enemyX[b] > dx || enemyY[b] > dy
										|| enemyX[b] + (enemyImage[b]/6+1)*8 < enemyX[i] || enemyY[b]+ (enemyImage[b]/6+1)*8 < enemyY[i])) {
									// We have a collision, check between what
									

									// player vs enemy bullet
									if (i == 0 && enemyType[b] == ITEM_TYPE_ENEMY_BULLET) {
										enemyLife[0] -= 100;
										enemyType[b] = ITEM_TYPE_EXPLOSION;
										enemyTimer[b] = 0;
									}
									// player vs enemy
									if (i == 0 && enemyType[b] == ITEM_TYPE_ENEMY) {
										enemyLife[0] -= 250;
										if (enemyImage[b] != IMAGE_ENEMY_BOSS_1) {
											enemyType[b] = ITEM_TYPE_EXPLOSION;
											movementPattern[b] = MOVE_STATIONARY;
											enemyTimer[b] = 0;
										}
									}
									// player vs power up
									if (i == 0 && enemyType[b] == ITEM_TYPE_POWERUP) {
										// whatever
										score += 100;
										enemyType[b] = 0;
										if (enemyImage[b] == IMAGE_POWERUP_SHIELD) {
											enemyLife[0] = MAX_LIFE;
										}
										if (enemyImage[b] == IMAGE_POWERUP_LIFE && lives < 5) {
											lives++;
										}
										if (enemyImage[b] == IMAGE_POWERUP_FIREUP) {
											playerFireSpeed = playerFireSpeed * 3 / 4 + 1;
										}

										if (enemyImage[b] == IMAGE_POWERUP_LASERPOWER && laserPower < 11)
											laserPower++;

										if (enemyImage[b] == IMAGE_POWERUP_PROTECTION) {

											for (slot = 1; slot < MAX_ITEMS - 1	&& enemyType[slot] != 0; slot++);

											// slot = b(enemyType);
											enemyType[slot] = ITEM_TYPE_PLAYER_BULLET;
											movementPattern[slot] = MOVE_PROTECTIVE;
											enemyImage[slot] = IMAGE_PROTECTION_BULLET;
											movementParam[slot] = rnd.nextInt(30) + 30;
											enemyTimer[slot] = rnd.nextInt(200);
										}
										if (enemyImage[b] == IMAGE_POWERUP_BOMB) {
											for (int e = 1; e < MAX_ITEMS; e++) {
												if (enemyType[e] == ITEM_TYPE_ENEMY) {
													enemyType[e] = ITEM_TYPE_EXPLOSION;
													score += 25;
													enemyTimer[e] = 0;
													movementPattern[e] = MOVE_STATIONARY;
												}
											}
										}
									}

									// bullet vs protective bullet -
									if (enemyImage[i] == IMAGE_PROTECTION_BULLET && enemyType[b] == ITEM_TYPE_ENEMY_BULLET) {
										enemyType[b] = ITEM_TYPE_EXPLOSION;
										enemyTimer[b] = 0;
										movementPattern[b] = MOVE_STATIONARY;
									}
									// the other way round
									if (enemyImage[b] == IMAGE_PROTECTION_BULLET && enemyType[i] == ITEM_TYPE_ENEMY_BULLET) {
										enemyType[i] = ITEM_TYPE_EXPLOSION;
										enemyTimer[i] = 0;
									}

									// enemy vs player bullet
									if (enemyType[i] == ITEM_TYPE_ENEMY && enemyType[b] == ITEM_TYPE_PLAYER_BULLET) {
										enemyLife[i] -= 100;
										enemyType[b] = ITEM_TYPE_EXPLOSION;
										enemyTimer[b] = 0;
										if (enemyLife[i] <= 0) {

											// 20 % chance of a power-up
											if (rnd.nextInt(100) < 25)
												powerUpSlot = i;
											if (enemyImage[i] == IMAGE_ENEMY_BOSS_1) {
												boss = false;
												score += 1500;
											}
											enemyType[i] = 0;
											score += 100;
										}
									}
									// same, the other way round
									if (enemyType[i] == ITEM_TYPE_PLAYER_BULLET && enemyType[b] == ITEM_TYPE_ENEMY) {
										enemyLife[b] -= 100;
										enemyType[i] = ITEM_TYPE_EXPLOSION;
										enemyTimer[i] = 0;
										if (enemyLife[b] <= 0) {
											if (rnd.nextInt(100) < 25)
												powerUpSlot = b;

											if (enemyImage[b] == IMAGE_ENEMY_BOSS_1) {
												boss = false;
												score += 1500;
											}

											enemyType[b] = 0;
											score += 100;
										}
									}
								}
							}
						}

						// Check if any power-up has appeared
						if (powerUpSlot != 0) {
							enemyType[powerUpSlot] = ITEM_TYPE_POWERUP;
							movementPattern[powerUpSlot] = MOVE_DOWN;
							fireFrequency[powerUpSlot] = 0;
							enemyImage[powerUpSlot] = IMAGE_POWERUP_SHIELD + rnd.nextInt(MAX_POWERUPS);
						}
					}
				}

				// Check player life status after all collisions
				if (enemyLife[0] <= 0) {
					lives--;
					enemyType[0] = ITEM_TYPE_EXPLOSION;
					if (lives < 0)
						state = STATE_GAME_OVER;
					else
						state = STATE_LIFE_LOST;
				}

			}

			/*************************************************************************
			 * SCENERY UPDATE
			 ************************************************************************/
			if (state != STATE_LIFE_LOST)
				sceneryY -= 2;
			if (sceneryY < 0) {
				sceneryY = sceneryY + SCENERY_BAND;
				g = scenery.createGraphics();
				g.copyArea(0, 0, SCENERY_WIDTH, SCENERY_HEIGHT, 0, SCENERY_BAND);
				// Clear the upper part
				g.setColor(new Color(0x004000));
				g.fillRect(0, 0, SCENERY_WIDTH, SCENERY_BAND);

				// Some random horizontal lines
				g.setColor(new Color(0));
				for (i = 0; i < SCENERY_BAND / 20; i++) {
					g.drawLine(rnd.nextInt(WIDTH), i * 20, rnd.nextInt(WIDTH), i * 20);
				}

				// Draw a random tree : START -------------------------------
				for (int tree = 0; tree < 2; tree++) {
					path.reset();
					size = rnd.nextInt(100) + 50;
					BufferedImage boulder = new BufferedImage(size * 2, size * 2,BufferedImage.TYPE_INT_ARGB);
					g = boulder.createGraphics();
					for (i = 0; i < 20; i++) {
						int pertx = rnd.nextInt(size / 8) - size / 16;
						int perty = rnd.nextInt(size / 8) - size / 16;
						dx = size/2+ (int) (size * 10 / 25 * Math.cos(Math.PI / 10 * i) + pertx*Math.cos(Math.PI / 10 * i));
						dy = size/2- (int) (size * 10 / 25 * Math.sin(Math.PI / 10 * i) + perty*Math.sin(Math.PI / 10 * i));
						if (i == 0)
							path.moveTo(dx, dy);
						else
							path.lineTo(dx, dy);
					}
					path.closePath();

					// Trunk
					g.setColor(new Color(0x7C4222));
					g.fillRect(size / 2 - 5, size / 2, 10, size / 2);
					// Trunk end

					// Shadow
					g.setColor(new Color(0, 0, 0, 80));
					g.translate(size / 3, size / 2);
					g.fill(path);
					//g.translate(-size / 3, -size / 2);
					g = boulder.createGraphics();
					// Shadow end

					// Main tree
					g.setColor(new Color(40, 100, 0));
					g.fill(path);
					g.setClip(path);

					// Shadow layer
					dx = size / 6;
					dy = size / 6;
					g.translate(dx, dy);
					g.shear(0.3, 0.1);

					g.setColor(new Color(30, 60, 0));
					g.fill(path);

					g = boulder.createGraphics();
					g.setColor(new Color(0));
					g.draw(path);

					g = scenery.createGraphics();
					g.drawImage(boulder, rnd.nextInt(WIDTH), rnd.nextInt(SCENERY_BAND	- size), null);
					// Draw a random tree : END -------------------------------
				}

			}

			/*************************************************************************
			 * SCREEN UPDATE
			 ************************************************************************/
			g = (Graphics2D) strategy.getDrawGraphics();

			// Scenery
			g.drawImage(scenery, 0, 0, WIDTH, HEIGHT, 0, sceneryY,
					SCENERY_WIDTH, sceneryY + HEIGHT, null);

			// Player
			g.drawImage(images[IMAGE_PLAYER], enemyX[0], enemyY[0], null);
			

			// Enemies and explosions
			for (i = 0; i < MAX_ITEMS; i++) {
				if (enemyType[i] != 0 && enemyType[i] != ITEM_TYPE_EXPLOSION) {
					// Missile rotation
					if (enemyImage[i] == IMAGE_PLAYER_BULLET) {
						g.rotate(-enemyStartX[i]*Math.PI/180,enemyX[i]+4,enemyY[i]+4);
					}
					g.drawImage(images[enemyImage[i]], enemyX[i], enemyY[i], null);
					
					g = (Graphics2D) strategy.getDrawGraphics();
					
					/*if (enemyType[i] == ITEM_TYPE_ENEMY) {
						dx = enemyX[i] + (enemyImage[i]/6+1)*8;
						dy = enemyY[i] + (enemyImage[i]/6+1)*8;
						g.setColor(Color.black);
						g.drawRect(enemyX[i], enemyY[i], (enemyImage[i]/6+1)*8, (enemyImage[i]/6+1)*8);
						g.drawRect(enemyX[0], enemyY[0], (enemyImage[0]/6+1)*8, (enemyImage[0]/6+1)*8);
					}*/

				}

				if (enemyType[i] == ITEM_TYPE_EXPLOSION) {
					// Explosions don't move and don't fire
					movementPattern[i] = 0;//MOVE_FREE;
					fireFrequency[i] = 0;
					int r1 = enemyTimer[i];
					if (r1 > 15)
						r1 = 15;
					g.setColor(new Color(255, 255 - r1 * 10, 0));
					g.fillOval(enemyX[i]-r1+16,enemyY[i]-r1+16, 2 * r1, 2 * r1);
					if (enemyTimer[i] > 15) {
						g.setColor(new Color(r1 * 10, 0, 0));
						r1 = enemyTimer[i] - 15;
						g.fillOval(enemyX[i]-r1+16, enemyY[i]- r1+16, 2 * r1, 2 * r1);
					}
					enemyTimer[i]++;
					if (enemyTimer[i] > 30)
						// If it's our ship the one who's exploding, it is because
						// we lost a life. Keep it this way.
						if (i != 0)
							enemyType[i] = 0;
						else
							enemyTimer[i] = 0;
				}
			}

			/*
			 *  Status
			 */

			// Score
			g.setColor(new Color(0xFFFFFF));
			g.drawString("Score", 10, STATUS_LINE + 15);
			g.drawString(String.valueOf(score), 60, STATUS_LINE + 15);
			
			// Lives
			for (i = 0; i < lives; i++) {
				dx = 100 + (PLAYER_SIZE + 2) * i;
				g.drawImage(images[IMAGE_PLAYER], dx, STATUS_LINE,
						dx + 18, STATUS_LINE + 18, 0, 0, 32, 32, null);
			}

			// Shield
			g.setColor(new Color(0));
			g.fillRect(253, STATUS_LINE, MAX_LIFE / 10 + 4, 15);
			if (enemyLife[0] > MAX_LIFE / 3)
				g.setColor(new Color(0x000088));
			else
				g.setColor(new Color(0xFF0000));
			g.fillRect(255, STATUS_LINE + 2, enemyLife[0] / 10, 10);

			// Generator
			g.setColor(new Color(0));
			g.fillRect(458, STATUS_LINE, 100, 15);
			g.setColor(new Color(0xFF0000));
			g.fillRect(458, STATUS_LINE, playerFireTimer * 100 / playerFireSpeed, 15);

			//g.setColor(new Color(0xFFFF00));
			// Reuse white color from above
			if (state == STATE_GAME_OVER) {
				g.drawString("GAME OVER", 300, 300);
			}			
			

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
