package kenny;

/**
 * Created by Kenny on 5/18/2017.
 */
public class AlgoFactory {


    public static IAlgo getAlgo(int m, int n){
        if(m > 12 && n > 12){
            return new AdjacencyListAlgoParallel();
        }
        else
        {
            return new AdjacencyListAlgoNaive();
        }
    }
}
