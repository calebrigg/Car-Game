import java.awt.*;
import java.awt.event.KeyEvent;

public class startScreen extends gameOver{
    //one-time boolean used to determine if game has started or not
    boolean begin=false;
    //Used for difficulty selection
    int difficulty=1;
    //Creation of different fonts to be used with display
    Font font1 = new Font("Impact", Font.BOLD,35);
    Font font2 = new Font("Verdana", Font.PLAIN, 18);


    //Actually draws the Game Over Screen
    public void start(Graphics p) {
        //Sets the startScreen background
        p.setColor(Color.BLACK);
        p.fillRect(0, 0, 500, 500);
        //draws the startScreen text
        p.setColor(Color.WHITE);
        //uses the Centered String function from the gameOver class
        gameOver.drawCenteredString(p, "Run The Road", 250, 200, 1, 1, font1);
        gameOver.drawCenteredString(p, "Select a Difficulty:", 250, 230, 1, 1, font2);
        gameOver.drawCenteredString(p, "1          2          3", 250, 275, 1, 1, font2);
        gameOver.drawCenteredString(p, "Press the Space Bar to Begin", 250, 325, 1, 1, font2);
        if (difficulty==1)p.drawRect(150, 250, 50, 50);
        if (difficulty==2)p.drawRect(225, 250, 50, 50);
        if (difficulty==3)p.drawRect(300, 250, 50, 50);
    }

}
