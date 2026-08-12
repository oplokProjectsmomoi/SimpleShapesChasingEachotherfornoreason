import java.awt.*;

public class blob{
    
    public int xpos;
    public int ypos;
    private int spd = 10;

    blob(int x, int y){
        xpos = x;
        ypos = y;
    }
    public void move(char key){
        switch(key){
            case 'w' -> ypos -= spd;
            case 's' -> ypos += spd;
            case 'a' -> xpos -= spd;
            case 'd' -> xpos += spd;
        }
    }

    protected void draw(Graphics g){

        Graphics2D g2db = (Graphics2D) g;

        g2db.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        //circle
        g2db.setColor(Color.BLUE);
        g2db.fillOval(xpos, ypos, 10, 10);
    }
}
