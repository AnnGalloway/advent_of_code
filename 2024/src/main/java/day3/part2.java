package day3;

import java.util.regex.Pattern;

public class part2 {

    public static StringBuilder input = part1.result;
    public static void main(String[] args) throws Exception {

        Pattern patternRemove = Pattern.compile("don't\\(\\).*?do\\(\\)");
        String string = patternRemove.matcher(input.toString()).replaceAll("");

        String newString = Pattern.compile("don't\\(\\).*").matcher(string).replaceAll("");

        System.out.println(part1.getAnswer(newString));





    }

}
