package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DayThree {

    public static long answer = 0;

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Paths.get("src/main/resources/Three.txt"));
        String[] split = content.split("\n");

        List<String[]> list = Arrays.stream(split).map(x -> x.split("")).toList();
        for (String [] banks: list){
            answer += Long.parseLong(joltageFinderRecursive(banks,11));
        }
        System.out.println("Your answer is: " + answer);
    }

    public static String joltageFinder(String[] bank){
        int highestFirst = Integer.parseInt(bank[0]);
        int indexOfHighestFirst = 0;

        for (int i = 1; i < bank.length -1; i++){
            if (Integer.parseInt(bank[i]) > highestFirst) {
                highestFirst = Integer.parseInt(bank[i]);
                indexOfHighestFirst = i;
            }
        }
        int highestSecond = 0;
        int indexOfHighestSecond = indexOfHighestFirst + 1;
        for (int i = indexOfHighestSecond; i < bank.length; i++){
            if (Integer.parseInt(bank[i]) > highestSecond) {
                highestSecond = Integer.parseInt(bank[i]);
            }
        }
        return String.valueOf(highestFirst) + String.valueOf(highestSecond);
    }

    public static String joltageFinderRecursive(String[] bank, int times){
        if (times < 0) return "";
        int highestFirst = Integer.parseInt(bank[0]);
        int indexOfHighestFirst = 0;

        for (int i = 1; i < bank.length - times; i++){
            if (Integer.parseInt(bank[i]) > highestFirst) {
                highestFirst = Integer.parseInt(bank[i]);
                indexOfHighestFirst = i;
            }
        }
        times = times - 1;

        return String.valueOf(highestFirst) + joltageFinderRecursive(Arrays.copyOfRange(bank, indexOfHighestFirst + 1, bank.length), times);
    }


}
