package eulertour;

import java.util.Scanner;

/**
 * This class reads the entire adjacency matrix from the given scanner
 * @author prupakheti
 *
 */
public class MatrixReaderGraph implements GraphReader{	
	UndirectedUnWeightedGraph G;
	
	@Override
	public	UndirectedUnWeightedGraph createGraph(Scanner sc) throws Exception{
		int n;
		System.out.println(" The first line should have an integer value n and  n x n adjacency matrix to follow " +
				"\n For eg for 3 x 3 adj matrix " +
				"\n 3"+
				"\n 0 1 1"+"\n 1 0 1"+"\n 1 1 0");
		try{
			n = Integer.parseInt(sc.nextLine());	
			G = new UndirectedUnWeightedGraph(n);
			
			for( int i = 0; i < n; ++i){
				for( int j = i+1; j < n; ++j){
					int flag = sc.nextInt();
					if( flag > 0)
						G.add(i, j);
				}
			}
		}
		catch(Exception e ){
			throw new Exception(e.toString());
		}
		return G;
	}



}
