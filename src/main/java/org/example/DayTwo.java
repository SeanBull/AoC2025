package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DayTwo {

    public static long answer = 0;

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Paths.get("src/main/resources/Two.txt"));
        String[] split = content.split(",");


        List<String[]> list = Arrays.stream(split).map(x -> x.split("-")).toList();

        for (String [] ranges: list){
            long[] range = range(Long.parseLong(ranges[0]), Long.parseLong(ranges[1]));

            for (Long i: range){
//                if (isDouble(i.toString())) answer += i;
                if (i.toString().matches("(\\d+)\\1+")) answer += i;
            }
        }

        System.out.println("Your answer is: " + answer);
    }

    public static Boolean isDouble(String number){
        System.out.println(number);
        String first = number.substring(0, number.length() / 2);
        String second = number.substring((number.length() / 2));
        System.out.println(first + " " + second);
        return first.equals(second);
    }

    public static long[] range(long start, long end) {
        if (end < start) {
            throw new IllegalArgumentException("end must be >= start");
        }
        if (end - start + 1 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Range too large to fit in an array");
        }
        int size = (int) (end - start + 1);
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = start + i;
        }
        return arr;
    }

}
