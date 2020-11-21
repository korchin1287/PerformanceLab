package task2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Rectangle parserRectangle(String str) throws FileNotFoundException {
        FileReader reader = new FileReader(str);
        Rectangle rectangle = new Rectangle();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            tmp = tmp.split("\\\\", 2)[0];
            String[] tox = tmp.split(" ", 2);
            rectangle.setCoordinates(Float.parseFloat(tox[0]), Float.parseFloat(tox[1]));
        }
        return (rectangle);
    }

    public static void parseAndCheckPoints(Rectangle rectangle, String str) throws FileNotFoundException {
        FileReader reader = new FileReader(str);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            tmp = tmp.split("\\\\", 2)[0];
            String[] tox = tmp.split(" ", 2);
            float x = Float.parseFloat(tox[0]);
            float y = Float.parseFloat(tox[1]);
            if (rectangle.checkPointOfVertex(x, y))
                System.out.println("" + 0);
            else if (rectangle.checkPointOnTheEdge(x, y))
                System.out.println("" + 1);
            else if (rectangle.checkPointInRectangle(x, y))
                System.out.println("" + 2);
            else
                System.out.println("" + 3);
        }
    }

    public static void main(String[] args) {
        try {
            Rectangle rectangle = parserRectangle(args[0]);
            parseAndCheckPoints(rectangle, args[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
