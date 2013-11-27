package eulertour;

import java.util.List;

public class EulerCircuitTour {
	private UndirectedUnWeightedGraph G;// The graph for which we have to do euler tour
	private boolean [][]marked; // marks an edge. If an edge i<-->j is visited, marked[i][j] and marked[j][i] will be true	
	private Path finalPath; // Linked list of final eulerian path
	int totalMarkedEdges; // counts the total number of visited edges so far
	
	public EulerCircuitTour(UndirectedUnWeightedGraph G) {
		this.G = G;
		int v = G.vertices();
		marked = new boolean[v][v];
		finalPath = new Path();
	}
	
	/**
	 * 
	 * @return true if the graph is eulerian
	 * @throws Exception
	 */
	private boolean isEulerian() throws Exception{
		int V = G.vertices();
		boolean flag = true;
		List<Integer> adj;
		for( int v = 0; v < V; ++v ){
			adj = G.adj(v);
			if(adj.size() == 0 || adj.size() % 2 != 0 ){
				flag = false;
				break;
			}
		}
		return flag;		
	}
	
	/**
	 * 
	 * @param detour : detour is the point that splices the cyclis path found so far
	 * @param currPath : the current sub path
	 * @param w : the point we do recursive euler dfs
	 * @throws Exception
	 */
	private void eulerianDfs(PathNode detour, Path currPath, int w) throws Exception{
		currPath.add(w);
		if( w == detour.getData() ){
			detour.splice(currPath);	// We  completed a sub circuit and are  spliceing it into the detour point from where the circuit began.
		}
		else{
			int v = 0;
			boolean flag = false;
			for( int u : G.adj(w)){
				if(!marked[w][u]){
					marked[w][u] = true; marked[u][w] = true;					
					v = u;
					flag = true;
					++totalMarkedEdges;
					break;
				}
			}
			if( flag ){
				eulerianDfs(detour, currPath, v);
			}
		}
	}
	
	/**
	 * This method continiously builds the eulerial path by splicing technique.
	 * @throws Exception
	 */
	private void eulerTour() throws Exception{
		finalPath.add(0);
		int v = G.adj(0).get(0);
		marked[0][v] = true; marked[v][0] = true;
		++totalMarkedEdges;
		
		PathNode curr = finalPath.getCurrNode();
		eulerianDfs(curr, new Path(), v);
		
		while(totalMarkedEdges != G.edges() ){ //we loop until we visit all the edges			
			curr = finalPath.getCurrNode();
			int u = curr.getData();
			boolean flag = false;
			for(int w : G.adj(u)){
				if(!marked[u][w]){
					marked[u][w] = true; marked[w][u] = true;
					v = w;
					flag = true;
					++totalMarkedEdges;
					break;
				}
			}			
			if(flag){				
				eulerianDfs(curr, new Path(), v);	
			}
			finalPath.move();
		}
		
	}
	
	
	public Path tour() throws Exception{
		if(isEulerian()){
			eulerTour();
			return finalPath;
		}
		else{
			System.out.println("Given graph is not an eulerian graph.");
			return null;
		}
		
	}

}
