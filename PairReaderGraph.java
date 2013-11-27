package eulertour;

import java.util.Scanner;

/**
 * 
 * @author prupakheti
 * This class creates the UndirectedWeightedGraph from the given scanner based on city pairing
 */
public class PairReaderGraph implements GraphReader{
	
	UndirectedUnWeightedGraph G;	
	private int size;
	@Override
	public UndirectedUnWeightedGraph createGraph(Scanner sc) throws Exception {
		if( sc == null ) throw new Exception("Invalid data scanner");
		System.out.println(" EulerTour console data reader. The first line should be entered as the value for the total number of cities. \n" +
				"The subsequent line should contains " +
				"pair< i j > which indicates there is an edge between city i and j");
		String line;
		if(sc.hasNext()){
			try{
				line = sc.nextLine();
				int n = Integer.parseInt(line);
				size = n;
				G = new UndirectedUnWeightedGraph(n);
				
				
				while( true ){
					line = sc.nextLine();
					if("end".equals(line)) break;
					if(line == null || line.trim().equals("") || !validate(line)) continue;	
					
				}
			}			
			catch (Exception e){
				throw new Exception(e.toString());
			}			
			
		}
		return G;
	}


	
	private boolean validate(String line){
		String []tokens = line.split("\\s+");
		
		if(tokens.length != 2) {
			System.out.println(" Invaid entry. Moving on to read next line of data ");
			return false;
		}
		try{
			int i = Integer.parseInt(tokens[0]);
			int j = Integer.parseInt(tokens[1]);	
			
			if( i < 0 || i >= size ) {
				System.out.println(" Invalid start index for city. Moving on to read next line of data ");
				return false;
			}
			if( j < 0 || j >= size ) {
				System.out.println(" Invalid end index for city. Moving on to read next line of data ");
				return false;
			}			
			if( i == j ){
				System.out.println(" Self edge should be avoided. Moving on to read next line of data");
			}
			else{
				G.add(i, j);
			}
		
		}
		catch(Exception e){
			System.out.println(" Not an integer. Moving on to read next line of data ");
			return false;
		}			
		return true;
	}

}
