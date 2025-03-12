package Dijkstra_algorithem;
import java.util.*;
public class Dijkstra {
    void dijkstra(int [][]graph,int start){
        int n = graph.length;
        int INFINITY = 10000;
        int dist[] = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(i!=start){
                dist[i]=INFINITY;
            }else{
                dist[i]=0;
            }//end of else
        }//end of for
        for(int count=0;count<=n-1;count++){
            int u=-1;
            int minDist = INFINITY;
            for(int i=0;i<n;i++){
                if(!visited[i] && dist[i]<minDist){
                    minDist = dist[i];
                    u=i;
                }//end of if
            }//end of for 
            visited[u] = true;
            for(int v=0;v<n;v++){
                if(!visited[v] && graph[u][v] !=0 && dist[u] != INFINITY && dist[u]+graph[u][v] < dist[v]){
                    dist[v] = dist[u]+graph[u][v];
                }//end of if 
            }//end of for 
        }//end of for 
        printSolution(dist,start);
    }//end of dijkstra algo
    void printSolution(int[] dist,int start){
        System.out.println("--------< shortest path of map >-------- ");
        char x='A';
        if(start==0){
            x='A';
        }else{
            if(start==1){
                x='B';
            }else{
                if(start==2){
                    x='C';
                }else{
                    if(start==3){
                        x='D';
                    }else{
                        if(start==4){
                            x='E';
                        }//end of if 
                    }//end of else
                }//end of else
            }///end of else
        }//end of else
        System.out.println("nodes distance from starting point");
        for(int i=0;i<dist.length;i++){
            if(i==0){
                System.out.println(x+" To A -> "+dist[i]);
            }else{
                if(i==1){
                    System.out.println(x+" To B -> "+dist[i]);
                }else{
                    if(i==2){
                        System.out.println(x+" To C -> "+dist[i]);
                    }else{
                        if(i==3){
                            System.out.println(x+" To D -> "+dist[i]);
                        }else{
                            if(i==4){
                                System.out.println(x+" To E -> "+dist[i]);
                            }//end of if 
                        }//end of else
                    }//end of else 
                }//end of else
            }//end of else
        }//end of for 
    }//end of printing mehtod
}//end of class
class Emplemnt{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dijkstra dijkstra = new Dijkstra();
        String places[] = {
            "    (2)    ",
            "A----------B",
            "|          | \\",
            "(4)        (1) (7)",
            "|          |    \\",
            "C----------D-----E",
            "     (3)      (5)"
    };
    System.out.println("\n\n");
    for (int i = 0; i < places.length; i++) {
        System.out.println("\t\t" + places[i]);
    }//end of for 
    int graph[][] = {
            { 0, 2, 4, 0, 0 },
            { 2, 0, 0, 1, 7 },
            { 4, 0, 0, 3, 0 },
            { 0, 1, 3, 0, 5 },
            { 0, 7, 0, 5, 0 }
    };
    System.out.println("\n\n");
    System.out.println("Where you want to go ");
    System.out.println("<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>~<>");
    System.out.print("Enter starting location (A=0, B=1, C=2, D=3, E=4): ");
    int start = sc.nextInt();
    dijkstra.dijkstra(graph, start);
    }//end of psvm
}//end of class
