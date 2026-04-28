#include "stdio.h"
#include <iostream>

using namespace std;

int main(){
	char num1[3], num2[3];
	scanf("%s %s",num1,num2);
	
	for(int i=2;i>=0;i--){
		if(num1[i]>num2[i]){
			cout<<num1[2]<<num1[1]<<num1[0];
			break;
		}
		else if(num1[i]<num2[i]){
			cout<<num2[2]<<num2[1]<<num2[0];
			break;
		}
	}
}