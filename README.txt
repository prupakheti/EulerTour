This program is DFS based approach for finding the eulerian path of a given Graph. The program first
check if the graph is Eulerian and there by proceeds to find the eulerian circuit.
The program runs in O(V+E) where V is the total number of vertices and E is the total number of edges in the graph.

There are two ways we can feed input to this program:


The two modes of input can be selected via command line argument. 
	java EulerTourDriver <arg1> <arg2>
	
	if arg1 is 1 it selects adj matrix mode of data reader else adj list mode
	arg2 if provided is file from which it reads the data otherwise the default input stream is console
	
	When both the arguments are missing it goes with adj list reader via console. 

1) Feed the adjacency matrix:
	the first line should contain the total number of cities ( say n )
	after that there will be n lines and each line should have n integers value
	
	For eg for 5 x 5 adj matrix  1
				5
			    0 1 1 1 1
			    1 0 1 1 1
			    1 1 0 1 1
			    1 1 1 0 1
			    1 1 1 1 0
			    

2) Feed the adj List:
	the first line should contain the total number of cities ( say n )
	after this we can have multiple lines with 2 integer values i j such that i and j have an edge connecting them. The data reader will stop scanning 
	whenever it encounters "end" string in a line.
		For eg for 5 x 5 above adjacency matrix 
		5
		0 1
		0 2
		0 3
		0 4
		1 2
		1 3
		1 4
		2 3
		2 4
		3 4
		end
		
The output of the given graph 

The Euler Tour of the given graph is : 
0 --> 3 --> 2 --> 4 --> 3 --> 1 --> 4 --> 0 --> 1 --> 2 --> 0 --> |end-
		
		

