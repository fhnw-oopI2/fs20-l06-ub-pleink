package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import tasky.State;
import tasky.Task;

import static ui.Starter.HEIGHT;
import static ui.Starter.WIDTH;

public class TaskListUI extends VBox {

    private Label stateLbl;
    private VBox taskList;

    private State state;

    public TaskListUI(State state){
        this.state = state;
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        stateLbl = new Label(state.toString());
        taskList = new VBox();
    }

    private void layoutControls() {
        getChildren().add(stateLbl);
        getChildren().add(taskList);

        stateLbl.setTextFill(ApplicationUI.color.darker());
        stateLbl.setPadding(new Insets(0, 0, 5, 0));

        taskList.setBackground(new Background(new BackgroundFill(ApplicationUI.color.lighter(), CornerRadii.EMPTY, Insets.EMPTY)));
        taskList.setMaxWidth(WIDTH*2/11);
        taskList.setPrefWidth(WIDTH*2/11);
        taskList.setPrefHeight(HEIGHT);
        taskList.setPadding(new Insets(5));
        setPadding(new Insets(5));
        setBackground(new Background(new BackgroundFill(ApplicationUI.color.light(), CornerRadii.EMPTY, Insets.EMPTY)));
        taskList.setSpacing(5d);
    }

    public void addTask(Task task){
        taskList.getChildren().add(new TaskUI(task));
    }

}
