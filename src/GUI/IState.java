package GUI;

public interface IState {
    public void update();
    public void render();
    public void enter();
    public void exit();
}
