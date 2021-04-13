CulminatingProject - Virtual Piano
==================================

This program simulates a piano using JavaFX and JFugue.

Terminology
----------------------------------
There are seven unique white keys on a piano:
A, B, C, D, E, F, and G. By convention, the foremost key
to start with is C major, which is why the program starts
with C, which will be relevant later.

There are 5 unique black keys on a piano, which can be
represented with two different notations:
# = sharp, so A# would read as "A-sharp"
b = flat, so Ab would read as "A-flat"
A# (or Bb), C# (or Db), D# (or Eb), F# (or Gb), and G# (or Ab).
For this program, I have standardized the black key namess so 
that they are always the 'sharp' designation. 

The term 'unique' used in this context means that these notes can
be transposed by some octave number n to create a harmonic, which is
some integer multiple of the fundamental frequency.
