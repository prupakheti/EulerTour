package eulertour;

import java.util.Scanner;

/**
 * 
 * @author prupakheti
 * An interface that reads adjacency matrix for a graph.
 *
 */
public interface GraphReader {
	UndirectedUnWeightedGraph createGraph(Scanner sc) throws Exception;
}
