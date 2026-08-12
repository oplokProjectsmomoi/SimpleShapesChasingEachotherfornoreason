import java.awt.*;

public class pred{
    private int xpos;
    private int ypos;
    private int spd = 3;
    private blob target;

    pred(int x, int y, blob target){
        xpos = x;
        ypos = y;
        this.target = target;
    }

    public void chase(){
        double dx = target.xpos - xpos;
        double dy = target.ypos - ypos;
        double distance = Math.sqrt((dx * dx) + (dy * dy));//a^2 + b^2 = c^2 

        if(distance > 0){
            xpos += (int)(spd * dx / distance);
            ypos += (int)(spd * dy / distance);
        }
    }

    protected void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        //rectangle
        g2d.setColor(Color.RED);
        g2d.fillRect(xpos, ypos, 10, 10);
    }
}
