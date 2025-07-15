#include<bits/stdc++.h>

using namespace std;

int main(){
    int num;
    int x1,x2,y1,y2,r1,r2;
    int circ_dis,r_sum;
    cin>>num;
    int answer[num];
    for(int i=0;i<num;i++){
        cin>>x1>>y1>>r1>>x2>>y2>>r2;
        circ_dis=pow(x1-x2,2)+pow(y1-y2,2);
        r_sum=pow(r1+r2,2);
        if(!circ_dis){
            if(r1==r2){
                answer[i]=-1;
            }
            else{
                answer[i]=0;
            }
        }
        else if(circ_dis==r_sum){
            answer[i]=1;
        }
        else if(circ_dis>r_sum){
            answer[i]=0;
        }
        else{
            if(sqrt(circ_dis)+r2<r1||sqrt(circ_dis)+r1<r2){
                answer[i]=0;
            }
            else if((int)sqrt(circ_dis)+r2==r1||(int)sqrt(circ_dis)+r1==r2){
                answer[i]=1;
            }
            else answer[i]=2;
        }
    }
    for(int i=0;i<num;i++){
        cout<<answer[i]<<endl;
    }

}