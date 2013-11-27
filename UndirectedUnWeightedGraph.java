package eulertour;

import java.util.ArrayList;
import java.util.List;

public class UndirectedUnWeightedGraph {
	private int V; // total number of vertices. vertex number ranges from 0 to V-1
	private int E; // total number of edges
	private List<Integer> []adjs; // adjacency list. adj[i] is a list of vertex of all neighbors of vertex i
	
	@SuppressWarnings("unchecked")
	public UndirectedUnWeightedGraph(int V){
		this.V = V;
		adjs = new List[V];
		for( int i = 0; i < V; ++i ){
			adjs[i] = new ArrayList<Integer>();
		}
	}
	
	public int vertices(){
		return V;
	}
	public int edges(){
		return E;
	}
	/**
	 * 
	 * @param v : the vertex of which the neighbors are to be returned
	 * @return : the list of neighbors of vertex v
	 * @throws Exception if v is invalid vertex
	 */
	public List<Integer> adj(int v) throws Exception{
		if( v < 0 || v >= V) throw new Exception("Invalid Vertex "+v);
		return adjs[v];
	}
	
	/**
	 * 
	 * @param u the first vertex of the edge u<-->v
	 * @param v the second vertex of the edge u<-->v
	 * @throws Exception if u and v are invalid
	 */
	public void add(int u, int v) throws Exception{
		if( v < 0 || v >= V) throw new Exception("Invalid Vertex "+v);
		if( u < 0 || u >= V) throw new Exception("Invalid Vertex "+u);
		if( !adjs[u].contains(v) && !adjs[v].contains(u)){
			adjs[u].add(v);
			adjs[v].add(u);			
			++E;
		}		
	}
	

}
