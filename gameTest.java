import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class gameTest extends Frame implements KeyListener {
    //Universal variables that are needed to be passed throughout the entire class
        //creates an array list for the cars
            ArrayList<movingCars> c = new ArrayList<>();

        //variable for the background class
            bg backg;

        //variable for the player class
            p1 player;

        //variable for the gameOver class
            gameOver gOver = new gameOver();

        //variable for the startScreen class
            startScreen ss = new startScreen();

        //keeps track of the score count throughout the game
            int count=0;

        //creates the string that is drawn for the score
            String score="Score: "+count;

        //creates the string that is drawn for the lives
            String lives="Lives: "+3;

        //determines whether the gameover screen is on
            boolean dedScreen=false;

        //determines whether the game is paused or not
            boolean gamePaused=false;

        //one-time boolean used to determine if game has started or not
            boolean begin=false;

        public gameTest() {
            // initializing the window
            setSize(500,500);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    System.exit(0);
                }
            });

            addKeyListener(this);

            // initialize the objects

                //creates the background variable
            backg = new bg();

                //creates the car objects
            movingCars temp;
            temp = new movingCars( 96, 115, 45, Color.BLUE, 9, true);
            c.add(temp);
            temp = new movingCars( 250, 200, 85, Color.ORANGE, 8, false);
            c.add(temp);
            temp = new movingCars( 372, 120, 45, Color.GRAY, 8, false);
            c.add(temp);
            temp = new movingCars( 185, 50, 25, Color.RED, 10, true);
            c.add(temp);

                //creates the player
            player = new p1(235,445,25, Color.PINK,25, 3);

        }

        public void paint(Graphics g) {
            //checks if the gameover screen is on, if so, the gameover function is called
            if (dedScreen){
                gameOverScreen(g);
            }
            //checks if the gameover screen is on, while it isn't it will redraw the screen
            if (!gamePaused&&begin) {
                //draws the background
                backg.create(g);
                //draws the cars
                for (int i = 0; i < c.size(); i++)
                    c.get(i).draw(g);
                //draws the player
                player.draw(g);
                //draws the life and score count
                g.setColor(Color.BLACK);
                g.drawString(score, 440, 490);
                g.drawString(lives, 442, 475);
            }
            if (!begin){
                ss.start(g);
            }
        }

        //keeps a running log of the score gained
        public void scoreLog(){
            count++;
            score="Score: "+count;
        }

        //keeps a running log of the lives lost
        public void lifeLog(){
            lives="Lives: "+player.lives;
        }

        //determines if player has reached the end-zone and then calls the scoreLog function
        public void point(){
            if (player.y < 45){
                player.x = 235;
                player.y = 445;
                scoreLog();
            }
        }

        //draws the gameover screen and sets the gamePaused value to true
        public void gameOverScreen(Graphics g){
            gOver.ded(g);
            gamePaused = true;
        }

        public void updateFrame() {
            //while the game isn't paused the function will continue to update the frames
            if (!gamePaused) {
                //The following functions are called to check for deaths/points/player bounds/lives
                deathOccur();
                lifeLog();
                playArea();
                point();
                //updates the frames for all of the cars and the player
                for (int i = 0; i < c.size(); i++) {
                    c.get(i).updateFrame(player);
                }
            }
        }

        public void deathOccur(){
            //if the player dies, the lives are set to 3, and the score is reset, then the gameover screen boolean is made true
            if (player.lives == 0){
                count = 0;
                player.lives = 3;
                score="Score: "+0;
                dedScreen=true;
            }
        }

        // is called when a key is pressed
        public void keyPressed(KeyEvent e) {
            //checks if the game is running to allow movement
            if (!dedScreen && begin) {
                //Uses the KeySelection function for the main Movement
                mainMove(e);
            }

            //if the space button is pressed, the gameover screen will disappear because the values are reset
            if(dedScreen){
                if (e.getKeyCode() == 32) {
                    gamePaused = false;
                    dedScreen = false;
                }
            }

            if (!begin){
                //Uses the KeySelection function for the startScreen
                startScreenSelection(e);
            }
        }

        public void	keyReleased(KeyEvent e) {
        }

        public void	keyTyped(KeyEvent e) {

        }

        public void mainMove(KeyEvent e){
            if (e.getKeyCode() == 37) player.rightKeyPressed();
            if (e.getKeyCode() == 39) player.leftKeyPressed();
            if (e.getKeyCode() == 40) player.upKeyPressed();
            if (e.getKeyCode() == 38) player.downKeyPressed();
        }

        //StartScreen Selection Controls
    public void startScreenSelection(KeyEvent e) {
        if (e.getKeyCode() == 49) {ss.difficulty = 1;}
        if (e.getKeyCode() == 50) {ss.difficulty = 2;}
        if (e.getKeyCode() == 51) {ss.difficulty = 3;}
        if (e.getKeyCode() == 37) {ss.difficulty--;}
        if (e.getKeyCode() == 39) {ss.difficulty++;}
        if (ss.difficulty == 4) {ss.difficulty = 1;}
        if (ss.difficulty == 0) {ss.difficulty = 3;}
        if (e.getKeyCode() == 32) {begin = true;}
    }

        //The area the player is allowed to move within the game
        public void playArea() {
            if (player.x < 0){player.x = player.x + player.v;}
            if (player.x > 480){player.x = player.x - player.v;}
            if (player.y > 480){player.y = player.y - player.v;}
        }

    public static void main(String[] args) throws InterruptedException {
            gameTest win = new gameTest();
            win.setVisible(true);

                // make the main loop for framing the animation
                while (true) {
                    // 1: show my frame
                    win.repaint();

                    // 2: delay of 50 msec
                    Thread.sleep(20);


                    // 3: update the frame
                    win.updateFrame();
                }
            }
        }