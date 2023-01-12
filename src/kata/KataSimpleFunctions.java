package kata;

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
}
