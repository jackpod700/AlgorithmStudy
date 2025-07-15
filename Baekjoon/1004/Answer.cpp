#include<bits/stdc++.h>
using namespace std;

int cnt;

bool is_in(int x,int y, int c1, int c2, int r){
    if(pow((x-c1),2)+pow((y-c2),2)<=r*r){
        cnt++;
        return true;
    }
    return false;
}

int main()
{
    int num,n,x1,y1,x2,y2,c1,c2,r;
    cin>>num;
    for(int j=0;j<num;j++){
        cin>>x1>>y1>>x2>>y2>>n;
        for(int i=0;i<n;i++){
            cin>>c1>>c2>>r;
            //if(is_in(x1,y1,c1,c2,r)&&is_in(x2,y2,c1,c2,r)) cnt-=2;
            bool start_in_circle = pow(c1 - x1, 2) + pow(c2 - y1, 2) <= r*r;
			bool end_in_circle = pow(c1 - x2, 2) + pow(c2 - y2, 2) <= r*r;

			if (start_in_circle != end_in_circle)
				cnt++;
        }
        cout<<cnt<<endl;
        cnt=0;
    }

}