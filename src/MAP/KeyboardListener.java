import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;


public class KeyboardListener implements KeyListener, FocusListener {
    public boolean[] keys = new boolean[120];
    
    /*IMPLEMENTSING KeyListener*/
    public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();
        if(keycode < keys.length){
            keys[keycode] = true;
        }
    }
    public void keyReleased(KeyEvent e){
        int keycode = e.getKeyCode();
        if(keycode < keys.length){
            keys[keycode] = false;
        }
    }

    public void keyTyped(KeyEvent e){

    }

    /*IMPLEMENTING FocusListener*/
    public void focusGained(FocusEvent e){

    }

    public void focusLost(FocusEvent e){
        for(int i = 0; i < keys.length; i++){
            keys[i] = false;
        }
    }

    /*MOVING UPDOWNLEFTRIGHT*/
    public boolean up(){
        return keys[KeyEvent.VK_W];
    }
    public boolean down(){
        return keys[KeyEvent.VK_S];
    }
    public boolean left(){
        return keys[KeyEvent.VK_A];
    }
    public boolean right(){
        return keys[KeyEvent.VK_D];
    }
}
