package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class part1 {

    static Scanner scanFile;

    static {
        try {
            scanFile = new Scanner(new File("/Users/anngalloway/UdemyLearning/advent_of_code/2024/src/main/resources/inputDay4"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Character>> lists = listOfLists(scanFile);

    public part1() throws FileNotFoundException {
    }

    public static void main(String[] args) throws Exception {

        int answer = 0;
        answer += findHorizontal(lists);
        System.out.println(answer);
        answer += findVertical(lists);
        answer += findDiagonal(lists);
        System.out.println(answer);

    }

    public static List<List<Character>> listOfLists(Scanner input){
        List<List<Character>> listOfLists = new ArrayList<>();
        while (input.hasNext()) {
            for (String line : input.nextLine().split(" ")) {
                List<Character> list = new ArrayList<>();
                for (char letter : line.toCharArray()) {
                    list.add(letter);
                }
                listOfLists.add(list);
            }
        }
        return listOfLists;
    }

    public static int findHorizontal (List<List<Character>> listOfLists) {
        List<Character> xmas = List.of('X','M','A','S');
        List<Character> samx = List.of('S','A','M','X');
        int horizontal = 0;
        for (List<Character> list : listOfLists) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 3) {
                    if (list.subList(i, i + 4).equals(xmas) || list.subList(i, i + 4).equals(samx)) {
                        horizontal += 1;
                    }
                }
            }
        }
        return horizontal;
    }

    public static int findVertical (List<List<Character>> listOfLists) {
        List<Character> xmas = List.of('X','M','A','S');
        List<Character> samx = List.of('S','A','M','X');
        int vertical = 0;
        for (int i = 0; i < listOfLists.size()-3; i++) {
            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                if ((listOfLists.get(i).get(j).equals(xmas.getFirst()) &&
                    listOfLists.get(i+1).get(j).equals(xmas.get(1)) &&
                    listOfLists.get(i+2).get(j).equals(xmas.get(2)) &&
                    listOfLists.get(i+3).get(j).equals(xmas.get(3))) ||
                    (listOfLists.get(i).get(j).equals(samx.getFirst()) &&
                     listOfLists.get(i+1).get(j).equals(samx.get(1)) &&
                     listOfLists.get(i+2).get(j).equals(samx.get(2)) &&
                     listOfLists.get(i+3).get(j).equals(samx.get(3)))) {
                    vertical += 1;
                }
            }
        }
        return vertical;
    }

    public static int findDiagonal (List<List<Character>> listOfLists) {
        List<Character> xmas = List.of('X','M','A','S');
        List<Character> samx = List.of('S','A','M','X');
        int diagonal = 0;
        for (int i = 0; i < listOfLists.size()-3; i++) {
            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                if (j < listOfLists.get(i).size()-3) {
                    if ((listOfLists.get(i).get(j).equals(xmas.getFirst()) &&
                         listOfLists.get(i+1).get(j+1).equals(xmas.get(1)) &&
                         listOfLists.get(i+2).get(j+2).equals(xmas.get(2)) &&
                        listOfLists.get(i+3).get(j+3).equals(xmas.get(3))) ||
                        (listOfLists.get(i).get(j).equals(samx.getFirst()) &&
                         listOfLists.get(i+1).get(j+1).equals(samx.get(1)) &&
                         listOfLists.get(i+2).get(j+2).equals(samx.get(2)) &&
                         listOfLists.get(i+3).get(j+3).equals(samx.get(3)))) {
                        diagonal += 1;
                    }
                }
                if (j > 2) {
                    if ((listOfLists.get(i).get(j).equals(xmas.getFirst()) &&
                        listOfLists.get(i+1).get(j-1).equals(xmas.get(1)) &&
                        listOfLists.get(i+2).get(j-2).equals(xmas.get(2)) &&
                        listOfLists.get(i+3).get(j-3).equals(xmas.get(3))) ||
                        (listOfLists.get(i).get(j).equals(samx.getFirst()) &&
                         listOfLists.get(i+1).get(j-1).equals(samx.get(1)) &&
                         listOfLists.get(i+2).get(j-2).equals(samx.get(2)) &&
                         listOfLists.get(i+3).get(j-3).equals(samx.get(3)))) {
                        diagonal += 1;
                    }
                }
            }
        }
        return diagonal;
    }
}
