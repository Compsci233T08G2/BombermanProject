import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class Sprite
{
    private Image picture;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    //Constructor for the sprite class to create sprites for the game loop
    public Sprite(double positionX, double positionY, double velocityX, double velocityY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    //Setters to be used by the game loop to create sprites with correct, size, position and dimensions
    public void setPicture(Image sprite)
    {
        picture = sprite;
        width = sprite.getWidth();
        height = sprite.getHeight();
    }

    public void setPicture(String sprite)
    {
        Image sprite2 = new Image(sprite);
        setPicture(sprite2);
    }

    public void setPosition(double x, double y)
    {
        this.positionX = x;
        this.positionY = y;
    }
    //Need to test velocity methods once the key listeners are connected.
    public void setVelocity(double x, double y)
    {
        this.velocityX = x;
        this.velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage( picture, positionX, positionY );
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite sprite)
    {
        return sprite.getBoundary().intersects( this.getBoundary() );
    }
}