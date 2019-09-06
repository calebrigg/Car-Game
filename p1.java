import java.awt.*;

public class p1 {
    // coordinates of player
    int x;
    int y;

    // width and height
    int w;
    int h;

    //Color of character
    Color color;

    // a count of the lives the player has
    int lives;

    // speed the character moves
    int v;


    public p1(int xx, int yy, int r, Color cc, int vv, int lfs) {
        //assigns the variables created above to the values passed
        x = xx;
        y = yy;
        w = r;
        h = r;
        color = cc;
        v = vv;
        lives = lfs;
    }

    //Draws the character
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,w,h);
    }

    // is called when the left arrow key is pressed
    public void leftKeyPressed() {
            x += v;
    }

    // is called when the right arrow key is pressed
    public void rightKeyPressed() {
        x -= v;
    }

    // is called when the up arrow key is pressed
    public void upKeyPressed() {
        y += v;
    }

    // is called when the down arrow key is pressed
    public void downKeyPressed() {
        y -= v;
    }
}