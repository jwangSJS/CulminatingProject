import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        setButtonLayout(buttonC, 100, 100, wStyle);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC, mouseEvent, "C" + mod, pHue, wStyle));

        buttonCs = new Button("C#");
        setButtonLayout(buttonCs, 110, 70, bStyle);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonCs, mouseEvent, "C#" + mod, pHue, bStyle));

        buttonD = new Button("D");
        setButtonLayout(buttonD, 130, 100, wStyle);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonD, mouseEvent, "D" + mod, pHue, wStyle));

        buttonDs = new Button("D#");
        setButtonLayout(buttonDs, 140, 70, bStyle);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonDs, mouseEvent, "D#" + mod, pHue, bStyle));

        buttonE = new Button("E");
        setButtonLayout(buttonE, 160, 100, wStyle);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonE, mouseEvent, "E" + mod, pHue, wStyle));

        buttonF = new Button("F");
        setButtonLayout(buttonF, 190, 100, wStyle);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonF, mouseEvent, "F" + mod, pHue, wStyle));

        buttonFs = new Button("F#");
        setButtonLayout(buttonFs, 200, 70, bStyle);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonFs, mouseEvent, "F#" + mod, pHue, bStyle));

        buttonG = new Button("G");
        setButtonLayout(buttonG, 220, 100, wStyle);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonG, mouseEvent, "G" + mod, pHue, wStyle));

        buttonGs = new Button("G#");
        setButtonLayout(buttonGs, 230, 70, bStyle);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonGs, mouseEvent, "G#" + mod, pHue, bStyle));

        buttonA = new Button("A");
        setButtonLayout(buttonA, 250, 100, wStyle);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonA, mouseEvent, "A" + mod, pHue, wStyle));

        buttonAs = new Button("A#");
        setButtonLayout(buttonAs, 260, 70, bStyle);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonAs, mouseEvent, "A#" + mod, pHue, bStyle));

        buttonB = new Button("B");
        setButtonLayout(buttonB, 280, 100, wStyle);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonB, mouseEvent, "B" + mod, pHue, wStyle));

        buttonC1 = new Button("C");
        setButtonLayout(buttonC1, 310, 100, wStyle);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC1, mouseEvent, "C" + mod1, pHue, wStyle));

        buttonCs1 = new Button("C#");
        setButtonLayout(buttonCs1, 320, 70, bStyle);
        buttonCs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonCs1, mouseEvent, "C#" + mod1, pHue, bStyle));

        buttonD1 = new Button("D");
        setButtonLayout(buttonD1, 340, 100, wStyle);
        buttonD1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonD1, mouseEvent, "D" + mod1, pHue, wStyle));

        buttonDs1 = new Button("D#");
        setButtonLayout(buttonDs1, 350, 70, bStyle);
        buttonDs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonDs1, mouseEvent, "D#" + mod1, pHue, bStyle));

        buttonE1 = new Button("E");
        setButtonLayout(buttonE1, 370, 100, wStyle);
        buttonE1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonE1, mouseEvent, "E" + mod1, pHue, wStyle));

        buttonF1 = new Button("F");
        setButtonLayout(buttonF1, 400, 100, wStyle);
        buttonF1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonF1, mouseEvent, "F" + mod1, pHue, wStyle));

        buttonFs1 = new Button("F#");
        setButtonLayout(buttonFs1, 410, 70, bStyle);
        buttonFs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonFs1, mouseEvent, "F#" + mod1, pHue, bStyle));

        buttonG1 = new Button("G");
        setButtonLayout(buttonG1, 430, 100, wStyle);
        buttonG1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonG1, mouseEvent, "G" + mod1, pHue, wStyle));

        buttonGs1 = new Button("G#");
        setButtonLayout(buttonGs1, 440, 70, bStyle);
        buttonGs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonGs1, mouseEvent, "G#" + mod1, pHue, bStyle));

        buttonA1 = new Button("A");
        setButtonLayout(buttonA1, 460, 100, wStyle);
        buttonA1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonA1, mouseEvent, "A" + mod1, pHue, wStyle));

        buttonAs1 = new Button("A#");
        setButtonLayout(buttonAs1, 470, 70, bStyle);
        buttonAs1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonAs1, mouseEvent, "A#" + mod1, pHue, bStyle));

        buttonB1 = new Button("B");
        setButtonLayout(buttonB1, 490, 100, wStyle);
        buttonB1.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonB1, mouseEvent, "B" + mod1, pHue, wStyle));

        buttonC2 = new Button("C");
        setButtonLayout(buttonC2, 520, 100, wStyle);
        buttonC2.addEventFilter(MouseEvent.ANY, mouseEvent ->
                sound.play(buttonC2, mouseEvent, "C" + mod2, pHue, wStyle));

        pane.addEventFilter(KeyEvent.ANY, keyEvent ->
                sound.play(keyEvent, keyBindToButton(keyEvent), pHue, getButtonStyle(keyEvent)));

        primaryStage.setOnCloseRequest(closeEvent -> { Runtime.getRuntime().halt(0); });

        pane.getChildren().addAll(buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1, buttonCs1, buttonD1, buttonDs1, buttonE1, buttonF1,
                buttonFs1, buttonG1, buttonGs1, buttonA1, buttonAs1, buttonB1, buttonC2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setButtonLayout(Button button, int x, int y, String style) {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setStyle(style);
    }

    private Button keyBindToButton(KeyEvent e) {
        return switch (e.getCode()) {
            case Q -> buttonC;
            case DIGIT2 -> buttonCs;
            case W -> buttonD;
            case DIGIT3 -> buttonDs;
            case E -> buttonE;
            case R -> buttonF;
            case DIGIT5 -> buttonFs;
            case T -> buttonG;
            case DIGIT6 -> buttonGs;
            case Y -> buttonA;
            case DIGIT7 -> buttonAs;
            case U -> buttonB;
            case I -> buttonC1;
            case DIGIT9 -> buttonCs1;
            case O -> buttonD1;
            case DIGIT0 -> buttonDs1;
            case P -> buttonE1;
            case Z -> buttonF1;
            case S -> buttonFs1;
            case X -> buttonG1;
            case D -> buttonGs1;
            case C -> buttonA1;
            case F -> buttonAs1;
            case V -> buttonB1;
            case B -> buttonC2;
            default -> null;
        };
    }

    private String getButtonStyle(KeyEvent e) {
        return switch(e.getCode()) {
            case Q, W , E, R, T, Y, U, I, O, P, Z, X, C, V, B -> wStyle;
            case DIGIT2, DIGIT3, DIGIT5, DIGIT6, DIGIT7, DIGIT9, DIGIT0, S, D, F -> bStyle;
            default -> null;
        };
    }
}