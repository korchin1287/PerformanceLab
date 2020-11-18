package task1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void MinValue(ArrayList<Integer> list){
		int ret = list.get(0);
		for (int i = 0; i < list.size(); i++)
		{
			if (ret > list.get(i))
				ret = list.get(i);
		}
		System.out.println(String.format("%.2f", (double)ret));
	}

	public static void MaxValue(ArrayList<Integer> list){
		int ret = list.get(0);
		for (int i = 0; i < list.size(); i++)
		{
			if (ret < list.get(i))
				ret = list.get(i);
		}
		System.out.println(String.format("%.2f", (double)ret));
	}

	public static void MiddleValue(ArrayList<Integer> list){
		int ret = 0;
		int size = list.size();
		for (int i = 0; i < size; i++)
		{
			ret += list.get(i);
		}
		System.out.println(String.format("%.2f", ((double)ret / size)));
	}

	public static void Mediana(ArrayList<Integer> list){
		int size = list.size();
		Collections.sort(list);
		if (size % 2 == 0) {
			double ret = (double)(list.get(size / 2) + list.get(size / 2 - 1)) / 2;
			System.out.println(String.format("%.2f", ret));
		}
		else
			System.out.println(String.format("%.2f", ((double)(list.get(size / 2)))));
	}

	public static void Pertencile(ArrayList<Integer> list){
		Collections.sort(list);
		double index = (((double)90 / 100) * (list.size() - 1)) + 1;
		int whole = (int)Math.floor(index);
		double fract = index - whole;
		double ret = list.get(whole - 1) + (fract * (list.get(whole) - list.get(whole - 1)));

		System.out.println(String.format("%.2f", ret));
	}

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader(args[0]);
		Scanner scanner = new Scanner(reader);
		ArrayList<Integer> list = new ArrayList<>();

		while (scanner.hasNextInt()) {
			list.add(scanner.nextInt());
		}
		Pertencile(list);
		Mediana(list);
		MaxValue(list);
		MinValue(list);
		MiddleValue(list);

		reader.close();
		scanner.close();
	}
}
