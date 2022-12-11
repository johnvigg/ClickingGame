import java.net.PortUnreachableException;
import java.security.PublicKey;

import javax.xml.transform.Templates;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{

    double score = 0;
    double multiplier = 1;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(100);

        Text text = new Text("0");
        

        Text upg = new Text("UPGRADES");
        

        Text doubleOnClick = new Text("double click power");
        doubleOnClick.setX(700);
        doubleOnClick.setY(50);

        
            doubleOnClick.setOnMouseClicked(e -> {
                multiplier *=2;
                score = score-100;
                text.setText(String.format("%.0f", score));
            });     
        


       

        ImageView imageView = new ImageView(new Image("1.png"));
        imageView.setX(400);
        imageView.setY(500);
        imageView.setFitHeight(116);
        imageView.setFitWidth(85);
        imageView.setOnMousePressed(e -> {
            score = score + multiplier;
            text.setText(String.format("%.0f", score));
            imageView.setFitHeight(121);
            imageView.setFitWidth(90);
        });
        imageView.setOnMouseReleased(e -> {
            imageView.setFitHeight(116);
            imageView.setFitWidth(85);
        });
        
        vBox.getChildren().add(text);
        vBox.getChildren().add(imageView);
        vBox.getChildren().addAll(upg,doubleOnClick);
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 800, 800, Color.AQUA); 
        primaryStage.setTitle("ShowImage"); 
        primaryStage.setScene(scene); // Place the scene in the stage 
        primaryStage.show();

    }

    public void upgradeScreen(VBox vBox){
        
    }
}
