package Ex3PrismMSTUsingAdjacencyList;

class Node{
    int source;
    int destination;
    int weight;


    public 	Node(int s,int d,int w,Node nextRef){
        this.source=s;
        this.destination=d;
        this.weight=w;


    }
}