package GUI;

public interface GameObject
{

	//Call every time physically possible.
	void render(RenderHandler renderer, int xZoom, int yZoom);

	//Call at 60 fps rate.
	void update(Game game);
}