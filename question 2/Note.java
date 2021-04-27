package question2;

import static java.lang.System.*;

public class Note  {
private String pitch;
private int duration;
   
//getter and setter for pitch
public String getPitch() {
return pitch;
}
public void setPitch(String pitch) {
this.pitch = pitch;
}
//getter and setter for duration
public int getDuration() {
return duration;
}
public void setDuration(int duration) {
this.duration = duration;
}

public Note(String pitch, int duration) {
this.setDuration(duration);
this.setPitch(pitch);
}

//this will be called in main.java
public void playNote() {
out.printf("The note %s is played for %d seconds\n",pitch,duration);


}
}


