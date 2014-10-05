package Ex1KruskalMST;

class Node{
	int source;
	int destination;
	int weight;
	Node nextRef;
	
public 	Node(int s,int d,int w,Node nextRef){
		this.source=s;
		this.destination=d;
		this.weight=w;
		this.nextRef=nextRef;
		
	}		
}