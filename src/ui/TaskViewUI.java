package ui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import tasky.State;

import java.util.stream.Stream;

import static ui.Starter.WIDTH;

public class TaskViewUI extends GridPane {

    private Label idLbl;
    private TextField idTxf;
    private Label titleLbl;
    private TextField titleTxf;
    private Label descLbl;
    private TextArea descTxa;
    private Label dateLbl;
    private DatePicker datePicker;
    private Label stateLbl;
    private ChoiceBox<State> stateChoiceBox;
    private Button saveBtn;
    private Button deleteBtn;

    public TaskViewUI(){
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {

        idLbl = new Label("ID:");
        idTxf = new TextField();

        titleLbl = new Label("Title:");
        titleTxf = new TextField();

        descLbl = new Label("Desc:");
        descTxa = new TextArea();

        dateLbl = new Label("Date:");
        datePicker = new DatePicker();

        stateLbl = new Label("State:");
        stateChoiceBox = new ChoiceBox<State>();
        stateChoiceBox.getItems().addAll(State.getAllStates());

        saveBtn = new Button("Save");
        deleteBtn = new Button("Delete");
    }

    private void layoutControls() {
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(WIDTH/24);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(WIDTH/4.8);
        getColumnConstraints().addAll(col1, col2);

        setVgap(10d);
        setHgap(20d);

        add(idLbl, 0, 0);
        add(idTxf, 1, 0);
        add(titleLbl, 0, 1);
        add(titleTxf, 1, 1);
        add(descLbl, 0, 2);
        add(descTxa, 1, 2, 1, 2);
        add(dateLbl, 0,4);
        add(datePicker, 1, 4);
        add(stateLbl, 0, 5);
        add(stateChoiceBox, 1, 5);
        add(saveBtn, 0, 6);
        add(deleteBtn, 1, 6);

        datePicker.setPrefWidth(WIDTH/4.8);
        stateChoiceBox.setPrefWidth(WIDTH/4.8);
    }
}
