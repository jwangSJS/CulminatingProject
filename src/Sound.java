import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
import javax.sound.midi.MidiUnavailableException;

public class Sound {
    public String mod; // first octave modifier
    public String mod1; // second octave modifier
    public String mod2; // third octave modifier
    RealtimePlayer player = new RealtimePlayer();

    public Sound() throws MidiUnavailableException {
        this.mod = "5";
        this.mod1 = String.valueOf(Integer.valueOf(mod) + 1);
        this.mod2 = String.valueOf(Integer.valueOf(mod) + 2);
    }

    public void play(MouseEvent event, String n) {
        Note note = new Note(n);

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            player.startNote(note);
        } else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            player.stopNote(note);
        }
    }

    KeyCode wasPressed = null; // KeyCode flag to handle continuous keyEvents from holding down a key

    public void play(KeyEvent event) {
        Note note = findNote(event);
        if (note == null) return;
        KeyCode isPressed = event.getCode();

        if (event.getEventType().equals(KeyEvent.KEY_PRESSED) && isPressed != wasPressed) {
            player.startNote(note);
            wasPressed = event.getCode();
        } else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            player.stopNote(note);
            wasPressed = null;
        }
    }

    // converts the keybind to notes
    private Note findNote(KeyEvent event){
        return switch (event.getCode()) {
            case Q -> new Note("C" + mod);
            case DIGIT2 -> new Note("C#" + mod);
            case W -> new Note("D" + mod);
            case DIGIT3 -> new Note("D#" + mod);
            case E -> new Note("E" + mod);
            case R -> new Note("F" + mod);
            case DIGIT5 -> new Note("F#" + mod);
            case T -> new Note("G" + mod);
            case DIGIT6 -> new Note("G#" + mod);
            case Y -> new Note("A" + mod);
            case DIGIT7 -> new Note("A#" + mod);
            case U -> new Note("B" + mod);
            case I -> new Note("C" + mod1);
            case DIGIT9 -> new Note("C#" + mod1);
            case O -> new Note("D" + mod1);
            case DIGIT0 -> new Note("D#" + mod1);
            case P -> new Note("E" + mod1);
            case Z -> new Note("F" + mod1);
            case S -> new Note("F#" + mod1);
            case X -> new Note("G" + mod1);
            case D -> new Note("G#" + mod1);
            case C -> new Note("A" + mod1);
            case F -> new Note("A#" + mod1);
            case V -> new Note("B" + mod1);
            case B -> new Note("C" + mod2);
            default -> null;
        };
    }
}