#include<iostream>

using namespace std;

int D[10];

int getD(int n){
    if(D[n]!=0) return D[n];
    D[n]=getD(n-1)+getD(n-2)+getD(n-3);
    return D[n];
}

int main() {
    int a,n;
    cin >> n;
    fill(D, D+10, 0);
    D[0]=1;
    D[1]=2;
    D[2]=4;
    for(int i=0;i<n;i++){
        cin>>a;
        cout<<getD(a-1)<<endl;
    }
    return 0;
}