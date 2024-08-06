public class Pixel {
    private int red;
    private int blue;
    private int green;

    public Pixel(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public void increaseColor(String color, int x) {
        if (color.equals("green")) {
            green+=x;
        } else if (color.equals("red")) {
            red+=x;
        } else if (color.equals("blue")) {
            blue+=x;
        } else {
            System.out.println("Invalid Option");
        }
    }
    public int getRed() {
        return red;
    }
    public int getGreen() {
        return green;
    }
    public int getBlue() {
        return blue;
    }
    public void setRed() {
        red = 255;
        blue = 0;
        green = 0;
    }
    public void setBlue() {
        red = 0;
        blue = 255;
        green = 0;
    }
    public void setGreen() {
        red = 0;
        blue = 0;
        green = 255;
    }
}
