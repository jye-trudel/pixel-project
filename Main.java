import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class name: Main
 * Purpose of the class: Driver Class
 * Author: Tristan Trudel
 * Teacher’s name: N Khan
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String line = "";
        String splitBy = ",";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pixels... \nEnter Image Size: ");
        int size = scanner.nextInt();
        Pixel[][] array = new Pixel[size][size];
        // Read image.csv
        Scanner scn = new Scanner(new File("image.csv"));
        while (scn.hasNextLine()) { //Takes values from a csv file and puts them into a temporary pixel array
            for (int row = 0; row < array.length; row++) {
                for (int c = 0; c < array[row].length; c++) {
                    line = scn.nextLine();
                    String[] hold = line.split(splitBy);
                    int r = Integer.parseInt(hold[0]);
                    int b = Integer.parseInt(hold[1]);
                    int g = Integer.parseInt(hold[2]);
                    array[row][c] = new Pixel(r, g, b);
                }
            }
        }
        Image img = new Image(array); //Image object with temp array
        boolean active = true;
        while (active) { //User workflow
            System.out.println("Choose an option...");
            System.out.println("1 ==> Change color");
            System.out.println("2 ==> Crop");
            System.out.println("3 ==> Export image");
            System.out.println("4 ==> Print values");
            System.out.println("5 ==> Increase / Decrease pixel values");
            System.out.println("0 ==> Exit program");
            int inp = scanner.nextInt();
            if (inp == 1) {
                System.out.println("Change full colors or just pixel...");
                String input = scanner.next();
                if (input.equals("full")) {
                    System.out.println("Enter color...");
                    input = scanner.next();
                    if (input.equals("red")) {
                        img.setAllRed();
                    } else if (input.equals("green")) {
                        img.setAllBlue();
                    } else if (input.equals("blue")) {
                        img.setAllGreen();
                    } else {
                        System.out.println("Invalid Input");
                    }
                } else if (input.equals("pixel")) {
                    System.out.println("Enter Pixel Indexs");
                    int p1 = scanner.nextInt();
                    int p2 = scanner.nextInt();
                    System.out.println("Enter color...");
                    input = scanner.next();
                    if (input.equals("red")) {
                        img.setRed(p1, p2);
                    } else if (input.equals("blue")) {
                        img.setBlue(p1, p2);
                    } else if (input.equals("green")) {
                        img.setGreen(p1, p2);
                    } else {
                        System.out.println("Invalid Input");
                    }
                } else {
                    System.out.println("Invalid Input");
                }
            } else if (inp == 2) {
                System.out.println("Enter starting pixels and new size");
                int sr = scanner.nextInt(); //sr = starting row
                int scol = scanner.nextInt(); // starting col
                int sz = scanner.nextInt(); //size
                img.cropImage(sr, scol, sz);
            } else if (inp == 3) {
                img.exportImage();
            } else if (inp == 0) {
                active = false;
            } else if (inp == 4) {
                img.printImageValues();
            } else if (inp == 5) {
                System.out.println("Enter index...");
                int inde1 = scanner.nextInt();
                int inde2 = scanner.nextInt();
                System.out.println("Enter which color...");
                String color = scanner.next();
                System.out.println("Enter the amount..."); 
                int increase = scanner.nextInt();
                img.increaseColor(color, increase, inde1, inde2);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
