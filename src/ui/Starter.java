package ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static final int THEME = 191;
    public static CLI tasky;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootPanel = new ApplicationUI();

        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("Tasky");
        primaryStage.setScene(scene);

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.centerOnScreen();

        primaryStage.show();
        tasky = new CLI();
        //tasky.run();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
