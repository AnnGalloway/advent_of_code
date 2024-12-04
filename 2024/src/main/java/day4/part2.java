package day4;

import java.util.List;

public class part2 {

    public static List<List<Character>> lists = part1.lists;

    public static void main(String[] args) {

        System.out.print(findDiagonal(lists));

    }

    public static int findDiagonal(List<List<Character>> listOfLists) {
        List<Character> xmas = List.of('M', 'A', 'S');
        int diagonal = 0;
        for (int i = 1; i < listOfLists.size()-1; i++) {
            for (int j = 1; j < listOfLists.get(i).size()-1; j++) {
                if (listOfLists.get(i).get(j) == xmas.get(1)) {
                    if (((listOfLists.get(i - 1).get(j - 1) == xmas.get(0)) &&
                         (listOfLists.get(i + 1).get(j + 1) == xmas.get(2))) ||
                        ((listOfLists.get(i - 1).get(j - 1) == xmas.get(2)) &&
                         (listOfLists.get(i + 1).get(j + 1) == xmas.get(0)))) {
                        if (((listOfLists.get(i - 1).get(j + 1) == xmas.get(2)) &&
                             (listOfLists.get(i + 1).get(j - 1) == xmas.get(0))) ||
                            ((listOfLists.get(i - 1).get(j + 1) == xmas.get(0)) &&
                             (listOfLists.get(i + 1).get(j - 1) == xmas.get(2)))) {
                            diagonal++;
                        }
                    }
                }
            }
        }
        return diagonal;

    }

}
