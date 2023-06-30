package miniprojtemplate;

import javafx.scene.image.Image;
import java.util.Random;

public class Fish extends Sprite {
	public static final int MAX_FISH_SPEED = 5;
	public final static Image FISH_IMAGE = new Image("images/enemy.png",Fish.FISH_WIDTH,Fish.FISH_WIDTH,true,false);
	public final static int FISH_WIDTH=50;
	protected boolean alive;
	//attribute that will determine if a fish will initially move to the right
	protected boolean moveRight;
	protected int speed;
	
	
	Fish(int x, int y){
		super(x,y);
		this.alive = true;
		this.loadImage(Fish.FISH_IMAGE);
		/*
		 *TODO: Randomize speed of fish and moveRight's initial value 
		 */
		Random r = new Random();
		speed = r.nextInt(Fish.MAX_FISH_SPEED);
		speed += 1;
		moveRight = false;
	}
	
	//method that changes the x position of the fish
	public void move(){
		/*
		 * TODO: 				If moveRight is true and if the fish hasn't reached the right boundary yet,
		 *    						move the fish to the right by changing the x position of the fish depending on its speed
		 *    					else if it has reached the boundary, change the moveRight value / move to the left 
		 * 					 Else, if moveRight is false and if the fish hasn't reached the left boundary yet,
		 * 	 						move the fish to the left by changing the x position of the fish depending on its speed.
		 * 						else if it has reached the boundary, change the moveRight value / move to the right
		 */
		if(this.moveRight){
			if(this.x >= GameStage.WINDOW_WIDTH){
				this.moveRight = false;
			} else {
				this.x += this.speed;
			}
		} else if( this.moveRight == false){
			if(this.x <= 0){
				this.moveRight = true;
			} else {
				this.x -= this.speed;
			}
		}
	}
	
	//getter
	public boolean isAlive() {
		return this.alive;
	}

	//setter
	public void isDead() { this.alive = false; }
}
