#include <iostream>
#include <queue>
#include <vector>

using namespace std;

typedef struct edge {
    int vertex1, vertex2;
    int weight;

    edge() {
        vertex1 = 0;
        vertex2 = 0;
        weight = 0;
    }

    edge(int v1, int v2, int w) {
        vertex1 = v1;
        vertex2 = v2;
        weight = w;
    }

    bool operator < (const edge& e) const {
        return weight < e.weight;
    }
}edge;

int Prim(int* vertex, vector<edge> edges[], int v) {
    int total_weight = 0;
    priority_queue<edge> adj_edges;
    int cur_vertex = 0, max_edge=0;
    vertex[0] = 1;

    for (int j = 0; j < v - 1; j++) {
        for (int i = 0; i < edges[cur_vertex].size(); i++) {
            adj_edges.push(edges[cur_vertex][i]);
        }
        while (!adj_edges.empty() && (vertex[adj_edges.top().vertex1] == 1 && vertex[adj_edges.top().vertex2] == 1)) {
            adj_edges.pop();
        }
        edge e = adj_edges.top();
        adj_edges.pop();
        vertex[e.vertex2] = 1;
        cur_vertex = e.vertex2;
        total_weight += e.weight;
        if(max_edge>e.weight){
            max_edge = e.weight;
        }
    }
    // return MST; 이렇게 하고 싶지만 최대한 빠르게 하기 위해서..total_weight를 리턴하는 걸로 하자
    return  -(total_weight-max_edge);

}

int main()
{
    int v, e;
    int v1, v2, w;
    int total_weight = 0;

    scanf("%d %d", &v, &e);

    int* vertex = new int[v];
    fill(vertex, vertex + v, 0);
    vector<edge> *edges = new vector<edge> [v];

    for (int i = 0; i < e; i++) {
        scanf("%d %d %d", &v1, &v2, &w);
        edges[v1-1].push_back(edge(v1-1, v2-1, -w));
        edges[v2-1].push_back(edge(v2-1, v1-1, -w));
    }

    total_weight = Prim(vertex, edges, v);
    printf("%d\n", total_weight);
}