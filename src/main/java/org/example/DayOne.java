package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DayOne {

    static int answer;
    static int currentPosition = 50;

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Paths.get("src/main/resources/One.txt"));
        String[] split = content.split("\n");

        for (String s : split) {
            System.out.println(s);
            int r = Integer.parseInt(s.replaceAll("[A-Z]", ""));
            currentPosition = partOne(s.replaceAll("[0-9]", "").equals("R") ? r : -1 * r);
//            currentPosition = partTwo(s.replaceAll("[0-9]", "").equals("R") ? r : -1 * r);
            System.out.println(currentPosition);
        }
        System.out.println("Your answer is: " + answer);
    }

    public static int partTwo(int steps){
        int fullRotations = steps / 100;
        hitZero(fullRotations);
        int actualMovement = steps % 100;

        int finalStep;
        int relativeStep = currentPosition + actualMovement;

        if (relativeStep > 99){
            hitZero(1);
            finalStep = (relativeStep % 99) -1;
        }
        else if (relativeStep < 0){
            if (currentPosition != 0){
                hitZero(1);
            }
            finalStep = 100 + relativeStep;
        }
        else finalStep = relativeStep;
        if (relativeStep != 100 && finalStep == 0) hitZero(1);
        return finalStep;
    }

    public static int partOne(int steps){
        int actualMovement = steps % 100;

        int finalStep;
        int relativeStep = currentPosition + actualMovement;

        if (relativeStep > 99){
            finalStep = (relativeStep % 99) -1;
        }
        else if (relativeStep < 0){
            finalStep = 100 + relativeStep;
        }
        else finalStep = relativeStep;
        if (finalStep == 0) hitZero(1);
        return finalStep;
    }

    public static void hitZero(int times){
        if (times > 0) System.out.println("We hit ZERO " + Math.abs(times) + " times");
        answer += Math.abs(times);
    }
}
