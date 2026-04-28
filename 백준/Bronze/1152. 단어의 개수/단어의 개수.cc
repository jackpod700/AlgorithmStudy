#include <iostream>
using namespace std;

int main(){
	string string;	//*스페이스바는 아스키코드 32번*
	int word=0, count=0;	//맨 마지막엔 스페이스바가 아니므로 미리 +1해놓는다
	getline(cin,string);
	while(string[count]!='\0'){
		if(string[count]>33&string[count+1]<33) word++;
		count++;
	}
	
	cout<<word;
	return 0;
}
	