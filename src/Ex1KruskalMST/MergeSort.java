package Ex1KruskalMST;

public class MergeSort {
	
	Node  merge(Node source){
		if(source ==null ||source.nextRef==null)
		return source;
		Node middle=middleOfLS(source);
		Node temp=middle.nextRef;
		middle.nextRef=null;
		System.out.println("middle:"+middle.source);
	 
		Node h1= merge(source);
		Node h2=merge(temp);
		
		return mergeSort(h1,h2);
		
	}
	
	
	Node middleOfLS(Node source){
		Node temp=source;
		Node temp1=source;
		
		while(temp1.nextRef!=null && temp1.nextRef.nextRef!=null  ){
			temp=temp.nextRef;
			temp1=temp1.nextRef.nextRef;						
		}
		
		return temp;
		
		
	}
	
	Node  mergeSort(Node temp,Node temp1){
		
		Node result=null;
				if(temp==null)
					return temp1;
		if(temp1==null)
			return temp;
		if(temp.weight<=temp1.weight){
			result=temp;
			result.nextRef=mergeSort(temp.nextRef,temp1);
		}else{
			result=temp1;
			result.nextRef=mergeSort(temp,temp1.nextRef);	
		}
		return result;
		}

		

}
