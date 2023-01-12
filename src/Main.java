import other_stuff.PrintShapes;
import other_stuff.TestClass;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Input dimension of square");
            int dimension = scan.nextInt();
            PrintShapes.printSquare(dimension);
        }
    }
}