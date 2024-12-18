package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class part1 {
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

        for (int i = 0; i < list1.size(); i++) {
            int list1int = list1.get(i);
            int list2int = list2.get(i);

            total += abs(list1int-list2int);
        }
        System.out.println(total);



    }
}
