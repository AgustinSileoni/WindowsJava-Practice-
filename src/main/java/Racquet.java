import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int Y= 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private final ventana window;

    public Racquet (ventana window) {
        this.window = window;       //Recibe la ventana sobre la cual se va a mostrar
    }

    void move() {
        if(x + xa > 0 & x + xa < window.getWidth() - WIDTH){
            x = x +xa;
        }
    }

    void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            xa = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = 1;
        }
    }
    void keyReleased(){
        xa=0;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,Y,WIDTH, HEIGHT);
    }

    public int getTopY(){
        return Y;
    }

    public void paint(Graphics2D g){
        g.fillRect( x , Y ,WIDTH ,HEIGHT );
    }


}
