public class Rectangle {
    /*FIELDS*/
    public int x, y, width, height;
    private int[] pixels;

    /*METHODS*/
    public Rectangle(){
        this(0,0,0,0);
    }

    public Rectangle(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public void generatePixels(int color){
        pixels = new int[width*height];
        for(int i = 0; i < width*height; i++)
            pixels[i] = color;
    }

    public int[] getPixels(){
        return pixels;
    }

    public void createBorder(int width, int color){
        /*FILLING WITH ALPHA VALUE SO IT BECOMES TRANSPARENT*/
        for(int i = 0; i < this.width*this.height; i++){
            pixels[i] = Game.alpha;
        }

        /*INSIDE BORDERS*/
        //top and bottom border
        for(int j = 0; j < width; j++)
            for(int i = 0; i < this.width; i++){
                pixels[i + j*this.width] = color;
                pixels[i + (this.height-j-1)*this.width] = color;
            }

        //left and right borders
        for(int i = 0; i < width; i++)
            for(int j = 0; j < this.height; j++){
                pixels[i + j*this.width] = color;
                pixels[(this.width-i-1) + j*this.width] = color;
            }
    }
}