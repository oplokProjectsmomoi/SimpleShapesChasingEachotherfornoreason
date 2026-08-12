import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class framme extends JFrame{
    private int WIDTH;
    private int HEIGHT;

    private blob pleyah;
    private pred konkerurpir;

    private JPanel gamepaPanel;

    public framme(int w, int h){
        WIDTH = w;
        HEIGHT = h;

        pleyah = new blob(300, 300);
        konkerurpir = new pred(0, 0, pleyah);
        gamepaPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D c2gin = (Graphics2D) g;
                c2gin.setColor(Color.BLACK);
                c2gin.fillRect(0, 0, getWidth(), getHeight());

                pleyah.draw(c2gin);
                konkerurpir.draw(c2gin);
            }
        };
        gamepaPanel.setFocusable(true);

       gamepaPanel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                pleyah.move(e.getKeyChar());
                gamepaPanel.repaint();
            }
        });
        Timer clock = new Timer(16, e->{
            konkerurpir.chase();
            gamepaPanel.repaint();
        });
        clock.start();

    }

    public void setUP(){
        setSize(WIDTH, HEIGHT);
        setTitle("i dunnon wut am i doing i'll just say \"lorem ipsum\" type shii");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(gamepaPanel);
        setVisible(true);
        gamepaPanel.requestFocusInWindow();
    }
}
