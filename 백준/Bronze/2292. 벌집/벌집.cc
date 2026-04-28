#include "stdio.h"
#include <iostream>

using namespace std;

int main(){
	int N, K=1,save=0; //K-1은 계층, 지나가는 방의 개수는 계층과 같다.
	
	cin>>N;
	
	if(N==1){
		cout<<"1";
		return 0;
	}
	
	for(;save*6<(N-1);K++){
		save+=K;
	}
	
	cout<<K;
}