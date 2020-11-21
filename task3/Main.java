package task3;

import task2.Rectangle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Float> array = new ArrayList<Float>();

    static {
        for (int i = 0; i < 16; i++){
            array.add((float) 0);
        }
    }
    public static void parseAndAddFile(String str) throws FileNotFoundException {
        FileReader reader = new FileReader(str);
        Scanner scanner = new Scanner(reader);
        int i = 0;
        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            tmp = tmp.split("\\\\", 2)[0];
            array.set(i, array.get(i) + Float.parseFloat(tmp));
            i++;
        }
    }

    public static int sortArray(ArrayList<Float> array){
        int index = 1;
        float max = 0;
        for (int i = 0; i < array.size(); i++){
            if (max < array.get(i)){
                max = array.get(i);
                index = i + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                parseAndAddFile(args[i]);
            }
            System.out.println(sortArray(array));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
