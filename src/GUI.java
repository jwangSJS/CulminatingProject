import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(8);

        // TODO: stop program when window is closed
        // TODO: add minor keys
        // TODO: add octave slider/text field

        Sound sound = new Sound();
        String mod = sound.mod;
        String modC = sound.modC;

        buttonC = new Button("C");
        GridPane.setConstraints(buttonC, 0, 2);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + mod));

        buttonCs = new Button("C#");
        GridPane.setConstraints(buttonCs, 1, 1);
        buttonCs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C#" + mod));

        buttonD = new Button("D");
        GridPane.setConstraints(buttonD, 2, 2);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D" + mod));

        buttonDs = new Button("D#");
        GridPane.setConstraints(buttonDs, 3, 1);
        buttonDs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D#" + mod));

        buttonE = new Button("E");
        GridPane.setConstraints(buttonE, 4, 2);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "E" + mod));

        buttonF = new Button("F");
        GridPane.setConstraints(buttonF, 6, 2);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F" + mod));

        buttonFs = new Button("F#");
        GridPane.setConstraints(buttonFs, 7, 1);
        buttonFs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F#" + mod));

        buttonG = new Button("G");
        GridPane.setConstraints(buttonG, 8, 2);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G" + mod));

        buttonGs = new Button("G#");
        GridPane.setConstraints(buttonGs, 9, 1);
        buttonGs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G#" + mod));

        buttonA = new Button("A");
        GridPane.setConstraints(buttonA, 10, 2);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A" + mod));

        buttonAs = new Button("A#");
        GridPane.setConstraints(buttonAs, 11, 1);
        buttonAs.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A#" + mod));

        buttonB = new Button("B");
        GridPane.setConstraints(buttonB, 12, 2);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "B" + mod));

        buttonC1 = new Button("C");
        GridPane.setConstraints(buttonC1, 14, 2);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + modC));

        grid.addEventFilter(KeyEvent.ANY, keyEvent -> sound.play(keyEvent));

        grid.getChildren().addAll(buttonC, buttonCs, buttonD, buttonDs, buttonE, buttonF, buttonFs, buttonG,
                buttonGs, buttonA, buttonAs, buttonB, buttonC1);
        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}