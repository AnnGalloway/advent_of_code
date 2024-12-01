package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws Exception {

        Scanner scanFile = new Scanner(new File("resources/inputDay1"));
        int number = 1;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(scanFile.hasNext()) {
            String thing = scanFile.next();
            if (number % 2 == 0){
                list2.add(Integer.valueOf(thing));
            } else {
                list1.add(Integer.valueOf(thing));
            }
            number++;
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int total = 0;

        for (int list1int : list1) {
            int countList2 = Collections.frequency(list2, list1int);
            total += list1int * countList2;

        }
        System.out.println(total);

    }
}
