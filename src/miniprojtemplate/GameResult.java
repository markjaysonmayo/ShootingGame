package miniprojtemplate;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class GameResult {
    private Scene scene;
    private Stage stage;
    private StackPane root;
    private Button homeBtn;
    public final static Image WON = new Image("images/won.png", GameStage.WINDOW_WIDTH-200, GameStage.WINDOW_HEIGHT-200,true,true);
    public final static Image DEFEAT = new Image("images/lose.png",GameStage.WINDOW_WIDTH-200,GameStage.WINDOW_HEIGHT-200,true,true);

    public GameResult(){
        this.root = new StackPane();
        this.scene = new Scene(root, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT, Color.WHITE);
    }

    public void start(Stage stage, int n){
        this.stage = stage;

        //this.root.getChildren().add(canvas);
        this.stage.setTitle("Mini");
        this.stage.setScene(this.scene);

        Font font = new Font("Courier New", 20);
        switch(n){
            case 0:
                ImageView imageView1 = new ImageView(WON);

                Button homeBtn = new Button("Home");
                this.homeBtn = homeBtn;
                homeBtn.setFont(font);
                homeBtn.setPrefSize(180,30);


                this.addEventHandler(homeBtn);

                root.getChildren().add(homeBtn);
                root.getChildren().add(imageView1);

                imageView1.setTranslateY(-55);

                homeBtn.setTranslateY(150);

                homeBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

                break;
            case 1:
                ImageView imageView2 = new ImageView(DEFEAT);
                homeBtn = new Button("Home");
                this.homeBtn = homeBtn;
                homeBtn.setFont(font);
                homeBtn.setPrefSize(180,30);


                this.addEventHandler(homeBtn);

                root.getChildren().add(homeBtn);
                root.getChildren().add(imageView2);

                imageView2.setTranslateY(-55);
                //root.getChildren().add(imgView);

                //imgView.setTranslateY(-100);

                homeBtn.setTranslateY(150);

                homeBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

                break;
        }

        this.stage.show();
    }


    private void addEventHandler(Button btn){
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getSource()==homeBtn) {
                    WelcomeScreen theGameStage = new WelcomeScreen();
                    theGameStage.start(stage, 0);
                }
            }
        });
    }
}

