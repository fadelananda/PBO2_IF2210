package GUI;

public class PlayerT implements GameObject {
    /*FIELDS*/
    private Sprite playerAvatar;
    int speed = 10;
    static final int BORDER_UP = 10;
    static final int BORDER_DOWN = 720;
    static final int BORDER_LEFT = 10;
    static final int BORDER_RIGHT = 950;
    private int xpos = 300;
    private int ypos = 300;


    /*METHODS*/
    public PlayerT(SpriteSheet avaspritesh){
        playerAvatar = avaspritesh.getSprite(1, 0);
    }

    public void render(RenderHandler renderer, int xzoom, int yzoom){
        renderer.renderSprite(playerAvatar, xpos, ypos, 2, 2);
    }

    public void update(Game game){
        KeyboardListener keyListener = game.getKeyListener();
        if(keyListener.up() && (ypos >= BORDER_UP)){
            if(ypos > 0){
                ypos -= speed;
            }
        }
        if(keyListener.down() && (ypos <= BORDER_DOWN)){
            if(ypos < 665){
                ypos += speed;
            }
        }
        if(keyListener.left() && (xpos >= BORDER_LEFT)){
            if(xpos > 0){
                xpos -= speed;
            }
        }
        if(keyListener.right() && (xpos <= BORDER_RIGHT)){
            if(xpos < 655){
                xpos += speed;
            }
        }
    }
}
