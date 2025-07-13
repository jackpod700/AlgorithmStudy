#include<iostream>

using namespace std;

int D[1001];

int getD(int n){
    if(D[n]!=0) return D[n];
    D[n]=(getD(n-1)+getD(n-2))%10007;
    return D[n];
}

int main(){
    fill_n(D,1001,0);
    D[1]=1;
    D[2]=2;
    int n;
    cin>>n;
    cout<<getD(n);
}