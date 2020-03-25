package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import tasky.Task;

import static ui.Starter.WIDTH;

public class TaskUI extends Label {

    private Task task;

    public TaskUI(Task task){
        this.task = task;
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        setText(task.getData().getTitle() + "\n"
        + task.getData().getDue() + "\n"
        + task.getData().getDesc());
        setPrefWidth(WIDTH*2/11);
        setWrapText(true);
    }

    private void layoutControls() {
        setBackground(new Background(new BackgroundFill(ApplicationUI.color.medium(), CornerRadii.EMPTY, Insets.EMPTY)));
        setPadding(new Insets(5));
    }
}
