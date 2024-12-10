package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class part1 {

    static Scanner scanFile;
    static {
        try {
            scanFile = new Scanner(new File("C:/Users/ann_g/IdeaProjects/advent_of_code/2024/src/main/resources/inputTest"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Long>> results = getFile(scanFile);

    public static void main(String[] args) throws Exception {
        int result = 0;

        for (List<Long> list : results) {
            Long total = list.getFirst();
            for (Long number: list) {
                System.out.println(total-number);
                if (total - number < 0){
                    System.out.println("too big");
                    break;
                } else if (total < sumTotal(list,total)) {
                    System.out.println("sums too big");
                    break;
                } else if (total == sumTotal(list,total)) {
                    result++;
                    break;
                } else if (total == multiplyAll(list)){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static List<List<Long>> getFile (Scanner localScanFile) {
        List<List<Long>> list = new ArrayList<>();
        while (localScanFile.hasNextLine()) {
            String line = localScanFile.nextLine().replace(":","");
            List<Long> listOfLongs = Arrays.stream(line.split(" +")).map(Long::parseLong).toList();
            list.add(listOfLongs);
        }
        return list;
    }

    public static long sumTotal (List<Long> listOfIntegers, long result) {
        long answer = -result;
        for (long number : listOfIntegers){
            answer += number;
        }
        return answer;
    }

    public static long multiplyAll (List<Long> listOfIntegers) {
        long answer = listOfIntegers.get(1);
        for (int i = 2; i < listOfIntegers.size(); i++){
            answer *= listOfIntegers.get(i);
        }
        System.out.println(answer);
        return answer;
    }

}
