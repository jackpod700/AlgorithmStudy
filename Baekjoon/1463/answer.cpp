#include<iostream>

using namespace std;

int D[1000001];

void getD(int n){
    if(D[n] != -1) return;

    if(n%3==0 && D[n/3]==-1) getD(n/3);
    if(n%2==0 && D[n/2]==-1) getD(n/2);
    if(D[n-1]==-1) getD(n-1);
    
    if(n%3==0 && n%2==0) D[n] = min(D[n/3], min(D[n/2], D[n-1])) + 1;
    else if(n%3==0) D[n] = min(D[n/3], D[n-1]) + 1;
    else if(n%2==0) D[n] = min(D[n/2], D[n-1]) + 1;
    else D[n] = D[n-1] + 1;
    return;
}

int main(){
    fill(D, D+1000001, -1);
    int n;
    cin >> n;

    D[1]=0;
    D[2]=1;
    D[3]=1;
    getD(n);
    cout<<D[n]<<endl;
    return 0;
}