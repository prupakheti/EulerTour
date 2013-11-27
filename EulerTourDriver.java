package eulertour;

import java.io.File;
import java.util.Scanner;


public class EulerTourDriver {		
	public static void main(String[] args) throws Exception{		
		Scanner sc = new Scanner(System.in);
		GraphReader graphReader = new PairReaderGraph();
		if( args.length > 0 ){
			if(args[0] != null && "1".equals(args[0])){
				graphReader = new MatrixReaderGraph();
			}
			if(args.length > 1 && args[1] != null){
				try{
					sc = new Scanner(new File(args[1]));
				}
				catch(Exception e){
					sc = new Scanner(System.in);
				}
			}
		}
		UndirectedUnWeightedGraph G = graphReader.createGraph(sc);
		EulerCircuitTour eulerCircuitTour = new EulerCircuitTour(G);
		Path eulerCircuitPath = eulerCircuitTour.tour();
		System.out.println("The Euler Tour of the given graph is : ");
		eulerCircuitPath.printPath();
	}

}
