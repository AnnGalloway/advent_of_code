package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class part2 {

    static Scanner scanFile;

    static {
        try {
            scanFile = new Scanner(new File("/Users/anngalloway/UdemyLearning/advent_of_code/2024/src/main/resources/inputDay7"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Long>> results = getFile(scanFile);

    public static void main(String[] args) throws Exception {
        long part2result = 0;

        for (List<Long> lineFromResults : results) {
            part2result += checkLine(lineFromResults);
        }
        System.out.println(part2result);
    }



    public static List<List<Long>> getFile(Scanner localScanFile) {
        List<List<Long>> list = new ArrayList<>();
        while (localScanFile.hasNextLine()) {
            String line = localScanFile.nextLine().replace(":", "");
            List<Long> listOfLongs = Arrays.stream(line.split(" +")).map(Long::parseLong).toList();
            list.add(listOfLongs);
        }
        return list;
    }

    public static List<List<String>> generateOperatorCombinations(int numOperators) {
        List<List<String>> combinations = new ArrayList<>();
        String[] operators = {"+", "*", "||"};

        int totalCombinations = (int) pow(3, numOperators);

        for (int i = 0; i < totalCombinations; i++) {
            List<String> operatorsList = new ArrayList<>();
            for (int j = 0; j < numOperators; j++) {
                int operatorIndex = (i / (int) Math.pow(3, j)) % 3;
                operatorsList.add(operators[operatorIndex]);
            }
            combinations.add(operatorsList);
        }
        return combinations;
    }

    public static long checkLine(List<Long> listOfIntegers) {
        long total = listOfIntegers.getFirst();
        long operatorsCombination = 0;
        List<Long> listOfInputs = listOfIntegers.subList(1, listOfIntegers.size());
//        System.out.println(listOfInputs);
        List<List<String>> listOfOperatorCombinations = generateOperatorCombinations(listOfInputs.size()-1);
//        System.out.println(listOfOperatorCombinations);
        for (int i = 0; i < listOfOperatorCombinations.size(); i++) {
            operatorsCombination = listOfInputs.getFirst();
            for (int j = 0; j < listOfInputs.size()-1; j++) {
//                System.out.println(listOfOperatorCombinations.get(i).get(j));
                if (listOfOperatorCombinations.get(i).get(j) == "+") {
                    operatorsCombination += listOfInputs.get(j+1);
                } else if (listOfOperatorCombinations.get(i).get(j) == "*") {
                    operatorsCombination *= listOfInputs.get(j+1);
                } else {
                    operatorsCombination = Long.parseLong(String.valueOf(operatorsCombination)+listOfInputs.get(j+1));
                }
            }
            if (operatorsCombination == total) {
//                System.out.println("match");
                return total;
            }

        }
        return 0;
    }

}
