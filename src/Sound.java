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
import org.jfugue.player.Player;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
import javax.sound.midi.MidiUnavailableException;

public class Sound {
    public String mod = "5"; // first octave modifier
    public String mod1; // second octave modifier
    public String mod2; // third octave modifier
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

    public void playSampleSong(int song) {
        player.changeInstrument(instrument);

        switch (song) {
            case 0:
                player.play("T[Adagio] V0 E6s D#6s | E6s D#6s E6s " +
                        "B5s D6s C6s | A5i+A3s E4s A4s C5s E5s A5s | " +
                        "B5i+E3s E4s G#4s E5s G#5s B5s | C6i+A3s E4s A4s ");
            case 1:
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
        }
    }
}