import java.awt.*;
public class bg {
    public void create(Graphics p){
        //Fills the are with 'pavement'
        p.setColor(Color.BLACK);
        p.fillRect(0, 75, 500, 370);
        //Fills the grassy area used as starting/finishing zones
        p.setColor(Color.GREEN);
        p.fillRect(0, 0, 500, 75);
        p.fillRect(0, 445, 500, 75);
        //Creates the areas that are yellow 'road lines'
        p.setColor(Color.YELLOW);
        p.fillRect(0, 165, 500, 3);
        p.fillRect(0, 225, 500, 3);
        p.fillRect(0, 357, 500, 3);
        //Creates the areas that are white 'road lines'
        p.setColor(Color.WHITE);
        p.fillRect(0, 85, 500, 3);
        p.fillRect(0, 430, 500, 3);
        }
}
