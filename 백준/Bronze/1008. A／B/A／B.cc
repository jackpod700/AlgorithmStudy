#include <iostream>
int main(){
	double a,b;
	while(true){
		std::cin>>a;
		if(a>0&&a<10){
			break;
		}
	}
		while(true){
		std::cin>>b;
		if(b>0&&b<10){
			break;
		}
	}
	printf("%.9f",a/b);
}