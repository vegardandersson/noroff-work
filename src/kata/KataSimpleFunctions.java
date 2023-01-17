package kata;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

public class KataSimpleFunctions {
    public static void fizzBuzz(int numOfLoops){

        String fizz = "Fizz";
        String buzz = "Buzz";
        String result;

        for(int i = 1; i < numOfLoops; i++){
            result = "";
            if(i % 3 == 0){
                result = result.concat(fizz);
            }
            if(i % 5 == 0){
                result = result.concat(buzz);
            }
            result = result.isEmpty() ? Integer.toString(i) : result;
            System.out.println(result);
        }
    }

    public static void findMaximumPairs(int[] inputArray){

        List<List<Integer>> allPairs = new ArrayList<>();
        List<Integer> differences = new ArrayList<>();
        List<List<Integer>> resultPairs = new ArrayList<>();

        for(int i = 1; i < inputArray.length; i++) {
            for (int j = 0; j < i; j++) {
                allPairs.add(new ArrayList<>(Arrays.asList(inputArray[j], inputArray[i])));
                differences.add(inputArray[i] - inputArray[j]);
            }
        }
        int maxDifference = Collections.max(differences);
        for(int i = 0; i < differences.size(); i++){
            if(differences.get(i) == maxDifference){
                resultPairs.add(allPairs.get(i));
            }
        }

        List<List<Integer>> maxSumPairs = KataSimpleFunctions.findPairsThatSumToMaxDifference(inputArray, maxDifference);


        //Printing results
        for(int i = 0; i < resultPairs.size(); i++){
            System.out.println(resultPairs.get(i).get(1) +
                    " - " + resultPairs.get(i).get(0) +
                    " = " + (resultPairs.get(i).get(1) - resultPairs.get(i).get(0)));
        }
        System.out.println("\n");
        for(int i = 0; i < maxSumPairs.size(); i++){
            System.out.println(maxSumPairs.get(i).get(0) +
                    " + " + maxSumPairs.get(i).get(1) +
                    " = " + (maxSumPairs.get(i).get(1) + maxSumPairs.get(i).get(0)));
        }
    }

    public static List<List<Integer>> findPairsThatSumToMaxDifference(int[] inputArray, int maxDifference){

        List<List<Integer>> resultPairs = new ArrayList<List<Integer>>();

        for(int i = 0; i < inputArray.length - 2; i++) {
            for (int j = inputArray.length - 1; j > i; j--) {
                if(inputArray[i] + inputArray[j] == maxDifference){
                    resultPairs.add(new ArrayList<>(Arrays.asList(inputArray[i], inputArray[j])));
                }
            }
        }
        return resultPairs;
    }

    public static String toCamelCase(String input){
        StringBuilder builder = new StringBuilder();
        String[] splitString = input.split("_");
        builder.append(splitString[0]);
        for(int i = 1; i < splitString.length; i++){
            builder.append(splitString[i].substring(0, 1).toUpperCase() + splitString[i].substring(1));
        }
        return builder.toString();
    }

    public static String toSnakeCase(String input){
        StringBuilder builder = new StringBuilder();
        String[] splitString = input.split("(?=\\p{Lu})");
        builder.append(splitString[0]);
        for(int i = 1; i < splitString.length; i++){
            builder.append("_");
            builder.append(splitString[i].toLowerCase());
        }
        return builder.toString();
    }

    public static List<String> findFridayTheThirteenth(int year){

        List<String> fridays = new ArrayList<>();
        LocalDate day = LocalDate.of(year, 1, 1);

        while(day.getDayOfWeek() != DayOfWeek.FRIDAY){
            day = day.plusDays(1);
        }

        while(day.getYear() != year+1){
            if(day.getDayOfMonth() == 13){
                fridays.add(day.toString());
            }
            day = day.plusDays(7);
        }

        return fridays;
    }

    public static List<Integer> findYearWithMostFridayTheThirteenths(int[] range){
        List<Integer> numOfFridays = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = range[0]; i < range[1]+1; i++){
            numOfFridays.add(findFridayTheThirteenth(i).size());
        }
        int maxNumber = Collections.max(numOfFridays);
        for(int i = 0; i < numOfFridays.size(); i++){
            if(numOfFridays.get(i) == maxNumber){
                result.add(i+range[0]);
            }
        }
        return result;
    }

}
