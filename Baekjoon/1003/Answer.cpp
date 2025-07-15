#include<bits/stdc++.h>
using namespace std;

pair<int,int> memo[40];

pair<int,int> fibonacci(int n){
    if(n==0){
        return {1,0};
    }
    if(n==1){
        return {0,1};
    }
    else{
        if(memo[n].first!=0) return memo[n];
        pair<int,int> p1 = fibonacci(n-1);
        pair<int,int> p2 = fibonacci(n-2);
        memo[n] = {p1.first+p2.first,p1.second+p2.second};
        return memo[n];
    }
}

int main(){
    pair<int,int> p;
    int num,n;
    cin>>num;

    for(int i=0;i<num;i++){
        cin>>n;
        p = fibonacci(n);
        cout<<p.first<<" "<<p.second<<endl;
    }
}