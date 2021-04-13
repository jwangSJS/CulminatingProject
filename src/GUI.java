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
        btLayout(buttonC, 100, 100);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonC, mouseEvent, "C" + mod, pHue));

        buttonCs = new Button("C#");
        btLayout(buttonCs, 110, 70);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonCs, mouseEvent, "C#" + mod, pHue));

        buttonD = new Button("D");
        btLayout(buttonD, 130, 100);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonD, mouseEvent, "D" + mod, pHue));

        buttonDs = new Button("D#");
        btLayout(buttonDs, 140, 70);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonDs, mouseEvent, "D#" + mod, pHue));

        buttonE = new Button("E");
        btLayout(buttonE, 160, 100);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonE, mouseEvent, "E" + mod, pHue));

        buttonF = new Button("F");
        btLayout(buttonF, 190, 100);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonF, mouseEvent, "F" + mod, pHue));

        buttonFs = new Button("F#");
        btLayout(buttonFs, 200, 70);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonFs, mouseEvent, "F#" + mod, pHue));

        buttonG = new Button("G");
        btLayout(buttonG, 220, 100);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonG, mouseEvent, "G" + mod, pHue));

        buttonGs = new Button("G#");
        btLayout(buttonGs, 230, 70);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonGs, mouseEvent, "G#" + mod, pHue));
        buttonA = new Button("A");
        btLayout(buttonA, 250, 100);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonA, mouseEvent, "A" + mod, pHue));

        buttonAs = new Button("A#");
        btLayout(buttonAs, 260, 70);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonAs, mouseEvent, "A#" + mod, pHue));

        buttonB = new Button("B");
        btLayout(buttonB, 280, 100);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonB, mouseEvent, "B" + mod, pHue));

        buttonC1 = new Button("C");
        btLayout(buttonC1, 310, 100);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonC1, mouseEvent, "C" + mod1, pHue));

        buttonCs1 = new Button("C#");
        btLayout(buttonCs1, 320, 70);
        buttonCs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonCs1, mouseEvent, "C#" + mod1, pHue));

        buttonD1 = new Button("D");
        btLayout(buttonD1, 340, 100);
        buttonD1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonD1, mouseEvent, "D" + mod1, pHue));

        buttonDs1 = new Button("D#");
        btLayout(buttonDs1, 350, 70);
        buttonDs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonDs1, mouseEvent, "D#" + mod1, pHue));

        buttonE1 = new Button("E");
        btLayout(buttonE1, 370, 100);
        buttonE1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonE1, mouseEvent, "E" + mod1, pHue));

        buttonF1 = new Button("F");
        btLayout(buttonF1, 400, 100);
        buttonF1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonF1, mouseEvent, "F" + mod1, pHue));

        buttonFs1 = new Button("F#");
        btLayout(buttonFs1, 410, 70);
        buttonFs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonFs1, mouseEvent, "F#" + mod1, pHue));

        buttonG1 = new Button("G");
        btLayout(buttonG1, 430, 100);
        buttonG1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonG1, mouseEvent, "G" + mod1, pHue));

        buttonGs1 = new Button("G#");
        btLayout(buttonGs1, 440, 70);
        buttonGs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonGs1, mouseEvent, "G#" + mod1, pHue));

        buttonA1 = new Button("A");
        btLayout(buttonA1, 460, 100);
        buttonA1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonA1, mouseEvent, "A" + mod1, pHue));

        buttonAs1 = new Button("A#");
        btLayout(buttonAs1, 470, 70);
        buttonAs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonAs1, mouseEvent, "A#" + mod1, pHue));

        buttonB1 = new Button("B");
        btLayout(buttonB1, 490, 100);
        buttonB1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonB1, mouseEvent, "B" + mod1, pHue));

        buttonC2 = new Button("C");
        btLayout(buttonC2, 520, 100);
        buttonC2.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(buttonC2, mouseEvent, "C" + mod2, pHue));

        pane.addEventFilter(KeyEvent.ANY, keyEvent -> sound.play(keyEvent, keyBindToButton(keyEvent), pHue));

        primaryStage.setOnCloseRequest(closeEvent -> { Runtime.getRuntime().halt(0); });

        pane.getChildren().addAll(buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1, buttonCs1, buttonD1, buttonDs1, buttonE1, buttonF1,
                buttonFs1, buttonG1, buttonGs1, buttonA1, buttonAs1, buttonB1, buttonC2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void btLayout(Button button, int x, int y) {
        button.setLayoutX(x);
        button.setLayoutY(y);
    }

    public Button keyBindToButton(KeyEvent e) {
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
}