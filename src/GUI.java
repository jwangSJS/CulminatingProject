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
    Button buttonF1s;
    Button buttonG1;
    Button buttonGs1;
    Button buttonA1;
    Button buttonAs1;
    Button buttonB1;
    Button buttonC2;

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
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + mod));
        // buttonC.setStyle("-fx-background-color: #ff0000; ");

        buttonCs = new Button("C#");
        btLayout(buttonCs, 110, 70);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C#" + mod));

        buttonD = new Button("D");
        btLayout(buttonD, 130, 100);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D" + mod));

        buttonDs = new Button("D#");
        btLayout(buttonDs, 140, 70);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D#" + mod));

        buttonE = new Button("E");
        btLayout(buttonE, 160, 100);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "E" + mod));

        buttonF = new Button("F");
        btLayout(buttonF, 190, 100);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F" + mod));

        buttonFs = new Button("F#");
        btLayout(buttonFs, 200, 70);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F#" + mod));

        buttonG = new Button("G");
        btLayout(buttonG, 220, 100);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G" + mod));

        buttonGs = new Button("G#");
        btLayout(buttonGs, 230, 70);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G#" + mod));

        buttonA = new Button("A");
        btLayout(buttonA, 250, 100);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A" + mod));

        buttonAs = new Button("A#");
        btLayout(buttonAs, 260, 70);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A#" + mod));

        buttonB = new Button("B");
        btLayout(buttonB, 280, 100);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "B" + mod));

        buttonC1 = new Button("C");
        btLayout(buttonC1, 310, 100);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + mod1));

        buttonCs1 = new Button("C#");
        btLayout(buttonCs1, 320, 70);
        buttonCs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C#" + mod1));

        buttonD1 = new Button("D");
        btLayout(buttonD1, 340, 100);
        buttonD1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D" + mod1));

        buttonDs1 = new Button("D#");
        btLayout(buttonDs1, 350, 70);
        buttonDs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D#" + mod1));

        buttonE1 = new Button("E");
        btLayout(buttonE1, 370, 100);
        buttonE1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "E" + mod1));

        buttonF1 = new Button("F");
        btLayout(buttonF1, 400, 100);
        buttonF1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F" + mod1));

        buttonF1s = new Button("F#");
        btLayout(buttonF1s, 410, 70);
        buttonF1s.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F#" + mod1));

        buttonG1 = new Button("G");
        btLayout(buttonG1, 430, 100);
        buttonG1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G" + mod1));

        buttonGs1 = new Button("G#");
        btLayout(buttonGs1, 440, 70);
        buttonGs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G#" + mod1));

        buttonA1 = new Button("A");
        btLayout(buttonA1, 460, 100);
        buttonA1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A" + mod1));

        buttonAs1 = new Button("A#");
        btLayout(buttonAs1, 470, 70);
        buttonAs1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A#" + mod1));

        buttonB1 = new Button("B");
        btLayout(buttonB1, 490, 100);
        buttonB1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "B" + mod1));

        buttonC2 = new Button("C");
        btLayout(buttonC2, 520, 100);
        buttonC2.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + mod2));

        pane.addEventFilter(KeyEvent.ANY, keyEvent -> sound.play(keyEvent));

        primaryStage.setOnCloseRequest(closeEvent -> { Runtime.getRuntime().halt(0); });

        pane.getChildren().addAll(buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1, buttonCs1, buttonD1, buttonDs1, buttonE1, buttonF1,
                buttonF1s, buttonG1, buttonGs1, buttonA1, buttonAs1, buttonB1, buttonC2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void btLayout(Button button, int x, int y){
        button.setLayoutX(x);
        button.setLayoutY(y);
    }
}