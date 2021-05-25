import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    private static int y= 330;
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
            xa = -window.speed;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = window.speed;
        }
    }
    void keyReleased(){
        xa=0;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH, HEIGHT);
    }

    public int getTopY(){
        return y;
    }

    public void paint(Graphics2D g){
        y = window.getHeight() - 30;
        g.fillRect( x , y ,WIDTH ,HEIGHT );
    }


}
