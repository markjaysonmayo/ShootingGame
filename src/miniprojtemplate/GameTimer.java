package miniprojtemplate;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/*
 * The GameTimer is a subclass of the AnimationTimer class. It must override the handle method.
 */

public class GameTimer extends AnimationTimer{

	private GraphicsContext gc;
	private Scene theScene;
	private Ship myShip;
	private ArrayList<Fish> fishes;
	public static final int MAX_NUM_FISHES = 3;

	private PowerUp powerup;
	private final static double FISH_SPAWN_DELAY = 5;
	private final static double BOSS_SPAWN_DELAY = 30;
	private final static double POWERUP_SPAWN_DELAY = 10;
	private final static double POWERUP_STAY = 5;
	private final static double INVULNERABILITY_LENGTH = 3;
	private final static double GAME_TIME = 60;
	private long startFishSpawn;
	private long startBossSpawn;
	private long startPowerUpSpawn;
	private long stayPowerUp;
	private long gameTime;
	private long shipInvulnerabilityTime;
	private BossFish boss;
	private boolean start;
	private boolean powerup_stay = false;
	private int fishKilled =0;
	public final static Image BG = new Image("images/background.png",GameStage.WINDOW_HEIGHT,GameStage.WINDOW_HEIGHT,true,true);
	public final static Image GAMENAME = new Image("images/game name.png",GameStage.WINDOW_HEIGHT+150,GameStage.WINDOW_HEIGHT+150,true,true);
	public final static Image SIDE = new Image("images/side.png",GameStage.WINDOW_HEIGHT,GameStage.WINDOW_HEIGHT,true,true);
	public final static Image WASD = new Image("images/wasd.png",150,150,true,true);
	public final static Image SPACE = new Image("images/space.png",GameStage.WINDOW_HEIGHT-200,GameStage.WINDOW_HEIGHT-200,true,true);
	public final static Image ABT = new Image("images/about.png",GameStage.WINDOW_HEIGHT+350,GameStage.WINDOW_HEIGHT+350,true,true);




	GameTimer(GraphicsContext gc, Scene theScene){

		this.gc = gc;
		this.theScene = theScene;
		this.myShip = new Ship("Going merry",100,200);
		//instantiate the ArrayList of Fish
		this.fishes = new ArrayList<Fish>();

		Random r = new Random();
		double limitLow = GameStage.WINDOW_HEIGHT * .2;
		double limitHigh = GameStage.WINDOW_HEIGHT *.5;
		int low = (int)limitLow;
		int high = (int)limitHigh;
		int y = r.nextInt(high - low) + low;
		this.boss = new BossFish(800,y);

		//call the spawnFishes method
		this.spawnFishes(false);
		//call method to handle mouse click event
		this.handleKeyPressEvent();
		this.start = true;
	}

	@Override
	public void handle(long currentNanoTime) {
		this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		double spawnFishElapsedTime = (currentNanoTime - startFishSpawn) / 1000000000.0;
		double spawnBossElapsedTime = (currentNanoTime - startBossSpawn) / 1000000000.0;
		double spawnPowerUpElapsedTime = (currentNanoTime - startPowerUpSpawn) / 1000000000.0;
		double PowerUpElapsedTime = (currentNanoTime - stayPowerUp) / 1000000000.0;
		double gameElapsedTime = (currentNanoTime - gameTime) / 1000000000.0;
		double invulnerabilityTime = (currentNanoTime - shipInvulnerabilityTime) / 1000000000.0;

		this.myShip.move();
		/*
		 * TODO: Call the moveBullets and moveFishes methods
		 */

		this.moveBullets();
		this.moveFishes();
		this.gc.drawImage(BG,0,0,GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);

		//render the ship
		this.myShip.render(this.gc);

		this.gc.setFill(javafx.scene.paint.Color.WHITE);
		Font theFont = Font.font("Tahoma",FontWeight.BOLD,30);//set font type, style and size
		this.gc.setFont(theFont);
		this.gc.fillText((Math.round((GameTimer.GAME_TIME -gameElapsedTime)*100.0)/100.0)+ "",370, 50);
		theFont = Font.font("Tahoma",FontWeight.BOLD,20);
		this.gc.setFont(theFont);
		this.gc.fillText("Strength: "+ this.myShip.getStrength(),25, 40);
		this.gc.fillText("Enemies Killed: "+ this.fishKilled,25, 75);

		/*
		 * TODO: Call the renderFishes and renderBullets methods
		 */
		this.renderFishes();
		this.renderBullets();


		if(this.boss.isAlive()){
			this.boss.render(this.gc);
			this.boss.move();
		}
		if(this.powerup_stay){
			this.powerup.render(this.gc);
			if(this.powerup.collidesWith(this.myShip)){
				switch(this.powerup.getType()){
					case PowerUp.TYPE_PEARL: this.myShip.setStrength(50);
						break;
					case PowerUp.TYPE_STAR: this.myShip.setInvulnerability(true);
						break;
				}
				this.powerup_stay = false;
			}
			if(PowerUpElapsedTime > GameTimer.POWERUP_STAY){
				this.powerup_stay = false;
			}
		}

		if(this.myShip.getInvulnerability()){
			this.gc.fillText("Guardian: " + (Math.round((GameTimer.INVULNERABILITY_LENGTH-invulnerabilityTime)*100.0)/100.0),600, 40);
			if(invulnerabilityTime > GameTimer.INVULNERABILITY_LENGTH){
				this.myShip.setInvulnerability(false);
				this.shipInvulnerabilityTime = System.nanoTime();
			}
		} else this.shipInvulnerabilityTime = System.nanoTime();

		if(spawnFishElapsedTime > GameTimer.FISH_SPAWN_DELAY) {
			if(this.start){
				this.startFishSpawn = System.nanoTime();
			}else {
				this.spawnFishes(true);
				this.startFishSpawn = System.nanoTime();
			}
		}
		if(spawnBossElapsedTime > GameTimer.BOSS_SPAWN_DELAY){
			if(this.start){
				this.startBossSpawn = System.nanoTime();
			} else {
				this.boss.setAlive();
				this.startBossSpawn = System.nanoTime();
			}
		}

		if(this.boss.isAlive()){
			this.gc.fillText("Boss Health:"+ this.boss.getHealth(),600, 75);
		}
		if(spawnPowerUpElapsedTime > GameTimer.POWERUP_SPAWN_DELAY){
			if(this.start){
				this.startPowerUpSpawn = System.nanoTime();
			} else {
				this.spawnPowerUp();
				this.powerup_stay = true;
				this.startPowerUpSpawn = System.nanoTime();
				this.stayPowerUp = System.nanoTime();
			}
		}
		if(gameElapsedTime > GameTimer.GAME_TIME){
			if(this.start){
				this.gameTime = System.nanoTime();
			} else {
				this.stop();
				GameResult theGameStage = new GameResult();
				theGameStage.start((Stage)this.theScene.getWindow(), 0);;
				this.gameTime = System.nanoTime();
			}
		}
		if(this.myShip.getStrength()<=0 && gameElapsedTime < GameTimer.GAME_TIME){
			if(this.start){
				this.gameTime = System.nanoTime();
			} else {
				this.stop();
				this.myShip = new Ship("Going merry",100,200);
				GameResult theGameStage = new GameResult();
				theGameStage.start((Stage)this.theScene.getWindow(), 1);;
				this.gameTime = System.nanoTime();
			}
		}
		if(this.start){
			this.gameTime = System.nanoTime();
		}
		this.start = false;




	}

	//method that will render/draw the fishes to the canvas
	private void renderFishes() {
		for (Fish f : this.fishes){
			f.render(this.gc);
		}
	}

	//method that will render/draw the bullets to the canvas
	private void renderBullets() {
		/*
		 *TODO: Loop through the bullets arraylist of myShip
		 *				and render each bullet to the canvas
		 */
		ArrayList<Bullet> bList = this.myShip.getBullets();
		for (Bullet bul : bList){
			bul.render(this.gc);
		}
	}

	//method that will spawn/instantiate three fishes at a random x,y location
	private void spawnFishes(boolean state){
		Random r = new Random();

		if(state==false){
			for(int i=0;i<7;i++){
				int x = r.nextInt(GameStage.WINDOW_WIDTH);
				double limitHigh = GameStage.WINDOW_HEIGHT * .13;
				double limitLow = GameStage.WINDOW_HEIGHT * .855;
				int low = (int)limitLow;
				int high = (int)limitHigh;
				int y = r.nextInt(low - high) + high;
				/*
				 *TODO: Add a new object Fish to the fishes arraylist
				 */
				Fish fish = new Fish(x,y);
				this.fishes.add(fish);
			}
		}else if (state){
			for(int i=0;i<GameTimer.MAX_NUM_FISHES;i++){
				int x = r.nextInt(GameStage.WINDOW_WIDTH);
				double limitHigh = GameStage.WINDOW_HEIGHT * .13;
				double limitLow = GameStage.WINDOW_HEIGHT * .855;
				int low = (int)limitLow;
				int high = (int)limitHigh;
				int y = r.nextInt(low - high) + high;
				/*
				 *TODO: Add a new object Fish to the fishes arraylist
				 */
				Fish fish = new Fish(x,y);
				this.fishes.add(fish);
			}
		}



	}

	//method that will move the bullets shot by a ship
	private void moveBullets(){
		//create a local arraylist of Bullets for the bullets 'shot' by the ship
		ArrayList<Bullet> bList = this.myShip.getBullets();

		//Loop through the bullet list and check whether a bullet is still visible.
		for(int i = 0; i < bList.size(); i++){
			Bullet b = bList.get(i);
			/*
			 * TODO:  If a bullet is visible, move the bullet, else, remove the bullet from the bullet array list.
			 */
			if(b.getX() < 800){
				for(Fish isda : this.fishes){
					if(isda.collidesWith(b)){
						isda.isDead();
						this.fishKilled += 1;
						bList.remove(b);
					}
				}


				b.move();

			}
			if(b.collidesWith(this.boss) && this.boss.isAlive()){
				this.boss.setHealth(this.myShip.getStrength());
				if(this.boss.getHealth()<=0){
					this.boss.setDead();
				}
				bList.remove(b);
			}
			if(b.getX() > 800){
				bList.remove(b);
			}
		}
	}

	//method that will move the fishes
	private void moveFishes(){
		//Loop through the fishes arraylist
		for(int i = 0; i < this.fishes.size(); i++){
			Fish f = this.fishes.get(i);
			/*
			 * TODO:  *If a fish is alive, move the fish. Else, remove the fish from the fishes arraylist.
			 */
			if (f.isAlive()){
				f.move();
			} else {
				fishes.remove(f);
			}
		}
	}


	//method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		this.theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				KeyCode code = e.getCode();
				moveMyShip(code);
			}
		});

		this.theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				KeyCode code = e.getCode();
				stopMyShip(code);
			}
		});
	}

	//method that will move the ship depending on the key pressed
	private void moveMyShip(KeyCode ke) {
		if(ke==KeyCode.UP) this.myShip.setDY(-3);

		if(ke==KeyCode.LEFT) this.myShip.setDX(-3);

		if(ke==KeyCode.DOWN) this.myShip.setDY(3);

		if(ke==KeyCode.RIGHT) this.myShip.setDX(3);

		if(ke==KeyCode.SPACE) this.myShip.shoot();

		for(Fish isda : this.fishes){
			if(this.myShip.collidesWith(isda)){
				isda.isDead();
				this.fishKilled += 1;
				this.myShip.setStrength(-30);
			}
		}
		if(this.myShip.collidesWith(this.boss) && this.boss.isAlive()) {
			this.myShip.setStrength(-50);
		}
		System.out.println(ke+" key pressed.");
	}

	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyShip(KeyCode ke){
		this.myShip.setDX(0);
		this.myShip.setDY(0);
	}

	private void spawnPowerUp(){
		Random r = new Random();
		int x = r.nextInt(GameStage.WINDOW_WIDTH/2); // over 2 kasi left side lang mag spawn
		double limitHigh = GameStage.WINDOW_HEIGHT * .13;
		double limitLow = GameStage.WINDOW_HEIGHT * .855;
		int low = (int)limitLow;
		int high = (int)limitHigh;
		int y = r.nextInt(low - high) + high;
		this.powerup = new PowerUp(x,y);
	}


}