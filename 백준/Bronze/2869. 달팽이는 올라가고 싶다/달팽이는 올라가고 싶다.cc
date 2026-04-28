#include "stdio.h"
#include <iostream>

using namespace std;

int main(){
	int V, A, B;
	scanf("%d %d %d",&A,&B,&V);
	cout<<(V-B-1)/(A-B)+1;
	
}