import java.awt.*;
public class gameOver {
    //Creation of different fonts to be used with display
    Font font1 = new Font("Impact", Font.BOLD,35);
    Font font2 = new Font("Verdana", Font.PLAIN, 18);

    //This function serves to draw a string with the center being placed at the exact coordinates specified.
    public static void drawCenteredString(Graphics g, String text, int xx, int yy, int ww, int hh, Font ff) {
        FontMetrics metrics = g.getFontMetrics(ff);
        int x = xx + (ww - metrics.stringWidth(text)) / 2;
        int y = yy + ((hh - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(ff);
        g.drawString(text, x, y);
    }

    //Actually draws the Game Over Screen
    public void ded(Graphics p) {
        //Sets the gameover background
            p.setColor(Color.BLACK);
            p.fillRect(0, 0, 500, 500);
        //draws the gameover text
            p.setColor(Color.WHITE);
            drawCenteredString(p, "Game Over", 250, 250, 1, 1, font1);
            drawCenteredString(p, "Press the Space Bar to Continue", 250, 300, 1, 1, font2);
    }
}
