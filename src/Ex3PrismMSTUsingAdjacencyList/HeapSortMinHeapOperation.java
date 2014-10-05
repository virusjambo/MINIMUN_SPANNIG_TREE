package Ex3PrismMSTUsingAdjacencyList;

/**
 * Created by user on 05-10-2014.
 */

public class HeapSortMinHeapOperation {
    int[] nodeList=null;
    int heapSize=0;


    public HeapSortMinHeapOperation(int[] nodeList, int size){
        this.nodeList=nodeList;
        this.heapSize=size;
    }

    void   MIN_HEAPIFFY( int[] nodeList,int i){
        int l=getLeft(i);
        int r=getRight(i);
        int largest;
        if(l>=0 && l<=heapSize-1 && nodeList[l]<nodeList[i]){
            largest= l;

        }else{
            largest= i;

        }
        if(r>=0 && r<=heapSize-1 && nodeList[r]<nodeList[largest]){
            largest= r;

        }
        if(largest!=i){
            int temp=nodeList[largest];
            nodeList[largest]=nodeList[i];
            nodeList[i]=temp;
            MIN_HEAPIFFY(nodeList, largest);

        }


    }

    void BUILD_MIN_HEAP(int[] nodeList){
        for(int i=((heapSize)/2);i>=0;i--) {
            MIN_HEAPIFFY(nodeList,i);
        }


    }


    void HEAP_SORT(int[] nodeList){
        BUILD_MIN_HEAP(nodeList);
        for(int i=nodeList.length-1;i>=1;i--) {
            int temp=nodeList[0];
            nodeList[0]=nodeList[i];
            heapSize--;
            nodeList[i]=temp;
            MIN_HEAPIFFY(nodeList, 0);

        }

    }


    int getParent(int i){
        return i/2-1;

    }
    int getLeft(int i){
        return 2*i+1 ;

    }
    int getRight(int i){
        return 2*i+2;

    }

    public static void main(String a[]){
        int []arr= {4,5,6,7,8,9,0};
        HeapSortMinHeapOperation hp=new HeapSortMinHeapOperation(arr,7);
        hp.HEAP_SORT(hp.nodeList);
        System.out.println("OUTPUT");
        for(int i=0;i<=hp.nodeList.length-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
    }


}