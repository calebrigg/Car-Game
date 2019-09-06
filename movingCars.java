import java.awt.*;
import java.util.Random;
public class movingCars {
    startScreen ss = new startScreen();
    //The x and y co-ordinates of the cars
    int x;
    int y;

    //The width and height of the cars
    int w;
    int h;

    //The speed of the cars
    int v;

    //The boolean responsible for the cars direction left or right
    boolean Alt;

    //the color value assigned to the cars
    Color color;

    public movingCars(int ypos, int ww, int hh, Color cc, int vv, boolean Dir) {
        //assigns the variables created above to the values passed
        w = ww;
        h = hh;
        Alt=Dir;
        color = cc;
        x = 0;
        y = ypos;
        v = vv;
    }

    //draws the cars
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }

    //creates randomized values for the cars
    public void randomizer(){
        Random rand = new Random();
        //creates the random rgb values
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        //creates an integer to assign random speed
        int vel=0;
            //If player selected difficulty of 1 then vel is restricted to an easy speed
            if (ss.difficulty==1) {
                vel = rand.nextInt(8) + 4;
            }
            //If player selected difficulty of 1 then vel is restricted to a normal speed
            if (ss.difficulty==2) {
                vel = rand.nextInt(10) + 6;
            }
            //If player selected difficulty of 1 then vel is restricted to a hard speed
            if (ss.difficulty==3) {
                vel = rand.nextInt(12) + 8;
            }
        //assigns the rgb values to a color value
        Color randc = new Color(r,g,b);
        //random color value is assigned to the car's color
        color = randc;
        //random speed value is assigned to the car's speed
        v = vel;

    }

    //Responsible for every new frame of the program
    public void updateFrame(p1 p) {

        //Detects player's collision with a car
        if (!((p.y + p.h < y) || (y + h < p.y) || (p.x > x + w) || (p.x + p.w < x))) {
            //decrements player's life
            p.lives--;
            //assigns player's the co-ordinates of the starting position.
            p.x = 235;
            p.y = 445;
        }

        //The rules used for cars that are heading left-to-right
       if (!Alt) {
        if (x >= 500) {
            //if car has exited the screen, it's color and speed changes and it is returned to the starting position
            x = -(w);
            randomizer();
            return;
        }

        //as long as the car is still on the screen it will move right
        if (x < 500) {
            x += v;
            return;
            }
        }
        //The rules used for cars that are heading right-to-left
        if (Alt) {
            if (x <= 0) {
                //if car has exited the screen, it's color and speed changes and it is returned to the starting position
                x = 500 +(w);
                randomizer();
                return;
            }
            //as long as the car is still on the screen it will move left
            if (x > 0) {
                x -= v;
                return;
            }
        }
    }
}

