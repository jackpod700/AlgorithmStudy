#include <iostream>
int main(){
	int a,b;
	while(true){
		std::cin>>a;
		if(a>0&&a<=10000){
			break;
		}
	}
		while(true){
		std::cin>>b;
		if(b>0&&b<=10000){
			break;
		}
	}
	std::cout<<a+b<<"\n"<<a-b<<"\n"<<a*b<<"\n"<<a/b<<"\n"<<a%b;
}