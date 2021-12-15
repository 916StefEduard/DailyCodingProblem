#include <iostream>
#include <vector>
#include <list>
using namespace std;

//Detect cycles in an undirected graph
// 1->2->3->4->1 has a cycle.

class Graph{
    int edgeNumber;
    list<int> *adj;
    vector<int> nodes;
public:
    bool helper(int vertex,bool visited[],int parent){
        visited[vertex] = true;
        list<int>::iterator it;
        for(it = adj[vertex].begin();it!=adj[vertex].end();++it){
            if(!visited[*it]){
                if(helper(*it,visited,vertex)) {
                    return true;
                }
            }else if(*it != parent)
                return true;
        }
        return false;
    }

    bool checkCycle(){
        auto visited = new bool [edgeNumber];
        for(int i=0; i<edgeNumber; ++i){
            visited[i] = false;
        }
        for(auto element:nodes){
            if(helper(element, visited, -1))
                return true;
        }
        return false;
    }

    Graph(int edgeNumber){
        this->edgeNumber = edgeNumber;
        adj = new list<int>[edgeNumber];
    }

    void addEdge(int start,int end){
        nodes.push_back(start);
        nodes.push_back(end);
        adj[start].push_back(end);
    }
};

int main(){
    Graph graph(3);
    graph.addEdge(1,2);
    graph.addEdge(2,3);
    cout<<graph.checkCycle();
    return 0;
}