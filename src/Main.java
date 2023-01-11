import other_stuff.PrintShapes;
import other_stuff.TestClass;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PrintShapes test = new PrintShapes();
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Input dimension of square");
            int dimension = scan.nextInt();
            test.printSquare(dimension);
        }
    }
}