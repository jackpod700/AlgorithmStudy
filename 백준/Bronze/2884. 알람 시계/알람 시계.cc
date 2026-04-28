#include <iostream>
using namespace std;

int main(){
	int H, M;
	int alH, alM;
	cin>>H;
	cin>>M;
	
	if(M<45){
		alH = H-1;
		if(alH<0){
			alH += 24;
		}
		alM = 60-(45-M);
	}
	else{
		alH = H;
		alM = M-45;
	}
	
	cout<<alH<<" "<<alM;
	return 0;
}
	