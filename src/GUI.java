import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Piano");
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(pane, 600, 300);

        // TODO: stop program when window is closed
        // TODO: add octave slider/text field

        Sound sound = new Sound();
        String mod = sound.mod;
        String modC = sound.modC;

        buttonC = new Button("C");
        btLayout(buttonC, 100, 100);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + mod));

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
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + modC));

        pane.addEventFilter(KeyEvent.ANY, keyEvent -> sound.play(keyEvent));

        pane.getChildren().addAll(buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void btLayout(Button button, int x, int y){
        button.setLayoutX(x);
        button.setLayoutY(y);
    }
}