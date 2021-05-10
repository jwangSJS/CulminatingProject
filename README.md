CulminatingProject - Virtual Piano
==================================
James Wang - PDS - Garvin

This program simulates a piano using JavaFX and JFugue.
JFugue Library Download: http://www.jfugue.org/download.html
JavaFX download: https://gluonhq.com/products/javafx/

Terminology
----------------------------------
There are seven unique white keys on a piano:
A, B, C, D, E, F, and G. By convention, the foremost key
to start with is C, which is why the program starts
with C, which will be relevant later.

There are 5 unique black keys on a piano, which can be
represented with two different notations:
The symbol # = sharp, so A# would read as "A-sharp"
The symbol b = flat, so Ab would read as "A-flat"
A# (or Bb), C# (or Db), D# (or Eb), F# (or Gb), and G# (or Ab).
For this program, I have standardized the black key namess so 
that they are always the 'sharp' designation. 

The term 'unique' used in this context means that these notes can
be transposed by some octave number n to create a harmonic, which is
some integer multiple of the fundamental frequency.

Piano
----------------------------------
There are 37 keys on the on-screen piano, which is from C to C and includes
3 full ranges of notes (starting from C) and one high C in a fourthd relative octave.

The instrument selector takes an integer range, inclusive, of [0,127]. It is advised
to skim the midiDictionary for JFugue here: https://soundprogramming.net/file-formats/general-midi-instrument-list/
to find instrument codes. However, the instrument selector has a label which displays
the instrument selected. 

The octave selector allows the user to select an octave starting with the lowest note
in the on-screen piano, in this case, the left-most C. This means that for an octave
selected n, the highest note on the on-screen piano, the right-most C, would have an
octave of n + 2. 

The keybinds are as follows: QWERTYUIOP[] forms the first line of white keys, and then
ZXCVBNM<>/ forms the next line of white keys. The respective black keys are above the
white key rows and are in their relative positions to the white key rows.

Class Structure
----------------------------------
The program, at the moment, is made up of two classes, a GUI class and a Sound class.

As the name implies, the GUI class handles the gui of the piano program, which includes
but is not limited to, buttons, textfields, windows, and combination boxes along with
their respective styling. In addition, the gui class also implements the eventListeners
which listen for mouse and keyboard inputs.

The Sound class handles the main sound driving code of the project, which includes the actual
playing of sound, dynamic buttons (buttons that change color when pressed), octaves, and
instruments.

However, the important concept to note is the intra-class communication between the GUI and Sound
classes. The GUI class acts as a linear class, which initializes and instantiates objects and variables.
The Sound class effectively acts as a loop which handles active events such as note presses and
instrument changes. In order for the program to work, the GUI class must pass to the Sound class
active objects, such as buttons, which must change or do something according to user input. In this way,
the program handles live input from a piano.
