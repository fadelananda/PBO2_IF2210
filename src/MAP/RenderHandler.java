import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class RenderHandler 
{
	/*FIELDS*/
	private BufferedImage view;
	private Rectangle camera;
	private int[] pixels;

	/*METHODS*/
	//constructor
	public RenderHandler(int width, int height) 
	{
		//Create a BufferedImage that will represent our view.
		view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		//bikin view point Snya
		camera = new Rectangle(0,0,width,height);
		// camera.x = -100;
		// camera.y = -100;

		//Create an array for pixels
		pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
	}

	public void render(Graphics graphics){
		graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
	}

	//drawing INDIVIDUAL pixel to the pixels array, one by one.
	public void setPixel(int pixel, int x, int y){
		if(x >= camera.x
			&& y >= camera.y
			&& x <= camera.x+camera.width
			&& y <= camera.y+camera.height){
			int pixelIndex = (x - camera.x) + (y - camera.y)*view.getWidth();
			if(pixels.length > pixelIndex && pixel != Game.alpha){
				pixels[pixelIndex] = pixel;
			}
		}
	}

	/*RENDER THINGS*/
	//main renderer because everything is basically an array
	public void renderArray(int[] toRender, int x, int y, int rWidth, int rHeight, int zoomx, int zoomy){
		for(int j = 0 ; j < rHeight; j++)
			for(int i = 0; i < rWidth; i++)
				for(int zy = 0; zy < zoomy ; zy++)
					for(int zx = 0; zx < zoomx ; zx++)
						setPixel(toRender[i + j*rWidth], (i*zoomx + x + zx), (j*zoomy + y + zy));
	}

	public void renderImage(BufferedImage image, int x, int y, int zoomx, int zoomy){
		int[] imgPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		renderArray(imgPixels, x, y, image.getWidth(), image.getHeight(), zoomx, zoomy);
	}

	public void renderRectangle(Rectangle r, int xzoom, int yzoom){
		//rectangle posistion is already on the constructor
		int[] recPixels = r.getPixels();
		if(recPixels != null){
			renderArray(recPixels, r.x, r.y, r.width, r.height, xzoom, yzoom);
		}
	}

	public void renderSprite(Sprite s, int x, int y, int xzoom, int yzoom){
		renderArray(s.getPixels(), x, y, s.getWidth(), s.getHeight(), xzoom, yzoom);
	}

	/*CLEAR*/
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}

	/*MISC*/
	public int getPixelsLength(){
		return pixels.length;
	}

	public Rectangle getCamera(){
		return camera;
	}
}