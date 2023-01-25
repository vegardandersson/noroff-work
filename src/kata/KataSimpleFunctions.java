package kata;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static int checkPasswordStrength(String password){

        //Color codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";

        //ErrorMessages for missing strength-characteristics
        String missingLowerCaseCharacter = "Needs at least 1 lower case letter";
        String missingUpperCaseCharacter = "Needs at least 1 upper case letter";
        String missingSpecialCharacter = "Needs at least 1 special character";
        String missingDigitCharacter = "Needs at least 1 digit";
        String missingLengthRequirement = "Password must be 8 or longer";

        //Elements for visually displaying password strength
        String strengthOutputString = "";
        String strongSegment = "|||||";
        String emptySegment = ".....";

        int strengthLevel = 0;

        //Container for special characters
        Pattern patternSpecialCharacters = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher containsSpecialCharacter = patternSpecialCharacters.matcher(password);

        boolean lowerCaseCharacter = false;
        boolean upperCaseCharacter = false;
        boolean specialCharacter = false;
        boolean digitCharacter = false;
        boolean lengthRequirement = false;

        for(int i = 0; i < password.length(); i++){
            char character = password.charAt(i);
            if(!lowerCaseCharacter){lowerCaseCharacter = Character.isLowerCase(character);}
            if(!upperCaseCharacter){upperCaseCharacter = Character.isUpperCase(character);}
            if(!specialCharacter){specialCharacter = containsSpecialCharacter.find();}
            if(!digitCharacter){digitCharacter = Character.isDigit(character);}
        }
        lengthRequirement = password.length() >= 8;

        StringBuilder builder = new StringBuilder();
        builder.append(ANSI_RED);
        if(!lowerCaseCharacter){builder.append(missingLowerCaseCharacter + "\n");}else{strengthLevel++;}
        if(!upperCaseCharacter){builder.append(missingUpperCaseCharacter + "\n");}else{strengthLevel++;}
        if(!specialCharacter){builder.append(missingSpecialCharacter + "\n");}else{strengthLevel++;}
        if(!digitCharacter){builder.append(missingDigitCharacter + "\n");}else{strengthLevel++;}
        if(!lengthRequirement){builder.append(missingLengthRequirement + "\n");}else{strengthLevel++;}

        strengthOutputString += "[" + strongSegment.repeat(strengthLevel) + emptySegment.repeat(5-strengthLevel) + "]";

        StringBuilder builder2 = new StringBuilder(strengthOutputString);
        if(strengthLevel == 5){builder2.insert(0, ANSI_GREEN);}
        else if (strengthLevel > 2){builder2.insert(0, ANSI_YELLOW);}
        else{builder2.insert(0, ANSI_RED);}

        System.out.println("\n" + builder2 + "\n");
        System.out.println(builder);
        if(strengthLevel == 5){System.out.println(ANSI_GREEN + "Strong password!");}

        return strengthLevel;
    }

    public static int sumDigProd(int num1, int num2){
        int sum = num1 + num2;
        return KataSimpleFunctions.sumRec(sum);
    }

    public static int sumRec(int sum){
        int[] digits = KataSimpleFunctions.splitNumber(sum);
        int answer = digits[0]*digits[1];
        if(answer > 10){
            sumRec(answer);
        } else {
            System.out.println(digits[0] + " * " + digits[1] + " = " + answer);
        }
        return digits[0]*digits[1];
    }

    public static int[] splitNumber(int num){
        String sumString = Integer.toString(num);
        int halfwayPoint = sumString.length() % 2 == 0 ? sumString.length()/2 : sumString.length()/2 + 1;
        return new int[]{
                Integer.parseInt(sumString.substring(0, halfwayPoint)),
                Integer.parseInt(sumString.substring(halfwayPoint))};
    }

    public static int romanToDecimal(String romanNumeral){
        Map<String, Integer> romanToDecimalMap = Map.of(
                "I", 1, "V", 5, "X", 10, "L",
                50, "C", 100, "D", 500, "M", 1000);
        int sum = 0;
        String[] symbols = romanNumeral.split("");
        if(symbols.length == 1){return romanToDecimalMap.get(symbols[0]);}
        for(int i = 0; i < symbols.length - 1; i++){
            int first = romanToDecimalMap.get(symbols[i]);
            int second = romanToDecimalMap.get(symbols[i+1]);
            if(first < second){
                sum += second-first;
                i++;
            }else if(i == (symbols.length - 2)){
                sum += first + second;
            }else{
                sum += first;
            }
        }
        return sum;
    }

}
