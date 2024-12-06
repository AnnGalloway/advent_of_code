package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class part1 {

    static Scanner scanFile;
    static Scanner scanFile2;


    static {
        try {
            scanFile = new Scanner(new File("/Users/anngalloway/UdemyLearning/advent_of_code/2024/src/main/resources/inputDay5"));
            scanFile2 = new Scanner(new File("/Users/anngalloway/UdemyLearning/advent_of_code/2024/src/main/resources/inputDay5_2"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Integer>> pageOrders = getPageOrder(scanFile);
    public static List<List<Integer>> listOfPageNumbers = getPageNumbers(scanFile2);


    public static void main(String[] args) throws Exception {
        int count = 0;
        for (List<Integer> pageNumbers : listOfPageNumbers) {
            boolean match = checkOrder(pageNumbers);
            if (match) {
                count += getMiddlePage(pageNumbers);
            }
        }
        System.out.println(count);
    }

    public static List<List<Integer>> getPageNumbers(Scanner input) {
        List<List<Integer>> pageNumbers = new ArrayList<>();
        while (input.hasNext()) {
            String line = input.nextLine();
            List<Integer> singleList = new ArrayList<>();
            for (String pageNumber : line.split(",")) {
                singleList.add(Integer.parseInt(pageNumber));
            }
            pageNumbers.add(singleList);
            }
        return pageNumbers;
    }

    public static List<List<Integer>> getPageOrder(Scanner input) {
        List<List<Integer>> pageOrder = new ArrayList<>();
        while (input.hasNext()) {
            String line = input.nextLine();
            List<Integer> singleList = new ArrayList<>();
            for (String pageNumber : line.split("\\|")) {
                singleList.add(Integer.parseInt(pageNumber));
            }
            pageOrder.add(singleList);
        }
        return pageOrder;
    }

    public static int getMiddlePage(List<Integer> list) {
        int middle = list.size() / 2;
        return list.get(middle);
    }

    public static boolean checkOrder (List<Integer> pageNumbers) {
        boolean match = true;
        for (int i=0; i<pageNumbers.size(); i++) {
            for (int j=i+1; j<pageNumbers.size(); j++) {
                for (List<Integer> pageOrder : pageOrders) {
                    if (pageOrder.get(0).equals(pageNumbers.get(j))) {
                        if (pageOrder.get(1).equals(pageNumbers.get(i))) {
                            match = false;
                        }
                    }
                }
            }
        }
        return match;
    }

}
