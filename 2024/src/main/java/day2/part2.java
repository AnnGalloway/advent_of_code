package day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class part2 {

    public static void main(String[] args) throws Exception {

        Scanner scanFile = new Scanner(new File("filelocation"));

        int safe = 0;

        while (scanFile.hasNext()) {
            List<Integer> numbers = new ArrayList<>();
            for (String line : scanFile.nextLine().split(" ")) {
                numbers.add(Integer.parseInt(line));
            }

            if (checkList(numbers)){
                safe++;
            } else {
                int removeOneSafe = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    List<Integer> numbersCopy = new ArrayList<>(numbers);
                    numbersCopy.remove(i);
                    if(checkList(numbersCopy)){
                        removeOneSafe++;
                    }
                }
                if(removeOneSafe > 0){
                    safe++;
                } else {
                    System.out.println(numbers);
                }
            }
        }
        System.out.println(safe);

    }

    public static boolean checkList(List<Integer> numbers) {
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
        return ((asc == 0 || desc == 0) && gap == numbers.size() - 1);
    }
}
