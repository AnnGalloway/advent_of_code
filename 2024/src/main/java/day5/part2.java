package day5;

import java.util.ArrayList;
import java.util.List;

public class part2 {

    public static List<List<Integer>> pageOrders = part1.pageOrders;
    public static List<List<Integer>> listOfPageNumbers = part1.listOfPageNumbers;

    public static void main(String[] args) throws Exception {
        int count = 0;
        List<List<Integer>> wrongOrders = new ArrayList<>();
        for (List<Integer> pageNumbers : listOfPageNumbers) {
            if (!part1.checkOrder(pageNumbers)) {
                wrongOrders.add(pageNumbers);
            }
        }
        System.out.println(wrongOrders);
        for (List<Integer> pageNumbers : wrongOrders) {
            swapOrder(pageNumbers);
        }
        System.out.println(wrongOrders);
        int answer = 0;
        for (List<Integer> pageNumbers : wrongOrders) {
            answer += part1.getMiddlePage(pageNumbers);
        }
        System.out.println(answer);
    }

    public static boolean swapOrder (List<Integer> pageNumbers) {
        boolean match = true;
        for (int i=0; i<pageNumbers.size(); i++) {
            for (int j=i+1; j<pageNumbers.size(); j++) {
                for (List<Integer> pageOrder : pageOrders) {
                    if (pageOrder.get(0).equals(pageNumbers.get(j))) {
                        if (pageOrder.get(1).equals(pageNumbers.get(i))) {
                            int first = pageNumbers.get(i);
                            int second = pageNumbers.get(j);
                            pageNumbers.set(i, second);
                            pageNumbers.set(j, first);
                        }
                    }
                }
            }
        }
        return match;
    }

}
