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

    public void dfsHelper(int v,boolean visited[]){
        visited[v] = true;
        System.out.print(v + " ");
        for(int n: adj[v]){
            if(!visited[n]){
                dfsHelper(n,visited);
            }
        }
    }

    public void dfs(int v){
        boolean visited[] = new boolean[vertex];
        dfsHelper(v,visited);
    }

    public static void main(String[] args) {
        var graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.dfs(0);
    }
}