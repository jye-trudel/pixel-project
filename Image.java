import java.util.Arrays;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Image {
    private Pixel[][] photo;

    public Image(Pixel[][] pixels) {
        photo = pixels;
    }

    public void printPixelValues(int row, int col) { // Prints pixel values for that given index
        System.out.println(photo[row][col].getRed());
        System.out.println(photo[row][col].getGreen());
        System.out.println(photo[row][col].getBlue());
    }

    public void exportImage() throws IOException {
        // Create a BufferedImage from pixel data
        //Rgb value image creation
        //Goes through array and makes a pixel object from the photo array
        int width = photo[0].length;
        int height = photo.length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Pixel pixel = photo[row][col]; 
                if (pixel != null) {
                    int red = pixel.getRed();
                    int green = pixel.getGreen();
                    int blue = pixel.getBlue();
                    int rgb = (red << 16) + (blue << 8) + (green); //using shift operator to combine rgb values into a 24bit rgb value
                    image.setRGB(col, row, rgb);
                }
            }
        }
        // Write BufferedImage to JPEG file
        File output = new File("output.jpg");
        ImageIO.write(image, "jpg", output);
    }

    public void printImageValues() { // goes through the array and prints out the rgb values for pixel objects
        for (Pixel[] row : photo) {
            for (Pixel p : row) {
                System.out.print(p.getRed() + " ");
                System.out.print(p.getGreen() + " ");
                System.out.print(p.getBlue() + " ");
                System.out.println();
            }
        }
    }
    public void setRed(int row, int col) {
        photo[row][col].setRed();
    }
    public void setAllRed() {
        for (int row = 0; row < photo.length; row++) {
            for (int col = 0; col < photo[row].length; col++) {
                photo[row][col].setRed();
            }
        }
    }
    public void setBlue(int row, int col) {
        photo[row][col].setBlue();
    }
    public void setAllBlue() {
        for (int row = 0; row < photo.length; row++) {
            for (int col = 0; col < photo[row].length; col++) {
                photo[row][col].setBlue();
            }
        }
    }
    public void setGreen(int row, int col) {
        photo[row][col].setGreen();
    }
    public void setAllGreen() {
        for (int row = 0; row < photo.length; row++) {
            for (int col = 0; col < photo[row].length; col++) {
                photo[row][col].setGreen();
            }
        }
    }
    public void increaseColor(String color, int value, int row, int col) {
        photo[row][col].increaseColor(color, value);
    }

    public void cropImage(int sRow, int sCol, int size) {
        int cCount = 0; int rCount = 0;
        Pixel[][] temp = new Pixel[size][size];
        for (int row = sRow; row < sRow+size-1; row++) {
            for (int col = sCol; col < sCol+size-1; col++) {
                temp[rCount][cCount] = photo[row][col];
                cCount++;
            }
            cCount = 0; rCount++;
        }
        photo = temp;
    }
}
