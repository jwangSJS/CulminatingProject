import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    String wStyle = "-fx-border-color: black;" +
            "-fx-background-color: #ffffff;";
    String bStyle = "-fx-background-color: #000000;" +
            "-fx-text-base-color: white;";
    String pHue = "-fx-background-color: #d94141; "; // button color when pressed

    int wX = 10;
    int wY = 100;
    int bX = 10;
    int bY = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Piano");
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(pane, 600, 300);

        Sound sound = new Sound();
        String mod = sound.mod; // first octave modifier
        String mod1 = sound.mod1; // second octave modifier
        String mod2 = sound.mod2; // third octave modifier

        buttonC = new Button("C");
        setButtonLayout(buttonC, 100, 100, wStyle, wX, wY);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC, mouseEvent, "C" + mod, pHue, wStyle));

        buttonCs = new Button("C#");
        setButtonLayout(buttonCs, 110, 70, bStyle, bX, bY);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonCs, mouseEvent, "C#" + mod, pHue, bStyle));

        buttonD = new Button("D");
        setButtonLayout(buttonD, 130, 100, wStyle, wX, wY);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonD, mouseEvent, "D" + mod, pHue, wStyle));

        buttonDs = new Button("D#");
        setButtonLayout(buttonDs, 140, 70, bStyle, bX, bY);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonDs, mouseEvent, "D#" + mod, pHue, bStyle));

        buttonE = new Button("E");
        setButtonLayout(buttonE, 160, 100, wStyle, wX, wY);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonE, mouseEvent, "E" + mod, pHue, wStyle));

        buttonF = new Button("F");
        setButtonLayout(buttonF, 190, 100, wStyle, wX, wY);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonF, mouseEvent, "F" + mod, pHue, wStyle));

        buttonFs = new Button("F#");
        setButtonLayout(buttonFs, 200, 70, bStyle, bX, bY);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonFs, mouseEvent, "F#" + mod, pHue, bStyle));

        buttonG = new Button("G");
        setButtonLayout(buttonG, 220, 100, wStyle, wX, wY);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonG, mouseEvent, "G" + mod, pHue, wStyle));

        buttonGs = new Button("G#");
        setButtonLayout(buttonGs, 230, 70, bStyle, bX, bY);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonGs, mouseEvent, "G#" + mod, pHue, bStyle));

        buttonA = new Button("A");
        setButtonLayout(buttonA, 250, 100, wStyle, wX, wY);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonA, mouseEvent, "A" + mod, pHue, wStyle));

        buttonAs = new Button("A#");
        setButtonLayout(buttonAs, 260, 70, bStyle, bX, bY);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonAs, mouseEvent, "A#" + mod, pHue, bStyle));

        buttonB = new Button("B");
        setButtonLayout(buttonB, 280, 100, wStyle, wX, wY);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonB, mouseEvent, "B" + mod, pHue, wStyle));

        buttonC1 = new Button("C");
        setButtonLayout(buttonC1, 310, 100, wStyle, wX, wY);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC1, mouseEvent, "C" + mod1, pHue, wStyle));

        buttonCs1 = new Button("C#");
        setButtonLayout(buttonCs1, 320, 70, bStyle, bX, bY);
        buttonCs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonCs1, mouseEvent, "C#" + mod1, pHue, bStyle));

        buttonD1 = new Button("D");
        setButtonLayout(buttonD1, 340, 100, wStyle, wX, wY);
        buttonD1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonD1, mouseEvent, "D" + mod1, pHue, wStyle));

        buttonDs1 = new Button("D#");
        setButtonLayout(buttonDs1, 350, 70, bStyle, bX, bY);
        buttonDs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonDs1, mouseEvent, "D#" + mod1, pHue, bStyle));

        buttonE1 = new Button("E");
        setButtonLayout(buttonE1, 370, 100, wStyle, wX, wY);
        buttonE1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonE1, mouseEvent, "E" + mod1, pHue, wStyle));

        buttonF1 = new Button("F");
        setButtonLayout(buttonF1, 400, 100, wStyle, wX, wY);
        buttonF1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonF1, mouseEvent, "F" + mod1, pHue, wStyle));

        buttonFs1 = new Button("F#");
        setButtonLayout(buttonFs1, 410, 70, bStyle, bX, bY);
        buttonFs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonFs1, mouseEvent, "F#" + mod1, pHue, bStyle));

        buttonG1 = new Button("G");
        setButtonLayout(buttonG1, 430, 100, wStyle, wX, wY);
        buttonG1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonG1, mouseEvent, "G" + mod1, pHue, wStyle));

        buttonGs1 = new Button("G#");
        setButtonLayout(buttonGs1, 440, 70, bStyle, bX, bY);
        buttonGs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonGs1, mouseEvent, "G#" + mod1, pHue, bStyle));

        buttonA1 = new Button("A");
        setButtonLayout(buttonA1, 460, 100, wStyle, wX, wY);
        buttonA1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonA1, mouseEvent, "A" + mod1, pHue, wStyle));

        buttonAs1 = new Button("A#");
        setButtonLayout(buttonAs1, 470, 70, bStyle, bX, bY);
        buttonAs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonAs1, mouseEvent, "A#" + mod1, pHue, bStyle));

        buttonB1 = new Button("B");
        setButtonLayout(buttonB1, 490, 100, wStyle, wX, wY);
        buttonB1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonB1, mouseEvent, "B" + mod1, pHue, wStyle));

        buttonC2 = new Button("C");
        setButtonLayout(buttonC2, 520, 100, wStyle, wX, wY);
        buttonC2.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC2, mouseEvent, "C" + mod2, pHue, wStyle));

        HashMap<KeyCode, Button> buttonRef = initializeHashMap();

        pane.addEventFilter(KeyEvent.ANY, keyEvent ->
                sound.play(keyEvent, buttonRef.get(keyEvent.getCode()), pHue, getButtonStyle(keyEvent)));

        primaryStage.setOnCloseRequest(closeEvent -> { Runtime.getRuntime().halt(0); });

        pane.getChildren().addAll(buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1, buttonCs1, buttonD1, buttonDs1, buttonE1, buttonF1,
                buttonFs1, buttonG1, buttonGs1, buttonA1, buttonAs1, buttonB1, buttonC2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setButtonLayout(Button button, int x, int y, String style, int x1, int y1) {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setStyle(style);
        button.setPrefSize(x1, y1);
    }

    private String getButtonStyle(KeyEvent e) {
        return switch(e.getCode()) {
            case Q, W , E, R, T, Y, U, I, O, P, Z, X, C, V, B -> wStyle;
            case DIGIT2, DIGIT3, DIGIT5, DIGIT6, DIGIT7, DIGIT9, DIGIT0, S, D, F -> bStyle;
            default -> null;
        };
    }

    private HashMap<KeyCode, Button> initializeHashMap(){
        HashMap<KeyCode, Button> buttonReference = new HashMap<KeyCode, Button>();
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