#include <iostream>
#include <algorithm>

using namespace std;

typedef struct vertex{
    vertex* parent;

    vertex() {
        this->parent = NULL;
    }

    vertex* find() {
        if (this->parent == NULL) {
            return this;
        }
        else {
            return parent->find();
        }
    }

    bool merge(vertex* v) {
        vertex* root1 = this->find();
        vertex* root2 = v->find();
        if(root1 == root2) return false;
        else{
            root2->parent = root1;
            return true;
        }
    }
}vertex;

typedef struct edge {
    int vertex1, vertex2, weight;
    
    edge() {
        vertex1 = 0;
        vertex2 = 0;
        weight = 0;
    }

    edge(int v1, int v2, int w) {
        this->vertex1 = v1;
        this->vertex2 = v2;
        this->weight = w;
    }

    bool operator < (const edge& e) const {
        return weight < e.weight;
    }


}edge;

int Kruskal(vertex* vertexes, edge* edges, int v, int e) {
    int total_weight = 0, max_edge=0,j=0;
    vertex *v1, *v2;
    edge temp_e;

    sort(edges, edges+e);

    while(j<v-1){
        temp_e = edges[j];
        v1=&vertexes[temp_e.vertex1];
        v2=&vertexes[temp_e.vertex2];
        if (!(v1->merge(v2))){
            j++;
            v++;
            continue;
        }
        else{
            total_weight += temp_e.weight;
            j++;
        }
    }
    max_edge = edges[j-1].weight;

    // return MST; 이렇게 하고 싶지만 최대한 빠르게 하기 위해서..total_weight를 리턴하는 걸로 하자
    return  total_weight-max_edge;

}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); 
    int v, e;
    int v1, v2, w;
    int total_weight = 0;

    cin>>v>>e;

    vertex* vertexes = new vertex[v];
    edge *edges = new edge [e];

    for (int i = 0; i < e; i++) {
        cin>>v1>>v2>>w;
        edges[i] = edge(v1-1, v2-1, w);
    }

    total_weight = Kruskal(vertexes, edges, v, e);
    cout<<total_weight<<'\n';
}
