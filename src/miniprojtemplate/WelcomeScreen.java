package miniprojtemplate;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;

public class WelcomeScreen {
    private Scene scene;
    private Stage stage;
    private StackPane root;
    private GameStage gametimer;
    private Button newGameBtn, instructionsBtn, aboutBtn, backBtn;
    public WelcomeScreen(){
        this.root = new StackPane();
        this.scene = new Scene(root, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT, Color.WHITE);
        //this.gc = canvas.getGraphicsContext2D();
        //this.button = new HBox();
        //this.start(stage);
        this.gametimer = new GameStage();
//		theGameStage.setStage(stage);
    }

    public void start(Stage stage, int n){
        this.stage = stage;

        //this.root.getChildren().add(canvas);
        this.stage.setTitle("Menu");
        this.stage.setScene(this.scene);

        Button backBtn = new Button("Back");

        Font font = new Font("Courier New", 20);
        switch(n){
            case 0:
                ImageView imgView = new ImageView(GameTimer.GAMENAME);

                Button newGameBtn = new Button("New Game");
                this.newGameBtn = newGameBtn;
                newGameBtn.setFont(font);
                newGameBtn.setPrefSize(180,30);

                Button instructionsBtn = new Button("Instructions");
                this.instructionsBtn = instructionsBtn;
                instructionsBtn.setFont(font);
                instructionsBtn.setPrefSize(180,30);

                Button aboutBtn = new Button("About");
                this.aboutBtn = aboutBtn;
                aboutBtn.setFont(font);
                aboutBtn.setPrefSize(180,30);

                this.addEventHandler(newGameBtn);
                this.addEventHandler(instructionsBtn);
                this.addEventHandler(aboutBtn);

                root.getChildren().add(aboutBtn);
                root.getChildren().add(instructionsBtn);
                root.getChildren().add(newGameBtn);
                root.getChildren().add(imgView);

                imgView.setTranslateY(-100);

                aboutBtn.setTranslateY(150);
                instructionsBtn.setTranslateY(100);
                newGameBtn.setTranslateY(50);

                aboutBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                instructionsBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                newGameBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                break;
            case 1:
                ImageView imgView1 = new ImageView(GameTimer.SIDE);
                ImageView imgView2 = new ImageView(GameTimer.WASD);
                ImageView imgView3 = new ImageView(GameTimer.SPACE);
                ImageView imgView4 = new ImageView(PowerUp.TYPE_PEARL_IMAGE);
                ImageView imgView5 = new ImageView(PowerUp.TYPE_STAR_IMAGE);
                ImageView imgView6 = new ImageView(Fish.FISH_IMAGE);
                ImageView imgView7 = new ImageView(BossFish.BOSS_FISH_IMAGE);

                font = Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 40);
                Text text = new Text("Solitude.");
                text.setFont(font);

                font = Font.font("Courier New", FontWeight.THIN, FontPosture.ITALIC, 20);
                Text text1 = new Text("Enjoyed by some,\ncannot be escaped by one.");
                text1.setFont(font);

                font = Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR, 15);
                Text text2 = new Text("     Solitude preserved by the adepti residing in \nWangshu Inn was disturbed by the shogunate's force.");
                text2.setFont(font);

                font = Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 15);
                Text text3 = new Text("Help Xiao conquer his these impediments \nwith the following: ");
                text3.setFont(font);

                font = Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR, 13);
                Text text4 = new Text("Your strength equates to your\nhealth. No strength == Game Over.");
                text4.setFont(font);

                Text text5 = new Text("After being attacked by\nordinary soldiers, your\nstrength is decreased\nand they die. It takes\na bullet to kill a\nordinary soldier.");
                text5.setFont(font);

                Text text6 = new Text("Boss will arrive 30\nseconds late, having\ngreater health and\ndamage. Depending on\nyour current strength,\nis the amount of\nbullets needed for the\nBoss to be killed.");
                text6.setFont(font);

                Text text7 = new Text("W - upward\nA - left\nS - downward\nD - right\nSPACE - shoot");
                text7.setFont(font);

                Text text8 = new Text("Power ups spawn at\ntime interval, make\nsure to get them.");
                text8.setFont(font);

                Text text9 = new Text("Qingxin -\n   +50 strength\nJade -\n   invulnerability");
                text9.setFont(font);

                Text text10 = new Text("Qingxin");
                text10.setFont(font);

                Text text11 = new Text("Jade");
                text11.setFont(font);

                Text text12 = new Text("Ordinary\nSoldier");
                text12.setFont(font);

                Text text13 = new Text("Boss");
                text13.setFont(font);

                font = new Font("Courier New", 20);
                this.backBtn = backBtn;
                backBtn.setFont(font);

                this.addEventHandler(backBtn);

                imgView7.setFitWidth(80);
                imgView7.setFitHeight(80);

                root.getChildren().add(imgView1);
                root.getChildren().add(backBtn);
                root.getChildren().add(text);
                root.getChildren().add(text1);
                root.getChildren().add(text2);
                root.getChildren().add(text3);
                root.getChildren().add(text4);
                root.getChildren().add(text5);
                root.getChildren().add(text6);
                root.getChildren().add(text7);
                root.getChildren().add(text8);
                root.getChildren().add(text9);
                root.getChildren().add(text10);
                root.getChildren().add(text11);
                root.getChildren().add(text12);
                root.getChildren().add(text13);
                root.getChildren().add(imgView2);
                root.getChildren().add(imgView3);
                root.getChildren().add(imgView4);
                root.getChildren().add(imgView5);
                root.getChildren().add(imgView6);
                root.getChildren().add(imgView7);


                imgView1.setTranslateX(-340);

                imgView2.setTranslateX(-55);
                imgView2.setTranslateY(40);

                imgView3.setTranslateX(-4);
                imgView3.setTranslateY(90);

                imgView4.setTranslateX(-80);
                imgView4.setTranslateY(140);

                imgView5.setTranslateX(-80);
                imgView5.setTranslateY(205);

                imgView6.setTranslateX(150);
                imgView6.setTranslateY(50);

                imgView7.setTranslateX(150);
                imgView7.setTranslateY(150);

                backBtn.setTranslateY(-200);
                backBtn.setTranslateX(-330);
                backBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

                text.setTranslateY(-200);
                text.setTranslateX(-30);

                text1.setTranslateY(-150);
                text1.setTranslateX(35);

                text2.setTranslateY(-80);
                text2.setTranslateX(120);

                text3.setTranslateY(-30);
                text3.setTranslateX(70);

                text4.setTranslateX(250);

                text5.setTranslateX(290);
                text5.setTranslateY(65);

                text6.setTranslateX(285);
                text6.setTranslateY(170);

                text7.setTranslateX(60);
                text7.setTranslateY(30);

                text8.setTranslateX(25);
                text8.setTranslateY(140);

                text9.setTranslateX(50);
                text9.setTranslateY(200);

                text10.setTranslateX(-80);
                text10.setTranslateY(172);

                text11.setTranslateX(-80);
                text11.setTranslateY(237);

                text12.setTranslateX(150);
                text12.setTranslateY(90);

                text13.setTranslateX(150);
                text13.setTranslateY(200);
                break;
            case 2:
                ImageView imgView8 = new ImageView(GameTimer.ABT);

                Rectangle rect = new Rectangle( 0,0,GameStage.WINDOW_WIDTH-100,GameStage.WINDOW_HEIGHT-100);
                rect.setFill(Color.BLACK.deriveColor(0, 1.2, 1, 0.6));

                font = Font.font("Impact",FontWeight.THIN,FontPosture.REGULAR,72);
                Text text14 = new Text("A B O U T");
                text14.setFont(font);
                text14.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.BOLD,FontPosture.ITALIC, 25);
                Text text15 = new Text("Project of:");
                text15.setFont(font);
                text15.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.NORMAL,FontPosture.REGULAR, 20);
                Text text16 = new Text("Dayrit, Karlos Denzel\nMayo, Mark Jayson");
                text16.setFont(font);
                text16.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.BOLD,FontPosture.ITALIC, 25);
                Text text17 = new Text("Assets by:");
                text17.setFont(font);
                text17.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.NORMAL,FontPosture.REGULAR, 20);
                Text text18 = new Text("Mayo, Mark Jayson");
                text18.setFont(font);
                text18.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.BOLD,FontPosture.ITALIC, 25);
                Text text19 = new Text("Inspirations:");
                text19.setFont(font);
                text19.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.NORMAL,FontPosture.REGULAR, 20);
                Text text20 = new Text("Genshin Impact\nPun-Rii");
                text20.setFont(font);
                text20.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.BOLD,FontPosture.ITALIC, 25);
                Text text21 = new Text("Reference:");
                text21.setFont(font);
                text21.setFill(Color.LIGHTGRAY);

                font = Font.font("Courier New", FontWeight.NORMAL,FontPosture.REGULAR, 20);
                Text text22 = new Text("UPLB | CMSC 22 -\n Mini Project Template");
                text22.setFont(font);
                text22.setFill(Color.LIGHTGRAY);

                font = new Font("Courier New", 20);
                this.backBtn = backBtn;
                backBtn.setFont(font);

                this.addEventHandler(backBtn);

                root.getChildren().add(imgView8);
                root.getChildren().add(rect);
                root.getChildren().add(text14);
                root.getChildren().add(text15);
                root.getChildren().add(text16);
                root.getChildren().add(text17);
                root.getChildren().add(text18);
                root.getChildren().add(text19);
                root.getChildren().add(text20);
                root.getChildren().add(text21);
                root.getChildren().add(text22);
                root.getChildren().add(backBtn);

                text14.setTranslateY(-150);

                text15.setTranslateX(-240);
                text15.setTranslateY(-50);

                text16.setTranslateX(-198);
                text16.setTranslateY(-10);

                text17.setTranslateX(-248);
                text17.setTranslateY(50);

                text18.setTranslateX(-220);
                text18.setTranslateY(80);

                text19.setTranslateX(80);
                text19.setTranslateY(-50);

                text20.setTranslateX(70);
                text20.setTranslateY(-10);

                text21.setTranslateX(60);
                text21.setTranslateY(50);

                text22.setTranslateX(118);
                text22.setTranslateY(90);

                backBtn.setTranslateY(-150);
                backBtn.setTranslateX(-280);
                backBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

                break;
        }
        this.stage.show();
    }

    private void addEventHandler(Button btn){
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getSource()==newGameBtn){
                    gametimer.setStage(stage);
                }else if(event.getSource()==instructionsBtn){
                    WelcomeScreen welcomeScreen = new WelcomeScreen();
                    welcomeScreen.start(stage,1);;
                }else if(event.getSource()==aboutBtn){
                    WelcomeScreen welcomeScreen = new WelcomeScreen();
                    welcomeScreen.start(stage,2);;
                }else if(event.getSource()==backBtn){
                    WelcomeScreen theGameStage = new WelcomeScreen();
                    theGameStage.start(stage, 0);
                }
            }
        });
    }
}

