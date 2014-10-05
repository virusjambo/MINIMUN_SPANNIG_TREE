package Ex1KruskalMST;

public class UnionFindAlgorithm {
	///You can find different approaches for this algo 
	//here is one
	
	//if N is number of nodes then size of the our temp array will be N
	
	int arr[];
	public UnionFindAlgorithm(int size){
		arr=new int[size];
		for(int i=0;i<size;i++){
			arr[i]=i;
			
		}
	}
	
	int find(int x){
		if(arr[x]==x)
			return x;
		arr[x]=find(arr[x]);
		return arr[x];
		
	}
	
	void union(int x,int y){
		arr[find(x)]=arr[find(y)];
	}
	
	void perfomFindAndUnionOnVertices(int x,int y){
		int tempX=find(x);
		int tempY=find(y);
		if(tempX!=tempY){
			union(x,y);
			System.out.println("source:"+x+"Destination:"+y);
		}
		
	}
	
	
	
	
	

}
