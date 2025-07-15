#include<bits/stdc++.h>
#include<stack>
using namespace std;

int test_num,n,k,w;
int d[1000];

int calc_sum(int w, int* maximum, stack<int>* s){
    maximum[w]=d[w];
    while(!s[w].empty()){
        int i=s[w].top();
        s[w].pop();
        if(maximum[i]==-1){
            maximum[w]=max(calc_sum(i,maximum,s)+d[w],maximum[w]);
        }
        else{
            maximum[w]=max(maximum[i]+d[w],maximum[w]);
        }
    }
    return maximum[w];

}

int main()
{
    cin>>test_num;
    int answer[test_num];
    int temp=test_num;
    while(test_num--){
        cin>>n>>k;
        stack<int>* s = new stack<int>[n];
        int maximum[n];
        fill_n(maximum,n,-1);
        for(int i=0;i<n;i++){
            cin>>d[i];
        }
        while(k--){
            int a,b;
            cin>>a>>b;
            a--;b--;
            s[b].push(a);
        }
        cin>>w;
        w--;
        answer[test_num]=calc_sum(w,maximum,s);
        //cout<<calc_sum(w,maximum,s);
    }
    while(temp--){
        cout<<answer[temp]<<endl;
    }
}