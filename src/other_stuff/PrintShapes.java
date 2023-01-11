package other_stuff;

public class PrintShapes {


    public void printTriangle(int dimension){

        //Initialize and Instantiate graphical symbol
        String symbol = "*";
        String space = "  ";

        //Initializing line types
        String intermediateLine;
        String topLine;
        String bottomLine;



    }

    public void printSquare(int dimension){

        //Initialize and Instantiate graphical symbol
        String symbol = "*  ";
        String endSymbol = "*";
        String space = "   ";

        //Initialize line types
        String fullLine;
        String intermediateLine;

        //Build fullLine
        fullLine = symbol.repeat(dimension-1);
        fullLine += endSymbol;

        //Build intermediateLine
        intermediateLine = symbol;
        intermediateLine += space.repeat(dimension-2);
        intermediateLine += endSymbol;

        for(int i = 0; i < dimension; i++){
            if(i == 0 || i == dimension - 1){
                System.out.println(fullLine);
            }else {
                System.out.println(intermediateLine);
            }
        }
    }

}
