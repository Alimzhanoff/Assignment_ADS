Assignment #4 
Group: IT-2504
Student name: Alimzhan Adilzhan

Graph Traversal and Representation System
A. Project Overview
This project focuses on the implementation and analysis of a graph data structure using Java. The goal is to represent vertices and edges effectively and compare the performance of fundamental traversal algorithms.  Graph Structure: I used an Adjacency List to store the graph, which is efficient for memory and vertex lookup. 

Vertices and Edges: A vertex represents a unique node, while an edge represents the connection (directed or undirected) between two nodes.  BFS and DFS: These are the two primary ways to explore a graph's structure, each with distinct behaviors and use cases. 

B. Class Descriptions
The project is divided into several classes to maintain a clean OOP structure:  Vertex: A class representing a node with a unique id.  Edge: A class representing a connection between a source and a destination vertex.  Graph: The core class that manages the Adjacency List and handles the logic for adding vertices/edges and performing traversals. 
Experiment: A utility class used to automate the testing of different graph sizes and measure execution time. 


C. Algorithm Descriptions
BFS (Breadth-First Search)Step-by-step: BFS starts at a source node, visits all its immediate neighbors, and then moves to the next level of neighbors. 
I used a Queue and a Set to track visited nodes.  Use cases: Finding the shortest path in unweighted graphs or social network analysis.
Time Complexity: O(V + E). 

DFS (Depth-First Search)Step-by-step: DFS starts at a source node and explores as far as possible along each branch before backtracking. This was implemented using recursion.  Use cases: Detecting cycles, topological sorting, or solving puzzles like mazes.  Time Complexity: O(V + E).

D. Experimental Results
I performed experiments on three graph sizes to observe how scale affects performance.


Graph Size	     BFS Execution Time (ns)	    DFS Execution Time (ns)
10 vertices	     ~52,000	                    ~45,000
30 vertices	     ~135,000	                    ~110,000
100 vertices	   ~480,000	                    ~430,000


Observations:
Both BFS and DFS show a linear increase in execution time as the number of vertices and edges increases, which aligns with the theoretical complexity of O(V+E).  

In my tests, DFS was slightly faster than BFS, likely due to the lower overhead of recursive calls compared to managing a Queue object


E. Reflection Section
During this assignment, I learned how to represent complex relationships using adjacency lists and realized how choice of data structure impacts search efficiency. The main difference I noticed is that BFS is better for "wide" searches, while DFS is more natural for "deep" exploration. One challenge I faced was ensuring that the visited set correctly prevented infinite loops in the recursive DFS, especially as the graph size grew to 100 vertices.






