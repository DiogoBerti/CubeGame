package GameCube;


import java.awt.Font;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class GameCube extends BasicGame {

	int x = 0;
	int y = 0;
	boolean movRight = true;
	boolean movDown = true;
	int inX = 10;
	int inY = 260;
	boolean indo = true;
	Random random = new Random();
	int yAng = 3;
	int velBola = 2;
	static boolean gameOver = false;
	int count = 0;
	int newPos = 0;
	int points = 0;
	
	
	Pad p = new Pad(50, 300);
	Pad target = new Pad(780,200);
	
	
	
	public GameCube(String gamename) {
		super(gamename);
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		y = random.nextInt(500)+30;
		x = 100;
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		Input input = gc.getInput();
		
				
		if (inY <= 0){
			inY = 0;
		}
		if (inY >= 600 - 40){
			inY = 600 - 40;
		}
		
		if (input.isKeyDown(input.KEY_W)){
			p.setY(p.getY() - 5);;
		} else if(input.isKeyDown(input.KEY_S)){
			p.setY(p.getY() + 5);;
		}
		
		
		
			
		if((x >= p.getX() && x <= p.getX() + 15) && (y >= p.getY() && y <= p.getY() + 80) ||  (x + 32 >= p.getX() && x + 32 <= p.getX() + 15) && (y + 32 >= p.getY() && y + 32 <= p.getY() + 80)){
			count++;
		}
	
		/*
		if((x + 32 >= p.getX() && x + 32 <= p.getX() + 15) && (y + 32 >= p.getY() && y + 32 <= p.getY() + 80)){
			count++;
		}
		*/
		
		
		
		if (movRight == true){
			x+=velBola;
						
			if(x >= 800-32){
				movRight = false;
				indo = false;
				yAng = random.nextInt(8)+1;
				velBola++;
			}
			
			if((x >= target.getX() && x <= target.getX() + 15) && (y >= target.getY() && y <= target.getY() + 60) ||  (x + 32 >= target.getX() && x + 32 <= target.getX() + 15) && (y + 32 >= target.getY() && y + 32 <= target.getY() + 60)){
				
				movRight = false;
				indo = false;
				yAng = random.nextInt(8)+1;
				velBola++;
				points++;
				
			}
			
								
		}else{
			x-=velBola;
			
			if((x >= p.getX() && x <= p.getX() + 15) && (y >= p.getY() && y <= p.getY() + 80) ||  (x + 32 >= p.getX() && x + 32 <= p.getX() + 15) && (y + 32 >= p.getY() && y + 32 <= p.getY() + 80)){
				movRight = true;
				indo = true;
				yAng = random.nextInt(8)+ 1;
				velBola++;
				
			}
		
			
			if(x <= 1){
				x = 1;
				
				gameOver = true;
				
				
			}
			
		}
			
		if(indo == false && x >= 400 && x <= 410){
			newPos = random.nextInt(500)+1;
			target.setY(newPos);
		}
		
		if (movDown == true){
			y+=yAng;
			if(y >= 
					600-32){
				movDown = false;
			}
		}else{
			y-=yAng;
			if(y<1 ){
				movDown = true;
			}
		}
		
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		
		
		g.setColor(Color.white);
		g.drawString("Bate e volta", 100, 0);
		
		
		if(gameOver == true){
			
			g.drawString("GAME OVER!", 300, 260);
			
			
			
		}
		
		if(indo == true){
			g.drawString("Indo", 700, 500);
		}else{
			g.drawString("Voltando",  700, 500);
		}
		
		if(indo == true){
			g.setColor(Color.blue);	
		}else{
			g.setColor(Color.cyan);
		}
		
		g.drawString("Counter = " + count, 50, 580);
		g.drawString("POINTS = " + points, 600, 580);
		
		g.fillRect(x, y, 32, 32);
		g.setBackground(Color.darkGray);
		g.setColor(Color.red);
		g.fillRect(p.getX(), p.getY(), 15, 80);
		
		g.setColor(Color.lightGray);
		g.fillRect(796, 0, 4, 600);
		g.setColor(Color.magenta);
		g.fillRect(target.getX(), target.getY(), 15, 70);
		
			
	}

	public static void main(String[] args) {
		
		AppGameContainer appgc;
		
		try {
			
			appgc = new AppGameContainer(new GameCube("Testing the game"));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
			if(gameOver == true){
				appgc.reinit();	
			}
			
			
			
		} catch (SlickException ex) {
			Logger.getLogger(GameCube.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		
		
	}
}