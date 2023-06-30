package miniprojtemplate;

import javafx.scene.image.Image;
import java.util.Random;

public class PowerUp extends Sprite {
    private String type;

    private final static int POWERUP_TYPE_AMOUNT = 2;
    //temporary pearl image
    public final static Image TYPE_PEARL_IMAGE = new Image("images/qingxin.png",Fish.FISH_WIDTH,Fish.FISH_WIDTH,true,true);
    //temporary star image
    public final static Image TYPE_STAR_IMAGE = new Image("images/immortality.png",Fish.FISH_WIDTH,Fish.FISH_WIDTH,true,true);
    public final static String TYPE_PEARL = "Pearl";
    public final static String TYPE_STAR = "Star";

    PowerUp(int x, int y){
        super(x,y);
        Random r = new Random();
        int determiner = r.nextInt(PowerUp.POWERUP_TYPE_AMOUNT);
        switch(determiner){
            case 0: this.type = PowerUp.TYPE_PEARL;
                this.loadImage(TYPE_PEARL_IMAGE);
                break;
            case 1: this.type = PowerUp.TYPE_STAR;
                this.loadImage(TYPE_STAR_IMAGE);
                break;
        }
    }

    //getter
    public String getType(){
        return this.type;
    }
}