package day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static day6.part1.goDown;
import static day6.part1.goLeft;
import static day6.part1.goRight;
import static day6.part1.goUp;

public class part2 {
    static List<List<Character>> map = part1.startMap;
    static List<Object> start = part1.start;

    public static void main(String[] args) {
        int countOfInfiniteLoops = 0;
        //come back later and work out why it breaks immediately above the starting point
        map.get(64).set(85,',');
        for (int i=0; i<map.size(); i++) {
            for (int j=0; j<map.get(i).size(); j++) {
                System.out.printf("location: %d, %d\n", i, j);
                if (map.get(i).get(j) == '.') {
                    map.get(i).set(j, '#');
                    List<Object> startCopy = List.of(start.get(0), start.get(1), start.get(2));
                    if (checkForInfiniteLoop(map, startCopy)) {
                        System.out.println("loop");
                        countOfInfiniteLoops++;
                    }
                    map.get(i).set(j, '.');
                }
            }
        }
//        System.out.println(checkForInfiniteLoop(map,start));
//        System.out.println(start);
//        map.get(6).set(3,'#');
//        System.out.println(checkForInfiniteLoop(map,start));
        System.out.println(countOfInfiniteLoops);
    }

    public static boolean checkForInfiniteLoop (List<List<Character>> map, List<Object> localStart) {
        Set<Object> locations = new HashSet<>();
        boolean loop = false;
        while ((int) localStart.get(0) != 0 && (int) localStart.get(1) != 0 && (int) localStart.get(0) != map.size() - 1 && (int) localStart.get(1) != map.get(0).size() - 1) {
            if (localStart.get(2) == "up") {
                if(!locations.add(localStart)) {
                    loop = true;
                    break;
                }
                localStart = goUp(map, localStart);
            }
            if (localStart.get(2) == "down") {
                if(!locations.add(localStart)) {
                    loop = true;
                    break;
                }
                localStart = goDown(map, localStart);
            }
            if (localStart.get(2) == "left") {
                if(!locations.add(localStart)) {
                    loop = true;
                    break;
                }
                localStart = goLeft(map, localStart);
            }
            if (localStart.get(2) == "right") {
                if(!locations.add(localStart)) {
                    loop = true;
                    break;
                }
                localStart = goRight(map, localStart);
            }
        }
        return loop;
    }

}
