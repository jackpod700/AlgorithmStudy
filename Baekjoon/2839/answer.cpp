#include<iostream>
#include<algorithm>

using namespace std;

int D[5001];

void getD(int n){
    if(D[n] != -2) return;

    if(D[n-3]==-2) getD(n-3);
    if(D[n-5]==-2) getD(n-5);
    if(D[n-3] == -1 && D[n-5] == -1){ D[n] = -1; return; }
    if(D[n-3] == -1) {D[n] = D[n-5] + 1; return;}
    if(D[n-5] == -1) {D[n] = D[n-3] + 1; return;}
    D[n] = min(D[n-3], D[n-5]) + 1;
    return;
}

int main(){
    fill(D, D + 5001, -2);
    int n;
    cin >> n;
    D[0] = 0;
    D[1] = -1;
    D[2] = -1;
    D[3] = 1;
    D[4] = -1;
    D[5] = 1;
    getD(n);
    cout << D[n] << endl;
    return 0;
}
