package Ex0PrismMinimumSpanningTreeUsingAdjucencyMatrx;


public class PrismMSP {
    boolean MST[];
    int minDist[];
    int graph[][];
    int values[];

    public PrismMSP(int i) {
        MST = new boolean[i];
        minDist = new int[i];
        graph = new int[i][i];
        values=new int [i];
    }


    void createGraph(int src, int dest, int dist) {

        graph[src][dest] = dist;
        graph[dest][src] = dist;
    }
    void create(){
        graph= new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

    }

    void defaultGraphValues() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
    }


    void defaultValue() {
        for (int i = 0; i < graph.length; i++) {
            minDist[i]=Integer.MAX_VALUE;
        }
    }
    //To find MIN value from minDist
    int findMinValue(){
        int minIndex = 0;
        int prevValue=Integer.MAX_VALUE;
        for(int i=0;i<graph.length;i++){
          if(minDist[i]<prevValue && !MST[i] && prevValue!=0) {
              minIndex = i;
              prevValue=minDist[i];
          }


      }
      return minIndex;
    }


    void MSP(){
       // MST[i-1]=true;


       // defaultGraphValues();
        defaultValue();
        minDist[0]=-1;

       for(int j=0;j<graph.length;j++){

          int  u=findMinValue();
           System.out.println("MIN INDEX:"+u);
           MST[u]=true;
           for(int k=0;k<graph.length;k++){
               if(graph[u][k]!=0 &&! MST[k] && graph[u][k]<minDist[k]){
                   minDist[k]=graph[u][k];
                   values[k]=u;
                   System.out.println("ADJACENCY"+graph[u][k]);
               }
           }
       }
    }

    void print(){
    for(int i=1;i<graph.length;i++){
        System.out.println(values[i]+"-"+i+"----"+graph[i][values[i]]);

    }

    }

    public static void main(String arg[]){
        PrismMSP prismMSP=new PrismMSP(5);

        prismMSP.create();
        prismMSP.MSP();
        prismMSP.print();
    }



}