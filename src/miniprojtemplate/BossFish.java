package miniprojtemplate;

import javafx.scene.image.Image;

public class BossFish extends Fish{
    public static final int BOSS_FISH_WIDTH = 300;
    public final static Image BOSS_FISH_IMAGE = new Image("images/boss.png",BossFish.BOSS_FISH_WIDTH,BOSS_FISH_WIDTH,true,false);
    private int health;

    BossFish(int x, int y) {
        super(x, y);
        this.loadImage(BOSS_FISH_IMAGE);
        super.alive = false;
        this.health = 3000;
    }

    public void setAlive(){
        this.alive = true;
    }
    public void setDead(){
        this.alive = false;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int strength){
        this.health = this.health - strength;
    }

}
