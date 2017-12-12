import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;

/**
 * Natasya Virgichalia
 * Date: 12/10/2017
 * Assignment 12.25
 */
public class processDataset {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> associate = new ArrayList<>();
        ArrayList<Double> assistant = new ArrayList<>();
        ArrayList<Double> full = new ArrayList<>();
        URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
        Scanner keyboard = new Scanner(url.openStream());
        while (keyboard.hasNext()) {
            String[] listLine = (keyboard.nextLine()).split(" ");
            collectData(assistant, associate, full, listLine[2], new Double(listLine[3]));
        }
        double assistantTotal = getTotal(assistant);
        double associateTotal = getTotal(associate);
        double fullTotal = getTotal(full);
        double allInTotal = (assistantTotal+associateTotal+fullTotal);

        System.out.println("        Total Salary");
        System.out.printf("Assistant total = $%.2f\n", assistantTotal);
        System.out.printf("Associate total = $%.2f\n", associateTotal);
        System.out.printf("Full professors total = $%.2f\n", fullTotal);
        System.out.printf("All faculty total = $%.2f\n", allInTotal);
        System.out.println();
        System.out.println("        Average Salary");
        System.out.printf("Assistant average = $%.2f\n", getAverage(assistantTotal, assistant.size()));
        System.out.printf("Associate average = $%.2f\n", getAverage(associateTotal, associate.size()));
        System.out.printf("Full professors average = $%.2f\n", getAverage(fullTotal, full.size()));
        System.out.printf("All faculty average = $%.2f\n", (allInTotal / (assistant.size() +associate.size() + full.size())));

    }
    public static void collectData(ArrayList<Double> firstList, ArrayList<Double> secondList, ArrayList<Double> thirdList, String rank, double money) {
        if(rank.equals("assistant")) {
            firstList.add(money);
        }
        else if (rank.equals("associate"))
            secondList.add(money);
        else if (rank.equals("full"))
            thirdList.add(money);
    }
    public static double getTotal (ArrayList<Double> list) {
        double total = 0;
        for(int i=0; i<list.size();i++) {
            total += list.get(i);
        }
        return total;
    }
    public static Double getAverage(double total, int size) {
        return (double)total/size;
    }

}
