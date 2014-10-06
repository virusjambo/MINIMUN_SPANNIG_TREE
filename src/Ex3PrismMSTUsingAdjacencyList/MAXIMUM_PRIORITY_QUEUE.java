package Ex3PrismMSTUsingAdjacencyList;

import java.util.Arrays;

public class MAXIMUM_PRIORITY_QUEUE {

    int[] nodeList=null;
    int heapSize=0;


    public MAXIMUM_PRIORITY_QUEUE(int[] nodeList, int size){
        this.nodeList=nodeList;
        this.heapSize=size;
    }

    void   MAX_HEAPIFFY(int i){
        int l=getLeft(i);
        int r=getRight(i);
        int largest;
        if(l>=0 && l<=heapSize-1 && nodeList[l]>nodeList[i]){
            largest= l;

        }else{
            largest= i;

        }
        if(r>=0 && r<=heapSize-1 && nodeList[r]>nodeList[largest]){
            largest= r;

        }
        if(largest!=i){
            int temp=nodeList[largest];
            nodeList[largest]=nodeList[i];
            nodeList[i]=temp;
            MAX_HEAPIFFY( largest);

        }


    }
    void BUILD_MAX_HEAP() {
        for (int i = ((heapSize) / 2); i >= 0; i--) {
            MAX_HEAPIFFY( i);
        }
    }

    int getParent(int i){
        return (i-1)/2;

    }
    int getLeft(int i){
        return 2*i+1 ;

    }
    int getRight(int i){
        return 2*i+2;

    }

    int EXTRACT_MAX() throws Exception {
     if(heapSize<0){
         throw new Exception("Heap Underflow");
     }
        int max=nodeList[0];
        nodeList[0]=nodeList[heapSize-1];
        heapSize--;
       MAX_HEAPIFFY(0);
        return max;

    }
    void HEAP_INCREASE_KEY(int pos,int value) throws Exception {
        if(nodeList[pos]>value){
            throw new Exception("Heap Underflow");
        }
        nodeList[pos]=value;
        while(pos>0 && nodeList[getParent(pos)]< nodeList[pos]){
            int temp=nodeList[getParent(pos)];
            nodeList[getParent(pos)]=nodeList[pos];
            nodeList[pos]=temp;
            pos=getParent(pos);
        }


    }

    void MAX_HEAP_INSERT(int keyValue) throws Exception {
        if(heapSize==nodeList.length){
            Arrays.copyOf(nodeList, nodeList.length+nodeList.length>>1);
        }
        heapSize++;
        nodeList[heapSize-1]=Integer.MIN_VALUE;
        HEAP_INCREASE_KEY(heapSize-1,keyValue);
    }

    public static void main(String a[]) throws Exception {
        int []arr= {4,5,6,7,8,9,0};
        MAXIMUM_PRIORITY_QUEUE hp=new MAXIMUM_PRIORITY_QUEUE(arr,7);
        hp.BUILD_MAX_HEAP();
        System.out.println("EXTRACTED MAX KEY:"+hp.EXTRACT_MAX());
        System.out.println("AFTER EXTRACTING MAX KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
        System.out.println();
        System.out.println("Increasing  KEY");
        hp.HEAP_INCREASE_KEY(3,15);
        System.out.println("AFTER Increasing  KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
        System.out.println();
        System.out.println("Inserting  KEY");
        hp.MAX_HEAP_INSERT(16);
        System.out.println("AFTER Inserting  KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
        System.out.println();
        System.out.println("EXTRACTED MAX KEY:"+hp.EXTRACT_MAX());
        System.out.println("AFTER EXTRACTING MAX KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
    }

}
