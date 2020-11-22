package task4;

import task2.Rectangle;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<VisitorsInTime> time = new ArrayList<>();

    public static void parseAndCount(String str) throws FileNotFoundException {
        FileReader reader = new FileReader(str);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            tmp = tmp.split("\\\\", 2)[0];
            String[] tox = tmp.split(" ", 2);
            String[] tox2 = tox[0].split(":", 2);
            int start = Integer.parseInt(tox2[0]) * 60 + Integer.parseInt(tox2[1]);
            tox2 = tox[1].split(":", 2);
            int end = Integer.parseInt(tox2[0]) * 60 + Integer.parseInt(tox2[1]);
            for(int i = 0; i < time.size(); i++){
                if (time.get(i).getTime() >= start && time.get(i).getTime() < end){
                    time.get(i).addVisitors();
                }
            }
        }
    }

    public static int searchMaxValue(){
        int max = 0;
        for(int i = 0; i < time.size(); i++){
            if (time.get(i).getVisitors() > max)
                max = time.get(i).getVisitors();
        }
        return max;
    }

    public static void printTime(int maxValue){
        for (int j = 0; j < time.size(); j++) {
            if (time.get(j).getVisitors() == maxValue){
                String start_h = time.get(j).getTime() / 60 + ":";
                int minute = (time.get(j).getTime() % 60);
                String start_m = (minute == 0) ? "00" : (time.get(j).getTime() % 60) + "";
                while (time.get(j).getVisitors() == maxValue)
                    j++;
                String end_h = time.get(j).getTime() / 60 + ":";
                minute = (time.get(j).getTime() % 60);
                String end_m = (minute == 0) ? "00" : (time.get(j).getTime() % 60) + "";
                System.out.println(start_h + start_m + " " + end_h + end_m);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 8 * 60; i <= 20 * 60; i++) {
            VisitorsInTime visitors = new VisitorsInTime(i, 0);
            time.add(visitors);
        }
        try {
            parseAndCount(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int maxValue = searchMaxValue();
        printTime(maxValue);
    }
}
