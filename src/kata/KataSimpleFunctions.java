package kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
