package Ex3PrismMSTUsingAdjacencyList;


public class MINIMUM_PRIORITY_QUEUE {

    int[] nodeList=null;
    int heapSize=0;


    public MINIMUM_PRIORITY_QUEUE(int[] nodeList, int size){
        this.nodeList=nodeList;
        this.heapSize=size;
    }

    void   MIN_HEAPIFFY(int i){
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
            MIN_HEAPIFFY( largest);

        }


    }
    void BUILD_MIN_HEAP() {
        for (int i = ((heapSize) / 2); i >= 0; i--) {
            MIN_HEAPIFFY( i);
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

    int EXTRACT_MIN() throws Exception {
        if(heapSize<0){
            throw new Exception("Heap Underflow");
        }
        int max=nodeList[0];
        nodeList[0]=nodeList[heapSize-1];
        heapSize--;
        MIN_HEAPIFFY(0);
        return max;

    }
    void HEAP_DECREASE_KEY(int pos,int value) throws Exception {
        if(nodeList[pos]<value){
            throw new Exception("Heap Underflow");
        }
        nodeList[pos]=value;
        while(pos>0 && nodeList[getParent(pos)]> nodeList[pos]){
            int temp=nodeList[getParent(pos)];
            nodeList[getParent(pos)]=nodeList[pos];
            nodeList[pos]=temp;
            pos=getParent(pos);
        }


    }



    public static void main(String a[]) throws Exception {
        int []arr= {4,5,6,7,8,9,0};
        MINIMUM_PRIORITY_QUEUE hp=new MINIMUM_PRIORITY_QUEUE(arr,7);
        hp.BUILD_MIN_HEAP();
        System.out.println("AFTER EXTRACTING MIN KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
        System.out.println("EXTRACTED MIN KEY:"+hp.EXTRACT_MIN());
        System.out.println("AFTER EXTRACTING MIN KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }
        System.out.println();
        System.out.println("Decreasing  KEY");
        hp.HEAP_DECREASE_KEY(3,1);
        System.out.println("AFTER Decreasing  KEY:");
        for(int i=0;i<=hp.heapSize-1;i++) {
            System.out.print(hp.nodeList[i]);
        }

    }

}
