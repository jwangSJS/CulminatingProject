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
import org.jfugue.player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PianoVisualizer extends GUI {
    Button A0;
    Button A1;
    Button A2;
    Button A3;
    Button A4;
    Button A5;
    Button A6;
    Button A7;

    Button As0;
    Button As1;
    Button As2;
    Button As3;
    Button As4;
    Button As5;
    Button As6;
    Button As7;

    Button B0;

    Button C1;
    Button C2;
    Button C3;
    Button C4;
    Button C5;
    Button C6;
    Button C7;
    Button C8;

    Button Cs1;
    Button Cs2;
    Button Cs3;
    Button Cs4;
    Button Cs5;
    Button Cs6;
    Button Cs7;

    Button D1;


    GUI gui = new GUI();
    Player player = new Player();

    public void createPianoVisualizer() {
        Stage stage = new Stage();
        stage.setTitle("Piano Visualizer");
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 200);

        C4 = createButton(C4, 30, 50, 0);
        Cs4 = createButton(Cs4, 35, 49, 1);

        Button enter = new Button();
        enter.setLayoutX(0);
        enter.setLayoutY(0);
        enter.setOnAction(actionEvent -> playSong(""));

        pane.getChildren().addAll(enter, C4, Cs4);

        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(Button button, int xPos, int yPos, int identifier){
        button = new Button();
        int xSize = 0;
        int ySize = 0;
        String style = "";

        switch (identifier) {
            case 0:
                xSize = gui.wX/2;
                ySize = gui.wY/2;
                style = gui.wStyle;
                break;
            case 1:
                xSize = gui.bX/2;
                ySize = gui.bY/2;
                style = gui.bStyle;
                break;
        }
        gui.setButtonLayout(button, xPos, yPos, style, xSize, ySize);
        return button;
    }

    public void playSong(String song) {
//        String top = "E5q|A5i B5i|C6q|C6q|";
        String top = "Rq|E2q|A4q,C5q,E5q|A4q C4q E5q|";
        String bot = "Rq|E2q|A4q,C5q,E5q|A4q C5q E5q|";
        String noteToPlay = "";
        int maxV = 0;
        player.play("V0 I[Piano] E5q A6i B6i C6q C6q V1 I[Piano] Rq E2q C5q C5q");

        // chords can describe any combination of notes.

        for(int i = 0; i < top.length(); i++) {
            if(top.charAt(i) == '|' || top.charAt(i) == ' ') {
                System.out.println(noteToPlay);
                player.play(noteToPlay);
                noteToPlay = "";
                continue;
            } else if (top.charAt(i) == ',') {
                noteToPlay += "V" + maxV + "I[Piano]" + noteToPlay;
                maxV++;
                continue;
            }
            noteToPlay += top.charAt(i);
        }

//        for (int i = 0; i < music.size() + 1; i++) {
//            ArrayList<String> note = music.get(i);
//
//            int maxVoice = 0;
//            for (int k = 0; k < note.size() + 1; k++) {
//                if (note > 1) {
//                    System.out.println(note.toString());
//                    for (int j = 0; j < note.size() + 1; j++) {
//                        noteToPlay += "V" + maxVoice + "I[Piano]" + note.get(i);
//                        maxVoice++;
//                    }
//                    break;
//                }
//            }
//            noteToPlay = "V" + String.valueOf(maxVoice) + note.get(0);
//
//            player.play(noteToPlay);
//        }

        //player.play(noteToPlay);
    }

    private ArrayList<ArrayList<String>> countSausage(String music) {
        ArrayList<String> currentNote = new ArrayList<>();
        ArrayList<ArrayList<String>> line = new ArrayList<>();
        String note = "";
        for(int i = 0; i < music.length(); i++) {
            if(music.charAt(i) == '|') {
                currentNote.add(note);
                line.add(currentNote);
                note = "";
                continue;
            } else if(music.charAt(i) == ' ') {
                currentNote.add(note);
                continue;
            }
            note += music.charAt(i);
        }
        return line;
    }
}
