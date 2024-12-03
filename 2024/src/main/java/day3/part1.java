package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class part1 {

    public static Scanner scanFile;

    static {
        try {
            scanFile = new Scanner(new File("resources/inputDay3"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringBuilder result = getInput(scanFile);

    private part1() {
    }

    public static void main(String[] args) throws Exception {

        int answer = getAnswer(result.toString());
        System.out.println(answer);
    }

    public static int findAnswer(List<Integer> numbersList) {
        int answer = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 2 == 0) {
                answer += numbersList.get(i) * numbersList.get(i + 1);
            }
        }
        return answer;
    }

    public static List<Integer> convertToNumberList(String multiplyThese) {
        List<Integer> numbersList = new ArrayList<>();

        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(multiplyThese);
        while (numberMatcher.find()) {
            numbersList.add(Integer.parseInt(numberMatcher.group()));
        }
        return numbersList;
    }

    public static StringBuilder getInput(Scanner scanFile) {
        StringBuilder result = new StringBuilder();
        while (scanFile.hasNext()) {
            result.append(scanFile.nextLine());
        }
        return result;
    }

    public static String getValidInputs(String input) {
        StringBuilder multiplyThese = new StringBuilder();
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            multiplyThese.append(matcher.group(0));
        }
        return multiplyThese.toString();
    }

    public static int getAnswer(String input) {

        String multiplyThese = getValidInputs(input);

        List<Integer> numbersList = convertToNumberList(multiplyThese);

        return findAnswer(numbersList);
    }


}
