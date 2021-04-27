package application;
	
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class Main extends Application {
@Override
public void start(Stage primaryStage) {
try {
StackPane root = new StackPane();
//below code is for layout of game output and also color of top and bottom text
double width = 500, height = 600;
int radius = 10, speed = 5;

Pane gamePane = new Pane();
root.getChildren().add(gamePane);

VBox timerBox = new VBox();
timerBox.setAlignment(Pos.TOP_CENTER);
root.getChildren().add(timerBox);

VBox target= new VBox();
target.setAlignment(Pos.BOTTOM_CENTER);
root.getChildren().add(target);

Label label = new Label("0");
label.setFont(Font.font(20));
label.setTextFill(Color.BLUE);
timerBox.getChildren().add(label);

Label label1 = new Label("0");
label1.setFont(Font.font(20));
label1.setTextFill(Color.BLUE);
target.getChildren().add(label1);

Circle movingc = new Circle(height/2, width/2, radius);
movingc.setFill(Color.RED);
gamePane.getChildren().add(movingc);
//Code for displaying random black dots
int num = ThreadLocalRandom.current().nextInt(5, 10);

for(int i = 0; i < num; i++ ) {

double randomx = ThreadLocalRandom.current().nextDouble(5,width-5);
double randomy = ThreadLocalRandom.current().nextDouble(5,height-5);
Circle dot1 = new Circle(randomx,randomy,5);
dot1.setFill(Color.BLACK);
gamePane.getChildren().add(dot1);

}

//this shows the number of dots left        
label1.setText("Target Left : " + num );


gamePane.setFocusTraversable(true);

Scene scene = new Scene(root,width,height);
primaryStage.setScene(scene);
primaryStage.show();

//this will focus on gamepane
gamePane.requestFocus();

//below lines of code is for showing elapsed time in seconds
AnimationTimer timer = new AnimationTimer() {
private long startTime = System.currentTimeMillis();
@Override public void handle(long stamp) {
long present = System.currentTimeMillis();
double elapseTime = (present - startTime)/1000.0;
label.setText("Elapsed time: "+(int)elapseTime + "second");

}
};
timer.start();

gamePane.setOnKeyPressed(e -> {
double x = movingc.getCenterX();
double y = movingc.getCenterY();

switch(e.getCode()) {
case UP:
if (y > radius) //if it doesn;t reach the top edge
movingc.setCenterY(y - speed);
break;
case LEFT:
if(x > radius)//if it doesn't reach the left edge
movingc.setCenterX(x - speed);
break;
case DOWN:
if(y < height - radius)
movingc.setCenterY(y + speed);
break;
case RIGHT:
if(x < width - radius)
movingc.setCenterX(x + speed);
default: 
break;
}

//this will collect overlapping black dots
List<Node> overlaps = new LinkedList<>();
ObservableList<Node> allCircles = gamePane.getChildren();

for(Node n : allCircles) {
Circle c = (Circle) n;
if(isOverlap(movingc, c)) {
overlaps.add(c);
}
}
for(Node n : overlaps) {
allCircles.remove(n);
label1.setText("Target Left : " + (allCircles.size()-1 ));
}

//if all circles are done only red circle will be there and it turns to blue
if(allCircles.size() == 1) {
timer.stop();
movingc.setFill(Color.BLUE);
}

});    
} catch(Exception e) {
e.printStackTrace();
}
}
public boolean isOverlap(Circle c1, Circle c2) {
double x1 = c1.getCenterX();
double y1 = c1.getCenterY();
double x2 = c2.getCenterX();
double y2 = c2.getCenterY();

//below lines of code is for computations in the game
double comp1 = Math.pow(Math.abs(x2 - x1), 2);
double comp2 = Math.pow(Math.abs(y2 - y1), 2);
double distance = Math.sqrt(comp1 + comp2);
double r1 = c1.getRadius();
double r2 = c2.getRadius();
boolean con1 = distance <= r1 + r2;
boolean con2 = distance > 0;
boolean overlap = con1 && con2;
return overlap;
}
public static void main(String[] args) {
launch(args);
}
}


