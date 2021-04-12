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
    Button buttonD;
    Button buttonE;
    Button buttonF;
    Button buttonG;
    Button buttonA;
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
        GridPane.setConstraints(buttonC, 0, 0);
        buttonC.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + mod));

        buttonD = new Button("D");
        GridPane.setConstraints(buttonD, 1, 0);
        buttonD.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "D" + mod));

        buttonE = new Button("E");
        GridPane.setConstraints(buttonE, 2, 0);
        buttonE.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "E" + mod));

        buttonF = new Button("F");
        GridPane.setConstraints(buttonF, 3, 0);
        buttonF.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "F" + mod));

        buttonG = new Button("G");
        GridPane.setConstraints(buttonG, 4, 0);
        buttonG.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "G" + mod));

        buttonA = new Button("A");
        GridPane.setConstraints(buttonA, 5, 0);
        buttonA.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "A" + mod));

        buttonB = new Button("B");
        GridPane.setConstraints(buttonB, 6, 0);
        buttonB.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "B" + mod));

        buttonC1 = new Button("C");
        GridPane.setConstraints(buttonC1, 7, 0);
        buttonC1.addEventFilter(MouseEvent.ANY, mouseEvent -> sound.play(mouseEvent, "C" + modC));

        grid.addEventFilter(KeyEvent.ANY, keyEvent -> sound.play(keyEvent));

        grid.getChildren().addAll(buttonC, buttonD, buttonE, buttonF, buttonG, buttonA, buttonB, buttonC1);
        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}