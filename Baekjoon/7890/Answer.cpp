#include<iostream>
#include<algorithm>
#include<vector>
#include<cstdio>
#include"delaunator.hpp"

using namespace std;

typedef struct dot
{
    int x;
    int y;
    int closest_dot_length;
    int input_order;
    dot(){x = 0;y = 0;closest_dot_length = 9999999;input_order = 0;}
    bool operator < (const dot &a) const {return x < a.x;}
} dot;

void input(vector<dot> arr, int n)
{
    for (int i = 0; i < n; i++)
    {
        dot temp;
        cin >> temp.x >> temp.y;
        temp.input_order = i;
        arr.push_back(temp);
    }
}

int main()
{
    // int num_case, dot_num;
    // vector<dot> arr;
    // // dot arr[100000];
    // cin >> num_case;
    // for(int j=0; j<num_case; j++){
    //     cin >> dot_num;
    //     for(int i = 0; i < num_case; i++)
    //     {
    //         input(arr, dot_num);
    //         sort(arr.begin(), arr.end());
    //     }
    // }

        /* x0, y0, x1, y1, ... */
    std::vector<double> coords = {-1, 1, 1, 1, 1, -1, -1, -1};

    //triangulation happens here
    delaunator::Delaunator d(coords);

    for(std::size_t i = 0; i < d.triangles.size(); i+=3) {
        printf(
            "Triangle points: [[%f, %f], [%f, %f], [%f, %f]]\n",
            d.coords[2 * d.triangles[i]],        //tx0
            d.coords[2 * d.triangles[i] + 1],    //ty0
            d.coords[2 * d.triangles[i + 1]],    //tx1
            d.coords[2 * d.triangles[i + 1] + 1],//ty1
            d.coords[2 * d.triangles[i + 2]],    //tx2
            d.coords[2 * d.triangles[i + 2] + 1] //ty2
        );
    }
}