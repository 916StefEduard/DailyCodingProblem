import org.apache.groovy.json.internal.Chr;

import java.util.*;

class Graph{
    int vertex;
    LinkedList<Integer> adj[];

    public Graph(int vertex){
        this.vertex = vertex;
        adj = new LinkedList[vertex];
        for(int i=0; i<vertex; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s,int e){
        adj[s].add(e);
        adj[e].add(s);
    }

    public void bfs(int s){
        boolean[] visited = new boolean[vertex];
        var queue = new LinkedList<Integer>();
        visited[s]  = true;
        queue.add(s);
        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            for(int n: adj[s]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        var graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.bfs(0);
    }
}