package Ex1KruskalMST;

public class KruskalMST {
	// what kruskal MST says
	// arrange all vertices in
	// increasing order of there weights
	// you can use merge sort for this(For java comparable and comparator (I
	// prefer my own implementation so we can control time complexity))
	// pick a minimum weight edge and check for cycle .
	// use union find algo for that

	// k lets use merge sort for our implementation

	// for this algo we don't need to represent edges as Adjacency List or
	// matrix.
	// for simplicity I am going with linked list(so dynamically I can add
	// edges) .You can go with array.
	// For java go with set or priority queue
     
	Node edges = null;
	int nodeCount=0;
	void addEdge(int source, int dest, int weight) {
		nodeCount++;
		if (edges == null) {
			edges = new Node(source, dest, weight, null);

		} else {
			edges = new Node(source, dest, weight, edges);
		}
	}
	
	void performMST(){
		UnionFindAlgorithm uf=new UnionFindAlgorithm(nodeCount);
		MergeSort mg=new MergeSort();
		Node head=null;
		head=mg.merge(edges);
		while(head!=null){
			uf.perfomFindAndUnionOnVertices(head.source,head.destination);
	
			head=head.nextRef;
			
			
		}
		
	}
	
	public static void main(String[] args) {
        KruskalMST mst=new KruskalMST();
        mst.addEdge(0,1,3);
		mst.addEdge(1,4,3);
		mst.addEdge(1,2,5);
		mst.addEdge(0,2,6);
		mst.addEdge(2,3,1);
		mst.addEdge(3,0,2);
		
		
		mst.performMST();
		
		
		
	}

}
