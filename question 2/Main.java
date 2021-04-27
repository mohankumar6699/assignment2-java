package question2;

import static java.lang.System.*;
public class Main {

public static void main(String[] args) {
//array of note objects is created below
Note[] noteArray = new Note[5];
noteArray[0] = new Note("D", 19);
noteArray[1] = new Note("C", 20);
noteArray[2] = new Note("F", 31);
noteArray[3] = new Note("B", 45);
noteArray[4] = new Note("C", 73);

processNotes(noteArray); //objects array noteArray is passed into processnotes

}
public static void processNotes(Note[] noteArray) {
int total = 0;
for(int i = 0;i <5; i++) {
	
noteArray[i].playNote();
total = total + noteArray[i].getDuration();//calculated total duration


}
out.printf("Total duration of notes : %d seconds",total); //prints output
}


}