package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import tasky.State;

import static ui.Starter.THEME;
import static ui.Starter.WIDTH;

public class ApplicationUI extends BorderPane {

    private HBox mainHBox;
    private HBox bottomBox;

    private TaskListUI todoBox;
    private TaskListUI doingBox;
    private TaskListUI doneBox;
    private VBox inputBox;
    private Label taskLbl;
    private TaskViewUI inputView;

    private Button newBtn;
    private Button refreshBtn;

    static Theme color;

    public ApplicationUI(){
        initializeControls();
        layoutControls();
        todoBox.addTask(Starter.tasky.taskyLogic.read(0));
        todoBox.addTask(Starter.tasky.taskyLogic.read(1));
    }

    private void initializeControls(){
        color = new Theme(THEME);
        mainHBox = new HBox();
        bottomBox = new HBox();

        todoBox = new TaskListUI(State.TODO);
        doingBox = new TaskListUI(State.DOING);
        doneBox = new TaskListUI(State.DONE);
        inputBox = new VBox();
        taskLbl = new Label("OVERVIEW");
        inputView = new TaskViewUI();

        newBtn = new Button("New");
        refreshBtn = new Button("Refresh");
    }

    private void layoutControls(){
        setBackground(new Background(new BackgroundFill(color.lighter(), CornerRadii.EMPTY, Insets.EMPTY)));

        setCenter(mainHBox);
        setBottom(bottomBox);

        mainHBox.getChildren().add(todoBox);
        mainHBox.getChildren().add(doingBox);
        mainHBox.getChildren().add(doneBox);
        mainHBox.getChildren().add(inputBox);
        inputBox.getChildren().add(taskLbl);
        taskLbl.setPadding(new Insets(0, 0, 5, 0));
        inputBox.getChildren().add(inputView);
        mainHBox.setSpacing(20d);
        inputBox.setPadding(new Insets(5d, 50d, 0d, 50d));


        bottomBox.getChildren().add(newBtn);
        bottomBox.getChildren().add(refreshBtn);
        bottomBox.setPadding(new Insets(WIDTH/90, WIDTH/90, 0, 5));
        bottomBox.setSpacing(20d);

        setPadding(new Insets(WIDTH/90));
    }
}
