package GUI;

public class PlayerT implements GameObject {
    /*FIELDS*/
    private Rectangle playerRect;
    private Sprite playerAvatar;
    int speed = 10;
    static final int BORDER_UP = 10;
    static final int BORDER_DOWN = 720;
    static final int BORDER_LEFT = 10;
    static final int BORDER_RIGHT = 950;


    /*METHODS*/
    public PlayerT(SpriteSheet avaspritesh){
        playerRect = new Rectangle(300, 300, 16, 16);
        playerRect.generatePixels(3, 0x3DFF33);
        playerAvatar = avaspritesh.getSprite(1, 0);
    }

    public void render(RenderHandler renderer, int xzoom, int yzoom){
        renderer.renderSprite(playerAvatar, 300, 300, 2, 2);
    }

    public void update(Game game){
        KeyboardListener keyListener = game.getKeyListener();
        if(keyListener.up() && (playerRect.y >= BORDER_UP)){
            if(playerRect.y > 0){
                playerRect.y -= speed;
            }
        }
        if(keyListener.down() && (playerRect.y <= BORDER_DOWN)){
            if(playerRect.y < 665){
                playerRect.y += speed;
            }
        }
        if(keyListener.left() && (playerRect.x >= BORDER_LEFT)){
            if(playerRect.x > 0){
                playerRect.x -= speed;
            }
        }
        if(keyListener.right() && (playerRect.x <= BORDER_RIGHT)){
            if(playerRect.x < 655){
                playerRect.x += speed;
            }
        }
    }
}
