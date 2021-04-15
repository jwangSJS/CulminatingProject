import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
import javax.sound.midi.MidiUnavailableException;

public class Sound {
    public String mod = "5"; // first octave modifier
    public String mod1; // second octave modifier
    public String mod2; // third octave modifier
    RealtimePlayer player = new RealtimePlayer();
    int instrument = 1;

    public Sound() throws MidiUnavailableException {
        this.mod = mod;
        this.mod1 = String.valueOf(Integer.valueOf(mod) + 1);
        this.mod2 = String.valueOf(Integer.valueOf(mod) + 2);
    }

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
            case Z -> "F" + mod1;
            case S -> "F#" + mod1;
            case X -> "G" + mod1;
            case D -> "G#" + mod1;
            case C -> "A" + mod1;
            case F -> "A#" + mod1;
            case V -> "B" + mod1;
            case B -> "C" + mod2;
            default -> null;
        };
    }

    private String findOctave(int relativeOctave) {
        return switch (relativeOctave) {
            case 0 -> mod;
            case 1 -> mod1;
            case 2 -> mod2;
            default -> null;
        };
    }
}