import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Canvas extends JPanel {
    @Override
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillOval(0,0,30,30);
        g2d.drawOval(0,50,30,30);
        g2d.fillRect(50,0,30,30);
        g2d.drawRect(50,50,30,30);

        g2d.draw(new Ellipse2D.Double(0,100,30,30) );
    }


}