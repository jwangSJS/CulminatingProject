// James Wang
// PDS 2021
// Mr. Garvin
// Culminating Project

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sound.midi.MidiUnavailableException;
import java.util.HashMap;

public class GUI extends Application {
    Button buttonC;
    Button buttonCs;
    Button buttonDs;
    Button buttonD;
    Button buttonE;
    Button buttonF;
    Button buttonFs;
    Button buttonG;
    Button buttonGs;
    Button buttonA;
    Button buttonAs;
    Button buttonB;
    Button buttonC1;
    Button buttonCs1;
    Button buttonD1;
    Button buttonDs1;
    Button buttonE1;
    Button buttonF1;
    Button buttonFs1;
    Button buttonG1;
    Button buttonGs1;
    Button buttonA1;
    Button buttonAs1;
    Button buttonB1;
    Button buttonC2;

    // white key style
    String wStyle = "-fx-border-color: black;" +
            "-fx-background-color: #ffffff;" +
            "-fx-font-size:7";
    // black key style
    String bStyle = "-fx-background-color: #000000;" +
            "-fx-text-base-color: white;" +
            "-fx-font-size:7";
    // button style when pressed
    String pStyle = "-fx-background-color: #d94141; " +
            "-fx-font-size:7";

    // sizes of keys
    int wX = 25;
    int wY = 140;
    int bX = 20;
    int bY = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Piano");
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(pane, 600, 300);

        Sound sound = new Sound();

        // combination box to select octaves
        String[] octaves = {"1", "2", "3", "4", "5", "6", "7"};
        ComboBox octaveCombo = new ComboBox(FXCollections.observableArrayList(octaves));
        setNodeLayout(octaveCombo, 500, 240);
        octaveCombo.getSelectionModel().select(3);
        octaveCombo.setOnAction(actionEvent -> sound.changeOctave(String.valueOf(octaveCombo.getValue())));

        Label octaveLabel = new Label("Select octave:");
        setNodeLayout(octaveLabel, 490, 220);

        // textfield to select instrument
        TextField instrumentSelector = new TextField();
        instrumentSelector.setPrefSize(50, 20);
        setNodeLayout(instrumentSelector, 350, 240);
        instrumentSelector.setText("1");

        Label instrumentLabel = new Label("Instrument: " + sound.findInstrumentName());
        setNodeLayout(instrumentLabel, 320, 220);

        // initializing the increment buttons
        String incrementInstrumentStyle = "-fx-font-size:9";

        Button instrumentConfirm = new Button("Enter");
        setButtonLayout(instrumentConfirm, 410, 240, "", 50, 25);
        instrumentConfirm.setOnAction(actionEvent ->
                sound.changeInstrument(instrumentLabel, instrumentSelector.getText()));

        Button increaseInstrument = new Button("^");
        setButtonLayout(increaseInstrument, 320, 240, incrementInstrumentStyle, 20, 20);
        increaseInstrument.setOnAction(actionEvent ->
                sound.changeInstrument(instrumentLabel, instrumentSelector,
                        instrumentSelector.getText(), 1));

        Button decreaseInstrument = new Button("v");
        setButtonLayout(decreaseInstrument, 320, 260, incrementInstrumentStyle, 20, 20);
        decreaseInstrument.setOnAction(actionEvent ->
                //System.out.println(instrumentSelector.getText()));
                sound.changeInstrument(instrumentLabel, instrumentSelector,
                        instrumentSelector.getText(), -1));

        Button playMusic = new Button("Play Me!");
        setButtonLayout(playMusic, 200, 250, "", 100, 20);
        playMusic.setOnAction(actionEvent -> sound.playMoonlight(1));

        // instantiate buttons and handle mouse clicks for each button
        buttonC = new Button("C");
        setButtonLayout(buttonC, 100, 70, wStyle, wX, wY);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC, mouseEvent, "C", 0, pStyle, wStyle));

        buttonCs = new Button("C#");
        setButtonLayout(buttonCs, 117, 70, bStyle, bX, bY);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonCs, mouseEvent, "C#", 0, pStyle, bStyle));

        buttonD = new Button("D");
        setButtonLayout(buttonD, 130, 70, wStyle, wX, wY);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonD, mouseEvent, "D", 0, pStyle, wStyle));

        buttonDs = new Button("D#");
        setButtonLayout(buttonDs, 147, 70, bStyle, bX, bY);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonDs, mouseEvent, "D#", 0, pStyle, bStyle));

        buttonE = new Button("E");
        setButtonLayout(buttonE, 160, 70, wStyle, wX, wY);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonE, mouseEvent, "E", 0, pStyle, wStyle));

        buttonF = new Button("F");
        setButtonLayout(buttonF, 190, 70, wStyle, wX, wY);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonF, mouseEvent, "F", 0, pStyle, wStyle));

        buttonFs = new Button("F#");
        setButtonLayout(buttonFs, 207, 70, bStyle, bX, bY);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonFs, mouseEvent, "F#", 0, pStyle, bStyle));

        buttonG = new Button("G");
        setButtonLayout(buttonG, 220, 70, wStyle, wX, wY);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonG, mouseEvent, "G", 0, pStyle, wStyle));

        buttonGs = new Button("G#");
        setButtonLayout(buttonGs, 237, 70, bStyle, bX, bY);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonGs, mouseEvent, "G#", 0, pStyle, bStyle));

        buttonA = new Button("A");
        setButtonLayout(buttonA, 250, 70, wStyle, wX, wY);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonA, mouseEvent, "A", 0, pStyle, wStyle));

        buttonAs = new Button("A#");
        setButtonLayout(buttonAs, 267, 70, bStyle, bX, bY);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonAs, mouseEvent, "A#", 0, pStyle, bStyle));

        buttonB = new Button("B");
        setButtonLayout(buttonB, 280, 70, wStyle, wX, wY);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonB, mouseEvent, "B", 0, pStyle, wStyle));

        buttonC1 = new Button("C");
        setButtonLayout(buttonC1, 310, 70, wStyle, wX, wY);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC1, mouseEvent, "C", 1, pStyle, wStyle));

        buttonCs1 = new Button("C#");
        setButtonLayout(buttonCs1, 327, 70, bStyle, bX, bY);
        buttonCs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonCs1, mouseEvent, "C#", 1, pStyle, bStyle));

        buttonD1 = new Button("D");
        setButtonLayout(buttonD1, 340, 70, wStyle, wX, wY);
        buttonD1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonD1, mouseEvent, "D", 1, pStyle, wStyle));

        buttonDs1 = new Button("D#");
        setButtonLayout(buttonDs1, 357, 70, bStyle, bX, bY);
        buttonDs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonDs1, mouseEvent, "D#", 1, pStyle, bStyle));

        buttonE1 = new Button("E");
        setButtonLayout(buttonE1, 370, 70, wStyle, wX, wY);
        buttonE1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonE1, mouseEvent, "E", 1, pStyle, wStyle));

        buttonF1 = new Button("F");
        setButtonLayout(buttonF1, 400, 70, wStyle, wX, wY);
        buttonF1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonF1, mouseEvent, "F", 1, pStyle, wStyle));

        buttonFs1 = new Button("F#");
        setButtonLayout(buttonFs1, 417, 70, bStyle, bX, bY);
        buttonFs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonFs1, mouseEvent, "F#", 1, pStyle, bStyle));

        buttonG1 = new Button("G");
        setButtonLayout(buttonG1, 430, 70, wStyle, wX, wY);
        buttonG1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonG1, mouseEvent, "G", 1, pStyle, wStyle));

        buttonGs1 = new Button("G#");
        setButtonLayout(buttonGs1, 447, 70, bStyle, bX, bY);
        buttonGs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonGs1, mouseEvent, "G#", 1, pStyle, bStyle));

        buttonA1 = new Button("A");
        setButtonLayout(buttonA1, 460, 70, wStyle, wX, wY);
        buttonA1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonA1, mouseEvent, "A", 1, pStyle, wStyle));

        buttonAs1 = new Button("A#");
        setButtonLayout(buttonAs1, 477, 70, bStyle, bX, bY);
        buttonAs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonAs1, mouseEvent, "A#", 1, pStyle, bStyle));

        buttonB1 = new Button("B");
        setButtonLayout(buttonB1, 490, 70, wStyle, wX, wY);
        buttonB1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonB1, mouseEvent, "B", 1, pStyle, wStyle));

        buttonC2 = new Button("C");
        setButtonLayout(buttonC2, 520, 70, wStyle, wX, wY);
        buttonC2.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC2, mouseEvent, "C", 2, pStyle, wStyle));

        HashMap<KeyCode, Button> buttonRef = KeyBindToButtonMap();

        // handle keyboard inputs
        pane.addEventFilter(KeyEvent.ANY, keyEvent ->
                sound.play(keyEvent, buttonRef.get(keyEvent.getCode()), pStyle, getButtonStyle(keyEvent)));

        // stop the program safely when window is closed
        primaryStage.setOnCloseRequest(closeEvent -> Runtime.getRuntime().halt(0));

        pane.getChildren().addAll(octaveCombo, octaveLabel, instrumentSelector, instrumentConfirm, instrumentLabel, playMusic,
                increaseInstrument, decreaseInstrument, buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF,
                buttonFs, buttonG, buttonGs, buttonA, buttonAs, buttonB, buttonC1, buttonCs1, buttonD1, buttonDs1,
                buttonE1, buttonF1, buttonFs1, buttonG1, buttonGs1, buttonA1, buttonAs1, buttonB1, buttonC2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setButtonLayout(Button button, int xPos, int yPos, String style, int xSize, int ySize) {
        setNodeLayout(button, xPos, yPos);
        button.setMinSize(xSize,ySize);
        button.setPrefSize(xSize, ySize);
        button.setMaxSize(xSize,ySize);
        button.setStyle(style);
        button.setAlignment(Pos.BOTTOM_CENTER);
        if (style.equals(bStyle)) { // make black keys overlay white keys
            button.setViewOrder(-1.0);
        }
    }

    private void setNodeLayout(Node node, int x, int y) {
        node.setLayoutX(x);
        node.setLayoutY(y);
    }

    private String getButtonStyle(KeyEvent e) {
        return switch(e.getCode()) {
            case Q, W , E, R, T, Y, U, I, O, P, Z, X, C, V, B -> wStyle;
            case DIGIT2, DIGIT3, DIGIT5, DIGIT6, DIGIT7, DIGIT9, DIGIT0, S, D, F -> bStyle;
            default -> null;
        };
    }

    private HashMap<KeyCode, Button> KeyBindToButtonMap(){
        HashMap<KeyCode, Button> buttonReference = new HashMap<>();
        buttonReference.put(KeyCode.Q, buttonC);
        buttonReference.put(KeyCode.DIGIT2, buttonCs);
        buttonReference.put(KeyCode.W, buttonD);
        buttonReference.put(KeyCode.DIGIT3, buttonDs);
        buttonReference.put(KeyCode.E, buttonE);
        buttonReference.put(KeyCode.R, buttonF);
        buttonReference.put(KeyCode.DIGIT5, buttonFs);
        buttonReference.put(KeyCode.T, buttonG);
        buttonReference.put(KeyCode.DIGIT6, buttonGs);
        buttonReference.put(KeyCode.Y, buttonA);
        buttonReference.put(KeyCode.DIGIT7, buttonAs);
        buttonReference.put(KeyCode.U, buttonB);
        buttonReference.put(KeyCode.I, buttonC1);
        buttonReference.put(KeyCode.DIGIT9, buttonCs1);
        buttonReference.put(KeyCode.O, buttonD1);
        buttonReference.put(KeyCode.DIGIT0, buttonDs1);
        buttonReference.put(KeyCode.P, buttonE1);
        buttonReference.put(KeyCode.Z, buttonF1);
        buttonReference.put(KeyCode.S, buttonFs1);
        buttonReference.put(KeyCode.X, buttonG1);
        buttonReference.put(KeyCode.D, buttonGs1);
        buttonReference.put(KeyCode.C, buttonA1);
        buttonReference.put(KeyCode.F, buttonAs1);
        buttonReference.put(KeyCode.V, buttonB1);
        buttonReference.put(KeyCode.B, buttonC2);
        return buttonReference;
    }
}