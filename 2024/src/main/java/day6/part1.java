package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class part1 {

    static Scanner scanFile;
    static {
        try {
            scanFile = new Scanner(new File("/Users/anngalloway/UdemyLearning/advent_of_code/2024/src/main/resources/inputDay6"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Character>> startMap = createMap(scanFile);
    public static List<Object> start = findStartingPosition(startMap);

    public static void main(String[] args) throws Exception {
        List<List<Character>> endMap = iterateMap(startMap, start);

        int countPositions = 1;
        for (List<Character> row : endMap) {
            for (char character : row) {
                if (character == 'X') {
                    countPositions++;
                }
            }
        }
        System.out.println(countPositions);
    }

    public static List<List<Character>> createMap (Scanner scanFile) {
        List<List<Character>> map = new ArrayList<>();
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            List<Character> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                row.add(line.charAt(i));
            }
            map.add(row);
        }
        return map;
    }

    public static List<Object> findStartingPosition (List<List<Character>> map) {
        List<Object> startingPosition = new ArrayList<>();
        for (List<Character> row : map) {
            for (Character character : row) {
                if (character == '^') {
                    startingPosition.add(map.indexOf(row));
                    startingPosition.add(row.indexOf(character));
                    startingPosition.add("up");
                    break;
                }
            }
        }
        return startingPosition;
    }

    public static List<Object> goUp (List<List<Character>> map, List<Object> startingPosition) {
        List<Object> nextPosition = new ArrayList<>(List.copyOf(startingPosition));
        nextPosition.set(0, (int) startingPosition.getFirst() - 1);
        if (map.get((int) nextPosition.get(0)).get((int) nextPosition.get(1)) == '#') {
            startingPosition.set(2, "right");
            return startingPosition;
        }
        return nextPosition;
    }

    public static List<Object> goRight (List<List<Character>> map, List<Object> startingPosition) {
        List<Object> nextPosition = new ArrayList<>(List.copyOf(startingPosition));
        nextPosition.set(1, (int) startingPosition.get(1) + 1);
        if (map.get((int) nextPosition.get(0)).get((int) nextPosition.get(1)) == '#') {
            startingPosition.set(2, "down");
            return startingPosition;
        }
        return nextPosition;
    }

    public static List<Object> goDown (List<List<Character>> map, List<Object> startingPosition) {
        List<Object> nextPosition = new ArrayList<>(List.copyOf(startingPosition));
        nextPosition.set(0, (int) startingPosition.getFirst() + 1);
        if (map.get((int) nextPosition.get(0)).get((int) nextPosition.get(1)) == '#') {
            startingPosition.set(2, "left");
            return startingPosition;
        }
        return nextPosition;
    }

    public static List<Object> goLeft (List<List<Character>> map, List<Object> startingPosition) {
        List<Object> nextPosition = new ArrayList<>(List.copyOf(startingPosition));
        nextPosition.set(1, (int) startingPosition.get(1) - 1);
        if (map.get((int) nextPosition.get(0)).get((int) nextPosition.get(1)) == '#') {
            startingPosition.set(2, "up");
            return startingPosition;
        }
        return nextPosition;
    }

    public static List<List<Character>> iterateMap (List<List<Character>> map, List<Object> start) {
        while ((int)start.get(0) != 0 && (int)start.get(1) != 0 && (int)start.get(0) != map.size()-1 && (int)start.get(1) != map.get(0).size()-1) {
            if (start.get(2) == "up") {
                map.get((int) start.get(0)).set((int) start.get(1), 'X');
                start = goUp(map, start);
            }
            if (start.get(2) == "down") {
                map.get((int) start.get(0)).set((int) start.get(1), 'X');
                start = goDown(map, start);
            }
            if (start.get(2) == "left") {
                map.get((int) start.get(0)).set((int) start.get(1), 'X');
                start = goLeft(map, start);
            }
            if (start.get(2) == "right") {
                map.get((int) start.get(0)).set((int) start.get(1), 'X');
                start = goRight(map, start);
            }
        }
        return map;
    }

}
