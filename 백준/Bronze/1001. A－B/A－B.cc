#include <iostream>
int main(){
	int a,b;
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
	std::cout<<a-b;
}