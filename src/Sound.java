// James Wang
// PDS 2021
// Mr. Garvin
// Culminating Project

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jfugue.midi.MidiDictionary;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
import javax.sound.midi.MidiUnavailableException;
import java.util.concurrent.ThreadLocalRandom;


public class Sound {
    public String mod = "5"; // first octave modifier
    public String mod1;
    public String mod2;
    public String mod3;
    RealtimePlayer player = new RealtimePlayer();
    int instrument = 1;

    public Sound() throws MidiUnavailableException {
        this.mod = mod;
        this.mod1 = String.valueOf(Integer.valueOf(mod) + 1);
        this.mod2 = String.valueOf(Integer.valueOf(mod) + 2);
        this.mod3 = String.valueOf(Integer.valueOf(mod) + 3);
    }

    // playing notes via mouse
    public void play(Button button, MouseEvent event, String rawNote, int relativeOctave,
                     String pressedStyle, String defaultStyle) {
        player.changeInstrument(instrument);
        // relative octave indicates note octave with respect to all other notes
        Note note = new Note(rawNote + findOctave(relativeOctave));

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            player.startNote(note);
            button.setStyle(pressedStyle); // change button color when pressed
        } else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            player.stopNote(note);
            button.setStyle(defaultStyle);
        }
    }

    KeyCode wasPressed = null; // KeyCode flag to handle continuous keyEvents from holding down a key

    // playing notes via keyboard
    public void play(KeyEvent event, Button button, String pressedStyle, String defaultStyle) {
        player.changeInstrument(instrument);
        String n = keyBindToNote(event);

        if (n == null) { return; }

        Note note = new Note(n);
        KeyCode isPressed = event.getCode();

        if (event.getEventType().equals(KeyEvent.KEY_PRESSED) && isPressed != wasPressed) {
            player.startNote(note);
            button.setStyle(pressedStyle); // change button style when pressed
            wasPressed = event.getCode();
        } else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            player.stopNote(note);
            button.setStyle(defaultStyle);
            wasPressed = null;
        }
    }

    public void changeOctave(String octave) {
        mod = String.valueOf(Integer.valueOf(octave) + 1);
        mod1 = String.valueOf(Integer.valueOf(mod) + 1);
        mod2 = String.valueOf(Integer.valueOf(mod) + 2);
        mod3 = String.valueOf(Integer.valueOf(mod) + 3);
    }

    public void changeOctave(String octave, ComboBox octaveCombo) {
        if (Integer.valueOf(octave) > 6) { octave = String.valueOf(6); }
        if (Integer.valueOf(octave) < 1) { octave = String.valueOf(1); }

        changeOctave(octave);
        octaveCombo.getSelectionModel().select(Integer.valueOf(octave) - 1);
    }

    public void changeInstrument(Label instrumentLabel, TextField instrumentSelector, String inst) {
        if (inst.equals("")) {
            instrumentSelector.setText(String.valueOf(instrument));
            return;
        }
        try {
            Integer.parseInt(inst);
        } catch (NumberFormatException nfe) {
            instrumentSelector.setText(String.valueOf(instrument));
            return;
        }
        int checkInst = Integer.parseInt(inst);
        if (checkInst < 1) {
            instrument = 1;
            instrumentSelector.setText("1");
            instrumentLabel.setText(findInstrumentName());
            return;
        } else if (checkInst > 127) {
            instrument = 127;
            instrumentSelector.setText("127");
            instrumentLabel.setText(findInstrumentName());
            return;
        }
        instrument = checkInst;
        instrumentLabel.setText(findInstrumentName());
    }

    // method for instrument increment buttons
    public void changeInstrument(Label instrumentLabel, TextField instrumentSelector, String inst, int increment) {
        int instrument = Integer.valueOf(inst) + increment;
        if (instrument < 1 || instrument > 127) {
            return;
        }
        changeInstrument(instrumentLabel, instrumentSelector, String.valueOf(instrument));
        instrumentSelector.setText(String.valueOf(instrument));
    }

    // method for random instruments
    public void changeInstrument(Label instrumentLabel, TextField instrumentSelector) {
        int instrument = ThreadLocalRandom.current().nextInt(1, 127 + 1);
        changeInstrument(instrumentLabel, instrumentSelector, String.valueOf(instrument));
        instrumentSelector.setText(String.valueOf(instrument));
    }

    // converts the keybind to notes
    private String keyBindToNote(KeyEvent event) {
        return switch (event.getCode()) {
            case Q -> "C" + mod;
            case DIGIT2 -> "C#" + mod;
            case W -> "D" + mod;
            case DIGIT3 -> "D#" + mod;
            case E -> "E" + mod;
            case R -> "F" + mod;
            case DIGIT5 -> "F#" + mod;
            case T -> "G" + mod;
            case DIGIT6 -> "G#" + mod;
            case Y -> "A" + mod;
            case DIGIT7 -> "A#" + mod;
            case U -> "B" + mod;
            case I -> "C" + mod1;
            case DIGIT9 -> "C#" + mod1;
            case O -> "D" + mod1;
            case DIGIT0 -> "D#" + mod1;
            case P -> "E" + mod1;
            case OPEN_BRACKET -> "F" + mod1;
            case EQUALS -> "F#" + mod1;
            case CLOSE_BRACKET -> "G" + mod1;
            case A -> "G#" + mod1;
            case Z -> "A" + mod1;
            case S -> "A#" + mod1;
            case X -> "B" + mod1;
            case C -> "C" + mod2;
            case F -> "C#" + mod2;
            case V -> "D" + mod2;
            case G -> "D#" + mod2;
            case B -> "E" + mod2;
            case N -> "F" + mod2;
            case J -> "F#" + mod2;
            case M -> "G" + mod2;
            case K -> "G#" + mod2;
            case COMMA -> "A" + mod2;
            case L -> "A#" + mod2;
            case PERIOD -> "B" + mod2;
            case SLASH -> "C" + mod3;
            default -> null;
        };
    }

    private String findOctave(int relativeOctave) {
        return switch (relativeOctave) {
            case 0 -> mod;
            case 1 -> mod1;
            case 2 -> mod2;
            case 3 -> mod3;
            default -> null;
        };
    }

    public String findInstrumentName() {
        return MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get((byte) instrument);
    }

    public void playSampleSong(String song) {
        player.changeInstrument(instrument);

        switch (song) {
            case "Arabesque":
                // Arabesque No.1 in E Major - Claude Debussy - Transcribed by James Wang
                player.play("T180 " +
                    "V0 Riii                  | C#6ia50 E6ia50 F#6ia50 G#6ia50 D#6ia50 B5ia50 Riii          | " +
                    "V1 C#5ia50 E5ia50 A5ia50 | Rqqq                                 G#5ia50 D#5ia50 B4ia50 | " +
                    "V0 Riii                   | A5ia55 C#6ia55 D#6ia55 E6ia55 B5ia55 G#5ia55 Riii | " +
                    "V1 A4ia55 C#5ia55 F#5ia55 | Rqqq                       E5ia55 B4ia55 G#4ia55  | " +
                    "V0 Riii         C#6iii+Ri_F#5i_A5i- A5-iii+F#6iii        C#6iii-+Ri_F#5i_A5i- | " +
                    "V1 F#4qqq+Ri_A4i_C#5qq                E4qqq+Ri_A4i_C#5qq                      | " +
                    "V0 C#6-iii+A5-iii   C#6q+Ri_F#5i_A5i- A5-iii+F#6iii         A6iii-+Ri_A5i_C#6i | A6-iii- " +
                    "V1 D#4qqq+Ri_A4i_C#5qq                      C#4qqq+Ri_A4i_E5qq                 | B3ia40  " +
                    "V0                A6-qqq-a0d127                                  A6-i G#6qq F#6qq         | " +
                    "V1 F#4ia40 A4ia40 C#5ia40 D#5ia40 F#5ia40 A5ia40 C#6ia40 D#6ia40 C#6ia40 B5qqa40  A5qqa40 | " +
                    "V0 Riii      E6id40  F#6id40  C#6id40  E6id40  B5id40  C#6id40  G#5id40  B5id40  F#5id40 " +
                    "V1 E3isa30d127 B3isa30d127 E4isa30d127 G#4isa30d127 B4isa30d127 G#4isa30d127 E4isa30d127 " +
                    "V0             | G#5id40 E5id40 G#5id40 D#5qqid40                                            " +
                    "V1 B3isa30d127 | E3isa30d127 C#4isa30d127 E4isa30d127 G#4isa30d127 C#5isa30d127 G#4isa30d127 " +
                    "V0 C#5qqa50                 | B4iiia50                E6ia50 F#6ia50 C#6ia50   E6ia50 B5ia50 "  +
                    "V1 E4isa30d127 C#4isa30d127 | E3isa30d127 B4isa30d127 E4isa30d127 G#4isa30d127 B4isa30d127   " +
                    "V0 C#6ia50   G#5ia50   B5ia50   F#5ia50 | G#5ia50 E5ia50 G#5ia50    D#5qqqa40               " +
                    "V1 G#4isa30d127 E4isa30d127 B3isa30d127 | E3isa30d127 C#4isa30d127 E4isa30d127 G#4isa30d127 " +
                    "V0                           C#5iiia40                | Rq " +
                    "V1 C#5isa30d127 G#4isa30d127 E4isa30d127 C#4isa30d127 | Rq ");
                break;
            case "Nocturne":
                // Nocturne Op.9 No.2 - Frédéric Chopin - Transcribed by James Wang
                player.play("T50 TIME:12/8 " +
                    "V0 Bb5i | G6qq F6i G6i F6qi Eb6q Bb5i                                          " +
                    "V1 Ri   | Eb3ia35 G4ia35+Eb5ia35 Bb4ia35+Eb5ia35+G5ia35 Eb4ia35 Ab4ia35+D5ia35 " +
                    "V0                                                                                            " +
                    "V1 Cb5ia35+D5ia35+Ab5ia35 Eb3ia35 G4ia35+Eb5ia35 Bb4ia35+Eb5ia35+G5ia35 D3ia35 G4ia35+Eb5ia35 " +
                    "V0                        | G6q                 (C6 C#6 C6 B5 C6)s*5:2 C7q                  " +
                    "V1 Bb4ia35+Eb5ia35+G5ia35 | C3ia36 G4ia37+E5ia37 Bb4ia40+E5ia40+G5ia40 C4ia40 G4ia40+E5ia40 " +
                    "V0 G6i                    Bb6qi                                         Ab6q                 " +
                    "V1 C5ia40+E5ia40+Bb5ia40  F3ia40 F4ia40+Db5ia40 Bb4ia40+Db5ia40+E5ia40  F3ia40 F4ia39+C5ia39 " +
                    "V0 G6i                   | F6qi                                         G6q                  " +
                    "V1 Ab4ia37+C5ia37+F5ia37 | Bb3ia35 F4ia35+D5ia35 Bb4ia35+D5ia35+Ab5ia35 B3ia35 G4ia37+F5ia37 " +
                    "V0 D6i                  Eb6qi                                       C6qi                   " +
                    "V1 D5ia38+F5ia38+G5ia38 C4ia40 G4ia40+Eb5ia40 C5ia40+Eb5ia40+G5ia40 A3ia40 Gb4ia40+Eb5ia40 " +
                    "V0                        | Bb5i    D7i            C7i                     Bb6s Ab6s " +
                    "V1 C5ia40+Eb5ia40+Gb5ia40 | Bb3ia40 F4ia40+Eb5ia40 Bb4ia40+Eb5ia40+Ab5ia40 Bb2ia40   " +
                    "V0 G6s Ab6s      C6s D6s         Eb6qi                                         Rq      " +
                    "V1 F4ia40+D5ia40 Bb4ia40+Ab5ia40 Eb3ia40 G4ia40+Eb5ia40 Bb4ia40+Eb5ia40+G5ia40 Eb4ia38 " +
                    "V0                Bb5i                   | G6qi                                          " +
                    "V1 G4ia36+Eb5ia36 Bb4ia35+Eb5ia35+G5ia35 | Eb3ia35 G4ia35+Eb5ia35 Bb4ia35+Eb5ia35+G5ia35 " +
                    "V0 F6s G6s (F6 G6 F6)t*3:2a48 E6s F6s G6s                F6i     Eb6qs          " +
                    "V1 Eb4ia35 Ab4ia35+D5ia35         Cb5ia35+D5ia35+Ab5ia35 Eb3ia35 G4ia35+Eb5ia35 " +
                    "V0                                F6s (Eb6 F6 Eb6)t*3:2 D6s Eb6s F6s               | G6s    " +
                    "V1 Bb4ia35+Eb5ia35+G5ia35 Eb3ia35 G4ia35+Eb5ia35            Bb4ia35+Eb5ia35+G5ia35 | C4ia36 " +
                    "V0 B5s C6s Db6s      C6s F6s               E6s Ab6s G6s Db7s      C7s G6s                " +
                    "V1     G4ia37+E5ia37 Bb4ia38+E5ia38+G5ia38 C4ia39   G4ia40+E5ia40 C5ia40+E5ia40+Bb5ia40  " +
                    "V0 Bb6qi                                        Ab6q                 G6i                   " +
                    "V1 F3ia39 F4ia37+Db5ia37 Bb4ia35+Db5ia35+E5ia35 F3ia35 F4ia35+C5ia35 Ab4ia35+C5ia35+F5ia35 " +
                    "V0 (F6 G6 F6 G6 F6 G6 F6 G6 F6 G6 F6 G6)x.*12:8a40 " +
                        "(F6 G6 F6 G6 F6 G6 F6 G6 F6 G6 F6 G6)x.*12:8a43 " +
                    "V1 Bb3ia35 F4ia35+D5ia35 Bb4ia35+D5ia35+Ab5ia35                                               " +
                    "V0 E6sa48 F6sa52 G6ia58  G6i           D6i                  Eb6qi                              " +
                    "V1 Ri    B3ia35 G4ia37+F5ia37 D5ia38+F5ia38+G5ia38 C4ia40 G4ia40+Eb5ia40 C5ia40+Eb5ia40+G5ia40 " +
                    "V0 C6qi                                          | Bb5i    D7i             " +
                    "V1 A3ia40 Gb4ia40+Eb5ia40 C5ia40+Eb5ia40+Gb5ia40 | Bb3ia40 F4ia40+Eb5ia40  " +
                    "V0 C7i                     Bb6s Ab6s G6s Ab6s    Ab6x C6t. D6s   Eb6qi                  " +
                    "V1 Bb4ia40+Eb5ia40+Ab5ia40 Bb2ia40 F4ia40+D5ia40 Bb4ia40+Ab5ia40 Eb3ia40 G4ia40+Eb5ia40 " +
                    "V0                                                                      " +
                    "V1 Bb4ia40+Eb5ia40+G5ia40 Eb4ia38 G4ia36+Eb5ia36 Bb4ia35+Eb5ia35+G5ia35 ");
                break;
        }
    }
}