#include "stdio.h"
#include <iostream>

using namespace std;

int main(){
	int K=1,X;
	cin>>X;
	while(1){
		X-=K;
		if(X<=0){
			break;
		}
		K++;
	}
	if(K%2==0){
		cout<<K+X<<"/"<<1-X;
	}
	else cout<<1-X<<"/"<<K+X;
	
}