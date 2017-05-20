package kenny;

public class KnightJourney {

    private final IAlgo algo;
    private int startX;
    private int startY;

    private final IPiece knight;

    public KnightJourney(String m, String n, String x, String y) {
        int mInt = Integer.parseInt(m);
        int nInt = Integer.parseInt(n);
        startX = Integer.parseInt(x);
        startY = Integer.parseInt(y);

        // Choose best AdjacencyList Algo. maybe can use DI with Strategy pattern if necessary to change the algo.
        algo = AlgoFactory.getAlgo(mInt, nInt);
        Board board = new Board(mInt, nInt);
        knight = new Knight();
        knight.setBoard(board);
    }

    public void printSolution(){
        System.out.println("Using " + algo.getClass().getName());
        long startTime = System.nanoTime();
        algo.solve(startX, startY, knight);
        long endTime = System.nanoTime();
        Board b = knight.getBoard();
        System.out.println(b.toString());
        long durationMS = (endTime-startTime)/1000000;
        System.out.println("Solved in " + durationMS + "ms");
    }


    public static void main(String[] args) {
        System.out.println("Welcome to A Knight's Journey");
        KnightJourney knightJourney;
        try {
            knightJourney = new KnightJourney(args[0], args[1], args[2], args[3]);
        }catch (Exception e){
            System.out.println("Usage: java -jar KnightJourney-1.0.jar [m] [n] [x] [y]");
            return;
        }
        knightJourney.printSolution();

    }
}
