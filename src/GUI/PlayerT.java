package GUI;

public class PlayerT implements GameObject {
    /*FIELDS*/
    private Rectangle playerRect;
    int speed = 10;

    /*METHODS*/
    public PlayerT(){
        playerRect = new Rectangle(300, 300, 16, 16);
        playerRect.generatePixels(3, 0x3DFF33);
    }

    public void render(RenderHandler renderer, int xzoom, int yzoom){
        renderer.renderRectangle(playerRect, xzoom, yzoom);
    }
    public void update(Game game){
        KeyboardListener keyListener = game.getKeyListener();
        if(keyListener.up()){
            if(playerRect.y > 0){
                playerRect.y -= speed;
            }
        }
        if(keyListener.down()){
            if(playerRect.y < 672){
                playerRect.y += speed;
            }
        }
        if(keyListener.left()){
            if(playerRect.x > 0){
                playerRect.x -= speed;
            }
        }
        if(keyListener.right()){
            if(playerRect.x < 672){
                playerRect.x += speed;
            }
        }
    }
}
