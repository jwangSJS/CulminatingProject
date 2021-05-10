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
    Button buttonCs2;
    Button buttonD2;
    Button buttonDs2;
    Button buttonE2;
    Button buttonF2;
    Button buttonFs2;
    Button buttonG2;
    Button buttonGs2;
    Button buttonA2;
    Button buttonAs2;
    Button buttonB2;
    Button buttonC3;

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

    String incrementButtonStyle = "-fx-font-size:9";

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
        Scene scene = new Scene(pane, 835, 330);

        Sound sound = new Sound();

        // combination box to select octaves
        String[] octaves = {"1", "2", "3", "4", "5", "6"};
        ComboBox octaveCombo = new ComboBox(FXCollections.observableArrayList(octaves));
        setNodeLayout(octaveCombo, 510, 240);
        octaveCombo.getSelectionModel().select(3);
        octaveCombo.setOnAction(actionEvent -> {
            sound.changeOctave(String.valueOf(octaveCombo.getValue()));
            actionEvent.consume();
        });

        Label octaveLabel = new Label("Select octave:");
        setNodeLayout(octaveLabel, 500, 220);

        // octave increment buttons
        Button increaseOctave = new Button("^");
        setButtonLayout(increaseOctave, 480, 240, incrementButtonStyle, 20, 20);
        increaseOctave.setOnAction(actionEvent -> {
            sound.changeOctave(String.valueOf(Integer.valueOf(String.valueOf(octaveCombo.getValue())) + 1),
                    octaveCombo);
            actionEvent.consume();
        });

        Button decreaseOctave = new Button("v");
        setButtonLayout(decreaseOctave, 480, 260, incrementButtonStyle, 20, 20);
        decreaseOctave.setOnAction(actionEvent -> {
            sound.changeOctave(String.valueOf(Integer.valueOf(String.valueOf(octaveCombo.getValue())) - 1),
                    octaveCombo);
            actionEvent.consume();
        });

        // textfield to select instrument
        TextField instrumentSelector = new TextField();
        instrumentSelector.setPrefSize(50, 20);
        setNodeLayout(instrumentSelector, 350, 240);
        instrumentSelector.setText("1");

        Label instrumentLabel = new Label("Instrument: " + sound.getCurrentInstrumentName());
        setNodeLayout(instrumentLabel, 320, 220);

        // confirm and increment instrument buttons
        Button instrumentConfirm = new Button("Enter");
        setButtonLayout(instrumentConfirm, 410, 240, "", 50, 25);
        instrumentConfirm.setOnAction(actionEvent -> {
            sound.changeInstrument(instrumentLabel, instrumentSelector, instrumentSelector.getText());
            actionEvent.consume();
        });

        Button increaseInstrument = new Button("^");
        setButtonLayout(increaseInstrument, 320, 240, incrementButtonStyle, 20, 20);
        increaseInstrument.setOnAction(actionEvent -> {
            sound.changeInstrument(instrumentLabel, instrumentSelector, instrumentSelector.getText(), 1);
            actionEvent.consume();
        });

        Button decreaseInstrument = new Button("v");
        setButtonLayout(decreaseInstrument, 320, 260, incrementButtonStyle, 20, 20);
        decreaseInstrument.setOnAction(actionEvent -> {
            sound.changeInstrument(instrumentLabel, instrumentSelector, instrumentSelector.getText(), -1);
            actionEvent.consume();
        });

        // random instrument button
        Button instrumentRandom = new Button("Random Instrument");
        setButtonLayout(instrumentRandom, 347, 270, "-fx-font-size:11", 120, 25);
        instrumentRandom.setOnAction(actionEvent -> {
            sound.changeInstrument(instrumentLabel, instrumentSelector);
            actionEvent.consume();
        });

        // combination box to select octaves
        String[] songs = {"Arabesque", "Nocturne"};
        ComboBox songCombo = new ComboBox(FXCollections.observableArrayList(songs));
        setNodeLayout(songCombo, 140, 240);
        songCombo.getSelectionModel().select(0);

        // play sample song button
        Button playMusic = new Button("Play");
        setButtonLayout(playMusic, 250, 240, "", 50, 25);
        playMusic.setOnAction(actionEvent -> {
            sound.playSampleSong(String.valueOf(songCombo.getValue()));
            actionEvent.consume();
        });

        Label sampleLabel = new Label("Select Sample Piece:");
        setNodeLayout(sampleLabel, 135, 220);

        // instantiate keyboard buttons and handle mouse clicks for each button
        buttonC = new Button("C");
        setButtonLayout(buttonC, 100, 70, wStyle, wX, wY);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonC, mouseEvent, "C", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonCs = new Button("C#");
        setButtonLayout(buttonCs, 117, 70, bStyle, bX, bY);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonCs, mouseEvent, "C#", 0, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonD = new Button("D");
        setButtonLayout(buttonD, 130, 70, wStyle, wX, wY);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonD, mouseEvent, "D", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonDs = new Button("D#");
        setButtonLayout(buttonDs, 147, 70, bStyle, bX, bY);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonDs, mouseEvent, "D#", 0, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonE = new Button("E");
        setButtonLayout(buttonE, 160, 70, wStyle, wX, wY);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonE, mouseEvent, "E", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonF = new Button("F");
        setButtonLayout(buttonF, 190, 70, wStyle, wX, wY);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonF, mouseEvent, "F", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonFs = new Button("F#");
        setButtonLayout(buttonFs, 207, 70, bStyle, bX, bY);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonFs, mouseEvent, "F#", 0, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonG = new Button("G");
        setButtonLayout(buttonG, 220, 70, wStyle, wX, wY);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonG, mouseEvent, "G", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonGs = new Button("G#");
        setButtonLayout(buttonGs, 237, 70, bStyle, bX, bY);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonGs, mouseEvent, "G#", 0, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonA = new Button("A");
        setButtonLayout(buttonA, 250, 70, wStyle, wX, wY);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonA, mouseEvent, "A", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonAs = new Button("A#");
        setButtonLayout(buttonAs, 267, 70, bStyle, bX, bY);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonAs, mouseEvent, "A#", 0, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonB = new Button("B");
        setButtonLayout(buttonB, 280, 70, wStyle, wX, wY);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonB, mouseEvent, "B", 0, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonC1 = new Button("C");
        setButtonLayout(buttonC1, 310, 70, wStyle, wX, wY);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonC1, mouseEvent, "C", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonCs1 = new Button("C#");
        setButtonLayout(buttonCs1, 327, 70, bStyle, bX, bY);
        buttonCs1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonCs1, mouseEvent, "C#", 1, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonD1 = new Button("D");
        setButtonLayout(buttonD1, 340, 70, wStyle, wX, wY);
        buttonD1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonD1, mouseEvent, "D", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonDs1 = new Button("D#");
        setButtonLayout(buttonDs1, 357, 70, bStyle, bX, bY);
        buttonDs1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonDs1, mouseEvent, "D#", 1, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonE1 = new Button("E");
        setButtonLayout(buttonE1, 370, 70, wStyle, wX, wY);
        buttonE1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonE1, mouseEvent, "E", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonF1 = new Button("F");
        setButtonLayout(buttonF1, 400, 70, wStyle, wX, wY);
        buttonF1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonF1, mouseEvent, "F", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonFs1 = new Button("F#");
        setButtonLayout(buttonFs1, 417, 70, bStyle, bX, bY);
        buttonFs1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonFs1, mouseEvent, "F#", 1, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonG1 = new Button("G");
        setButtonLayout(buttonG1, 430, 70, wStyle, wX, wY);
        buttonG1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonG1, mouseEvent, "G", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonGs1 = new Button("G#");
        setButtonLayout(buttonGs1, 447, 70, bStyle, bX, bY);
        buttonGs1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonGs1, mouseEvent, "G#", 1, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonA1 = new Button("A");
        setButtonLayout(buttonA1, 460, 70, wStyle, wX, wY);
        buttonA1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonA1, mouseEvent, "A", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonAs1 = new Button("A#");
        setButtonLayout(buttonAs1, 477, 70, bStyle, bX, bY);
        buttonAs1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonAs1, mouseEvent, "A#", 1, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonB1 = new Button("B");
        setButtonLayout(buttonB1, 490, 70, wStyle, wX, wY);
        buttonB1.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonB1, mouseEvent, "B", 1, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonC2 = new Button("C");
        setButtonLayout(buttonC2, 520, 70, wStyle, wX, wY);
        buttonC2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonC2, mouseEvent, "C", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonCs2 = new Button("C#");
        setButtonLayout(buttonCs2, 537, 70, bStyle, bX, bY);
        buttonCs2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonCs2, mouseEvent, "C#", 2, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonD2 = new Button("D");
        setButtonLayout(buttonD2, 550, 70, wStyle, wX, wY);
        buttonD2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonD2, mouseEvent, "D", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonDs2 = new Button("D#");
        setButtonLayout(buttonDs2, 567, 70, bStyle, bX, bY);
        buttonDs2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonDs2, mouseEvent, "D#", 2, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonE2 = new Button("E");
        setButtonLayout(buttonE2, 580, 70, wStyle, wX, wY);
        buttonE2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonE2, mouseEvent, "E", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonF2 = new Button("F");
        setButtonLayout(buttonF2, 610, 70, wStyle, wX, wY);
        buttonF2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonF2, mouseEvent, "F", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonFs2 = new Button("F#");
        setButtonLayout(buttonFs2, 627, 70, bStyle, bX, bY);
        buttonFs2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonFs2, mouseEvent, "F#", 2, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonG2 = new Button("G");
        setButtonLayout(buttonG2, 640, 70, wStyle, wX, wY);
        buttonG2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonG2, mouseEvent, "G", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonGs2 = new Button("G#");
        setButtonLayout(buttonGs2, 657, 70, bStyle, bX, bY);
        buttonGs2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonGs2, mouseEvent, "G#", 2, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonA2 = new Button("A");
        setButtonLayout(buttonA2, 670, 70, wStyle, wX, wY);
        buttonA2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonA2, mouseEvent, "A", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonAs2 = new Button("A#");
        setButtonLayout(buttonAs2, 687, 70, bStyle, bX, bY);
        buttonAs2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonAs2, mouseEvent, "A#", 2, pStyle, bStyle);
            mouseEvent.consume();
        });

        buttonB2 = new Button("B");
        setButtonLayout(buttonB2, 700, 70, wStyle, wX, wY);
        buttonB2.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonB2, mouseEvent, "B", 2, pStyle, wStyle);
            mouseEvent.consume();
        });

        buttonC3 = new Button("C");
        setButtonLayout(buttonC3, 730, 70, wStyle, wX, wY);
        buttonC3.addEventFilter(MouseEvent.ANY, mouseEvent -> {
            sound.play(buttonC3, mouseEvent, "C", 3, pStyle, wStyle);
            mouseEvent.consume();
        });

        HashMap<KeyCode, Button> buttonRef = KeyBindToButtonMap();

        // handle keyboard inputs for all notes
        pane.addEventFilter(KeyEvent.ANY, keyEvent ->
            sound.play(keyEvent, buttonRef.get(keyEvent.getCode()), pStyle, getButtonStyle(keyEvent)));

        // stop the program safely when window is closed
        primaryStage.setOnCloseRequest(closeEvent -> Runtime.getRuntime().halt(0));

        pane.getChildren().addAll(octaveCombo, octaveLabel, instrumentSelector, instrumentLabel, songCombo,
                playMusic, increaseInstrument, decreaseInstrument, instrumentConfirm, instrumentRandom, increaseOctave,
                decreaseOctave, sampleLabel, buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1, buttonCs1, buttonD1, buttonDs1, buttonE1, buttonF1,
                buttonFs1, buttonG1, buttonGs1, buttonA1, buttonAs1, buttonB1, buttonC2, buttonCs2, buttonD2, buttonDs2,
                buttonE2, buttonF2, buttonFs2, buttonG2, buttonGs2, buttonA2, buttonAs2, buttonB2, buttonC3);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // set up layouts for buttons
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

    // associate each piano key with white or black key styles
    private String getButtonStyle(KeyEvent e) {
        return switch(e.getCode()) {
            case Q, W , E, R, T, Y, U, I, O, P, OPEN_BRACKET, CLOSE_BRACKET, Z, X, C, V, B, N, M, COMMA, PERIOD,
                    SLASH -> wStyle;
            case DIGIT2, DIGIT3, DIGIT5, DIGIT6, DIGIT7, DIGIT9, DIGIT0, EQUALS, A, S, F, G, J, K, L -> bStyle;
            default -> null;
        };
    }

    // map to pass button to Sound class
    private HashMap<KeyCode, Button> KeyBindToButtonMap(){
        HashMap<KeyCode, Button> buttonMap = new HashMap<>();
        buttonMap.put(KeyCode.Q, buttonC);
        buttonMap.put(KeyCode.DIGIT2, buttonCs);
        buttonMap.put(KeyCode.W, buttonD);
        buttonMap.put(KeyCode.DIGIT3, buttonDs);
        buttonMap.put(KeyCode.E, buttonE);
        buttonMap.put(KeyCode.R, buttonF);
        buttonMap.put(KeyCode.DIGIT5, buttonFs);
        buttonMap.put(KeyCode.T, buttonG);
        buttonMap.put(KeyCode.DIGIT6, buttonGs);
        buttonMap.put(KeyCode.Y, buttonA);
        buttonMap.put(KeyCode.DIGIT7, buttonAs);
        buttonMap.put(KeyCode.U, buttonB);
        buttonMap.put(KeyCode.I, buttonC1);
        buttonMap.put(KeyCode.DIGIT9, buttonCs1);
        buttonMap.put(KeyCode.O, buttonD1);
        buttonMap.put(KeyCode.DIGIT0, buttonDs1);
        buttonMap.put(KeyCode.P, buttonE1);
        buttonMap.put(KeyCode.OPEN_BRACKET, buttonF1);
        buttonMap.put(KeyCode.EQUALS, buttonFs1);
        buttonMap.put(KeyCode.CLOSE_BRACKET, buttonG1);
        buttonMap.put(KeyCode.A, buttonGs1);
        buttonMap.put(KeyCode.Z, buttonA1);
        buttonMap.put(KeyCode.S, buttonAs1);
        buttonMap.put(KeyCode.X, buttonB1);
        buttonMap.put(KeyCode.C, buttonC2);
        buttonMap.put(KeyCode.F, buttonCs2);
        buttonMap.put(KeyCode.V, buttonD2);
        buttonMap.put(KeyCode.G, buttonDs2);
        buttonMap.put(KeyCode.B, buttonE2);
        buttonMap.put(KeyCode.N, buttonF2);
        buttonMap.put(KeyCode.J, buttonFs2);
        buttonMap.put(KeyCode.M, buttonG2);
        buttonMap.put(KeyCode.K, buttonGs2);
        buttonMap.put(KeyCode.COMMA, buttonA2);
        buttonMap.put(KeyCode.L, buttonAs2);
        buttonMap.put(KeyCode.PERIOD, buttonB2);
        buttonMap.put(KeyCode.SLASH, buttonC3);
        return buttonMap;
    }
}