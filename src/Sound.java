import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
import javax.sound.midi.MidiUnavailableException;

public class Sound {
    public String mod; // octave modifier
    public String modC; // special octave modifier for last note
    RealtimePlayer player = new RealtimePlayer();

    public Sound() throws MidiUnavailableException {
        this.mod = "5";
        this.modC = String.valueOf(Integer.valueOf(mod) + 1);
    }

    public void play(MouseEvent event, String n) {
        Note note = new Note(n);

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            player.startNote(note);
        } else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            player.stopNote(note);
        }
    }

    KeyCode wasPressed = null; // handle continuous keyEvents from holding down a key

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
        switch (event.getCode()) {
            case A:
                return new Note("C" + mod);
            case S:
                return new Note("D" + mod);
            case D:
                return new Note("E" + mod);
            case F:
                return new Note("F" + mod);
            case J:
                return new Note("G" + mod);
            case K:
                return new Note("A" + mod);
            case L:
                return new Note("B" + mod);
            case SEMICOLON:
                return new Note("C" + modC);
        }
        return null;
    }
}