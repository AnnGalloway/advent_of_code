package day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class part1 {

    public static void main(String[] args) throws Exception {

        Scanner scanFile = new Scanner(new File("filelocation"));

        int safe = 0;

        while (scanFile.hasNext()) {
            List<Integer> numbers = new ArrayList<>();
            for (String line : scanFile.nextLine().split(" ")) {
                numbers.add(Integer.parseInt(line));
            }
            int asc = 0;
            int desc = 0;
            int gap = 0;
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    desc++;
                }
                if (numbers.get(i) < numbers.get(i + 1)) {
                    asc++;
                }
                int diff = abs(numbers.get(i) - numbers.get(i + 1));
                if (diff >= 1 && diff <= 3) {
                    gap++;
                }
            }
            if ((asc == 0 || desc == 0) && gap == numbers.size() - 1) {
                safe++;
            }
        }
        System.out.println(safe);

    }
}
